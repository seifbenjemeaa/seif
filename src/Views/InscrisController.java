/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entites.Action;
import Entites.User;
import Service.UserMetier;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Krist
 */
public class InscrisController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
      @FXML
    private JFXPasswordField Tpass;

 

   

    @FXML
    private JFXTextField Tuser;

    @FXML
    private JFXTextField Tadd;

 

   

    @FXML
    private JFXTextField Tprenom;

    

    @FXML
    private JFXTextField tmail;

   

    @FXML
    private JFXTextField Tnom;
    
    
    @FXML
    private JFXButton valider;
        @FXML
    private JFXButton annuler;
    
    
     @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
      boolean vr = true;
      UserMetier RM = new  UserMetier();
       String Username=Tuser.getText();
        String password=Tpass.getText();
        String Adresse=Tadd.getText();
        String Nom=Tnom.getText();
        String Prenom=Tprenom.getText();
          String Email=tmail.getText();
        
          if (Username.equals("")|| password.equals("") || Adresse.equals("") || Nom.equals("")|| Prenom.equals("") || Email.equals("") || RM.SearchUser(Username) )
          {
              vr=false;
          }
         
          if ( vr==true)
          {
         User R = new User(Username, password, Nom, Prenom, Adresse, Email);
        
         RM.InsertUser(R);
     

        TrayNotification trayS = new TrayNotification("Inscription", "Inscription réussi Veuillez vous connectez", NotificationType.SUCCESS);
        
   
        trayS.showAndDismiss(Duration.seconds(2));
                
       
       
       
     
     Parent root = FXMLLoader.load(getClass().getResource("Connexion.fxml"));
         
        Scene scene = new Scene(root);
        
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
        
        app_stage.setScene(scene);
        
        app_stage.show();
         
         
         
       
                
          }
          else
          {
               

        TrayNotification tray = new TrayNotification("Inscription", "tout les champs sont obligatoire ou bien le UserName est déja pris", NotificationType.WARNING);
        tray.setAnimationType(AnimationType.POPUP);
      
        tray.showAndDismiss(Duration.seconds(3));
          }
        
    }
    
    
    
      @FXML
    private void RsesetButtonAction(ActionEvent event) {
      
       Tuser.setText("");
       Tpass.setText("");
       Tadd.setText("");
      Tnom.setText("");
        Tprenom.setText("");
     tmail.setText("");
       
        
        
        
        
    }
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
