/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.sql.Date;

/**
 *
 * @author laure et clemence
 */
public class MajInfo {
    public int etat;
    public String nom, type, enseignant, groupe, salle;
    public String date,heures;

    public MajInfo(){}
    /**
     * constructeur
     * @param etat
     * @param nom
     * @param type
     * @param enseignant
     * @param groupe
     * @param salle
     * @param date
     * @param heures 
     */
    public MajInfo(String etat, String nom, String type, String enseignant, String groupe, String salle, String date, String heures){
      if(etat.equals("Validée")){
          this.etat=2;
      }else if(etat.equals("En cours de validation")){
          this.etat=1;
      }else{
          this.etat=0;
      }
      this.nom = nom;
      this.type = type;
      this.enseignant = enseignant;
      this.groupe = groupe;
      this.salle = salle;
      this.date = date;
      this.heures = heures;
    }

    /**
     * affichage
     * @return 
     */
    public String toString(){
      String str;
      if(this.etat != 0 && this.nom != null && this.type != null && this.enseignant != null && this.groupe != null && this.salle != null && this.date != null && this.heures != null){
        str = "Description de la séance";
        str += "Etat : " + this.etat + "\n";
        str += "Nom : " + this.nom + "\n";
        str += "Type : " + this.type + "\n";
        str += "Enseignant : " + this.enseignant + "\n";
        str += "Groupe(s) : " + this.groupe + "\n";
        str += "Salle : " + this.salle + "\n";
        str += "Date : " + this.date + "\n";
        str += "Horaires : " + this.heures + "\n";
      }
      else{
        str = "Aucune information !";
      }
      return str;
    }
}
