package org.example.mappers;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        String inputFilePath = "src/main/resources/clientOrder.json";
        String outputFilePath = "src/main/resources/order.json";

        orderService.convertClientOrderToJsonFile(inputFilePath, outputFilePath);

        System.out.println("Le fichier order.json a été créé avec succès.");
    }
}
