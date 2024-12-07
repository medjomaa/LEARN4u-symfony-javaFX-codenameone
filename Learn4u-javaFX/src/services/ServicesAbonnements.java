/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Model.Abonnements;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyDb;

/**
 *
 * @author mouss
 */
public class ServicesAbonnements implements IServicesMouss<Abonnements> {
    private  Connection cnx = MyDb.getInstance().getCnx() ;
    
     
    public Statement ste;
    public  PreparedStatement pst;

   
    @Override
    public void ajouter(Abonnements t) {
        String requete = "INSERT INTO `abonnements` (`category_id`,`nom`,`description`,`prix`) "
                + "VALUES (?,?,?,?);";
        

   try {
            pst = (PreparedStatement) cnx.prepareStatement(requete);
             pst.setInt(1, t.getCategory_id());
            pst.setString(2, t.getNom());
            
            pst.setString(3, t.getDescription());
            pst.setFloat(4, t.getPrix());
          
            pst.executeUpdate();
            System.out.println("abonnement "+t.getNom()+" added successfully");
        } catch (SQLException ex) {
            Logger.getLogger(ServicesAbonnements.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

 
    @Override
    public ObservableList<Abonnements> afficher() {
      ObservableList<Abonnements> abonnement= FXCollections.observableArrayList();
        try {
       
        String querry ="SELECT * FROM `abonnements`";
        Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(querry);
        while (rs.next()){
            Abonnements p = new Abonnements();
            
             p.setId(rs.getInt(1));
                p.setCategory_id(rs.getInt("category_id"));
                p.setNom(rs.getString("nom"));
                p.setDescription(rs.getString("description"));
                 p.setPrix(rs.getFloat("prix"));
                 
                   
                 
            abonnement.add(p);
            
            
        }
        
        
        
        return abonnement;
    } catch (SQLException ex) {
        }
    return abonnement;
    }

    @Override
    public void modifier(Abonnements t) {
         try {
            String requete =  "UPDATE `abonnements` SET `category_id`=?,`nom`=?,`description`=?,`prix`=? WHERE id ="+t;
           
            PreparedStatement pst= MyDb.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, t.getCategory_id());
            pst.setString(2, t.getNom());
             pst.setString(3, t.getDescription());
              pst.setFloat(4, t.getPrix());

            pst.executeUpdate();
            System.out.println("Abonnement a été MODIFIE!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
       }  
   

    public void supprimer(int id) {
       try {
       String query2="delete from abonnements where id=?";
                PreparedStatement smt = cnx.prepareStatement(query2);
                smt.setInt(1, id);
               
                smt.executeUpdate();
                System.out.println("suppression avec succee");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
       }
         }

    @Override
    public void rechercher(int x) {
         List<Abonnements> abonnement= new ArrayList();
      boolean test ;
         try {
       
        String query ="SELECT * FROM abonnements";
        Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(query);
        while (rs.next()){
             Abonnements c = new Abonnements();

             c.setId(rs.getInt(1));
                c.setCategory_id(rs.getInt("Category_id"));
                c.setNom(rs.getString("nom"));
                c.setDescription(rs.getString("Description"));
                 c.setPrix(rs.getFloat("prix"));
                          
            abonnement.add(c);
       
        }
       
   test =abonnement.stream().anyMatch((p -> p.getId()==x ));
   if (test ==true ){
     for (int i = 0; i < abonnement.size(); i++) {
           if (abonnement.get(i).getId()== x) {
                 System.out.println( abonnement.get(i));
           
           } }
   
   }
   else
   {
       System.out.println( "aucun abonnement");
   }
        } catch (SQLException ex){} ;
       
    }
    


    @Override
    public void trier() {
         afficher().stream().sorted((a,b) -> a.getNom().compareTo(b.getNom())).forEach(System.out::println);;
    }




}
