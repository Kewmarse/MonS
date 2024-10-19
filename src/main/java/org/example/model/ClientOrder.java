package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

// Cette classe représente le format du JSON d'entrée.
public class ClientOrder {
    private int id;
    @JsonProperty("message_type")
    private String message_type;
    private String creation;
    private int exported;
    private Contenu contenu;

    // Getters et setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
   public String getMessage_type() { return message_type; }
    public void setMessage_type(String message_type) { this.message_type = message_type; }
    public String getCreation() { return creation; }
    public void setCreation(String creation) { this.creation = creation; }
    public int getExported() { return exported; }
    public void setExported(int exported) { this.exported = exported; }
    public Contenu getContenu() { return contenu; }
    public void setContenu(Contenu contenu) { this.contenu = contenu; }

// Classe représentant le contenu du message
@JsonIgnoreProperties(ignoreUnknown = true)
public static class Contenu {
        @JsonProperty("type_message")
        private String type_message;
        @JsonProperty("id")
        private int id;
        @JsonProperty("fournisseur")
        private Fournisseur fournisseur;
        @JsonProperty("site_reception")
        private SiteReception site_reception;
        @JsonProperty("numero_commande")
        private String numero_commande;
        @JsonProperty("numero_livraison")
        private String numero_livraison;
        @JsonProperty("satus")
        private String statut;
        @JsonProperty("creation")
        private String creation;
        @JsonProperty("modification")
        private String modification;
        @JsonProperty("date_reception")
        private String date_reception;
        @JsonProperty("lignes")
        private List<Ligne> lignes;

        // Getters et setters


        public String getType_message() { return type_message; }
        public void setType_message(String type_message) { this.type_message = type_message; }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Fournisseur getFournisseur() {
            return fournisseur;
        }

        public void setFournisseur(Fournisseur fournisseur) {
            this.fournisseur = fournisseur;
        }

      public SiteReception getSite_reception() {return site_reception;}
        public void setSite_reception(SiteReception site_reception) {
            this.site_reception = site_reception;
        }
     public String getNumero_commande() { return numero_commande; }
        public void setNumero_commande(String numero_commande) {this.numero_commande = numero_commande; }

     public String getNumero_livraison() { return numero_livraison; }
    public void setNumero_livraison(String numero_livraison) {
        this.numero_livraison = numero_livraison;
    }

        public String getStatut() {
            return statut;
        }

        public void setStatut(String statut) {
            this.statut = statut;
        }

        public String getCreation() {
            return creation;
        }

        public void setCreation(String creation) {
            this.creation = creation;
        }

        public String getModification() {
            return modification;
        }

        public void setModification(String modification) {
            this.modification = modification;
        }

    public String getDate_reception() {return date_reception;}
        public void setDate_reception(String date_reception) {this.date_reception = date_reception;}
        public List<Ligne> getLignes() {
            return lignes;
        }

        public void setLignes(List<Ligne> lignes) {
            this.lignes = lignes;
        }

 // Classe représentant un fournisseur
        public static class Fournisseur {
            private String code;
            private String nom;
            private String telephone;


            // Getters et setters
            public String getCode() { return code; }
            public void setCode(String code) { this.code = code; }
            public String getNom() { return nom; }
            public void setNom(String nom) { this.nom = nom; }
            public String getTelephone() { return telephone; }
            public void setTelephone(String telephone) { this.telephone = telephone; }
        }

// Classe représentant le site de réception
        public static class SiteReception {
            @JsonProperty("site_id")
            private int siteId;
            @JsonProperty("nom_site")
            private String nom_site;
            private String telephone;


            // Getters et setters
            public int getSiteId() { return siteId; }
            public void setSiteId(int siteId) { this.siteId = siteId; }
           public String getNom_site() { return nom_site; }
            public void setNom_site(String nom_site) { this.nom_site = nom_site; }
            public String getTelephone() { return telephone; }
            public void setTelephone(String telephone) { this.telephone = telephone; }
        }

 // Classe représentant une ligne de commande
        public static class Ligne {
            @JsonProperty("id")
            private String id;
            @JsonProperty("code_produit")
            private String code_produit;
            private String libelle_fr;
            private int quantite;
            private String unite;
            private int lieu;
            private int nb_jour_dlc_apres_decongelation;
            private int nb_jour_dlv;
            private int nb_jour_blocage;
            private boolean fragile;
            private String numero_lot;
            private String dlc;
            private String categorie;

            // Getters et setters

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

         public String getCode_produit() { return code_produit; }
            public void setCode_produit(String code_produit) {this.code_produit = code_produit; }

            public String getLibelle_fr() {
                return libelle_fr;
            }

            public void setLibelle_fr(String libelle_fr) {
                this.libelle_fr = libelle_fr;
            }

            public int getQuantite() {
                return quantite;
            }

            public void setQuantite(int quantite) {
                this.quantite = quantite;
            }

            public String getUnite() {
                return unite;
            }

            public void setUnite(String unite) {
                this.unite = unite;
            }

            public int getLieu() {
                return lieu;
            }

            public void setLieu(int lieu) {
                this.lieu = lieu;
            }

            public int getNb_jour_dlv() {
                return nb_jour_dlv;
            }

            public void setNb_jour_dlv(int nb_jour_dlv) {
                this.nb_jour_dlv = nb_jour_dlv;
            }

            public int getNb_jour_dlc_apres_decongelation() {
                return nb_jour_dlc_apres_decongelation;
            }

            public void setNb_jour_dlc_apres_decongelation(int nb_jour_dlc_apres_decongelation) {
                this.nb_jour_dlc_apres_decongelation = nb_jour_dlc_apres_decongelation;
            }

            public int getNb_jour_blocage() {
                return nb_jour_blocage;
            }

            public void setNb_jour_blocage(int nb_jour_blocage) {
                this.nb_jour_blocage = nb_jour_blocage;
            }

            public boolean isFragile() {
                return fragile;
            }

            public void setFragile(boolean fragile) {
                this.fragile = fragile;
            }

            public String getNumero_lot() {
                return numero_lot;
            }

            public void setNumero_lot(String numero_lot) {
                this.numero_lot = numero_lot;
            }

            public String getDlc() {
                return dlc;
            }

            public void setDlc(String dlc) {
                this.dlc = dlc;
            }

            public String getCategorie() {
                return categorie;
            }

            public void setCategorie(String categorie) {
                this.categorie = categorie;
            }
        }
    }
}
