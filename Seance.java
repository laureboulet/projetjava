/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Date;

/**
 *
 * @author laure et clemence
 */
public class Seance {
    //attributs
    private int id;
    private int semaine;
    private Date date;
    private int heure_debut;
    private int heure_fin;
    private int etat;
    private int id_cours;
    private int id_type;
    
    //constructeurs 
    public Seance(){}
    /**
     * constructeur
     * @param id
     * @param semaine
     * @param date
     * @param heure_debut
     * @param heure_fin
     * @param etat
     * @param id_cours
     * @param id_type 
     */
    public Seance(int id,int semaine,Date date,int heure_debut,int heure_fin,int etat,int id_cours, int id_type){
        this.id = id;
        this.semaine = semaine;
        this.date = date;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.etat = etat;
        this.id_cours = id_cours;
        this.id_type = id_type;
    }
    //methodes
    /**
     * on get l'id
     * @return 
     */
    public int getId(){
        return id;
    }
    /**
     * on get le numero de la semaine
     * @return 
     */
    public int getSemaine(){
        return semaine;
    }
    /**
     * on recupère la date
     * @return 
     */
    public Date getDate(){
        return date;
    }
    /**
     * on recupère l'heure de debut
     * @return 
     */
    public int getHeure_debut(){
        return heure_debut;
    }
    /**
     * on recupère l'heure de fin
     * @return 
     */
    public int getHeure_fin(){
        return heure_fin;
    }
    /**
     * on recupère l'etat
     * @return 
     */
    public int getEtat(){
        return etat;
    }
    /**
     * on recupère l'id du cours
     * @return 
     */
    public int getId_cours(){
        return id_cours;
    }
    /** 
     * on recupère l'id du type de cours
     * @return 
     */
    public int getId_type(){
        return id_type;
    }
    /**
     * on rentre l'id
     * @param id 
     */
    public void setId(int id){
        this.id = id;
    }
    /**
     * on rentre la semaine
     * @param semaine 
     */
    public void setSemaine(int semaine){
        this.semaine = semaine;
    }
    /**
     * on rentre la date
     * @param date 
     */
    public void setDate(Date date){
        this.date = date;
    }
    /**
     * on rentre l'heure de debut
     * @param heure_debut 
     */
    public void setHeure_debut(int heure_debut){
        this.heure_debut = heure_debut;
    }
    /**
     * on rentre l'heure de fin
     * @param heure_fin 
     */
    public void setHeure_fin(int heure_fin){
        this.heure_fin = heure_fin;
    }
    /**
     * on rentre l'etat
     * @param etat 
     */
    public void setEtat(int etat){
        this.etat = etat;
    }
    /**
     * on rentre l'id du cours
     * @param id_cours 
     */
    public void setId_cours(int id_cours){
        this.id_cours = id_cours;
    }
    /**
     * on rentre l'id du type de cours
     * @param id_type 
     */
    public void setId_type(int id_type){
        this.id_type = id_type;
    }

    int getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
