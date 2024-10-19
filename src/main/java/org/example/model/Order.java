package org.example.model;

import java.util.List;
//Cette classe représente le format du JSON de sortie.
public class Order {
    private int id;
    private String contact_id;
    private String reference;
    private String datevalidationprovider;
    private String dateOrder;
    private String datereceive_estimated;
    private int branchs_id;
    private String user_text_5;
    private String weight;
    private String branch_name;
    private String quantity;
    private String quantityreceive;
    private String contact_name;
    private List<OrderItem> items;

    // Getters et Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContact_id() {
        return contact_id;
    }

    public void setContact_id(String contact_id) {
        this.contact_id = contact_id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDatevalidationprovider() {
        return datevalidationprovider;
    }

    public void setDatevalidationprovider(String datevalidationprovider) {
        this.datevalidationprovider = datevalidationprovider;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getDatereceive_estimated() {
        return datereceive_estimated;
    }

    public void setDatereceive_estimated(String datereceive_estimated) {
        this.datereceive_estimated = datereceive_estimated;
    }

    public String getUser_text_5() {
        return user_text_5;
    }

    public void setUser_text_5(String user_text_5) {
        this.user_text_5 = user_text_5;
    }

    public int getBranchs_id() {
        return branchs_id;
    }

    public void setBranchs_id(int branchs_id) {
        this.branchs_id = branchs_id;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuantityreceive() {
        return quantityreceive;
    }

    public void setQuantityreceive(String quantityreceive) {
        this.quantityreceive = quantityreceive;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

//OrderItem
    public static class OrderItem {
        private String id;
        private int idpurchaseorder;
        private String idproducts;
        private String quantityorder;
        private int branchs_id;

        // Getters et Setters


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getIdpurchaseorder() {
            return idpurchaseorder;
        }

        public void setIdpurchaseorder(int idpurchaseorder) {
            this.idpurchaseorder = idpurchaseorder;
        }

        public String getIdproducts() {
            return idproducts;
        }

        public void setIdproducts(String idproducts) {
            this.idproducts = idproducts;
        }

        public int getBranchs_id() {
            return branchs_id;
        }

        public void setBranchs_id(int branchs_id) {
            this.branchs_id = branchs_id;
        }

        public String getQuantityorder() {
            return quantityorder;
        }

        public void setQuantityorder(String quantityorder) {
            this.quantityorder = quantityorder;
        }
    }}
