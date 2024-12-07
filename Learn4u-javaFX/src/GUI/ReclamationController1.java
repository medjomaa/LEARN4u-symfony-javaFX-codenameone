/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.util.Duration;
import entities.Reclamation;


import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;
import org.controlsfx.control.Notifications;
import services.ReclamationService;

import utils.MyConnection;



/**
 * FXML Controller class
 *
 * @author med
 */
public class ReclamationController1 implements Initializable {
     static int v = 0 ;
    static Stage stageAdd;
    static Reclamation d;
    @FXML
    private TableColumn<Reclamation, String>rating;
    @FXML
    private TableColumn<Reclamation, String> title;
    @FXML
    private TableColumn<Reclamation, String> category;
    @FXML
    private TableColumn<Reclamation, String> content;
    @FXML
    private Button supprimer;
    @FXML
    private TextField tfsearch;
  
    @FXML
    public TableView table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //    ServiceAvis sa = new ServiceAvis();
           ReclamationService RS = new ReclamationService();
        ArrayList arrayList = (ArrayList) RS.afficher();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        table.setItems(observableList);
       rating.setCellValueFactory(new PropertyValueFactory<>("type"));
       title.setCellValueFactory(new PropertyValueFactory<>("description"));
      category.setCellValueFactory(new PropertyValueFactory<>("user"));
      content.setCellValueFactory(new PropertyValueFactory<>("notification"));
        // TODO
    }    

   

    @FXML
    private void supprimer(ActionEvent event) {
        
               if (table.getSelectionModel().isEmpty()) {
             new Alert(Alert.AlertType.ERROR, "The table is empty ").show();
        } else {
            ObservableList<Reclamation> bon = table.getSelectionModel().getSelectedItems();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure to delete this reclamation");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                    ReclamationService sa = new  ReclamationService();
                sa.supprimer(bon.get(0));
                System.out.println(bon.get(0));
                System.out.println(bon.get(0).getId());
            }
        }
        list();
        
        
    }
    
      @FXML
    private void pdf(ActionEvent event) {
      //  Image img = new Image('/tick.png');
          Notifications notificationBuilder = Notifications.create()
                    .title("Reclamation ajouteé")
                    .text("Reclamation ajouteé")
                 //   .graphic(new ImageView(img))
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
        
 PrinterJob job = PrinterJob.createPrinterJob();
 if (job != null) {
     table.setScaleX(0.60);
                        table.setScaleY(0.60);
                        table.setTranslateX(-500);
    boolean success = job.printPage(table);
    
    if (success) {
        
        job.endJob();
       
        table.setScaleX(1);
                        table.setScaleY(1);
                        table.setTranslateX(0);

    }
 }
    }
    @FXML
    private void chercher(ActionEvent event) {
        ObservableList< Reclamation> List = FXCollections.observableArrayList();
        ReclamationService sa = new  ReclamationService();
        try {
            Connection cnx = MyConnection.getInstance().getConnection();
            String text = tfsearch.getText();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT * FROM Reclamation where type='" + text + "'");

            while (rs.next()) {
                List.add(new Reclamation( rs.getString("type"), rs.getString("description"),rs.getInt(1)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationController1.class.getName()).log(Level.SEVERE, null, ex);
        }
        rating.setCellValueFactory(new PropertyValueFactory<>("type"));
        title.setCellValueFactory(new PropertyValueFactory<>("description"));
        category.setCellValueFactory(new PropertyValueFactory<>("user"));
        content.setCellValueFactory(new PropertyValueFactory<>("notification"));
        
        table.setItems(List);
        table.refresh();
    }
    
    @FXML
       public void list(){
     //   ServiceAvis sa = new ServiceAvis();
        ReclamationService rs =new ReclamationService();
     //   ArrayList arrayList = (ArrayList) sa.afficher();
           ArrayList arrayListt = (ArrayList) rs.afficher();
           System.out.println(arrayListt);
           ObservableList observableListt = FXCollections.observableArrayList(arrayListt);
       table.setItems(observableListt);
     /*   ObservableList observableList = FXCollections.observableArrayList(arrayList);
        table.setItems(observableList);*/
       
}
   
    @FXML
    private void gotorate(ActionEvent event) throws IOException {
         d = (Reclamation) table.getSelectionModel().getSelectedItem();

            
            
          
        //Stage stageModifier = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/add_reclamation.fxml"));
        Scene scene = new Scene(root);
        stageAdd = new Stage();
        stageAdd.setScene(scene);
        stageAdd.show();
        // setNode(FXMLLoader.load(getClass().getResource("/pidev/bonplan/GUI/ModifierCategorie.fxml")));
    }
    private void gotostat(ActionEvent event) throws IOException {
         d = (Reclamation) table.getSelectionModel().getSelectedItem();

            
            
          
        //Stage stageModifier = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/ChartR.fxml"));
        Scene scene = new Scene(root);
        stageAdd = new Stage();
        stageAdd.setScene(scene);
        stageAdd.show();
        // setNode(FXMLLoader.load(getClass().getResource("/pidev/bonplan/GUI/ModifierCategorie.fxml")));
    }

    @FXML
    private void edit(ActionEvent event) throws IOException  {
        
                      if (table.getSelectionModel().isEmpty()) {
             new Alert(Alert.AlertType.ERROR, "The table is empty ").show();
        } else {
            ObservableList<Reclamation> bon = table.getSelectionModel().getSelectedItems();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure to edit this reclamation");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                     Parent root = FXMLLoader.load(getClass().getResource("/GUI/modifier_reclamation.fxml"));
                     Scene scene = new Scene(root);
                    stageAdd = new Stage();
                      stageAdd.setScene(scene);
                      stageAdd.show();
                    ReclamationService sa = new  ReclamationService();
                     
             //  sa.modifier(bon.get(0));
           
                System.out.println(bon.get(0).getId());
                 v =bon.get(0).getId() ;
                  System.out.println("test 1 /////////////");
            }
        }
        list();
    }
    
}
