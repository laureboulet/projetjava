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
public class Seance_groupes {
    //attribut
    private int id_seance_groupes;
    //constructeurs
    public Seance_groupes(){}
    
    public Seance_groupes(int id_seance_groupes){
        this.id_seance_groupes = id_seance_groupes;
    }
    //methodes
    public int getId_seance_groupes(){
        return id_seance_groupes;
    }
    public void setId_seance_groupes(int id_seance_groupes){
        this.id_seance_groupes = id_seance_groupes;
    }
}
