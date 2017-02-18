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
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    private Label profil;
    
          @FXML
    private JFXButton editpassword;
    
        
         @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        
         Parent root = FXMLLoader.load(getClass().getResource("Modifier.fxml"));
         
        Scene scene = new Scene(root);
        
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
        
        app_stage.setScene(scene);
        
        app_stage.show();
        
    }
    
       @FXML
    private void PAsswordButtonAction(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("ChangementPassword.fxml"));
         
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
        Image img = new Image(S, 200, 250, true, true);
         
    
       imagp.setImage(img);
        Circle clip = new Circle(imagp.getFitWidth() / 2,
                    imagp.getFitHeight() / 2,
                    85);
            imagp.setClip(clip);
       
        TranslateTransition trPass= new TranslateTransition();
        trPass.setDuration(Duration.seconds(2));
        trPass.setNode(profil);
        trPass.setByY(0);
        trPass.setByX(170);
        trPass.play();
        
        
         TranslateTransition TRimage= new TranslateTransition();
        TRimage.setDuration(Duration.seconds(2));
        TRimage.setNode(imagp);
        TRimage.setByY(-170);
        TRimage.setByX(0);
        TRimage.play();
       
    }    
    
}
