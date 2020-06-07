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
public class Etudiant {
    //attributs
    private int id_utilisateur;
    private int numero;
    private int id_groupe;
    
    //constructeur vide
    public Etudiant(){
        
    }
    
    /**constructeur avec attributs
     * 
     * @param id_utilisateur 
     */
    public Etudiant(int id_utilisateur){
        this.id_utilisateur = id_utilisateur;
        
    }
    
    /**methodes de recuperation des attributs
     * 
     * @return 
     */
    public int getId_utilisateur(){
        return id_utilisateur;
    }
    
    /**
     * on recupère le numero
     * @return 
     */
    public int getNumero(){
        return numero;
    }
    
    /**
     * on récupère l'id du groupe de l'etudiant
     * @return 
     */
    public int getId_groupe(){
        return id_groupe;
    }
    
    //methodes pour mettre à jour des valeurs d'attributs
    /**
     * on rentre son id
     * @param id_utilisateur 
     */
    public void setId_utilisateur(int id_utilisateur){
        this.id_utilisateur = id_utilisateur;
    }
    
    /**
     * on rentre son numero
     * @param numero 
     */
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    /**
     * on rentre son id de groupe
     * @param id_groupe 
     */
    public void setId_groupe(int id_groupe){
        this.id_groupe = id_groupe;
    }
}
