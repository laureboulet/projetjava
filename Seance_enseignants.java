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
public class Seance_enseignants {
    //attribut
    private int id_seance;
    private int id_enseignant;
    
    //constructeurs
    public Seance_enseignants(){}
    
    public Seance_enseignants(int id_seance, int id_enseignant){
        this.id_seance = id_seance;
        this.id_enseignant = id_enseignant;
    }
    //methodes
    public int getId_seance(){
        return id_seance;
    }
    
    public int getId_enseignant(){
        return id_enseignant;
    }
    
    public void setId_seance(int id_seance){
        this.id_seance = id_seance;
    }
    
    public void setId_enseignant(int id_enseignant){
        this.id_enseignant = id_enseignant;
    }
}
