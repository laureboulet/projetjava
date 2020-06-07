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
public class Site {
    //attributs
    private int id;
    private String nom;
    
    //constructeurs
    
    public Site(){}
    /**
     * constructeur
     * @param id
     * @param nom 
     */
    public Site(int id, String nom){
        this.id = id;
        this.nom = nom;
    }
    //methodes
    /**
     * recupère l'id
     * @return 
     */
    public int getId(){
        return id;
    }
    /**
     * recupere le nom
     * @return 
     */
    public String getNom(){
        return nom;
    }
    /**
     * rentre l'id
     * @param id 
     */
    public void setId(int id){
        this.id = id;
    }
    /**
     * rentre le nom
     * @param nom 
     */
    public void setNom(String nom){
        this.nom = nom;
    }
    
}
