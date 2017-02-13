/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entites.User;
import Service.UserMetier;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User R =  new User();
        int id= R.getId();
        
        UserMetier RM = new UserMetier();
       R= RM.GetUser(40);
       Luser.setText(R.getUsername());
       Ladresse.setText(R.getAdresse());
       Lnom.setText(R.getNom());
       Lprenom.setText(R.getPrenom());
       Lpass.setText(R.getPassword());
       Lemail.setText(R.getEmail());
       
    }    
    
}
