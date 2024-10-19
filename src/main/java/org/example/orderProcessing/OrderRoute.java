package org.example.orderProcessing;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.example.mappers.OrderMapper;
import org.example.model.ClientOrder;
import org.example.model.Order;

public class OrderRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // Gestion des exceptions
        onException(Exception.class)
                .log("Error processing message: ${exception.message}")
                .handled(true);

// Route principale
        from("file:src/main/resources?fileName=clientOrder.json&noop=true")
                .unmarshal().json(JsonLibrary.Jackson, ClientOrder.class) // Désérialiser le JSON
                .process(exchange -> {
                    // Récupérer le client order
                    ClientOrder clientOrder = exchange.getIn().getBody(ClientOrder.class);
                    // Mapper vers l'ordre
                    Order order = OrderMapper.mapClientOrderToOrder(clientOrder);
                    // Mettre l'ordre dans le corps pour la prochaine étape
                    exchange.getIn().setBody(order);
                })
                .multicast()
                .to("direct:orderRoute", "direct:orderItemsRoute"); // Envoyer vers deux routes

// Route pour traiter la commande
        from("direct:orderRoute")
                .log("Processing Order: ${body}") // Logique de traitement de l'ordre
                .to("file:src/main/resources?fileName=order.json&fileExist=Append"); // Sauvegarder dans un fichier

 // Route pour traiter les lignes de commande
        from("direct:orderItemsRoute")
                .process(exchange -> {
                    Order order = exchange.getIn().getBody(Order.class);
                    // Traiter les lignes de commande
                    for (Order.OrderItem item : order.getItems()) {
                        Exchange newExchange = exchange.getContext().getEndpoint("direct:itemProcessingRoute").createExchange();
                        newExchange.getIn().setBody(item); // Mettre l'item dans le corps
                        exchange.getContext().createProducerTemplate().send("direct:itemProcessingRoute", newExchange);
                    }
                });

// Route pour traiter chaque ligne de commande
        from("direct:itemProcessingRoute")
                .log("Processing Order Item: ${body}") // Logique de traitement de l'item
                .to("file:src/main/resources?fileName=orderItems.json&fileExist=Append"); // Sauvegarder les items dans un fichier
    }
}