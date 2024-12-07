/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

/**
 *
 * @author mouss
 * @param <Category>
 */
public interface IServicesMouss <Category> {
    
     public void  ajouter(Category t);
    public List<Category> afficher();
    public void  modifier (Category t );
    public void supprimer(int id);
    public void rechercher(int x);
     public void trier() ;
  
    
}
