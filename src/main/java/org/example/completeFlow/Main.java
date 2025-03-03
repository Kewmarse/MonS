package org.example.completeFlow;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new DataProcessingRoute());

        context.start();

        Thread.sleep(5000);
        context.stop();
    }
}
