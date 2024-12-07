/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Abonnements;
import services.ServicesAbonnements;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mouss
 */
public class FinalController implements Initializable {

    @FXML
    private TextField Idtf;
    @FXML
    private TextField Ctf;
    @FXML
    private TextField Ntf;
    @FXML
    private TextField Ptf;
    @FXML
    private TextField Dtf;

       /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
@FXML
    private void onSave(ActionEvent event) {
        int id = 0;
        float p;
        int c;
        
        String idString = Idtf.getText();
        String pString = Ptf.getText();
        String cString = Ctf.getText();
        
        try{
            id = Integer.parseInt(idString);
            p = Integer.parseInt(pString);
            c = Integer.parseInt(cString);
        }catch(NumberFormatException exc){
            System.out.println("Number is required");
            return;
        }   
        
        if(Ntf.getText().equals("")){
            System.out.println("Le nom est requis");
            return;
        }
        
         if(Dtf.getText().equals("")){
            System.out.println("Description  requis");
            return;
        }
        
        Abonnements o = new Abonnements(c, Ntf.getText(),Dtf.getText(), p);
        ServicesAbonnements ps = new ServicesAbonnements();
        
        ps.ajouter(o);
        
        System.out.println("Abonnements ajouté");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("XFinal.fxml"));
        
        try {
            Parent root = loader.load();
            XFinalController controller = loader.getController();
            controller.setIdLabel(id);
            controller.setCategoriLabel(c);

            controller.setNomLabel(o.getNom());
           controller.setDescriptionLabel(o.getDescription());
            controller.setPrixLabel(p);
            
            this.Idtf.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FinalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    
}
