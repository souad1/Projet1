package com.example.dktique.shoppingstore1;

import java.io.Serializable;
import java.util.List;


public class Produit implements Serializable {

    private String nom;
    private List<String> taille;
    private String prix;
    private String year;
    private String summary;
    private String category;
    private int cover;
    private int iconCover;

    public String getNom() {
        return nom;
    }

    public List<String> getTaille() {
        return taille;
    }

    public String getPrix() {
        return prix;
    }

    public String getYear() {
        return year;
    }

    public String getSummary() {
        return summary;
    }

    public String getCategory() {
        return category;
    }

    public int getCover() {
        return cover;
    }

    public int getIconCover() {
        return iconCover;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTaille(List<String> taille) {
        this.taille = taille;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public void setIconCover(int iconCover) {
        this.iconCover = iconCover;
    }
}