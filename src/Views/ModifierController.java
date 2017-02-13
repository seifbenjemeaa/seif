/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entites.User;
import Service.UserMetier;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

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
      
       String Username=TUser.getText();
        
        String Adresse=Tadresse.getText();
        String Nom=Tnom.getText();
        String Prenom=Tprenom.getText();
          String Email=Temail.getText();
         User R = new User(Username, "", Nom, Prenom, Adresse, Email);
         UserMetier RM= new UserMetier();
        RM.ModifyUser(R);
        Notifications not = Notifications.create()
                .text("Modification faite avec succes")
                .title("Modification Compte")
                .graphic(null)
                .position(Pos.TOP_RIGHT)
                .hideAfter(Duration.seconds(3));
                
        not.showConfirm();
        
    }
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
