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
public class Type_cours {
    //attributs
    private int id;
    private String nom;
    
    //constructeur vide
    public Type_cours(){
        
    }
    
    //constructeur avec attrinuts
    public Type_cours(int id, String nom){
        this.id = id;
        this.nom = nom;
    }
    
    //methodes pour recuperer les attributs
    public int getId(){
        return id;
    }
    
    public String getNom(){
        return nom;
    }
    
    //methodes pour mettre à jour des valeurs d'attributs
    public void setId(int id){
        this.id = id;
    }
    
     public void setNom(String nom){
        this.nom = nom;
    }
}
