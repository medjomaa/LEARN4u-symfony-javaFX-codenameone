/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

/**
 *
 * @author solta
 */
public interface IIIService1<T>  {
    
    public void ajouter(T t);
  
    public void modifier(T t);
      public void supprimer(T t);
    public List<T> afficher();
   

    
}
