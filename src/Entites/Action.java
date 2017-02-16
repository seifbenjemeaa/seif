/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Krist
 */
public class Action {
    private String Description;
    private LocalDate dateAction;
    private int id_User;
    private String UserName;

    public Action() {
       this.Description="";
       this.dateAction=null;
       this.id_User=0;
       this.UserName="";
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public LocalDate getDateAction() {
        return dateAction;
    }

    public void setDateAction(LocalDate dateAction) {
        this.dateAction = dateAction;
    }

    @Override
    public String toString() {
        return "Action{" + "Description=" + Description + ", dateAction=" + dateAction + ", id_User=" + id_User + ", UserName=" + UserName + '}';
    }

   

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public Action(String Description, LocalDate dateAction, int id_User, String UserName) {
        this.Description = Description;
        this.dateAction = dateAction;
        this.id_User = id_User;
        this.UserName = UserName;
    }
    
    
    
    
    
    
}
