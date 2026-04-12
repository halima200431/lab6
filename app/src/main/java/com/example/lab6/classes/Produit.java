package com.example.pizzarecipes.classes;

public class Produit {
    // Compteur statique pour générer des IDs uniques automatiquement
    private static long AUTO_ID = 1;

    private long id;
    private String nom;
    private double prix;
    private int imageRes;     // Référence drawable (R.mipmap.pizza1, etc.)
    private String duree;
    private String ingredients;
    private String description;
    private String etapes;

    // Constructeur vide (utilisé si on veut remplir champ par champ)
    public Produit() {
        this.id = AUTO_ID++;
    }

    // Constructeur complet (utilisé dans seed())
    public Produit(String nom, double prix, int imageRes, String duree,
                   String ingredients, String description, String etapes) {
        this.id = AUTO_ID++;
        this.nom = nom;
        this.prix = prix;
        this.imageRes = imageRes;
        this.duree = duree;
        this.ingredients = ingredients;
        this.description = description;
        this.etapes = etapes;
    }

    // Getters
    public long getId()           { return id; }
    public String getNom()        { return nom; }
    public double getPrix()       { return prix; }
    public int getImageRes()      { return imageRes; }
    public String getDuree()      { return duree; }
    public String getIngredients(){ return ingredients; }
    public String getDescription(){ return description; }
    public String getEtapes()     { return etapes; }

    // Setters
    public void setNom(String nom)              { this.nom = nom; }
    public void setPrix(double prix)            { this.prix = prix; }
    public void setImageRes(int imageRes)       { this.imageRes = imageRes; }
    public void setDuree(String duree)          { this.duree = duree; }
    public void setIngredients(String i)        { this.ingredients = i; }
    public void setDescription(String d)        { this.description = d; }
    public void setEtapes(String e)             { this.etapes = e; }

    @Override
    public String toString() { return nom + " - " + prix + " €"; }
}