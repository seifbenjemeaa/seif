/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import ConnexionBD.ConnexionBase;
import Entites.Admin;
import Interface.Iadmin;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Krist
 */
public class AdminMetier implements Iadmin {
Connection con= ConnexionBase.getInstance();
    @Override
    public void InsertUser(Admin R) {
        String role="ADMIN";
        try
        {
        Statement  st=  (Statement) con.createStatement();
   
      st.executeUpdate("INSERT INTO user (username,password,nom,prenom,adresse,email,roles) " + 
                "VALUES ('"+R.getUsername()+"', '"+R.getPassword()+"','"+R.getNom()+"','"+R.getPrenom()+"','"+R.getAdresse()+"',+'"+R.getEmail()+"','"+role+"')");
         }
       catch (Exception e) {
      e.printStackTrace();
    }
        System.out.println("l'utilisateur "+R.getUsername()+" a été ajouté a la base de données");
    }
    

    @Override
    public void ModifyUser(Admin R) {
            try
        {
             Statement  st=  (Statement) con.createStatement();
             String sql="UPDATE user Set nom='"+R.getNom()+"',prenom='"+R.getPrenom()+"',adresse='"+R.getAdresse()+"',email='"+R.getEmail()+"' where username='"+R.getUsername()+"' ";
             st.executeUpdate(sql);
             
            
            
        }
       catch (Exception e) {
      e.printStackTrace();
    }
        System.out.println("l'utilisateur "+R.getUsername()+" a été modifié dans la base de données");
    }

    @Override
    public void DeleteUser(Admin R) {
          try
        {
             Statement  st=  (Statement) con.createStatement();
             String sql="DELETE FROM user where '"+R.getUsername()+"'=username ";
             st.executeUpdate(sql);
             
            
            
        }
       catch (Exception e) {
      e.printStackTrace();
    }
       
        System.out.println("l'utilisateur "+R.getUsername()+" a été Supprimé de la base de données");
    }
    
}
