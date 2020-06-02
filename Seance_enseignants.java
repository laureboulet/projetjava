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
    private int id_seance_enseignants;
    
    //constructeurs
    public Seance_enseignants(){}
    
    public Seance_enseignants(int id_seance_salles){
        this.id_seance_enseignants = id_seance_enseignants;
    }
    //methodes
    public int getId_seance_enseignants(){
        return id_seance_enseignants;
    }
    public void setId_seance_enseignants(int id_seance_enseignants){
        this.id_seance_enseignants = id_seance_enseignants;
    }
}
