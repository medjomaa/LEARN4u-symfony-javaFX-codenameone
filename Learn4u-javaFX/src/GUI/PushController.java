/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author mouss
 */
public class PushController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
      
       Notifications notificationBuilder;
        notificationBuilder = Notifications.create()
                .title("Abonnements Ajouté")
                .text("Saved to Home/Abonnement/")
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.TOP_LEFT)
                .onAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("Clicked on notification");
                    }
                });
        notificationBuilder.showConfirm();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
