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
public class Promotion {
    //attributs
    private int id;
    private String nom;
    
    //constructeur vide
    public Promotion(){
        
    }
    
    //constructeur avec attributs
    public Promotion (int id, String nom){
        this.id = id;
        this.nom = nom;
    }
    
    //methodes pour récupérer toutes les attributs
    /**
     * on recupère l'id
     * @return 
     */
    public int getId(){
        return id;
    }
    
    /**
     * on recupère le nom
     * @return 
     */
    public String getNom(){
        return nom;
    }
    
    //methodes pour mettre à jour des valeurs d'attributs
    /**
     * on rentre l'id
     * @param id 
     */
    public void setId(int id){
        this.id = id;
    }
    
    /**
     * on rentre le nom
     * @param nom 
     */
    public void setNom(String nom){
        this.nom = nom;
    }
}
