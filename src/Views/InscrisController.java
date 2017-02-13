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
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Krist
 */
public class InscrisController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
      @FXML
    private JFXPasswordField Tpass;

 

   

    @FXML
    private JFXTextField Tuser;

    @FXML
    private JFXTextField Tadd;

 

   

    @FXML
    private JFXTextField Tprenom;

    

    @FXML
    private JFXTextField tmail;

   

    @FXML
    private JFXTextField Tnom;
    
    
    @FXML
    private JFXButton valider;
        @FXML
    private JFXButton annuler;
    
    
     @FXML
    private void handleButtonAction(ActionEvent event) {
      
       String Username=Tuser.getText();
        String password=Tpass.getText();
        String Adresse=Tadd.getText();
        String Nom=Tnom.getText();
        String Prenom=Tprenom.getText();
          String Email=tmail.getText();
         User R = new User(Username, password, Nom, Prenom, Adresse, Email);
         UserMetier RM= new UserMetier();
         RM.InsertUser(R);
        Notifications not = Notifications.create()
                .text("Inscription réussi")
                .title("Inscription")
                .graphic(null)
                .position(Pos.TOP_RIGHT)
                .darkStyle()
                .hideAfter(Duration.seconds(3));
                
        not.showConfirm();
          Tuser.setText("");
       Tpass.setText("");
       Tadd.setText("");
      Tnom.setText("");
        Tprenom.setText("");
     tmail.setText("");
       
        
        
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
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
