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
    /**
     * constructeur
     * @param id_seance
     * @param id_enseignant 
     */
    public Seance_enseignants(int id_seance, int id_enseignant){
        this.id_seance = id_seance;
        this.id_enseignant = id_enseignant;
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
     * on recupere l'id de l'enseignant
     * @return 
     */
    public int getId_enseignant(){
        return id_enseignant;
    }
    
    /**
     * on rentre l'id de la seance
     * @param id_seance 
     */
    public void setId_seance(int id_seance){
        this.id_seance = id_seance;
    }
    
    /**
     * on rentre l'id d'un enseignant
     * @param id_enseignant 
     */
    public void setId_enseignant(int id_enseignant){
        this.id_enseignant = id_enseignant;
    }
}
