/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entites.User;

import Service.UserMetier;
import ConnexionBD.ConnexionBase;
import Entites.Action;
import Entites.Admin;
import Entites.Session;
import Service.ActionMetier;
import Service.AdminMetier;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 *
 * @author Kristou
 */
public class HostAndGuestJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date d = new Date(1993, 12, 10);
        LocalDate l = LocalDate.now();
        Action A = new Action("HELLO", l, 63, "SubZero");
        ActionMetier AA = new ActionMetier();
        AdminMetier RM = new AdminMetier();
                UserMetier RMM= new UserMetier();
                
        //Admin E= new Admin("ADMIN", "ADMIN", "Ahmed", "Kristou", "HOME", "Kristou993@gmail.com");
       // String URL ="file:/C:/Users/Krist/Desktop/628cc12d68dceeb2d25c3f787f18b196.jpg";
       // RM.InsertUser(E);
      //  RMM.SetImage("ADMIN", URL);
    // AA.InsertAction(A);
      // AA.DeleteAction();
            
       String mail_pattern="^[_a-z0-9-]+(\\\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\\\.[a-z0-9-]+)+$";
        Pattern pat = Pattern.compile(mail_pattern);
        Matcher mat=pat.matcher("ahmed.kristou@esprit.tn");

}
}