package org.example.api;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.example.model.Order;

public class OrderRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:fetchOrders")
                .setHeader("CamelHttpMethod", constant("GET"))
                .setHeader("Accept", constant("application/json"))
                .toD("https://montest.com/api/commandes?bridgeEndpoint=true&query=filter=${header.filter}")
                .unmarshal().json(JsonLibrary.Jackson, Order.class)
                .process(exchange -> {
                    Order orderResponse = exchange.getIn().getBody(Order.class);
                });
    }
}
