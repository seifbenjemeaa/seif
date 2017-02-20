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
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.input.MouseEvent;
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
    
      @FXML
    private JFXHamburger ham1;

    FileChooser fileChooser = new FileChooser();
    //FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
    //fileChooser.getExtensionFilters().add(extFilter);

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        boolean vr = true;
        boolean vrimage = true;
        UserMetier RM = new UserMetier();
        String Username = Tuser.getText();
        String password = Tpass.getText();
        String Adresse = Tadd.getText();
        String Nom = Tnom.getText();
        String Prenom = Tprenom.getText();
        String Email = tmail.getText();
      
        
        

        String S = "";
        try {
            S = file.toURI().toString();
        } catch (Exception e) {
            TrayNotification trayS = new TrayNotification("Inscription", "Image manquante", NotificationType.WARNING);

            trayS.setAnimationType(AnimationType.SLIDE);
            trayS.showAndDismiss(Duration.seconds(5));
            vr = false;
            vrimage = false;
        }

        if (RM.SearchUser(Username)) {
            TrayNotification trayS = new TrayNotification("Inscription", "Username déja pris", NotificationType.WARNING);
            trayS.setAnimationType(AnimationType.POPUP);
            trayS.setAnimationType(AnimationType.POPUP);
            trayS.showAndDismiss(Duration.seconds(2));
            vr = false;

        } else if (Username.equals("") || password.equals("") || Adresse.equals("") || Nom.equals("") || Prenom.equals("") || Email.equals("")) {
            TrayNotification tray = new TrayNotification("Inscription", "tout les sont champs obligatoires ", NotificationType.WARNING);
            tray.setAnimationType(AnimationType.POPUP);

            tray.showAndDismiss(Duration.seconds(2));
            vr = false;
        }
        else if (Mail_valide()==false)
        {
            TrayNotification tray = new TrayNotification("Inscription", "Adresse mail non valide", NotificationType.WARNING);
            tray.setAnimationType(AnimationType.POPUP);

            tray.showAndDismiss(Duration.seconds(2));
            
            vr=false;
        }
        
        
        else if (vr == true) {
            
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
    public boolean Mail_valide()
    {
        String email = tmail.getText();
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(email);
        return(m.matches());
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
 HamburgerSlideCloseTransition tr1= new HamburgerSlideCloseTransition(ham1);
        tr1.setRate(-1);
        ham1.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{
             
           try {
               Parent root = FXMLLoader.load(getClass().getResource("Connexion.fxml"));
               
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
