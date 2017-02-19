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
import javafx.scene.image.ImageView;
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
    private ImageView imagM;
       
          @FXML
    private ImageView imagP;
    
    
     @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
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
        R.SetPassword(passC,id);
          TrayNotification tray = new TrayNotification("Modification Password", "Changement effectué ", NotificationType.SUCCESS);
        
        tray.setAnimationType(AnimationType.SLIDE);
        tray.showAndDismiss(Duration.seconds(2));
        
         LocalDate l = LocalDate.now();
          ActionMetier AA = new ActionMetier();
         User RR = new User();
         Action A = new Action("Changement de mot de passe", l, RR.getId(), RR.getPseudo());
         AA.InsertAction(A);
         Tpass.setText("");
         TpassC.setText("");
         
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
        trPass.setNode(Modifier);
        trPass.setByY(0);
        trPass.setByX(230);
        trPass.play();
        
        
         TranslateTransition Trvalider= new TranslateTransition();
        Trvalider.setDuration(Duration.seconds(2));
        Trvalider.setNode(Annuler);
        Trvalider.setByY(0);
        Trvalider.setByX(250);
        Trvalider.play();
        
      /*   TranslateTransition TrMail= new TranslateTransition();
        TrMail.setDuration(Duration.seconds(2));
        TrMail.setNode(Tpass);
        TrMail.setByY(0);
        TrMail.setByX(120);
        TrMail.play();
        
        TranslateTransition Trcode= new TranslateTransition();
        Trcode.setDuration(Duration.seconds(2));
        Trcode.setNode(TpassC);
        Trcode.setByY(0);
        Trcode.setByX(120);
        Trcode.play();
        
        TranslateTransition TrViewMail= new TranslateTransition();
        TrViewMail.setDuration(Duration.seconds(2));
        TrViewMail.setNode(imagM);
        TrViewMail.setByY(0);
        TrViewMail.setByX(100);
        TrViewMail.play();
        
         TranslateTransition TRVIEWPASS= new TranslateTransition();
        TRVIEWPASS.setDuration(Duration.seconds(2));
        TRVIEWPASS.setNode(imagP);
        TRVIEWPASS.setByY(0);
        TRVIEWPASS.setByX(100);
        TRVIEWPASS.play();*/
    }    
    
}
