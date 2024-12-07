/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import entities.Avis;
import entities.Reclamation;
import static GUI.ReclamationController1.stageAdd;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.ServiceAvis;
import org.controlsfx.control.Notifications ;
import services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author med
 */
public class add_reclamationController1 implements Initializable {

    @FXML
    private ComboBox<String> rating;
    @FXML
    private TextField title;
  /*  private ComboBox<String> category;
    private TextField content;*/
   
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
       
        ObservableList<String> listr = FXCollections.observableArrayList("problem technique","problem de paymement","probleme de authentification","autres","5");
  //  ObservableList<String> listc = FXCollections.observableArrayList("java","symfony","codename one");
         rating.setItems(listr);
       //  category.setItems(listc);
    }    

    @FXML
    private void onSave(ActionEvent event) throws IOException {
      
     //   Avis p = new Avis(rating.getValue(), title.getText(), category.getValue(),content.getText());
          Reclamation p = new Reclamation(rating.getValue(), title.getText());
      //  ServiceAvis ps = new ServiceAvis();
        ReclamationService ps = new ReclamationService();
        
        if (!title.getText().equals("")&& !title.getText().equals("") )
         {
                  //ps.add(p);
               ps.ajouter(p);
               Parent root = FXMLLoader.load(getClass().getResource("/GUI/Reclamation.fxml"));
                     Scene scene = new Scene(root);
                    stageAdd = new Stage();
                      stageAdd.setScene(scene);
                      stageAdd.show() ;
                   // new Alert(Alert.AlertType.INFORMATION, "Reclamation ajouté").show();
                  

       Image image = new Image("/images/tick.png",50, 100, false, true);
        
                   
                     Notifications notificationBuilder = Notifications.create()
                    .title("Reclamation ")
                    .text("        Reclamation ajouteé")
                    .graphic(new ImageView(image)).darkStyle()
                    .hideAfter(Duration.seconds(5))
                             .position(Pos.TOP_RIGHT)
                             .onAction(new EventHandler<ActionEvent>()
                             {
                       @Override
                       public void handle(ActionEvent event) {
                            System.out.println("ok");
                       }
                             
                             }
                             );
                     notificationBuilder.show();
                     notificationBuilder.darkStyle();
       //  }*/
         }
         else
         {
                  new Alert(Alert.AlertType.ERROR, "Ecrivez votre titre et commentaire ").show();
         }
       
        
       
        
    }
    
}
