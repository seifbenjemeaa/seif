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
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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
    
    
    
     @FXML
    private void handleButtonAction(ActionEvent event) {
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
         
         Action A = new Action("Modification de compte", l, 63, "SubZero");
         AA.InsertAction(A);
         
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
        
    }
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User R =  new User();
        int id= R.getId();
        
        UserMetier RM = new UserMetier();
       R= RM.GetUser(63);
       TUser.setText(R.getUsername());
       Tadresse.setText(R.getAdresse());
       Tnom.setText(R.getNom());
       Tprenom.setText(R.getPrenom());
      
       Temail.setText(R.getEmail());
    }    
    
}
