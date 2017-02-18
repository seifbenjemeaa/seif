/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXNodesList;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
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
    private ImageView imagP;
    
    
     @FXML
    private void handleButtonAction(ActionEvent event) {
        
        final String username = "Kristou993@gmail.com";
		final String password = "Maxo22655274";
 
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
			message.setFrom(new InternetAddress("Kristou993@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(Mail.getText()));
			message.setSubject("Changement mot de passe");
			message.setText("Votre code est 2457");
 
			Transport.send(message);
 
			System.out.println("message sent successfully");
      }
      catch (MessagingException e) {
          System.out.println("message not sent");
      throw new RuntimeException(e);}
                
                Mail.setText("");
                
                  TrayNotification trayfail = new TrayNotification("Email", "Un code a été envoyé a votre adresse mail", NotificationType.INFORMATION);
                       trayfail.setAnimationType(AnimationType.SLIDE);

   
        trayfail.showAndDismiss(Duration.seconds(3));
                
		}
        
          @FXML
    private void CodeButtonAction(ActionEvent event) throws IOException {
       String code= Code.getText();
       if (code.equals("2457"))
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
    public void initialize(URL url, ResourceBundle rb) {
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
    }    
    
}
