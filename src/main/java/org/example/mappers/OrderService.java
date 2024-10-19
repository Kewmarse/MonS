package org.example.mappers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.ClientOrder;
import org.example.model.Order;
import java.io.File;
import java.io.IOException;

//Cette classe gère la lecture du fichier JSON d'entrée et l'écriture du fichier JSON de sortie.
public class OrderService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void convertClientOrderToJsonFile(String inputFilePath, String outputFilePath) {
        try {
            // Désérialiser le JSON d'entrée à partir du fichier
            ClientOrder clientOrder = objectMapper.readValue(new File(inputFilePath), ClientOrder.class);

            // Mapper l'objet ClientOrder à Order
            OrderMapper mapper = new OrderMapper();
            Order order = mapper.mapClientOrderToOrder(clientOrder);

            // Sérialiser l'objet Order en JSON et l'écrire dans le fichier de sortie
            objectMapper.writeValue(new File(outputFilePath), order);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
