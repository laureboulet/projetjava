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
    /**
     * Constructeur
     * @param id
     * @param email
     * @param passwd
     * @param nom
     * @param prenom
     * @param droit 
     */
    public Utilisateur(int id, String email, String passwd, String nom, String prenom, int droit){
        this.id = id;
        this.email = email;
        this.passwd = passwd;
        this.nom = nom;
        this.prenom = prenom;
        this.droit = droit;
    }
    
    //methodes pour récupérer toutes les attributs 
    /**
     * recupère l'id
     * @return 
     */
    public int getId(){
        return id;
    }
    /**
     * recupère l'email
     * @return 
     */
    public String getEmail(){
        return email;
    }
    /**
     * recupère le mot de passe
     * @return 
     */
    public String getPasswd(){
        return passwd;
    }
    /**
     * recupere le nom
     * @return 
     */
    public String getNom(){
        return nom;
    }
    /**
     * recupère le prenom
     * @return 
     */
    public String getPrenom(){
        return prenom;
    }
    /**
     * recupère le droit
     * @return 
     */
    public int getDroit(){
        return droit;
    }
    
    //methodes pour mettre à jour des valeurs d'attributs
    /**
     * rentre l'id
     * @param id 
     */
    public void setId(int id){
        this.id = id;
    }
    /**
     * rentre l'email
     * @param email 
     */
    public void setEmail(String email){
        this.email = email;
    }
    /**
     * rentre le mot de passe
     * @param passwd 
     */
    public void setPasswd(String passwd){
        this.passwd = passwd;
    }
    /**
     * rentre le nom
     * @param nom 
     */
    public void setNom(String nom){
        this.nom = nom;
    }
    /**
     * rentre le prenom
     * @param prenom 
     */
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    /**
     * rentre le droit
     * @param droit 
     */
    public void setDroit(int droit){
        this.droit = droit;
    }
    
    
}
