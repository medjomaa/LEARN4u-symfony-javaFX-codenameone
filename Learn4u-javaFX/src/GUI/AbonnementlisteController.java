/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Abonnements;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.ServicesAbonnements;

/**
 * FXML Controller class
 *
 * @author mouss
 */
public class AbonnementlisteController implements Initializable {

  
   
    @FXML
    private TableView<Abonnements> AbT;
    ObservableList<Abonnements> list1;
    
    ObservableList<Abonnements> dataList; 
   
    @FXML
    private Button addT;
    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    //Abonnements abonnements = null;
    ServicesAbonnements sa=new ServicesAbonnements();
    //ObservableList<Abonnements> AbonnementsList = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Abonnements, Integer> category_id;
    @FXML
    private TableColumn<Abonnements, String> nom;
    @FXML
    private TableColumn<Abonnements, String> description;
    @FXML
    private TableColumn<Abonnements, Float> prix;
    @FXML
    private TextField filterField;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnUpdate;
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

     afficher();   
    }
     
    ServicesAbonnements o1= new ServicesAbonnements();
    List<Abonnements> list = new ArrayList<> ();
    // list = o1.afficher();
    public void afficher(){
        
        category_id.setCellValueFactory(new PropertyValueFactory<Abonnements, Integer>("category_id"));
        nom.setCellValueFactory(new PropertyValueFactory<Abonnements, String>("nom"));
        description.setCellValueFactory(new PropertyValueFactory<Abonnements, String>("description"));
        prix.setCellValueFactory(new PropertyValueFactory<Abonnements, Float>("prix"));
        list1=sa.afficher();
        System.out.println(list1);
        AbT.setItems(list1);
    }

   

    @FXML
    private void supprimerAb(ActionEvent event) {
        
        Abonnements a=  AbT.getItems().get(AbT.getSelectionModel().getSelectedIndex());
        sa.supprimer(a.getId());
        afficher();

    }
    
    
    @FXML
    private void handleButtonAction (ActionEvent event) throws Exception {
        Stage stage;
        Parent root;
       
        if(event.getSource()==addT){
            
            stage = (Stage) addT.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Abonnements.fxml"));
              Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
    
    }
    
    
    
    
    
}
  

























































    /* private final ObservableList<Abonnements> list1 = FXCollections.observableArrayList();
        @FXML
        void search_abonnements(){
        
         category_id.setCellValueFactory(new PropertyValueFactory<Abonnements, Integer>("category_id"));
        nom.setCellValueFactory(new PropertyValueFactory<Abonnements, String>("nom"));
        description.setCellValueFactory(new PropertyValueFactory<Abonnements, String>("description"));
        prix.setCellValueFactory(new PropertyValueFactory<Abonnements, Float>("prix"));
        
       // dataList= mysqlconnect.getDataabonnements();
        
        AbT.setItems(list1);
      /*  FilteredList<Abonnements> filtereDdata = new FilteredList<>(dataList, b-> true);
        fiteredField.textProperty().addListener((observable, oldValue, newValue) -> {
            FilteredData.setPredicate( person -> {
            if (newValue == null || newValue.isEmpty()){
            return true;}
            
            String lowerCaseFilter = newValue.toLowerCase();
            
            if (abonnements.getCategory_id().toLowerCase().indexOf(lowerCaseFilter) != -1){
            return true;
            } 
            else if (abonnements.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1){
            return true;
            } else if (abonnements.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1){
                
            return true;
            }
            else if (abonnements.getPrix().toLowerCase().indexOf(lowerCaseFilter) != -1)
            return true;
                else 
                    return false;
            
                });
        });
        
        
        // rechercher
         FilteredList<Abonnements> filteredData = new FilteredList<>(AbonnementsList, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
            fielterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Abonnements -> {
            // If filter text is empty, display all persons.

            if (newValue == null || newValue.isEmpty()) {
            return true;
        }

           // Compare first name and last name of every person with filter text.
          String lowerCaseFilter = newValue.toLowerCase();

            if (Abonnements.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
            return true; // Filter matches first name.
        } 

        else  
         return false; // Does not match.
            });
            });
            
            
        
          SortedList<Abonnements> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        //  Otherwise, sorting the TableView would have no effect.
            sortedData.comparatorProperty().bind(AbT.comparatorProperty());
        // 5. Add sorted (and filtered) data to the table.
            AbT.setItems(sortedData);
           
}
        
}
            /*
        }                SortedList<Abonnements> sortedData = new SortedList<>(filteredData);

            // 4. Bind the SortedList comparator to the TableView comparator.
            //  Otherwise, sorting the TableView would have no effect.
            sortedData.comparatorProperty().bind(AbT.comparatorProperty());
                FilteredList<Abonnements> filteredData1 = new FilteredList<>(sortedData, b -> true);
                textfield1.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData1.setPredicate(Abonnements -> {

            if (newValue == null || newValue.isEmpty()) {
            return true;
                }

            // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(Abonnements.getPrix()).indexOf(lowerCaseFilter) != -1)
                    return true;

                    else  
                    return false; // Does not match.
        });
        });
                
    // 3. Wrap the FilteredList in a SortedList. 
    //      3. Wrap the FilteredList in a SortedList. 

    SortedList<Abonnements> sortedData1 = new SortedList<>(filteredData1);

        // 4. Bind the SortedList comparator to the TableView comparator.
        //  Otherwise, sorting the TableView would have no effect.
            sortedData1.comparatorProperty().bind(AbT.comparatorProperty());
        // 5. Add sorted (and filtered) data to the table.
            AbT.setItems(sortedData1);
    }
    

    @FXML
    private void deleteQ(ActionEvent event) {
          Abonnements q = AbT.getSelectionModel().getSelectedItem();
        o1.supprimer(q);
        o1.afficher();
    }
    
    
    private void affQ(ActionEvent event) {
        Abonnements q = AbT.getSelectionModel().getSelectedItem();
       // DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      // parsing the string to convert it into date
        //LocalDate local_date = LocalDate.parse(e.getDate());
        category_id.setText(Integer.toString(q.getCategory_id()));
        nom.setText(q.getNom());
        description.setText(q.getDescription());
        prix.setText(Float.toString(q.getPrix()));

      */  
   
            /*
   @FXML
    private void handleButtonAction (ActionEvent event) throws Exception {
        Stage stage;
        Parent root;
       
        if(event.getSource()==addT){
            
            stage = (Stage) addT.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Abonnements.fxml"));
              Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
    
    }
    
}

*/