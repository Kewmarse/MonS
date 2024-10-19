package org.example.api;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
public class ProductRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:fetchProducts")
                .setHeader("CamelHttpMethod", constant("GET"))
                .setHeader("Accept", constant("application/json"))
                .toD("https://montest.com/api/produits?bridgeEndpoint=true&query=filter=${header.filter}")
                .unmarshal().json(JsonLibrary.Jackson, Product.class)
                .process(exchange -> {
                    Product productResponse = exchange.getIn().getBody(Product.class);
                });
    }
}
