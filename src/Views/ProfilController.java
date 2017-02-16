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
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Krist
 */
public class ProfilController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
      @FXML
    private TableColumn<User, String> Prenom;

    @FXML
    private TableColumn<User, String> Adresse;

    @FXML
    private TableColumn<User, String> password;

    @FXML
    private TableColumn<User, String> Email;

    @FXML
    private TableColumn<User, String> Username;

    @FXML
    private TableColumn<User, String> Nom;

    @FXML
    private TableView<User> table;
        @FXML
    private JFXButton lister;
        
        @FXML
    private JFXTextField TUsername;
    
    
     @FXML
    private void handleButtonAction(ActionEvent event) {
       
        
        UserMetier RM = new UserMetier();
     ArrayList<User>LST = RM.ListUser();
     
    
        ObservableList<User> lst = FXCollections.observableArrayList();
        for ( int i=0;i<LST.size();i++)
        {  lst.add(LST.get(i));
              }
        
          Prenom.setCellValueFactory(new PropertyValueFactory<User,String>("Prenom"));
        Nom.setCellValueFactory(new PropertyValueFactory<User,String>("Nom"));
        Adresse.setCellValueFactory(new PropertyValueFactory<User,String>("Adresse"));
        Email.setCellValueFactory(new PropertyValueFactory<User,String>("Email"));
        password.setCellValueFactory(new PropertyValueFactory<User,String>("password"));
        Username.setCellValueFactory(new PropertyValueFactory<User,String>("Username"));
        table.setItems(lst);
    }
    
     @FXML
    private void DeleteButtonAction(ActionEvent event) {
    
       User R = new User();
       R = table.getSelectionModel().getSelectedItem();
        
   
    
    UserMetier RM = new UserMetier();
  
    
    
   
   
    
   
    
    
    
           
    RM.DeleteUser(R);
    
    
    
        TrayNotification trayS = new TrayNotification("Suppression", "Le client "+R.getUsername()+" a été supprimé", NotificationType.SUCCESS);
        
   
        trayS.showAndDismiss(Duration.seconds(2));
       
      
     ArrayList<User>LST = RM.ListUser();
     
     
        ObservableList<User> lst = FXCollections.observableArrayList();
        for ( int i=0;i<LST.size();i++)
        {  lst.add(LST.get(i));
              }
        
          Prenom.setCellValueFactory(new PropertyValueFactory<User,String>("Prenom"));
        Nom.setCellValueFactory(new PropertyValueFactory<User,String>("Nom"));
        Adresse.setCellValueFactory(new PropertyValueFactory<User,String>("Adresse"));
        Email.setCellValueFactory(new PropertyValueFactory<User,String>("Email"));
        password.setCellValueFactory(new PropertyValueFactory<User,String>("password"));
        Username.setCellValueFactory(new PropertyValueFactory<User,String>("Username"));
        table.setItems(lst);
     
    
  
    }
    
    
    
    
    
     
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     System.out.println("Hello there");
     
      UserMetier RM = new UserMetier();
     ArrayList<User>LST = RM.ListUser();
     
      System.out.println("YOU CLIKED ME");
        ObservableList<User> lst = FXCollections.observableArrayList();
        for ( int i=0;i<LST.size();i++)
        {  lst.add(LST.get(i));
              }
        
          Prenom.setCellValueFactory(new PropertyValueFactory<User,String>("Prenom"));
        Nom.setCellValueFactory(new PropertyValueFactory<User,String>("Nom"));
        Adresse.setCellValueFactory(new PropertyValueFactory<User,String>("Adresse"));
        Email.setCellValueFactory(new PropertyValueFactory<User,String>("Email"));
        password.setCellValueFactory(new PropertyValueFactory<User,String>("password"));
        Username.setCellValueFactory(new PropertyValueFactory<User,String>("Username"));
        table.setItems(lst);
     
     
    }    
    
}
