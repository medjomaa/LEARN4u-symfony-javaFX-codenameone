/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author mouss
 */
public class Category {
    
    private int id;
    private String indice;

    public Category() {
    }

    public Category(int id) {
        this.id = id;
    }

    public Category(String indice) {
        this.indice = indice;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndice() {
        return indice;
    }

    public void setIndice(String indice) {
        this.indice = indice;
    }
    
     @Override
   public String toString(){
       return "Category{" +"id=" + id +"indice="+indice+'}';
   }
}
