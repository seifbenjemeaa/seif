/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Service.UserMetier;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXNodesList;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Krist
 */
public class PasswordMailController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXTextField Mail;

    @FXML
    private JFXPasswordField Code;
    
        @FXML
    private AnchorPane parent;
     @FXML
    private JFXButton envoie;
      @FXML
    private JFXButton valider;
    
      @FXML
    private ImageView imaM;
      
    @FXML
    private JFXTextField username;
        @FXML
    private ImageView usem;

   

    @FXML
    private ImageView imagP;
    
    
       @FXML
    private JFXHamburger ham1;
    private    int randomNum = ThreadLocalRandom.current().nextInt(100000, 999999 + 1);
    private String CodeValidation=Integer.toString(randomNum);
    
    
    
     @FXML
    private void handleButtonAction(ActionEvent event) {
        
        final String username = "hostandguest4@gmail.com";
		final String password = "esprit2250";
                 boolean vr=true;
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
                                @Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username,password);
				}
			});
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("hostandguest4@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(Mail.getText()));
			message.setSubject("Changement mot de passe");
			message.setText("votre code est  "+CodeValidation);
 
			Transport.send(message);
 
			System.out.println("message sent successfully");
      }
      catch (MessagingException e) {
          TrayNotification trayfail = new TrayNotification("Email", "Veuillez saisir votre Username", NotificationType.WARNING);
                       trayfail.setAnimationType(AnimationType.POPUP
                               
                       );
                                 trayfail.showAndDismiss(Duration.seconds(3));
                                 vr=false;
      }
                
                Mail.setText("");
                this.username.setText("");
               
              
                if ( vr)
                {
                
                
                  TrayNotification trayfail = new TrayNotification("Email", "Un code a été envoyé a votre adresse mail", NotificationType.INFORMATION);
                       trayfail.setAnimationType(AnimationType.SLIDE);

   
        trayfail.showAndDismiss(Duration.seconds(3));}
                
		}
    @FXML
     private void Mail(KeyEvent event) throws IOException {
         String UserName=username.getText();
         UserMetier rr= new UserMetier();
        String mail= rr.GetMail(UserName);
        Mail.setText(mail);
     }
    
    
    
        
          @FXML
    private void CodeButtonAction(ActionEvent event) throws IOException {
       String code= Code.getText();
       if (code.equals(CodeValidation))
               {
                    Parent root = FXMLLoader.load(getClass().getResource("ChangementPasswordMail.fxml"));
         
        Scene scene = new Scene(root);
        
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
        
        app_stage.setScene(scene);
        
        app_stage.show();
               }
       else
       {
            TrayNotification trayfail = new TrayNotification("Validation Code", "Code incorrect", NotificationType.WARNING);
        
                          trayfail.setAnimationType(AnimationType.POPUP);

        trayfail.showAndDismiss(Duration.seconds(2));
       }
    }
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
       TranslateTransition trPass= new TranslateTransition();
        trPass.setDuration(Duration.seconds(2));
        trPass.setNode(envoie);
        trPass.setByY(0);
        trPass.setByX(230);
        trPass.play();
        
        
         TranslateTransition Trvalider= new TranslateTransition();
        Trvalider.setDuration(Duration.seconds(2));
        Trvalider.setNode(valider);
        Trvalider.setByY(0);
        Trvalider.setByX(250);
        Trvalider.play();
        
         TranslateTransition TrMail= new TranslateTransition();
        TrMail.setDuration(Duration.seconds(2));
        TrMail.setNode(Mail);
        TrMail.setByY(0);
        TrMail.setByX(120);
        TrMail.play();
        
        TranslateTransition Trcode= new TranslateTransition();
        Trcode.setDuration(Duration.seconds(2));
        Trcode.setNode(Code);
        Trcode.setByY(0);
        Trcode.setByX(120);
        Trcode.play();
         TranslateTransition truser= new TranslateTransition();
        truser.setDuration(Duration.seconds(2));
        truser.setNode(username);
        truser.setByY(0);
        truser.setByX(120);
        truser.play();
        
         TranslateTransition TM= new TranslateTransition();
        TM.setDuration(Duration.seconds(2));
        TM.setNode(usem);
        TM.setByY(0);
        TM.setByX(120);
        TM.play();
        
        
        TranslateTransition TrViewMail= new TranslateTransition();
        TrViewMail.setDuration(Duration.seconds(2));
        TrViewMail.setNode(imaM);
        TrViewMail.setByY(0);
        TrViewMail.setByX(100);
        TrViewMail.play();
        
         TranslateTransition TRVIEWPASS= new TranslateTransition();
        TRVIEWPASS.setDuration(Duration.seconds(2));
        TRVIEWPASS.setNode(imagP);
        TRVIEWPASS.setByY(0);
        TRVIEWPASS.setByX(100);
        TRVIEWPASS.play();
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
