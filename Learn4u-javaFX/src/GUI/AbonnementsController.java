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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mouss
 */
public class AbonnementsController implements Initializable {

    @FXML
    private TextField Ntf;
    @FXML
    private TextField Dtf;
    @FXML
    private TextField Ptf;
    @FXML
    private ComboBox comb;
    @FXML
    private Label label;
    @FXML
    private Label Eup;
    @FXML
    private Label Fuc;
    @FXML
    private Label Eun;
    @FXML
    private Label Eud;
    @FXML
    private Button addT;
    private Button menu;
    @FXML
    private Button addM;
   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // ObservableList<String> list = FXCollections.observableArrayList("NIVEAU 1","NIVEAU 2","NIVEAU 3","NIVEAU 4","NIVEAU 5");
       comb.setItems(FXCollections.observableArrayList("NIVEAU 1","NIVEAU 2","NIVEAU 3","NIVEAU 4","NIVEAU 5"));
   
    }    

    @FXML
    private void Select(ActionEvent event) {
     String s = comb.getSelectionModel().getSelectedItem().toString();
     label.setText(s);
    }

    @FXML
    private void onSave(ActionEvent event) {
        int c=0;
          float p;
       

        //String cString = Ctf.getText();
        String pString = Ptf.getText();
        
        try{
           // c = Integer.parseInt(cString);
             p = Integer.parseInt(pString);
        }catch(NumberFormatException exc){
            System.out.println("Number is required");
            return;
        }  
        /*try{
            nom = String.valueOf(Ntf.getText());
            Eun.setVisible(false);
        }catch(Exception exc){
            System.out.println("name exception");
            Eun.setVisible(true);
            return;
        }  */

        
        if(Ntf.getText().equals("")){
            System.out.println("Le nom est requis");
            return;
        }
         if(Dtf.getText().equals("")){
            System.out.println("La description est requis");
            return;
        }
         
         if(label.getText().equals("NIVEAU 1")){
            //System.out.println("Le nom est requis");
            c = 6;
        }
         if(label.getText().equals("NIVEAU 2")){
            //System.out.println("Le nom est requis");
            c = 4;
        }
         if(label.getText().equals("NIVEAU 3")){
            //System.out.println("Le nom est requis");
            c = 3;
        }
         if(label.getText().equals("NIVEAU 4")){
            //System.out.println("Le nom est requis");
            c = 2;
        }
         if(label.getText().equals("NIVEAU 5")){
            //System.out.println("Le nom est requis");
            c = 1;
        }
        
        Abonnements o = new Abonnements(c, Ntf.getText(),Dtf.getText(), p);
        ServicesAbonnements ps = new ServicesAbonnements();
        
         ps.ajouter(o);
        
        System.out.println("Abonnements ajouté");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Abonnementliste.fxml"));
        
        try {
            Parent root = loader.load();
            DetailsController controller = loader.getController();
            
               controller.setCategoriLabel(c);
            controller.setNomLabel(o.getNom());
            controller.setDescriptionLabel(o.getDescription());
            
         
            controller.setPrixLabel(p);
         
            //this.Idtf.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AbonnementsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    
    @FXML
    private void handleButtonAction (ActionEvent event) throws Exception {
        Stage stage;
        Parent root;
       
        if(event.getSource()==addT){
            
            stage = (Stage) addT.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Push.fxml"));
              Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }

        
    }
       

    @FXML
    private void onMenu(ActionEvent event)  throws Exception {
        Stage stage;
        Parent root;
       
        if(event.getSource()==addM){
            
            stage = (Stage) addM.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Abonnementliste.fxml"));
              Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }

    
    }
    
}
    
//}
