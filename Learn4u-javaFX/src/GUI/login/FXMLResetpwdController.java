/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.login;

import Mailer.MailerAPI;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mailer.PasswordGenerator;
import org.controlsfx.control.Notifications;
import services.AuthService;

/**
 * FXML Controller class
 *
 * @author MSI GF63
 */
public class FXMLResetpwdController implements Initializable {

    @FXML
    private TextField tfemail;
    @FXML
    private Button tfresetpwd;
    @FXML
    private Button tfback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Resetpwd(ActionEvent event) {
        AuthService service = new AuthService();
            String pwd = "testtest"; //PasswordGenerator.generateStrongPassword()
        String mail = tfemail.getText();
     String regex = "^(.+)@(.+)$";
          Pattern email=Pattern.compile(regex);
          Matcher emailmatch=email.matcher(tfemail.getText());
          if(emailmatch.matches()==false)
         {
              Notifications notificationBuilder = Notifications.create()
                        .title("Notification").text("Not a valid email").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                        .position(Pos.BOTTOM_RIGHT)
                        .onAction((ActionEvent event1) -> {
                            System.out.println("Password sent to your mail ");
                });
                notificationBuilder.darkStyle();
                notificationBuilder.show();
         }else
          { 
            if (service.ResetPwd(mail, pwd) == true) {
                MailerAPI.send("noreply.learn4u@gmail.com", "123456sss", mail, "Password reset request ", "Hello " + mail + "\n This is your new password generated by SAHTI Application : \n  " + pwd + " \n The above is a temporary password. We highly recommend that you update the password after you log in successfully. \n Thanks, ");
                //notification
                Notifications notificationBuilder = Notifications.create()
                        .title("Notification").text("Password sent to your email").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
                        .position(Pos.BOTTOM_RIGHT)
                        .onAction((ActionEvent event1) -> {
                            System.out.println("Password sent to your mail ");
                });
                notificationBuilder.darkStyle();
                notificationBuilder.show();

            }
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/login/FXMLLogin.fxml"));

        Parent root;
        Stage stage;
        try {
            root = loader.load();
            stage = (Stage) tfresetpwd.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }}
    
    }

    @FXML
    private void cancel(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/login/FXMLLogin.fxml"));

        Parent root;
        Stage stage;
        try {
            root = loader.load();
            stage = (Stage) tfback.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}