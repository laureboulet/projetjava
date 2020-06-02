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
    public Site(int id, String nom){
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
    public void setId(int id){
        this.id = id;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    
}
