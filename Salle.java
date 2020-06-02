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
    public int getId(){
        return id;
    }
    public String getNom(){
        return nom;
    }
    public int getCapacite(){
        return capacite;
    }
    public int getId_site(){
        return id_site;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setCapacite(int capacite){
        this.capacite = capacite;
    }
    public void setId_site(int id_site){
        this.id_site = id_site;
    }
}
