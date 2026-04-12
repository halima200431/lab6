package com.example.pizzarecipes.dao;

import java.util.List;

/**
 * Interface générique DAO (Data Access Object).
 * Définit le contrat CRUD pour n'importe quel type d'entité.
 * @param <T> le type d'objet géré (ici Produit)
 */
public interface IDao<T> {
    T create(T t);           // Ajouter un objet
    T update(T t);           // Modifier un objet existant
    boolean delete(long id); // Supprimer par ID
    T findById(long id);     // Trouver par ID
    List<T> findAll();       // Retourner toute la liste
}