/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import utils.DataSource;

/**
 *
 * @author remo
 */
public class ReclamationService implements IIIService1<Reclamation>{

    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;

    public ReclamationService() {
        //Récupération de la connection à la base de données
        cnx = DataSource.getInstance().getConnection();
    }

    @Override
    public void ajouter(Reclamation p) {
       String requete = "INSERT INTO reclamation (type,description) VALUES ('" + p.getType() + "','" +p.getDescription()+ "')";
        
        try {
            ste = cnx.createStatement();
            ste.executeUpdate(requete);
            System.out.println("personne ajoutée");

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ajouterPst(Reclamation p) {
        String requete = "INSERT INTO `reclamation` (`type`,`description`) VALUES (?,?);";
        
        try {
            pst = cnx.prepareStatement(requete);
            pst.setString(1, p.getType());
            pst.setString(2, p.getDescription());
            pst.executeUpdate();
            System.out.println("reclamation ajoutée");
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Reclamation> afficher(){
        List<Reclamation> personnes = new ArrayList<>();
        String requete = "SELECT * FROM `reclamation`";
        
        try {
            ste = cnx.createStatement();
            ResultSet rs =  ste.executeQuery(requete);
            
            while(rs.next()){
//                Personne p = new Personne();
//                p.setId(rs.getInt("id"));
//                p.setNom(rs.getString(2));
//                p.setPrenom(rs.getString("prenom"));
//                personnes.add(p);                
                personnes.add(new Reclamation(rs.getString("type"), rs.getString("description"),rs.getInt(1)));
            }
            System.out.println(personnes);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return personnes;
    }

     @Override
    public void modifier(Reclamation t) {
        try {
            String req = "UPDATE reclamation SET type='" + t.getType() + "',Description='" + t.getDescription() + "' WHERE id=" + t.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("reclamation modifée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Reclamation t) {
        try {
            String req = "DELETE FROM reclamation where id=" + t.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("reclamation supprimée !"+t.getId());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
