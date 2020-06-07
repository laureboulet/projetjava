/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.util.ArrayList;
import java.util.Collections;
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
    /**
     * Constructeur pour le recapitulatif
     * @param ut
     * @param tab 
     */
    public Controleur_recap(Utilisateur ut, Recapitulatif tab){
        int droit = ut.getDroit();
        if(droit==4){
            Etudiant e = new Etudiant(ut.getId());
            EtudiantDAO ed = new EtudiantDAO();
            Seance_groupes sg = new Seance_groupes();
            List<Seance_groupes> obj= new ArrayList<>();
            Seance_groupesDAO sd= new Seance_groupesDAO();
            Seance seance = new Seance();
            SeanceDAO seanced = new SeanceDAO();
            
            
            e = ed.find(ut.getId());
            obj = sd.find(e.getId_groupe());
            
            int idSeance=0;
            int nb=0;
            int i=0;
            List<String> matiere = new ArrayList<>();
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
                //on récupère l'id de la seance
                seance=seanced.find(it.getId_seance());

                //case 1 afficher les differentes matieres
                Cours cours = new Cours();
                CoursDAO coursd = new CoursDAO();
                cours= coursd.find(seance.getId_cours());
                String nomcours = cours.getNom();
                if (Collections.frequency(matiere,nomcours)==0){

                    matiere.add(nomcours);
                    data[i][0]=nomcours;
                    data[i][4] = 1;
                    data[i][3] = "1.5";

                    i++;
                }else{
                    int alo = 0;
                    for(String maMatiere : matiere){
                        if(maMatiere.equals(nomcours)){
                            data[alo][4] = (Integer) data[alo][4] + 1;
                            data[alo][3] = String.valueOf(Float.parseFloat((String) data[alo][3]) + (float)0.5);
                        }
                        alo = alo +1;
                    }

                }
                
             
                //case 2 premiere seance
                //seance.getHeure_debut();
                //case 3 derniere seance
                //case 4 durée
                //case 5 nombres de séances
                
                
            }
            
  
                
                tab.SetData(data);

           
            for(String it2: matiere){
                    System.out.println("matiere : "+it2);
                }
        }
        
    }
}
