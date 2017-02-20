/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entites.User;
import java.util.ArrayList;


/**
 *
 * @author Kristou
 */
public interface IUser {
    
    public void InsertUser(User R);
    public void ModifyUser(User R);
    public void DeleteUser(User R);
    public void DisplayUser();
    public boolean  SearchUser(String Username);
    public ArrayList<User> ListUser();
    public boolean Authentification (User R);
    public int getID (String username);
public User GetUser (int id);
public void SetPassword ( String password,int id);
    public void SetImage(String s,String Username);
     public String GetImage(String Username);
     public String GetRole (String username);
      public ArrayList<User> ListUsercustom(String username);
      public String GetMail(String username);
    
    
}
