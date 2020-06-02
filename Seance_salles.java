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
public class Seance_salles {
    //attribut
    private int id_seance_salles;
    
    //constructeurs
    public Seance_salles(){}
    
    public Seance_salles(int id_seance_salles){
        this.id_seance_salles = id_seance_salles;
    }
    //methodes
    public int getId_seance_salles(){
        return id_seance_salles;
    }
    public void setId_seance_salles(int id_seance_salles){
        this.id_seance_salles = id_seance_salles;
    }
}
