/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

/**
 *
 * @author Kristou
 */
public class User  extends Session{
    
    
    private String Username;
    private String password;
    private String Nom;
    private String Prenom;
    private String adresse ;
    private String Email;

    public User(String Username, String password, String Nom, String Prenom, String adresse,String Email) {
        this.Username = Username;
        this.password = password;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.adresse = adresse;
         this.Email = Email;
    }

    public User() {
        
    }

    @Override
    public String toString() {
        return "User{" + "Username=" + Username + ", password=" + password + ", Nom=" + Nom + ", Prenom=" + Prenom + ", adresse=" + adresse + ", Email=" + Email + '}';
    }

   
    
    
    
    

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
    
    
}
