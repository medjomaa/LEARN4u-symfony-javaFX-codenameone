/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class FXMLCoursController implements Initializable {

    @FXML
    private TextField search_field;
    @FXML
    private Button instructor_button;
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Label idf;
    @FXML
    private Label emmm;
    @FXML
    private GridPane gird;
    @FXML
    private Button f;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        label.setText(ConsulterCoursController.nom_recup);
        emmm.setText(ConsulterCoursController.decriptionrecup);
        // TODO
    }    

    @FXML
    private void search(KeyEvent event) {
    }

    @FXML
    private void pp(ActionEvent event) {
    }

    @FXML
    private void becomeInstructor(ActionEvent event) {
    }

    @FXML
    private void ffff(MouseEvent event) {
    }

    @FXML
    private void mes_abo(ActionEvent event) {
    }

    @FXML
    private void panier(MouseEvent event) {
    }

    @FXML
    private void abon(MouseEvent event) {
    }

    @FXML
    private void stat(MouseEvent event) {
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
    }


    @FXML
    private void fd(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/consulterEvent.fxml"));
            Stage stage = (Stage) f.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ConsulterEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
