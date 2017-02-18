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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
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
    
    User R1 = new User();
      @FXML
    private JFXPasswordField Tpass;

 
    @FXML
    private ImageView imgP;

   

    @FXML
    private JFXTextField Tuser;

    @FXML
    private JFXTextField Tadd;

 @FXML
    private Label erreur;

   

    @FXML
    private JFXTextField Tprenom;

    

    @FXML
    private JFXTextField tmail;

   private File file;

    @FXML
    private JFXTextField Tnom;
    
    
    @FXML
    private JFXButton valider;
        @FXML
    private JFXButton annuler;
        
        
            @FXML
    private JFXButton editpassword;
        
          FileChooser fileChooser = new FileChooser();
        //FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        //fileChooser.getExtensionFilters().add(extFilter);
         
    
    
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
          String S="";
          try
          {
              S=  file.toURI().toString();
          }
          catch(Exception e) {
                TrayNotification trayS = new TrayNotification("Inscription", "Image manquante", NotificationType.WARNING);
        
   trayS.setAnimationType(AnimationType.SLIDE);
        trayS.showAndDismiss(Duration.seconds(5));
        vr=false;
          }
          
         
          
          
         if(RM.SearchUser(Username))
         {
               TrayNotification trayS = new TrayNotification("Inscription", "Username déja pris", NotificationType.WARNING);
        trayS.setAnimationType(AnimationType.POPUP);
   trayS.setAnimationType(AnimationType.POPUP);
        trayS.showAndDismiss(Duration.seconds(2));
        vr=false;
             
         }
        
         else if (Username.equals("")|| password.equals("") || Adresse.equals("") || Nom.equals("")|| Prenom.equals("") || Email.equals("") ||RM.SearchUser(Username) )
          {
              vr=false;
          }
         
         
          if ( vr==true)
          {
        // User R = new User(Username, password, Nom, Prenom, Adresse, Email);
        R1.setEmail(Email);
        R1.setAdresse(Adresse);
        R1.setPassword(password);
        R1.setNom(Nom);
        R1.setPrenom(Prenom);
        R1.setUsername(Username);
      
      RM.InsertUser(R1);
      
     
      
         RM.SetImage(S, Username);
      
     

        TrayNotification trayS = new TrayNotification("Inscription", "Inscription réussi Veuillez vous connectez", NotificationType.SUCCESS);
        trayS.setAnimationType(AnimationType.POPUP);
   
        trayS.showAndDismiss(Duration.seconds(2));
                
       
       
       
     
     Parent root = FXMLLoader.load(getClass().getResource("Connexion.fxml"));
         
        Scene scene = new Scene(root);
        
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
        
        app_stage.setScene(scene);
        
        app_stage.show();
         
         
         
       
                
          }
          else
          {
               

        TrayNotification tray = new TrayNotification("Inscription", "tout les sont champs obligatoires ", NotificationType.WARNING);
        tray.setAnimationType(AnimationType.POPUP);
      
        tray.showAndDismiss(Duration.seconds(2));
          }
        
    }
    
    @FXML
    private void ErreurButtonAction(KeyEvent event) {
        
      /*String Username=Tuser.getText();
        UserMetier RM= new UserMetier();
       if( RM.SearchUser(Username))
       {  erreur.setText("Username déja pris");}*/
        
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
    
    
    @FXML
    private void uploadImage() {
                file = fileChooser.showOpenDialog(imgP.getScene().getWindow());

        if (file != null) {
            Image img = new Image(file.toURI().toString(), 200, 250, true, true);
            imgP.setImage(img);
            imgP.setFitWidth(252);
            imgP.setFitHeight(238);

              Circle clip = new Circle(imgP.getFitWidth() / 2,
                    imgP.getFitHeight() / 2,
                    100);
            imgP.setClip(clip);
        }
   
    }
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
