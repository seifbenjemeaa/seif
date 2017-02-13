/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Krist
 */
public class ConnexionBase {
    
     private String url = "jdbc:mysql://localhost:3306/guest";
 
  private String user = "root";
  
  private String passwd = "";
 
  private static Connection con;
  
   private ConnexionBase(){
    try {
      con = DriverManager.getConnection(url, user, passwd);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
   
   
   public static Connection getInstance(){
    if(con == null){
      new ConnexionBase();
     
       
      
    }
   
    
    return con;   
  } 
    
    
    
}
