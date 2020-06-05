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
    public int getId(){
        return id;
    }
    public int getSemaine(){
        return semaine;
    }
    public Date getDate(){
        return date;
    }
    public int getHeure_debut(){
        return heure_debut;
    }
    public int getHeure_fin(){
        return heure_fin;
    }
    public int getEtat(){
        return etat;
    }
    public int getId_cours(){
        return id_cours;
    }
    public int getId_type(){
        return id_type;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setSemaine(int semaine){
        this.semaine = semaine;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public void setHeure_debut(int heure_debut){
        this.heure_debut = heure_debut;
    }
    public void setHeure_fin(int heure_fin){
        this.heure_fin = heure_fin;
    }
    public void setEtat(int etat){
        this.etat = etat;
    }
    public void setId_cours(int id_cours){
        this.id_cours = id_cours;
    }
    public void setId_type(int id_type){
        this.id_type = id_type;
    }

    int getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
