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
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Krist
 */
public class ModifierController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
      @FXML
    private JFXTextField Temail;

    @FXML
    private JFXTextField Tadresse;

    @FXML
    private JFXButton annuler;

    @FXML
    private JFXTextField TUser;

    @FXML
    private JFXTextField Tprenom;

    @FXML
    private JFXButton Modifier;

    @FXML
    private JFXTextField Tnom;
    
    private File file;
    
        @FXML
    private ImageView imagp;
    
            @FXML
    private JFXHamburger ham1;
    
    
    
    
    
     @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
      boolean vr = true;
       String Username=TUser.getText();
        
        String Adresse=Tadresse.getText();
        String Nom=Tnom.getText();
        String Prenom=Tprenom.getText();
          String Email=Temail.getText();
         User R = new User(Username, "", Nom, Prenom, Adresse, Email);
         UserMetier RM= new UserMetier();
          if (Username.equals("")|| Adresse.equals("") || Nom.equals("")|| Prenom.equals("") || Email.equals("")  )
          {
              vr=false;
          }
            if ( vr==true)
          {
      
        RM.ModifyUser(R);
        
     

        TrayNotification trayS = new TrayNotification("Modification", "Modification effectué", NotificationType.SUCCESS);
        
   
        trayS.showAndDismiss(Duration.seconds(2));
          
          
          LocalDate l = LocalDate.now();
          ActionMetier AA = new ActionMetier();
         
         Action A = new Action("Modification de compte", l, R.getId(), R.getPseudo());
         AA.InsertAction(A);
         String s="";
         boolean vri=true;
         if (file==null)
         { vri=false;}
         if ( vri)
         {
         s=file.toURI().toString();

             RM.SetImage(s, R.getPseudo());
         }
         
         
          TUser.setText("");
        
         Tadresse.setText("");
         Tnom.setText("");
         Tprenom.setText("");
          Temail.setText("");
         
          }
            
            else
            {
                  TrayNotification trayfail = new TrayNotification("Modification", "Tout les champs sont obligatoire", NotificationType.WARNING);
        
   
        trayfail.showAndDismiss(Duration.seconds(2));
          
            }
            
              Parent root = FXMLLoader.load(getClass().getResource("AccueilTeste.fxml"));
         
        Scene scene = new Scene(root);
        
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
        
        app_stage.setScene(scene);
        
        app_stage.show();
        
    }
    
    @FXML
    private void ResetButtonAction(ActionEvent event) {
        TUser.setText("");
       Tadresse.setText("");
       Tnom.setText("");
       Tprenom.setText("");
      
       Temail.setText("");
    }
    
    @FXML
    private void uploadImage() {
            FileChooser fileChooser = new FileChooser();

        file = fileChooser.showOpenDialog(imagp.getScene().getWindow());

        if (file != null) {
            Image img = new Image(file.toURI().toString(), 200, 250, true, true);
            imagp.setImage(img);
            imagp.setFitWidth(252);
            imagp.setFitHeight(238);

            Circle clip = new Circle(imagp.getFitWidth() / 2,
                    imagp.getFitHeight() / 2,
                    80);
            imagp.setClip(clip);
        }

    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User R =  new User();
        int id= R.getId();
        
        UserMetier RM = new UserMetier();
       R= RM.GetUser(id);
       TUser.setText(R.getUsername());
       Tadresse.setText(R.getAdresse());
       Tnom.setText(R.getNom());
       Tprenom.setText(R.getPrenom());
      
       Temail.setText(R.getEmail());
       
       HamburgerSlideCloseTransition tr1= new HamburgerSlideCloseTransition(ham1);
        tr1.setRate(-1);
        ham1.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{
             
           try {
               Parent root = FXMLLoader.load(getClass().getResource("AccueilTeste.fxml"));
               
               Scene scene = new Scene(root);
               
               Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
               
               app_stage.setScene(scene);
               
               app_stage.show();
           } catch (IOException ex) {
               Logger.getLogger(PasswordMailController.class.getName()).log(Level.SEVERE, null, ex);
           }
            
            });
      
       
    }    
    
}