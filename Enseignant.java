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
    private int id_enseignant;
    
    //contructeur vide
    public Enseignant(){
        
    }
    
    //constructeur avec attributs
    public Enseignant(int id_enseignant){
        this.id_enseignant = id_enseignant;
    }
    
    //methodes pour recuperer les attributs
    public int getId_enseignant(){
        return id_enseignant;
    }
    
    //methodes pour mettre à jour des valeurs d'attributs
    public void setId_enseignant(int id_enseignant){
        this.id_enseignant = id_enseignant;
    }
}
