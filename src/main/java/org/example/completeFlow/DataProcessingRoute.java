package org.example.completeFlow;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.example.api.Product;

import java.util.List;

public class DataProcessingRoute extends RouteBuilder {
    @Override
    public void configure() {
        // Route pour récupérer des produits
        from("timer://foo?repeatCount=1") // Simule une exécution unique
                .to("https://montest.com/api/produits?bridgeEndpoint=true&httpMethod=GET") // Récupérer la liste des produits
                .unmarshal().json(JsonLibrary.Jackson, List.class) // Convertir JSON en liste d'objets
                .process(exchange -> {
                    List<Product> products = exchange.getIn().getBody(List.class);
                    // Transformation des données, par exemple, ajuster le prix
                    products.forEach(product -> {
                        product.setPrice(product.getPrice() * 1.1); // Augmenter le prix de 10%
                    });
                    exchange.getIn().setBody(products); // Mettre à jour le corps avec les produits transformés
                })
                .marshal().json(JsonLibrary.Jackson) // Convertir la liste d'objets en JSON
                .setHeader("Content-Type", constant("application/json")) // Définir l'en-tête Content-Type
                .to("https://montest.com/api/products?bridgeEndpoint=true&httpMethod=POST") // Créer les produits sur la plateforme de destination
                .log("Produits créés/modifiés : ${body}"); // Journaliser la réponse
    }
}
