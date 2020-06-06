/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.util.ArrayList;
import java.util.List;
import modele.Cours;
import modele.CoursDAO;
import modele.Etudiant;
import modele.EtudiantDAO;
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
import modele.Site;
import modele.SiteDAO;
import modele.Type_cours;
import modele.Type_coursDAO;
import modele.Utilisateur;
import modele.UtilisateurDAO;
import vue.Edt;
import vue.Modele;

/**
 *
 * @author laure et clemence
 */
public class Controleur_edt {
    public Controleur_edt(){
        
    }
    
    public Controleur_edt(Utilisateur ut){
        int droit = ut.getDroit();
        
        if(droit==4){
            //objets temporaires que l'on crée pour récupérer les informations à afficher dans l'edt
            Etudiant et = new Etudiant(ut.getId());
            EtudiantDAO ed = new EtudiantDAO();
            Seance_groupes sg = new Seance_groupes();
            List<Seance_groupes> obj= new ArrayList<>();
            Seance_groupesDAO sd= new Seance_groupesDAO();
            Seance seance = new Seance();
            SeanceDAO seanced = new SeanceDAO();
            
            //on récupère le groupe d'un étudiant à partir de son id (identique pour utilisateur et etudiant)
            et = ed.find(et.getId_utilisateur());
            //on récupère les id de séances correspondant à ce groupe
            
            obj = sd.find(et.getId_groupe());
            int idSeance=0;
            
              Object[][] donnees = {
                        {"8:00-9:30","","","","","",""},
                        {"9:30-11:00","","","","","",""},
                        {"11:00-12:30","","","","","",""},
                        {"12:30-14:00","","","","","",""},
                        {"14:00-15:30","","","","","",""},
                        {"15:30-17:00","","","","","",""},
                        {"17:00-18:30","","","","","",""},
                        {"18:30-20:00","","","","","",""},
                        {"20:00-21:30","","","","","",""}};
            
            //pour chaque seance on rempli la case correspondante
            for(Seance_groupes it : obj){
                Object[] date = new String[4];
                //case 1
                idSeance = it.getId_seance();
                seance= seanced.find(idSeance);
                String etat;
                if(seance.getEtat()==1){
                    etat = "En cours de validation";
                }else if(seance.getEtat()==2){
                    etat = "validé";
                }else {
                    etat = "annulé";
                }
                System.out.println(etat);
                date [0]=etat;
                //casee 2
                Cours cours = new Cours();
                CoursDAO coursd = new CoursDAO();
                cours= coursd.find(seance.getId_cours());
                String nomcours = cours.getNom();
                Type_cours type = new Type_cours();
                Type_coursDAO typed = new Type_coursDAO();
                type = typed.find(seance.getId_type());
                String typecours = type.getNom();
                System.out.println(nomcours+","+typecours);
                date[1]=nomcours+","+typecours;
                //case 3
                Seance_enseignants sens = new Seance_enseignants();
                Seance_enseignantsDAO sensd = new Seance_enseignantsDAO();
                sens = sensd.find(seance.getId());
                Utilisateur enseign = new Utilisateur();
                UtilisateurDAO enseignd = new UtilisateurDAO();
                enseign = enseignd.findNom(sens.getId_enseignant());
                String enseignant = enseign.getNom();
                Groupe gr = new Groupe();
                GroupeDAO grd = new GroupeDAO();
                gr = grd.find(et.getId_groupe());
                System.out.println(enseignant+","+gr.getNom());
                date[2]=enseignant+","+gr.getNom();
                //case 4 
                Salle s = new Salle();
                SalleDAO sad = new SalleDAO();
                Seance_salles sesa = new Seance_salles();
                Seance_sallesDAO sesad = new Seance_sallesDAO();
                //on cherche l'id de la salle correspondant a cette seance
                sesa = sesad.find(seance.getId());
                //on cherche la salle correspondant à cet id 
                s=sad.find(sesa.getId_salle());
                String salle = s.getNom();
                Site si = new Site();
                SiteDAO sid = new SiteDAO();
                si=sid.find(s.getId_site());
                String site = si.getNom();
                System.out.println(salle+","+site);
                System.out.println(seance.getId()+","+sesa.getId_salle()+","+s.getNom());       
                date[3] = salle+","+site;
                
                if(seance.getHeure_debut() ==800) {
                    donnees[0][2]="<html>" + date[0] +"<br>" + date[1]  +"<br>" +date[2] + "<br>" +date[3] +"</html>";
                } else if(seance.getHeure_debut() ==930) {
                    donnees[1][2]="<html>" + date[0]  +"<br>" + date[1]  +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                } else if (seance.getHeure_debut()==1100){
                    donnees[2][2]="<html>" + date[0] +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                } else if (seance.getHeure_debut()==1230){
                    donnees[3][2]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                } else if (seance.getHeure_debut()==1400){
                    donnees[4][2]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                } else if (seance.getHeure_debut()==1530){
                    donnees[5][2]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                } else if (seance.getHeure_debut()==1700){
                    donnees[6][2]="<html>" + date[0] +"<br>" + date[1] +"<br>" +date[2]+  "<br>" +date[3] +"</html>";
                } else if (seance.getHeure_debut()==1830){
                    donnees[7][2]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                }
               
               System.out.println("On passe au cours suivant");
            }
            
      //<html>" + date[0][0]  +"<br>" + date[1][0] + date[1][1] +"<br>" +date[2][0] +date[2][1] +"</html>
            //Object[][] date = {{"etat"},{"nomcours","typecours"},{"enseignant","groupe"},{"salle","site"}};
          



            //date,salle,site,nom et type de cours,enseignant,groupe
            String[] entetes = {" ","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi"};
            Modele mod = new Modele(donnees,entetes);

            Edt table = new Edt(mod);
            table.setVisible(true);
        }
        else{
            System.out.println("Tu n'es pas un etudiant!");
        }
    }
}
