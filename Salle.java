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
public class Salle {
    //attributs
    private int id;
    private String nom;
    private int capacite;
    private int id_site;
    
    //constructeurs
    public Salle(){}
    public Salle(int id, String nom){
        this.id = id;
        this.nom = nom;
    }
    //methodes
    /**
     * on récupère l'id
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
     * on recupère la capacité
     * @return 
     */
    public int getCapacite(){
        return capacite;
    }
    /**
     * on recuprère l'id du site
     * @return 
     */
    public int getId_site(){
        return id_site;
    }
    /**
     * on remplit l'id
     * @param id 
     */
    public void setId(int id){
        this.id = id;
    }
    /**
     * on remplit le nom
     * @param nom 
     */
    public void setNom(String nom){
        this.nom = nom;
    }
    /**
     * on remplit la capacité
     * @param capacite 
     */
    public void setCapacite(int capacite){
        this.capacite = capacite;
    }
    /**
     * on remplit l'id du site
     * @param id_site 
     */
    public void setId_site(int id_site){
        this.id_site = id_site;
    }
}
