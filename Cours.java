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
public class Cours {
    //attributs
    private int id;
    private String nom;
    
    //constructeur vide
    public Cours(){
        
    }
    
    //constructeurs avec attributs
    public Cours(int id, String nom){
        this.id = id;
        this.nom = nom;
    }
    
    //methodes pour recupérer les attributs
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
