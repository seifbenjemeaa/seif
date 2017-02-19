/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entites.User;
import Service.UserMetier;
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
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

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
    private Label L1;
      
         @FXML
    private ImageView photo;

    @FXML
    private Label user;
      
      
       @FXML
    private void SwitchButtonAction(ActionEvent event) throws IOException {
      
     
    }
      
      

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        User R = new User();
      String CH="VOUS ETES CONNECTE EN TANT "+R.getPseudo()+"";
    L1.setText(CH);
    UserMetier RR = new UserMetier();
    String path = RR.GetImage(R.getPseudo());
    Image img = new Image(path, 200, 250, true, true);
          Circle clip = new Circle(photo.getFitWidth() / 2,
                    photo.getFitHeight() / 2,
                    85);
            photo.setClip(clip);
    
       photo.setImage(img);
       user.setText(R.getPseudo());
    }    
    
}
