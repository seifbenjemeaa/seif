/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


import Entites.User;

import Service.UserMetier;
import ConnexionBD.ConnexionBase;
import Entites.Admin;
import Entites.Session;
import Service.AdminMetier;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Kristou
 */
public class HostAndGuestJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
    User R = new User("Ahmed", "21662847AIUE", "New User", "Ahmed", "Tunis","Kristou993@gmail.com");
    UserMetier RM= new UserMetier();
    User R2=new User();
     
      //ConnexionBase.getInstance();
    
      /*int i=2;
      User R3 = new User();
      R3=RM.SearchUser(i);
     String S= R3.toString();
     System.out.println(S);*/
    // RM.InsertUser(R);
      

   
    }
    
}
