/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entites.User;
import Service.UserMetier;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Krist
 */
public class SimpleProfilController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private ImageView imagp;
    
    @FXML
    private Label Luser;

    @FXML
    private Label Lemail;

    @FXML
    private Label Ladresse;

    @FXML
    private Label Lnom;

    @FXML
    private Label Lprenom;

    @FXML
    private Label Lpass;
    
        @FXML
    private JFXButton Modification;
    
    
        
         @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        
         Parent root = FXMLLoader.load(getClass().getResource("Modifier.fxml"));
         
        Scene scene = new Scene(root);
        
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
        
        app_stage.setScene(scene);
        
        app_stage.show();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User R =  new User();
        int id= R.getId();
        
        UserMetier RM = new UserMetier();
       R= RM.GetUser(67);
       Luser.setText(R.getUsername());
       Ladresse.setText(R.getAdresse());
       Lnom.setText(R.getNom());
       Lprenom.setText(R.getPrenom());
       Lpass.setText(R.getPassword());
       Lemail.setText(R.getEmail());
      
       String S= RM.GetImage("saief");
     System.out.println(S);
        Image img = new Image(S, 100, 150, true, true);
    
       imagp.setImage(img);
       
    }    
    
}
