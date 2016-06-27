package com.example.dktique.shoppingstore1;

import java.io.Serializable;
import java.util.List;


public class Produit implements Serializable {

    private String nom;
    private String taille;
    private String prix;
    private String marque;
    private String description;
    private String style;
    private String saison;
    private String matiere;
    private String category;
    private String categorie2;
    private String cover;
    private String iconCover;
    private String quantite;

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public String getQuantite() {
        return quantite;
    }

    public String getNom() {
        return nom;
    }

    public String getTaille() {
        return taille;
    }

    public String getPrix() {
        return prix;
    }



    public String getCategory() {
        return category;
    }

    public String getCategorie2() {return categorie2;}

    public String getCover() { return cover; }

    public String getIconCover() {
        return iconCover;
    }



    public String getMarque() {
        return marque;
    }

    public String getDescription() {
        return description;
    }

    public String getStyle() {
        return style;
    }

    public String getSaison() {
        return saison;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setPrix(String prix) {

        this.prix = prix;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCategorie2(String categorie2) { this.categorie2 = categorie2; }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setIconCover(String iconCover) { this.iconCover = iconCover; }

}