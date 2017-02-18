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
        UserMetier RM = new UserMetier();
    // AA.InsertAction(A);
      // AA.DeleteAction();
     String S= RM.GetImage("saief");
     System.out.println(S);

}
}