/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entites.Action;
import Entites.User;
import Service.ActionMetier;
import Service.UserMetier;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Krist
 */
public class ChangementPasswordMailController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
      @FXML
    private JFXPasswordField Tpass;

    @FXML
    private JFXPasswordField TpassC;

    @FXML
    private JFXTextField TUser;

    @FXML
    private JFXButton Valider;
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        boolean vr = true;
        String pass= Tpass.getText();
        String passC= TpassC.getText();
        String username= TUser.getText();
          User R1 = new User();

        UserMetier R = new UserMetier();
          int id = R.getID(TUser.getText());
        
        if (pass.equals(passC)==false )
        {
            vr=false;
            

        TrayNotification tray = new TrayNotification("Modification Password", "Combinaison de mot de passe incorret ", NotificationType.WARNING);
        
        tray.setAnimationType(AnimationType.POPUP);
        tray.showAndDismiss(Duration.seconds(3));
        }
        else if (id ==0){
            TrayNotification tray = new TrayNotification("Modification Password", "Username invalide ", NotificationType.WARNING);
        
        tray.setAnimationType(AnimationType.POPUP);
        tray.showAndDismiss(Duration.seconds(3));
            
        }
        else
        {
      
              
        R.SetPassword(passC,id);
          TrayNotification tray = new TrayNotification("Modification Password", "Changement effectué ", NotificationType.SUCCESS);
        
        tray.setAnimationType(AnimationType.SLIDE);
        tray.showAndDismiss(Duration.seconds(2));
        
         LocalDate l = LocalDate.now();
          ActionMetier AA = new ActionMetier();
         User RR = new User();
         Action A = new Action("Changement de mot de passe par mail", l, id, TUser.getText());
         AA.InsertAction(A);
        
         
          Parent root = FXMLLoader.load(getClass().getResource("Connexion.fxml"));
         
        Scene scene = new Scene(root);
        
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
        
        app_stage.setScene(scene);
        
        app_stage.show();
         
         
         
         
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       TranslateTransition trPass= new TranslateTransition();
        trPass.setDuration(Duration.seconds(2));
        trPass.setNode(Valider);
        trPass.setByY(0);
        trPass.setByX(300);
        trPass.play();
        
        
        
         TranslateTransition TrMail= new TranslateTransition();
        TrMail.setDuration(Duration.seconds(2));
        TrMail.setNode(Tpass);
        TrMail.setByY(0);
        TrMail.setByX(200);
        TrMail.play();
        
        TranslateTransition Trcode= new TranslateTransition();
        Trcode.setDuration(Duration.seconds(2));
        Trcode.setNode(TpassC);
        Trcode.setByY(0);
        Trcode.setByX(200);
        Trcode.play();
        
        TranslateTransition TRuser= new TranslateTransition();
        TRuser.setDuration(Duration.seconds(2));
        TRuser.setNode(TUser);
        TRuser.setByY(0);
        TRuser.setByX(200);
        TRuser.play();
    }    
    
}
