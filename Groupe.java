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
public class Groupe {
    //attributs
    private int id;
    private String nom;
    private int id_promotion;
    
    //constructeur vide
    public Groupe(){
        
    }
    
    
    /**constructeur avec attributs
     * 
     * @param id
     * @param nom
     * @param id_promotion 
     */
    public Groupe(int id, String nom, int id_promotion){
        this.id = id;
        this.nom = nom;
        this.id_promotion = id_promotion;
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
    
    /**
     * on recupere l'id de la promotion
     * @return 
     */
    public int getId_promotion(){
        return id_promotion;
    }
    
    //methodes pour mettre à jour des valeurs d'attributs
    /**
     * on rntre l'id
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
    
    /**
     * on rentre l'id de la promotion
     * @param id_promotion 
     */
    public void setId_promotion(int id_promotion){
        this.id_promotion = id_promotion;
    }
}
