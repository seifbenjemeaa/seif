/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entites.User;
import Service.UserMetier;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Krist
 */
public class AccueilTesteController implements Initializable {

    /**
     * Initializes the controller class.
     */
        @FXML
    private JFXButton annonce;
        
            @FXML
    private JFXButton annonce2;

    @FXML
    private JFXButton notif;

    @FXML
    private JFXHamburger hamb1;

    @FXML
    private Label L1;

    @FXML
    private JFXButton profil;

    @FXML
    private ImageView photo;

    @FXML
    private JFXButton reclam;

    @FXML
    private JFXButton gestion;
      @FXML
    private VBox Vbox;

      
      
       @FXML
    private void SwitchButtonAction(ActionEvent event)  throws IOException {
     Stage stage; 
          Parent root;
          stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
       //load up OTHER FXML document
          root = FXMLLoader.load(getClass().getResource("SimpleProfil.fxml"));
          Scene scene = new Scene(root);
          stage.setScene(scene);
          stage.show();
        
     
    }
    
    @FXML
    private void Notifications(ActionEvent event)  throws IOException {
     Stage stage; 
          Parent root;
          stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
       //load up OTHER FXML document
          root = FXMLLoader.load(getClass().getResource("Notifications.fxml"));
          Scene scene = new Scene(root);
          stage.setScene(scene);
          stage.show();
        
     
    }
    
       @FXML
    private void Gestions(ActionEvent event)  throws IOException {
     Stage stage; 
          Parent root;
          stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
       //load up OTHER FXML document
          root = FXMLLoader.load(getClass().getResource("Profil.fxml"));
          Scene scene = new Scene(root);
          stage.setScene(scene);
          stage.show();
        
     
    }
    
    @FXML
    private void Sortir(ActionEvent event)  throws IOException {
     Stage stage; 
          Parent root;
          stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
       //load up OTHER FXML document
          root = FXMLLoader.load(getClass().getResource("Connexion.fxml"));
          Scene scene = new Scene(root);
          stage.setScene(scene);
          stage.show();
          User R = new User();
          R.setId(0);
          R.setPseudo("");
        
     
    }


      
      

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User R = new User();
      String CH="Bienvenue "+R.getPseudo()+"";
    L1.setText(CH);
    UserMetier RR = new UserMetier();
    String path = RR.GetImage(R.getPseudo());
    Image img = new Image(path, 200, 250, true, true);
          Circle clip = new Circle(photo.getFitWidth() / 2,
                    photo.getFitHeight() / 2,
                    50);
            photo.setClip(clip);
    
       photo.setImage(img);
      
       
         TranslateTransition Tphoto= new TranslateTransition();
        Tphoto.setDuration(Duration.seconds(2));
        Tphoto.setNode(L1);
        Tphoto.setByY(0);
        Tphoto.setByX(200);
        Tphoto.play();
       
       
       
      annonce2.setVisible(false);
       annonce.setVisible(false);
       notif.setVisible(false);
        gestion.setVisible(false);
         notif.setVisible(false);
         reclam.setVisible(false);
       
       
       
     
        User U = new User();
        int id =U.getId();
        UserMetier RRR= new UserMetier();
        
        String role = RRR.GetRole(U.getPseudo());
        if (role.equals("USER"))
        {
            annonce.setVisible(true);
       
        gestion.setVisible(false);
         notif.setVisible(false);
         reclam.setVisible(true);
         annonce2.setVisible(true);
        }
        else
        {
                annonce.setVisible(true);
       notif.setVisible(true);
        gestion.setVisible(true);
         
         reclam.setVisible(true);
         annonce2.setVisible(true);
        }
            
        
       
         TranslateTransition TRViewpass= new TranslateTransition();
        TRViewpass.setDuration(Duration.seconds(1.5));
        TRViewpass.setNode(annonce);
        TRViewpass.setByY(0);
        TRViewpass.setByX(20);
        TRViewpass.play();
        
           TranslateTransition TProfil= new TranslateTransition();
        TProfil.setDuration(Duration.seconds(1.5));
        TProfil.setNode(reclam);
        TProfil.setByY(0);
        TProfil.setByX(20);
        TProfil.play();
        
        
           TranslateTransition T3= new TranslateTransition();
        T3.setDuration(Duration.seconds(1.5));
        T3.setNode(reclam);
        T3.setByY(0);
        T3.setByX(20);
        T3.play();
        
          TranslateTransition T4= new TranslateTransition();
        T4.setDuration(Duration.seconds(1.5));
        T4.setNode(annonce2);
        T4.setByY(0);
        T4.setByX(20);
        T4.play();
        
          TranslateTransition T5= new TranslateTransition();
        T5.setDuration(Duration.seconds(1.5));
        T5.setNode(notif);
        T5.setByY(0);
        T5.setByX(20);
        T5.play();
        
        
         TranslateTransition T6= new TranslateTransition();
        T6.setDuration(Duration.seconds(1));
        T6.setNode(gestion);
        T6.setByY(0);
        T6.setByX(20);
        T6.play();
        
            
       
        
        
      
       
        
    }    
    
}
