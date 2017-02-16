/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entites.User;
import Service.UserMetier;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Krist
 */
public class ChangementPasswordController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    private JFXPasswordField Tpass;

    @FXML
    private JFXPasswordField TpassC;

    @FXML
    private JFXButton Annuler;

    @FXML
    private JFXButton Modifier;
    
    
     @FXML
    private void handleButtonAction(ActionEvent event) {
        boolean vr = true;
        String pass= Tpass.getText();
        String passC= TpassC.getText();
        if (pass.equals(passC)==false)
        {
            vr=false;
            

        TrayNotification tray = new TrayNotification("Modification Password", "Combinaison de mot de passe incorret ", NotificationType.WARNING);
        
        tray.setAnimationType(AnimationType.POPUP);
        tray.showAndDismiss(Duration.seconds(3));
        }
        else
        {
        User R1 = new User();
        int id = R1.getId();
        UserMetier R = new UserMetier();
        R.SetPassword(passC,40);
          TrayNotification tray = new TrayNotification("Modification Password", "Changement effectué ", NotificationType.SUCCESS);
        
        tray.setAnimationType(AnimationType.SLIDE);
        tray.showAndDismiss(Duration.seconds(2));
        }
        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
