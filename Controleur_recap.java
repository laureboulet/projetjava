/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import modele.Cours;
import modele.CoursDAO;
import modele.Etudiant;
import modele.EtudiantDAO;
import modele.Seance;
import modele.SeanceDAO;
import modele.Seance_groupes;
import modele.Seance_groupesDAO;
import modele.Utilisateur;
import vue.Edt;
import vue.Modele;
import vue.Recapitulatif;

/**
 *
 * @author laure et clemence
 */
public class Controleur_recap {
    public Controleur_recap(){
        
    }
    public Controleur_recap(Utilisateur ut){
        int droit = ut.getDroit();
        if(droit==4){
            Etudiant e = new Etudiant(ut.getId());
            EtudiantDAO ed = new EtudiantDAO();
            Seance_groupes sg = new Seance_groupes();
            List<Seance_groupes> obj= new ArrayList<>();
            Seance_groupesDAO sd= new Seance_groupesDAO();
            Seance seance = new Seance();
            SeanceDAO seanced = new SeanceDAO();
            
            
            e = ed.find(e.getId_utilisateur());
            obj = sd.find(e.getId_groupe());
            System.out.println(e.getId_groupe());
            int idSeance=0;
            int nb=0;
            String nomtmp = "";
            Object[][] data = { 
                    {"","","","",""},
                    {"","","","",""},
                    {"","","","",""},
                    {"","","","",""},
                    {"","","","",""},
                    {"","","","",""},
                    {"","","","",""},
                    {"","","","",""},
                    {"","","","",""},
                    {"","","","",""}};
            for(Seance_groupes it : obj){
                int i=0;
                //case 1 afficher les differentes matieres
                Cours cours = new Cours();
                CoursDAO coursd = new CoursDAO();
                cours= coursd.find(seance.getId_cours());
                String nomcours = cours.getNom();
                System.out.println(nomcours);
                if(nomtmp!=nomcours){
                    data[0][i]= nomcours;
                }
                //else{
                  //  nb++;
                //}
                nomtmp = nomcours;
                //case 2 premiere seance
                //seance.getHeure_debut();
                //case 3 derniere seance
                //case 4 durée
                //case 5 nombres de séances
                
                String[] header = {"Matières","Première séance","Dernière séance","Durée","Nb."};
                Modele model2 = new Modele(data,header);
                
                Recapitulatif tab = new Recapitulatif();
                //tab.tableau2 = new JTable(model2);
                tab.setVisible(true);
                i++;
                
            }
        }
        
    }
}
