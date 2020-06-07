/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import modele.Cours;
import modele.CoursDAO;
import modele.Enseignant;
import modele.EnseignantDAO;
import modele.Groupe;
import modele.GroupeDAO;
import modele.Salle;
import modele.SalleDAO;
import modele.Seance;
import modele.SeanceDAO;
import modele.Seance_enseignants;
import modele.Seance_enseignantsDAO;
import modele.Seance_groupes;
import modele.Seance_groupesDAO;
import modele.Seance_salles;
import modele.Seance_sallesDAO;
import modele.Type_cours;
import modele.Type_coursDAO;
import modele.Utilisateur;
import modele.UtilisateurDAO;
import vue.Maj;
import vue.MajInfo;

/**
 *
 * @author laure et clemence
 */
public class Controleur_maj {
    /**
     * controleur vide
     */
    public Controleur_maj(){
        
    }
    
    /**
     * constructeur
     * @param ut
     * @param maj 
     */
    public Controleur_maj(Utilisateur ut, Maj maj){
        //on récupère tous les enseignants
        List<Enseignant> ens = new ArrayList<>();
        EnseignantDAO ensd = new EnseignantDAO();
        ens=ensd.findAll();
        
        for(Enseignant it : ens){
            Utilisateur util = new Utilisateur();
            UtilisateurDAO utild = new UtilisateurDAO();
            util=utild.findNom(it.getId_utilisateur());
            maj.enseignant.addItem(util.getNom());
        }
        
        // on récupère tous les groupes
        List<Groupe> gr = new ArrayList<>();
        GroupeDAO grd = new GroupeDAO();
        gr=grd.findAll();
        
        for(Groupe it: gr){
            maj.groupe.addItem(it.getNom());
        }
        
        //on récupère toutes les salles
        List<Salle> sal = new ArrayList<>();
        SalleDAO sald = new SalleDAO();
        sal=sald.findAll();
        
        for(Salle it: sal){
            maj.salle.addItem(it.getNom());
        }
        
        //on récupère les données rentrées qui ont été stockées dans Majinfo
        
        maj.okBouton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0) {        
        maj.info = new MajInfo(maj.etat.getSelectedItem().toString(), maj.nom.getText(), (String)maj.type.getSelectedItem(), (String)maj.enseignant.getSelectedItem(),(String)maj.groupe.getSelectedItem(),(String)maj.salle.getSelectedItem(),(String)maj.date.getText(),getHoraire());
        //setVisible(false);
        
        //on récupère heure de debut et de fin
        int hdebut=0, hfin=0;
        
        switch (maj.info.heures) {
            case "8:00-9:30":
                hdebut=800;
                hfin=930;
                break;
            case "9:30-11:00":
                hdebut=930;
                hfin=1100;
                break;
            case "11:00-12:30":
                hdebut=1100;
                hfin=1230;
                break;
            case "12:30-14:00":
                hdebut=1230;
                hfin=1400;
                break;
            case "14:00-15:30":
                hdebut=1400;
                hfin=1530;
                break;
            case "15:30-17:00":
                hdebut=1530;
                hfin=1700;
                break;
            case "17:00-18:30":
                hdebut=1700;
                hfin=1830;
                break;
            case "18:30-20:00":
                hdebut=1830;
                hfin=2000;
                break;
            case "20:00-21:30":
                hdebut=2000;
                hfin=2130;
                break;
            default:
                break;
        }
        
        //on récupère l'id du cours
        Cours cours = new Cours();
        CoursDAO coursd = new CoursDAO();
        cours=coursd.findId(maj.info.nom);
        int idCours = cours.getId();
        
        //on recupère l'id du type
        Type_cours tcours = new Type_cours();
        Type_coursDAO tcoursd = new Type_coursDAO();
        tcours=tcoursd.findId(maj.info.type);
        int typeCours = tcours.getId();
        
        int state = maj.info.etat;
        
        //onrécupère la date 
       // String dat=maj.info.date;
        //Date date=Date.valueOf(dat);
         Date date = Date.valueOf(maj.info.date);
        //java.sql.Date date = new java.sql.Date(dat);
        
        
        //on crée la séance 
        Seance seance = new Seance();
        SeanceDAO seanced = new SeanceDAO();
        
        seance.setHeure_debut(hdebut);
        seance.setHeure_fin(hfin);
        seance.setDate(date);
        seance.setEtat(state);
        seance.setId_cours(idCours);
        seance.setId_type(typeCours);
        seance.setSemaine(1);
        
        seanced.create(seance);
        seance=seanced.findId(seance);
        
        
        //on récupère l'id du groupe
        Groupe groupe = new Groupe();
        GroupeDAO grouped = new GroupeDAO();
        groupe = grouped.findId(maj.info.groupe);
        
        //on crée une séane_groupe
        Seance_groupes segr = new Seance_groupes();
        Seance_groupesDAO segrd = new Seance_groupesDAO();
        segr=segrd.createS(seance,groupe);
        
        //on récupère l'id de l'enseignant
        Utilisateur prof = new Utilisateur();
        UtilisateurDAO profd = new UtilisateurDAO();
        
        prof=profd.findId(maj.info.enseignant);
        
        //on crée une seance enseignant à partir d'une seance et d'un enseignant
        Enseignant ens = new Enseignant();
        ens.setId_utilisateur(prof.getId());
        
        Seance_enseignants see = new Seance_enseignants();
        Seance_enseignantsDAO seed = new Seance_enseignantsDAO();
        seed.createS(seance,ens);
        
        
        // on crée une séance salle
        Salle room = new Salle();
        SalleDAO roomd = new SalleDAO();
        room=roomd.findId(maj.info.salle);
        System.out.println(room.getId());
        Seance_salles ss = new Seance_salles();
        Seance_sallesDAO ssd = new Seance_sallesDAO();
        ssd.createS(seance, room);
        
       maj.setVisible(false);
        
      }

      /**
       * on récupère les plages horaires
       */  
      public String getHoraire(){
        return (maj.tranche1.isSelected()) ? maj.tranche1.getText() : 
               (maj.tranche2.isSelected()) ? maj.tranche2.getText() : 
               (maj.tranche3.isSelected()) ? maj.tranche3.getText() : 
               (maj.tranche4.isSelected()) ? maj.tranche4.getText() :
               (maj.tranche5.isSelected()) ? maj.tranche5.getText() :
               (maj.tranche6.isSelected()) ? maj.tranche6.getText() :
               (maj.tranche7.isSelected()) ? maj.tranche7.getText() :
               (maj.tranche8.isSelected()) ? maj.tranche8.getText() :
               (maj.tranche9.isSelected()) ? maj.tranche9.getText() :
                maj.tranche1.getText();  
      }
        });
        
       
        maj.setVisible(true);
        
    }
}
