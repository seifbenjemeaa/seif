/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

/**
 *
 * @author Krist
 */
public class Session {
    protected static  int id;
 protected static String pseudo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String getPseudo() {
        return pseudo;
    }

    public  void setPseudo(String pseudo) {
        Session.pseudo = pseudo;
    }

  

  
    
}
