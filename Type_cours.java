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
    /**
     * constructeur
     * @param id
     * @param nom 
     */
    public Type_cours(int id, String nom){
        this.id = id;
        this.nom = nom;
    }
    
    //methodes pour recuperer les attributs
    /**
     * recupère l'attribut de l'id
     * @return 
     */
    public int getId(){
        return id;
    }
    /**
     * recupere l'attribut nom
     * @return 
     */
    public String getNom(){
        return nom;
    }
    
    //methodes pour mettre à jour des valeurs d'attributs
    /**
     * rentre l'attribut de l'id
     * @param id 
     */
    public void setId(int id){
        this.id = id;
    }
    /**
     * rentre l'attribut nom
     * @param nom 
     */
     public void setNom(String nom){
        this.nom = nom;
    }
}
