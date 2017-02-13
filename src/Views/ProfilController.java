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
       boolean vr;
        
    String user= TUsername.getText();
    
    UserMetier RM = new UserMetier();
  
   vr=RM.SearchUser(user);
   
    
   
    
    
     if (vr==true)
      {
            User R= new User(user, "", "", "", "", "");
    RM.DeleteUser(R);
        Notifications noterr = Notifications.create()
                .text("Suppression succès")
                .title("Suppression")
                .graphic(null)
                .position(Pos.TOP_RIGHT)
                .hideAfter(Duration.seconds(3));
                
        noterr.showConfirm();
        
    }  
     else
     {
          Notifications noterr = Notifications.create()
                .text("UserName invalide")
                .title("Suppression")
                .graphic(null)
                .position(Pos.TOP_RIGHT)
                .hideAfter(Duration.seconds(3));
                
        noterr.showWarning();
     }
     
     TUsername.setText("");
   
  
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
