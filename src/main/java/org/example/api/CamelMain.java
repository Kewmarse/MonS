package org.example.api;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelMain {
    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();

        camelContext.addRoutes(new ProductRoute());
        camelContext.addRoutes(new OrderRoute());

        camelContext.start();

        Thread.sleep(5000);

        camelContext.stop();
    }
}
