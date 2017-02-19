/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entites.Action;
import Entites.User;
import Service.ActionMetier;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Krist
 */
public class NotificationsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableColumn<Action, Integer> id_u;

    @FXML
    private TableColumn<Action, LocalDate> date;

    @FXML
    private TableColumn<Action, Integer> id_n;

    @FXML
    private TableView<Action> table;

    @FXML
    private TableColumn<Action, String> username;

    @FXML
    private TableColumn<Action, String> desc;
    @FXML
    private JFXButton vider;
    
    
      @FXML
    private JFXHamburger ham1;
    
    
     @FXML
    private void DeleteButtonAction(ActionEvent event) {
        ActionMetier A= new ActionMetier();
        
        A.DeleteAction();
        
         ArrayList<Action>LST = A.ListAction();
     
    
        ObservableList<Action> lst = FXCollections.observableArrayList();
        for ( int i=0;i<LST.size();i++)
        {  lst.add(LST.get(i));
              }
        
        
        id_u.setCellValueFactory(new PropertyValueFactory<Action,Integer>("id_User"));
        desc.setCellValueFactory(new PropertyValueFactory<Action,String>("Description"));
        username.setCellValueFactory(new PropertyValueFactory<Action,String>("UserName"));
        date.setCellValueFactory(new PropertyValueFactory<Action,LocalDate>("dateAction"));
       
        table.setItems(lst);
        
    
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ActionMetier A = new ActionMetier();
        ArrayList<Action>LST = A.ListAction();
     
    
        ObservableList<Action> lst = FXCollections.observableArrayList();
        for ( int i=0;i<LST.size();i++)
        {  lst.add(LST.get(i));
              }
        
         
        id_u.setCellValueFactory(new PropertyValueFactory<Action,Integer>("id_User"));
        desc.setCellValueFactory(new PropertyValueFactory<Action,String>("Description"));
        username.setCellValueFactory(new PropertyValueFactory<Action,String>("UserName"));
        date.setCellValueFactory(new PropertyValueFactory<Action,LocalDate>("dateAction"));
       
        table.setItems(lst);
        
        
        
         HamburgerSlideCloseTransition tr1= new HamburgerSlideCloseTransition(ham1);
        tr1.setRate(-1);
        ham1.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{
             
           try {
               Parent root = FXMLLoader.load(getClass().getResource("AccueilTeste.fxml"));
               
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
