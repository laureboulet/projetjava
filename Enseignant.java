/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author laure clemence
 */
public class Enseignant {
    //attributs
    private int id_utilisateur;
    private int id_cours;
    
    
    /**contructeur vide
     * 
     */
    public Enseignant(){
        
    }
    
    /**constructeur avec attributs
     * 
     * @param id_utilisateur 
     */
    public Enseignant(int id_utilisateur){
        this.id_utilisateur = id_utilisateur;
        
    }
    
    /**methodes pour recuperer les attributs
     * on recupère l'id de l'utilisateur
     * @return 
     */
    public int getId_utilisateur(){
        return id_utilisateur;
    }
    
    /**on récupère l'id du cours
     * 
     * @return 
     */
    public int getId_cours(){
        return id_cours;
    }
    
    /**methodes pour mettre à jour des valeurs d'attributs
     * on entre la valeur id utilisateur
     * @param id_utilisateur 
     */
    public void setId_utilisateur(int id_utilisateur){
        this.id_utilisateur = id_utilisateur;
    }
    
    /**
     * on entre la valeur id cours
     * @param id_cours 
     */
    public void setId_cours(int id_cours){
        this.id_cours = id_cours;
    }
}
