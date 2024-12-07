/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author mouss
 */
public class DetailsController implements Initializable {

  // @FXML
   // private Label ILabel;
    @FXML
    private Label CLabel;
    @FXML
    private Label NLabel;
    @FXML
    private Label DLabel;
    @FXML
    private Label PLabel;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
   /* public void setIdLabel(int id){
        this.ILabel.setText(id+"");
    }*/
     public void setCategoriLabel(int c){
        this.CLabel.setText(c+"");
    }
    
    public void setNomLabel(String value){
        this.NLabel.setText(value);
    }
    public void setDescriptionLabel(String value){
        this.DLabel.setText(value);
    }
    
    public void setPrixLabel(float p){
        this.PLabel.setText(p+"");
    }
   
}
