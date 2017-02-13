/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entites.Session;
import Entites.User;
import Service.UserMetier;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Krist
 */
public class ConnexionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private JFXTextField TU;

    @FXML
    private JFXButton inscription;

    @FXML
    private JFXPasswordField TP;

    @FXML
    private JFXButton Connexion;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
      
     
       int idbase;
        
         String Username=TU.getText();
         String Password = TP.getText();
         User R = new User(Username, Password, "", "", "", "");
        UserMetier RM= new UserMetier();
     boolean vr=   RM.Authentification(R);
    Notifications not = Notifications.create()
                .text("Bienvenue chez Host&Guest "+Username)
                .title("Authentification")
                .graphic(null)
            .darkStyle()
                .position(Pos.TOP_RIGHT)
                .hideAfter(Duration.seconds(3));
       
         Notifications notif = Notifications.create()
                .text("Username ou mot de passe incorrecte")
                .title("Authentification")
                .graphic(null)
                 .darkStyle()
                .position(Pos.TOP_RIGHT)
                .hideAfter(Duration.seconds(3));
           if (vr==true)      
          { not.showInformation();
        idbase=RM.getID(Username);
        R.setId(idbase);
        R.setPseudo(Username);
         Parent root = FXMLLoader.load(getClass().getResource("AccueilTeste.fxml"));
         
        Scene scene = new Scene(root);
        
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
        
        app_stage.setScene(scene);
        
        app_stage.show();
                
        
                  }
           else
               
           {notif.showError();}
           
           System.out.println(R.getId());
         
             }
    
    
      @FXML
    private void SwitchButtonAction(ActionEvent event) throws IOException {
      
       Parent root = FXMLLoader.load(getClass().getResource("Inscris.fxml"));
         
        Scene scene = new Scene(root);
        
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
        
        app_stage.setScene(scene);
        
        app_stage.show();
    
    }
     
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
