/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entites.User;
import Interface.IUser;
import ConnexionBD.ConnexionBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Kristou
 */
public class UserMetier implements IUser {
Connection con= ConnexionBase.getInstance();
    @Override
    public void InsertUser(User R) {
        String role="USER";
      
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
    public void ModifyUser(User R) {
        
        
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
    public void DeleteUser(User R) {
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

    @Override
    public void DisplayUser() {
       
      
           try
        {
             Statement  st=  (Statement) con.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery("SELECT * FROM user");
            while ( rs.next() ) {
           
                System.out.println(rs.getString("username") +"|"+rs.getString("password")+"|"+rs.getString("nom")+"|"+rs.getString("prenom")+"|"+rs.getString("adresse")+"|"+rs.getString("email"));
            }
           
            
        }
       catch (Exception e) {
      e.printStackTrace();
    }
       
       
    }

    @Override
    public boolean SearchUser(String UserName) {
        User R= new User();
        boolean vr=true;
        int id=0;
           try
        {
             Statement  st=  (Statement) con.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery("SELECT id FROM user WHERE username = '"+UserName+"'");
             while ( rs.next() ) {
            id=Integer.parseInt(rs.getString(1));
     
     }
             if (id==0)
             {
                 vr=false;
             }
            
        }
       catch (Exception e) {
      e.printStackTrace();
    }
        
       
        
        return vr;
    }

    @Override
    public ArrayList<User> ListUser() {
          User R= new User();
          String username;
          String pass;
          String nom;
          String prenom;
          String adresse;
          String Email;
        ArrayList<User> ListR= new ArrayList<>();
           try
        {
             Statement  st=  (Statement) con.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery("SELECT * FROM user");
            while ( rs.next() ) {
            username=rs.getString(2);
            pass=rs.getString(8);
            nom=rs.getString(18);
            prenom=rs.getString(19);
            adresse= rs.getString(20);
            Email= rs.getString(4);
                ListR.add(new User(username, pass, nom, prenom, adresse,Email));
            }
            
            
        }
       catch (Exception e) {
      e.printStackTrace();
    }
       return ListR; 
    }

    @Override
    public boolean Authentification(User R) {
        boolean vr = true;
        int id=0;
           try
        {
             Statement  st=  (Statement) con.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery("SELECT id FROM user WHERE username = '"+R.getUsername()+"' AND password='"+R.getPassword()+"'");
     while ( rs.next() ) {
            id=Integer.parseInt(rs.getString(1));
     
     }
             if( id==0)
     {
         vr=false;
     }
    
        }
       catch (Exception e) {
      e.printStackTrace();
    }
        
        return vr;
    }

    @Override
    public int getID(String username) {
        User R= new User();
        
        int id=0;
           try
        {
             Statement  st=  (Statement) con.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery("SELECT id FROM user WHERE username = '"+username+"'");
             while ( rs.next() ) {
            id=Integer.parseInt(rs.getString(1));
     
     }
            
            
        }
       catch (Exception e) {
      e.printStackTrace();
    }
        
       
        
        return id;
    }

    @Override
    public User GetUser(int id) {
        User R = new User();
         String username;
          String pass;
          String nom;
          String prenom;
          String adresse;
          String Email;
      
           try
        {
             Statement  st=  (Statement) con.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery("SELECT * FROM user where id="+id+"");
            while ( rs.next() ) {
            username=rs.getString(2);
            pass=rs.getString(8);
            nom=rs.getString(18);
            prenom=rs.getString(19);
            adresse= rs.getString(20);
            Email= rs.getString(4);
               R.setUsername(username); 
               R.setEmail(Email);
               R.setAdresse(adresse);
               R.setPassword(pass);
               R.setPrenom(prenom);
               R.setNom(nom);
            }
            
            
        }
       catch (Exception e) {
      e.printStackTrace();
    }
        
        return R;
    }

    @Override
    public void SetPassword(String password,int id) {
         
        try
        {
             Statement  st=  (Statement) con.createStatement();
             String sql="UPDATE user Set password='"+password+"' where "+id+"=id";
             st.executeUpdate(sql);
             
            
            
        }
       catch (Exception e) {
      e.printStackTrace();
    }
        System.out.println("Mot de passe modifié");
    }

    @Override
    public void SetImage(String s,String Username) {
            try
        {
             Statement  st=  (Statement) con.createStatement();
             String sql="UPDATE user Set image='"+s+"'where username = '"+Username+"'";
             st.executeUpdate(sql);
            
            
        }
       catch (Exception e) {
      e.printStackTrace();
    }
       
    }

    @Override
    public String GetImage(String Username) {
       
        
          
        String image="";
           try
        {
             Statement  st=  (Statement) con.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery("SELECT image FROM user WHERE username = '"+Username+"'");
             while ( rs.next() ) {
            image=rs.getString(1);
     
     }
            
            
        }
       catch (Exception e) {
      e.printStackTrace();
    }
        
        
        return image;
    }

    @Override
    public String GetRole(String username) {
        
        
         String role="";
           try
        {
             Statement  st=  (Statement) con.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery("SELECT roles FROM user WHERE username = '"+username+"'");
             while ( rs.next() ) {
            role=rs.getString(1);
     
     }
            
            
        }
       catch (Exception e) {
      e.printStackTrace();
    }
        
        
        return role;
    }
      
    

  
    
}
