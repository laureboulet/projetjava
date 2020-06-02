/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author laure et clemence
 */
public class Utilisateur {
    //attributs
    private int id;
    private String email;
    private String passwd;
    private String nom;
    private String prenom;
    private int droit;
    
    //constructeur vide
    public Utilisateur(){
    }
    
    //constructeur avec attributs
    public Utilisateur(int id, String email, String passwd, String nom, String prenom, int droit){
        this.id = id;
        this.email = email;
        this.passwd = passwd;
        this.nom = nom;
        this.prenom = prenom;
        this.droit = droit;
    }
    
    //methodes pour récupérer toutes les attributs 
    public int getId(){
        return id;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPasswd(){
        return passwd;
    }
    
    public String getNom(){
        return nom;
    }
    
    public String getPrenom(){
        return prenom;
    }
    
    public int getDroit(){
        return droit;
    }
    
    //methodes pour mettre à jour des valeurs d'attributs
    public void setId(int id){
        this.id = id;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setPasswd(String passwd){
        this.passwd = passwd;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    
    public void setDroit(int droit){
        this.droit = droit;
    }
    
    
}
