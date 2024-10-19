package org.example.productRoute;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.example.api.Product;

public class Main {
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new CreateProductRoute());

        context.start();

        Product newProduct = new Product(5, "New Product", 45);

        context.createProducerTemplate().sendBody("direct:createProduct", newProduct);

        Thread.sleep(2000);
        context.stop();
    }
}
