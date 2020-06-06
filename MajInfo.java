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
    private int etat;
    private String nom, type, enseignant, groupe, salle;
    private String date,heures;

    public MajInfo(){}
    public MajInfo(int etat, String nom, String type, String enseignant, String groupe, String salle, String date, String heures){
      this.etat = etat;
      this.nom = nom;
      this.type = type;
      this.enseignant = enseignant;
      this.groupe = groupe;
      this.salle = salle;
      this.date = date;
      this.heures = heures;
    }

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
