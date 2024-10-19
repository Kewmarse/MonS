package org.example.productRoute;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

public class CreateProductRoute extends RouteBuilder {
    @Override
    public void configure() {
        // Route pour créer un produit
        from("direct:createProduct")
                .marshal().json(JsonLibrary.Jackson) // Convertir l'objet Java en JSON
                .setHeader("Content-Type", constant("application/json")) // Définir l'en-tête Content-Type
                .to("https://montest.com/api/products?bridgeEndpoint=true&httpMethod=POST") // URL de l'API
                .unmarshal().json(JsonLibrary.Jackson, ProductResponse.class) // Gérer la réponse JSON
                .log("Produit créé avec succès : ${body}"); // Journaliser la réponse
    }
}
