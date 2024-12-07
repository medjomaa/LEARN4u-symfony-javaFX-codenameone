/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Category;
import utils.MyDb;

/**
 *
 * @author mouss
 */
public class ServicesCategoryMouss implements IServicesMouss<Category> {
    private  Connection cnx = MyDb.getInstance().getCnx() ;

    @Override
    public void ajouter(Category t) {
       try {
        String querry = "INSERT INTO 'category' (indice)' VALUES ('" + t.getIndice() + "')";
        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }
        
        
    }
    @Override
    public List<Category> afficher() {
      List<Category> category = new ArrayList();
        try {
       
        String querry ="SELECT * FROM `category`";
        Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(querry);
        while (rs.next()){
             Category p = new Category();
            
             p.setId(rs.getInt(1));
                p.setIndice(rs.getString("indice"));
                
                 
                 
            category.add(p);
            
            
        }
        
        
        
        return category;
    } catch (SQLException ex) {
        }
    return category;
    }


    @Override
    public void modifier(Category t) {
        try {
            String requete =  "UPDATE `category` SET `Indice`=? WHERE id ="+t;
           
            PreparedStatement pst= MyDb.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, t.getIndice());
    
              
            pst.executeUpdate();
            System.out.println("Category a été MODIFIE!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
       }  

   
    public void supprimer(Category z) {
        try
       {
           //DELETE FROM  WHERE 0
           String requete="DELETE FROM `category` WHERE id ="+z.getId() ;
          PreparedStatement pste=MyDb.getInstance().getCnx().prepareStatement(requete);
           if (pste.execute())
          { System.out.println("une Category a été supprimé");}
           
       }catch(SQLException ex)
       {
          System.out.println(ex.getMessage());
       }
         }
    


    @Override
    public void rechercher(int x) {
           List<Category> category = new ArrayList();
      boolean test ;
         try {
       
        String query ="SELECT * FROM category";
        Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(query);
        while (rs.next()){
            Category c = new Category();
            
             c.setId(rs.getInt(1));
            c.setIndice(rs.getString("indice"));
            
            
            
            category.add(c);
        }
       
   test =category.stream().anyMatch((p -> p.getId()==x ));
   if (test ==true ){
     for (int i = 0; i < category.size(); i++) {
           if (category.get(i).getId()== x) {
                 System.out.println( category.get(i));
           
           } }
   
   }
   else
   {
       System.out.println( "aucune category");
   }
        } catch (SQLException ex){} ;
       
    }
    

    @Override
    public void trier() {
        afficher().stream().sorted((a,b) -> a.getIndice().compareTo(b.getIndice())).forEach(System.out::println);;
    }

   /*@Override
    public void modifier(Category t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    @Override
    public void supprimer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
