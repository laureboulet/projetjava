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
    private int id_seance;
    private int id_salle;
    
    //constructeurs
    public Seance_salles(){}
    
    /**
     * constructeur
     * @param id_seance
     * @param id_salle 
     */
    public Seance_salles(int id_seance, int id_salle){
        this.id_seance = id_seance;
        this.id_salle = id_salle;
    }
    //methodes
    /**
     * on recupere l'id de la seance
     * @return 
     */
    public int getId_seance(){
        return id_seance;
    }
    
    /**
     * on recupère l'id d'une salle 
     * @return 
     */
    public int getId_salle(){
        return id_salle;
    }
    /**
     * on recupère l'id d'une seance
     * @param id_seance 
     */
    public void setId_seance(int id_seance){
        this.id_seance = id_seance;
    }
    /**
     * on rcupere l'id d'une salle
     * @param id_salle 
     */
    public void setId_salle(int id_salle){
        this.id_salle = id_salle;
    }
}
