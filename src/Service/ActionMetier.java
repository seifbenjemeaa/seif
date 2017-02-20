/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import ConnexionBD.ConnexionBase;
import Entites.Action;
import Entites.User;
import Interface.Iactions;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Krist
 */
public class ActionMetier implements Iactions {
Connection con= ConnexionBase.getInstance();

    @Override
    public void InsertAction(Action A) {
        
      
        try
        {
        Statement  st=  (Statement) con.createStatement();
   
      st.executeUpdate("INSERT INTO actions (id_user,description,date,username) " + 
                "VALUES ("+A.getId_User()+", '"+A.getDescription()+"','"+A.getDateAction()+"','"+A.getUserName()+"')");
         }
       catch (Exception e) {
      e.printStackTrace();
    }
      
    System.out.println("Suucess");

    }

    @Override
    public void DeleteAction() {
        try
        {
             Statement  st=  (Statement) con.createStatement();
             String sql="DELETE FROM actions " ;
             st.executeUpdate(sql);
             
            
            
        }
       catch (Exception e) {
      e.printStackTrace();
    }
           System.out.println("Suucess");
    }

    @Override
    public ArrayList<Action> ListAction() {
       
    Action A = new Action();
            
          String username;
          int id_n;
          int id_u;
          String Desc;
          LocalDate d;
          
        ArrayList<Action> ListR= new ArrayList<>();
           try
        {
             Statement  st=  (Statement) con.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery("SELECT * FROM actions");
            while ( rs.next() ) {
            username=rs.getString(5);
            Desc=rs.getString(3);
           d=LocalDate.parse(rs.getString(4));
           id_u=Integer.parseInt(rs.getString(2));
           id_n=Integer.parseInt(rs.getString(1));
                ListR.add(new Action(Desc, d, id_u, username));
            }
            
            
        }
       catch (Exception e) {
      e.printStackTrace();
    }
       return ListR; 
}

    @Override
    public ArrayList<Action> ListActionCustom(String Username) {
         Action A = new Action();
            
          String username;
          int id_n;
          int id_u;
          String Desc;
          LocalDate d;
          
        ArrayList<Action> ListR= new ArrayList<>();
           try
        {
             Statement  st=  (Statement) con.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery("SELECT * FROM actions where username = '"+Username+"'");
            while ( rs.next() ) {
            username=rs.getString(5);
            Desc=rs.getString(3);
           d=LocalDate.parse(rs.getString(4));
           id_u=Integer.parseInt(rs.getString(2));
           id_n=Integer.parseInt(rs.getString(1));
                ListR.add(new Action(Desc, d, id_u, username));
            }
            
            
        }
       catch (Exception e) {
      e.printStackTrace();
    }
       return ListR; 
        
        
    }
}
