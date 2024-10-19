package org.example.mappers;


import org.example.model.ClientOrder;
import org.example.model.Order;

import java.util.ArrayList;
import java.util.List;
//Cette classe gère le mapping entre ClientOrder et Order.
public class OrderMapper {

    public static Order mapClientOrderToOrder(ClientOrder clientOrder) {
        Order order = new Order();
        order.setId(clientOrder.getContenu().getId());
        order.setContact_id(clientOrder.getContenu().getFournisseur().getCode());
        order.setContact_name(clientOrder.getContenu().getFournisseur().getNom());
        order.setBranchs_id(clientOrder.getContenu().getSite_reception().getSiteId());
        order.setBranch_name(clientOrder.getContenu().getSite_reception().getNom_site());
        order.setUser_text_5(clientOrder.getContenu().getType_message());
        order.setReference(clientOrder.getContenu().getNumero_commande());
        order.setDateOrder(clientOrder.getContenu().getCreation() + "+0000");
        order.setDatereceive_estimated(clientOrder.getContenu().getDate_reception() + "T00:00:00+0000");

        // Mapping des items
        List<Order.OrderItem> orderItems = new ArrayList<>();
        for (ClientOrder.Contenu.Ligne ligne : clientOrder.getContenu().getLignes()) {
            Order.OrderItem orderItem = new Order.OrderItem();
            orderItem.setId(ligne.getId());
            orderItem.setIdpurchaseorder(clientOrder.getContenu().getId());
            orderItem.setIdproducts(ligne.getCode_produit());
            orderItem.setQuantityorder(String.valueOf(ligne.getQuantite()) + ".000000");
            orderItem.setBranchs_id(clientOrder.getContenu().getSite_reception().getSiteId());
                orderItems.add(orderItem);
        }
        order.setItems(orderItems);
        return order;
    }
}