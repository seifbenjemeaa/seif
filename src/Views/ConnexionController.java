/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entites.Action;
import Entites.Session;
import Entites.User;
import Service.ActionMetier;
import Service.UserMetier;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.ImageView;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.textfield.TextFields;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

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
    private ImageView imagUser;

    @FXML
    private ImageView imagePass;

    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
      
     
       int idbase;
        
         String Username=TU.getText();
         String Password = TP.getText();
         User R = new User(Username, Password, "", "", "", "");
        UserMetier RM= new UserMetier();
     boolean vr=   RM.Authentification(R);
  
    
    
      NotificationType type = NotificationType.SUCCESS;

        TrayNotification tray = new TrayNotification("Authentification", "Bienvenue chez Host&Guest "+Username, NotificationType.SUCCESS);
        
        tray.setNotificationType(type);
        
        
        
         

        TrayNotification trayFail= new TrayNotification("Authentification", "Username ou mot de passe incorrecte", NotificationType.WARNING);
        
       
       
       
       
           if (vr==true)      
          { tray.showAndDismiss(Duration.seconds(2));
        idbase=RM.getID(Username);
        R.setId(idbase);
        R.setPseudo(Username);
    LocalDate l = LocalDate.now();
          ActionMetier AA = new ActionMetier();
         
         Action A = new Action("Authentification depuis Java Desktop", l, idbase, Username);
        AA.InsertAction(A);
        
        
        
         Parent root = FXMLLoader.load(getClass().getResource("AccueilTeste.fxml"));
         
        Scene scene = new Scene(root);
        
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
        
        app_stage.setScene(scene);
        
        app_stage.show();
                
        
                  }
           else
               
           {trayFail.showAndDismiss(Duration.seconds(3));}
           
           
         
             }
    
    
      @FXML
    private void SwitchButtonAction(ActionEvent event) throws IOException {
      
       Parent root = FXMLLoader.load(getClass().getResource("PasswordMail.fxml"));
         
        Scene scene = new Scene(root);
        
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
        
        app_stage.setScene(scene);
        
        app_stage.show();
    
    }
    
     @FXML
    private void Singup(ActionEvent event) throws IOException {
      
       Parent root = FXMLLoader.load(getClass().getResource("Inscris.fxml"));
         
        Scene scene = new Scene(root);
        
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
        
        app_stage.setScene(scene);
        
        app_stage.show();
    
    }
     
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition tr= new TranslateTransition();
        tr.setDuration(Duration.seconds(2));
        tr.setNode(Connexion);
        tr.setByY(0);
        tr.setByX(100);
        tr.play();
        
         TranslateTransition trr= new TranslateTransition();
        trr.setDuration(Duration.seconds(2));
        trr.setNode(inscription);
        trr.setByY(0);
        trr.setByX(-100);
        trr.play();
        
        
           TranslateTransition trUser= new TranslateTransition();
        trUser.setDuration(Duration.seconds(2));
        trUser.setNode(TU);
        trUser.setByY(120);
        trUser.setByX(0);
        trUser.play();
        
        
         TranslateTransition trPass= new TranslateTransition();
        trPass.setDuration(Duration.seconds(2));
        trPass.setNode(TP);
        trPass.setByY(140);
        trPass.setByX(0);
        trPass.play();
        
          TranslateTransition TrViewUser= new TranslateTransition();
      TrViewUser  .setDuration(Duration.seconds(2));
        TrViewUser.setNode(imagUser);
        TrViewUser.setByY(120);
        TrViewUser.setByX(0);
        TrViewUser.play();
        
          TranslateTransition TRViewpass= new TranslateTransition();
        TRViewpass.setDuration(Duration.seconds(2));
        TRViewpass.setNode(imagePass);
        TRViewpass.setByY(140);
        TRViewpass.setByX(0);
        TRViewpass.play();
        
        
      
       
    }    
    
}
