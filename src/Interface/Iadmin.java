/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entites.Admin;
import Entites.User;

/**
 *
 * @author Krist
 */
public interface Iadmin {
    
     public void InsertUser(Admin R);
    public void ModifyUser(Admin R);
    public void DeleteUser(Admin R);
}
