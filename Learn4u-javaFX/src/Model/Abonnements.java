/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author mouss
 */
public class Abonnements {
     private int id,category_id;
    private String nom;
    private String description;
    private float prix;

    public Abonnements(int id, int category_id, String nom, String description, float prix) {
        this.id = id;
        this.category_id = category_id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    public Abonnements(int category_id, String nom, String description, float prix) {
        this.category_id = category_id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }
    
      @Override
    public String toString(){
        return "Abonnements{" + " id=" + id + "category_id=" + category_id + "nom=" + nom + "description=" + description + "prix=" + prix +'}';
    }

    public Abonnements() {
    }
        
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
    
    
    
}
