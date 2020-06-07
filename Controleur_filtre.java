/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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
import modele.Site;
import modele.SiteDAO;
import modele.Type_cours;
import modele.Type_coursDAO;
import modele.Utilisateur;
import modele.UtilisateurDAO;
import vue.Edt;
import vue.Maj;
import vue.Modele;

/**
 *
 * @author laure et clemence
 */
public class Controleur_filtre {
    //private String valeur;
    private int i=0;
    public Controleur_filtre(){
        
    }
    public Controleur_filtre(Utilisateur ut, String valeur, String valeur2){
        int droit = ut.getDroit();
        if(droit==1){
            List<Enseignant> ens = new ArrayList<>();
            EnseignantDAO ensdao = new EnseignantDAO();
            ens = ensdao.findAll();
            List<Groupe> gr = new ArrayList<>();
            GroupeDAO grdao = new GroupeDAO();
            gr=grdao.findAll();
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
            
            String[] entetes = {" ","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi"};
            Modele mod = new Modele(donnees,entetes);
            
            
            ArrayList<Edt> t = new ArrayList<Edt>();
            Edt edt = new Edt(mod);
            t.add(edt);
            t.add(edt);
            t.add(edt);
            t.add(edt);
            t.add(edt);
            //t.get(i) = edt;
            t.get(i).cours4.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                Maj nouv = null;
                    nouv = new Maj(t.get(i).ajouter, "Ajouter une séance", true);
                    //nouv.setVisible(true);
                    Controleur_maj ctrl = new Controleur_maj(ut,nouv);
                }         
            });
            //Controleur_maj ctrl = new Controleur_maj(ut);
            
            t.get(i).menu.add(t.get(i).cours);
            t.get(i).menu.add(t.get(i).groupes);
            t.get(i).menu.add(t.get(i).enseignants);
            t.get(i).menu.add(t.get(i).salles);
            t.get(i).menu.add(t.get(i).ens);
            t.get(i).menu.add(t.get(i).gr);
            t.get(i).menu.add(t.get(i).cou);
            t.get(i).menu.add(t.get(i).ok);
            t.get(i).ok.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    String val = valeur;
                    String val2 = valeur2;
                val = t.get(i).ens.getSelectedItem().toString();
                val2 = t.get(i).gr.getSelectedItem().toString();
                System.out.println(val);
                System.out.println("coucou");
                System.out.println(val2);
                Controleur_filtre filtre = new Controleur_filtre(ut,val,val2);
                //t.get(i).setVisible(true);
                }         
            });
            t.get(i).cou.addItem("Cours");
            t.get(i).ens.addItem("Enseignants");
            t.get(i).gr.addItem("Groupes");
            
            for(Enseignant it : ens){
                Utilisateur u = new Utilisateur();
                UtilisateurDAO ud = new UtilisateurDAO();
                u=ud.findNom(it.getId_utilisateur());
                t.get(i).ens.addItem(u.getNom());
                
                System.out.println(u.getNom());
            }
            for(Groupe it : gr){
                t.get(i).gr.addItem(it.getNom());
            }   
            if(valeur!=null&&valeur2=="Groupes"){
                Utilisateur u = new Utilisateur();
                UtilisateurDAO ud = new UtilisateurDAO();
                Enseignant e = new Enseignant();
                EnseignantDAO ed = new EnseignantDAO();
                u=ud.findId(valeur);
                //System.out.println(valeur);
                Seance_enseignants se = new Seance_enseignants();
                List<Seance_enseignants> obj = new ArrayList<>();
                Seance_enseignantsDAO sed = new Seance_enseignantsDAO();
                obj=sed.findList(u.getId());
                Seance seance = new Seance();
                SeanceDAO seanced = new SeanceDAO();
                int idSeance=0;
                for(Seance_enseignants it : obj){
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
                    date [0]=etat;
                     //case 2
                    Cours cours = new Cours();
                    CoursDAO coursd = new CoursDAO();
                    cours= coursd.find(seance.getId_cours());
                    String nomcours = cours.getNom();
                    Type_cours type = new Type_cours();
                    Type_coursDAO typed = new Type_coursDAO();
                    type = typed.find(seance.getId_type());
                    String typecours = type.getNom();
                    date[1]=nomcours+","+typecours;
                    //case 3
                    Seance_groupes sg = new Seance_groupes();
                    Seance_groupesDAO sd = new Seance_groupesDAO();
                    sg = sd.findS(seance.getId());
                    String enseignant = ut.getNom();
                    Groupe gro = new Groupe();
                    GroupeDAO grd = new GroupeDAO();
                    gro = grd.find(sg.getId_groupe());
                    date[2]=enseignant+","+gro.getNom();
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
                    date[3] = salle+","+site;
                    //on récupère le jour de la semaine
                    int day = seance.getDate().getDay();

                    day++;


                    if(seance.getHeure_debut() ==800) {
                        donnees[0][day]="<html>" + date[0] +"<br>" + date[1]  +"<br>" +date[2] + "<br>" +date[3] +"</html>";
                    } else if(seance.getHeure_debut() ==930) {
                        donnees[1][day]="<html>" + date[0]  +"<br>" + date[1]  +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1100){
                        donnees[2][day]="<html>" + date[0] +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1230){
                        donnees[3][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1400){
                        donnees[4][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1530){
                        donnees[5][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1700){
                        donnees[6][day]="<html>" + date[0] +"<br>" + date[1] +"<br>" +date[2]+  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1830){
                        donnees[7][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    }
                    for(int i=0;i<4;i++){
                        System.out.println(date[i]);
                    }
                }         
                for(int i=0;i<4;i++){
                    for(int j=0;j<6;j++){
                        System.out.println(donnees[i][j]);
                    }
                }
            if(i!=0){
                t.get(i).setVisible(true);
                t.get(i-1).setVisible(false);
            }
            else{
                t.get(i).setVisible(true);
            }
            i++;
            }
            else if(valeur2!=null&&valeur=="Enseignants"){
                Groupe g = new Groupe();
                GroupeDAO gd = new GroupeDAO();
                g=gd.findId(valeur2);
                System.out.println("bonjour"+g.getNom());
                List<Seance_groupes> sg = new ArrayList<>();
                Seance_groupesDAO sgd = new Seance_groupesDAO();
                sg=sgd.find(g.getId());
                
                Seance seance = new Seance();
                SeanceDAO seanced = new SeanceDAO();
                int idSeance=0;
                for(Seance_groupes it : sg){
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
                    date[1]=nomcours+","+typecours;
                    //case 3             
                    Seance_enseignants sens = new Seance_enseignants();
                    Seance_enseignantsDAO sensd = new Seance_enseignantsDAO();
                    sens = sensd.find(seance.getId());
                    Utilisateur enseign = new Utilisateur();
                    UtilisateurDAO enseignd = new UtilisateurDAO();
                    enseign = enseignd.findNom(sens.getId_enseignant());
                    String enseignant = enseign.getNom();
                    Groupe gro = new Groupe();
                    GroupeDAO grd = new GroupeDAO();
                    gro = grd.findId(valeur2);
                    date[2]=enseignant+","+gro.getNom();
                    //System.out.println(gro.getNom());
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
                    date[3] = salle+","+site;
                    //on récupère le jour de la semaine
                    int day = seance.getDate().getDay();

                    day++;

                    if(seance.getHeure_debut() ==800) {
                        donnees[0][day]="<html>" + date[0] +"<br>" + date[1]  +"<br>" +date[2] + "<br>" +date[3] +"</html>";
                    } else if(seance.getHeure_debut() ==930) {
                        donnees[1][day]="<html>" + date[0]  +"<br>" + date[1]  +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1100){
                        donnees[2][day]="<html>" + date[0] +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1230){
                        donnees[3][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1400){
                        donnees[4][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1530){
                        donnees[5][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1700){
                        donnees[6][day]="<html>" + date[0] +"<br>" + date[1] +"<br>" +date[2]+  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1830){
                        donnees[7][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    }
                }
                for(int i=0;i<4;i++){
                    for(int j=0;j<6;j++){
                        System.out.println(donnees[i][j]);
                    }
                }
                if(i!=0){
                    t.get(i).setVisible(true);
                    t.get(i-1).setVisible(false);
                }
                else{
                    t.get(i).setVisible(true);
                }
                i++;
            }
            else if((valeur!=null&&valeur2!=null)&&(valeur!="Enseignants"&&valeur2!="Groupes")){ //filtre croise
                Utilisateur u = new Utilisateur();
                UtilisateurDAO ud = new UtilisateurDAO();
                Enseignant e = new Enseignant();
                EnseignantDAO ed = new EnseignantDAO();
                u=ud.findId(valeur);
                Groupe g = new Groupe();
                GroupeDAO gd = new GroupeDAO();
                g=gd.findId(valeur2);
                Seance_enseignants se = new Seance_enseignants();
                List<Seance_enseignants> obj = new ArrayList<>();
                Seance_enseignantsDAO sed = new Seance_enseignantsDAO();
                obj=sed.findList(u.getId());
                List<Seance_groupes> sg = new ArrayList<>();
                Seance_groupesDAO sgd = new Seance_groupesDAO();
                sg=sgd.find(g.getId());
                Seance seance = new Seance();
                SeanceDAO seanced = new SeanceDAO();
                int idSeance=0;
                for(Seance_groupes it : sg){
                    for(Seance_enseignants iterator : obj){
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
                        date [0]=etat;
                        //case 2
                        Cours cours = new Cours();
                        CoursDAO coursd = new CoursDAO();
                        cours= coursd.find(seance.getId_cours());
                        String nomcours = cours.getNom();
                        Type_cours type = new Type_cours();
                        Type_coursDAO typed = new Type_coursDAO();
                        type = typed.find(seance.getId_type());
                        String typecours = type.getNom();
                        date[1]=nomcours+","+typecours;
                        //case 3
                        Seance_enseignants sens = new Seance_enseignants();
                        Seance_enseignantsDAO sensd = new Seance_enseignantsDAO();
                        sens = sensd.find(seance.getId());
                        Utilisateur enseign = new Utilisateur();
                        UtilisateurDAO enseignd = new UtilisateurDAO();
                        enseign = enseignd.findNom(sens.getId_enseignant());
                        String enseignant = enseign.getNom();
                        Groupe gro = new Groupe();
                        GroupeDAO grd = new GroupeDAO();
                        gro = grd.findId(valeur2);
                        date[2]=enseignant+","+gro.getNom(); //ou valeur a la place de enseignant
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
                        date[3] = salle+","+site;
                        //on récupère le jour de la semaine
                        int day = seance.getDate().getDay();

                        day++;
                        
                        if(seance.getHeure_debut() ==800) {
                        donnees[0][day]="<html>" + date[0] +"<br>" + date[1]  +"<br>" +date[2] + "<br>" +date[3] +"</html>";
                        } else if(seance.getHeure_debut() ==930) {
                            donnees[1][day]="<html>" + date[0]  +"<br>" + date[1]  +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                        } else if (seance.getHeure_debut()==1100){
                            donnees[2][day]="<html>" + date[0] +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                        } else if (seance.getHeure_debut()==1230){
                            donnees[3][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                        } else if (seance.getHeure_debut()==1400){
                            donnees[4][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                        } else if (seance.getHeure_debut()==1530){
                            donnees[5][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                        } else if (seance.getHeure_debut()==1700){
                            donnees[6][day]="<html>" + date[0] +"<br>" + date[1] +"<br>" +date[2]+  "<br>" +date[3] +"</html>";
                        } else if (seance.getHeure_debut()==1830){
                            donnees[7][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                        }
                        for(int i=0;i<4;i++){
                            System.out.println(date[i]);
                        }
                    }
                }
                for(int i=0;i<4;i++){
                    for(int j=0;j<6;j++){
                        System.out.println(donnees[i][j]);
                    }
                }
                if(i!=0){
                    t.get(i).setVisible(true);
                    t.get(i-1).setVisible(false);
                }
                else{
                    t.get(i).setVisible(true);
                }
                i++;
            }
        }
        else if(droit==2){
            List<Enseignant> ens = new ArrayList<>();
            EnseignantDAO ensdao = new EnseignantDAO();
            ens = ensdao.findAll();
            List<Groupe> gr = new ArrayList<>();
            GroupeDAO grdao = new GroupeDAO();
            gr=grdao.findAll();
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
            
            String[] entetes = {" ","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi"};
            Modele mod = new Modele(donnees,entetes);
            
            
            ArrayList<Edt> t = new ArrayList<Edt>();
            Edt edt = new Edt(mod);
            t.add(edt);
            t.add(edt);
            t.add(edt);
            t.add(edt);
            t.add(edt);
            t.get(i).menu.add(t.get(i).ens);
            t.get(i).menu.add(t.get(i).gr);
            t.get(i).menu.add(t.get(i).cou);
            t.get(i).menu.add(t.get(i).ok);
            t.get(i).ok.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    String val = valeur;
                    String val2 = valeur2;
                val = t.get(i).ens.getSelectedItem().toString();
                val2 = t.get(i).gr.getSelectedItem().toString();
                System.out.println(val);
                System.out.println("coucou");
                System.out.println(val2);
                Controleur_filtre filtre = new Controleur_filtre(ut,val,val2);
                //t.get(i).setVisible(true);
                }         
            });
            t.get(i).cou.addItem("Cours");
            t.get(i).ens.addItem("Enseignants");
            t.get(i).gr.addItem("Groupes");
            
            for(Enseignant it : ens){
                Utilisateur u = new Utilisateur();
                UtilisateurDAO ud = new UtilisateurDAO();
                u=ud.findNom(it.getId_utilisateur());
                t.get(i).ens.addItem(u.getNom());
                
                System.out.println(u.getNom());
            }
            for(Groupe it : gr){
                t.get(i).gr.addItem(it.getNom());
            }   
            if(valeur!=null&&valeur2=="Groupes"){
                Utilisateur u = new Utilisateur();
                UtilisateurDAO ud = new UtilisateurDAO();
                Enseignant e = new Enseignant();
                EnseignantDAO ed = new EnseignantDAO();
                u=ud.findId(valeur);
                //System.out.println(valeur);
                Seance_enseignants se = new Seance_enseignants();
                List<Seance_enseignants> obj = new ArrayList<>();
                Seance_enseignantsDAO sed = new Seance_enseignantsDAO();
                obj=sed.findList(u.getId());
                Seance seance = new Seance();
                SeanceDAO seanced = new SeanceDAO();
                int idSeance=0;
                for(Seance_enseignants it : obj){
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
                    date [0]=etat;
                     //case 2
                    Cours cours = new Cours();
                    CoursDAO coursd = new CoursDAO();
                    cours= coursd.find(seance.getId_cours());
                    String nomcours = cours.getNom();
                    Type_cours type = new Type_cours();
                    Type_coursDAO typed = new Type_coursDAO();
                    type = typed.find(seance.getId_type());
                    String typecours = type.getNom();
                    date[1]=nomcours+","+typecours;
                    //case 3
                    Seance_groupes sg = new Seance_groupes();
                    Seance_groupesDAO sd = new Seance_groupesDAO();
                    sg = sd.findS(seance.getId());
                    String enseignant = ut.getNom();
                    Groupe gro = new Groupe();
                    GroupeDAO grd = new GroupeDAO();
                    gro = grd.find(sg.getId_groupe());
                    date[2]=enseignant+","+gro.getNom();
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
                    date[3] = salle+","+site;
                    //on récupère le jour de la semaine
                    int day = seance.getDate().getDay();

                    day++;


                    if(seance.getHeure_debut() ==800) {
                        donnees[0][day]="<html>" + date[0] +"<br>" + date[1]  +"<br>" +date[2] + "<br>" +date[3] +"</html>";
                    } else if(seance.getHeure_debut() ==930) {
                        donnees[1][day]="<html>" + date[0]  +"<br>" + date[1]  +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1100){
                        donnees[2][day]="<html>" + date[0] +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1230){
                        donnees[3][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1400){
                        donnees[4][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1530){
                        donnees[5][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1700){
                        donnees[6][day]="<html>" + date[0] +"<br>" + date[1] +"<br>" +date[2]+  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1830){
                        donnees[7][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    }
                    for(int i=0;i<4;i++){
                        System.out.println(date[i]);
                    }
                }         
                for(int i=0;i<4;i++){
                    for(int j=0;j<6;j++){
                        System.out.println(donnees[i][j]);
                    }
                }
            if(i!=0){
                t.get(i).setVisible(true);
                t.get(i-1).setVisible(false);
            }
            else{
                t.get(i).setVisible(true);
            }
            i++;
            }
            else if(valeur2!=null&&valeur=="Enseignants"){
                Groupe g = new Groupe();
                GroupeDAO gd = new GroupeDAO();
                g=gd.findId(valeur2);
                System.out.println("bonjour"+g.getNom());
                List<Seance_groupes> sg = new ArrayList<>();
                Seance_groupesDAO sgd = new Seance_groupesDAO();
                sg=sgd.find(g.getId());
                
                Seance seance = new Seance();
                SeanceDAO seanced = new SeanceDAO();
                int idSeance=0;
                for(Seance_groupes it : sg){
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
                    date[1]=nomcours+","+typecours;
                    //case 3             
                    Seance_enseignants sens = new Seance_enseignants();
                    Seance_enseignantsDAO sensd = new Seance_enseignantsDAO();
                    sens = sensd.find(seance.getId());
                    Utilisateur enseign = new Utilisateur();
                    UtilisateurDAO enseignd = new UtilisateurDAO();
                    enseign = enseignd.findNom(sens.getId_enseignant());
                    String enseignant = enseign.getNom();
                    Groupe gro = new Groupe();
                    GroupeDAO grd = new GroupeDAO();
                    gro = grd.findId(valeur2);
                    date[2]=enseignant+","+gro.getNom();
                    //System.out.println(gro.getNom());
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
                    date[3] = salle+","+site;
                    //on récupère le jour de la semaine
                    int day = seance.getDate().getDay();

                    day++;

                    if(seance.getHeure_debut() ==800) {
                        donnees[0][day]="<html>" + date[0] +"<br>" + date[1]  +"<br>" +date[2] + "<br>" +date[3] +"</html>";
                    } else if(seance.getHeure_debut() ==930) {
                        donnees[1][day]="<html>" + date[0]  +"<br>" + date[1]  +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1100){
                        donnees[2][day]="<html>" + date[0] +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1230){
                        donnees[3][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1400){
                        donnees[4][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1530){
                        donnees[5][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1700){
                        donnees[6][day]="<html>" + date[0] +"<br>" + date[1] +"<br>" +date[2]+  "<br>" +date[3] +"</html>";
                    } else if (seance.getHeure_debut()==1830){
                        donnees[7][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                    }
                }
                for(int i=0;i<4;i++){
                    for(int j=0;j<6;j++){
                        System.out.println(donnees[i][j]);
                    }
                }
                if(i!=0){
                    t.get(i).setVisible(true);
                    t.get(i-1).setVisible(false);
                }
                else{
                    t.get(i).setVisible(true);
                }
                i++;
            }
            else if((valeur!=null&&valeur2!=null)&&(valeur!="Enseignants"&&valeur2!="Groupes")){ //filtre croise
                Utilisateur u = new Utilisateur();
                UtilisateurDAO ud = new UtilisateurDAO();
                Enseignant e = new Enseignant();
                EnseignantDAO ed = new EnseignantDAO();
                u=ud.findId(valeur);
                Groupe g = new Groupe();
                GroupeDAO gd = new GroupeDAO();
                g=gd.findId(valeur2);
                Seance_enseignants se = new Seance_enseignants();
                List<Seance_enseignants> obj = new ArrayList<>();
                Seance_enseignantsDAO sed = new Seance_enseignantsDAO();
                obj=sed.findList(u.getId());
                List<Seance_groupes> sg = new ArrayList<>();
                Seance_groupesDAO sgd = new Seance_groupesDAO();
                sg=sgd.find(g.getId());
                Seance seance = new Seance();
                SeanceDAO seanced = new SeanceDAO();
                int idSeance=0;
                for(Seance_groupes it : sg){
                    for(Seance_enseignants iterator : obj){
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
                        date [0]=etat;
                        //case 2
                        Cours cours = new Cours();
                        CoursDAO coursd = new CoursDAO();
                        cours= coursd.find(seance.getId_cours());
                        String nomcours = cours.getNom();
                        Type_cours type = new Type_cours();
                        Type_coursDAO typed = new Type_coursDAO();
                        type = typed.find(seance.getId_type());
                        String typecours = type.getNom();
                        date[1]=nomcours+","+typecours;
                        //case 3
                        Seance_enseignants sens = new Seance_enseignants();
                        Seance_enseignantsDAO sensd = new Seance_enseignantsDAO();
                        sens = sensd.find(seance.getId());
                        Utilisateur enseign = new Utilisateur();
                        UtilisateurDAO enseignd = new UtilisateurDAO();
                        enseign = enseignd.findNom(sens.getId_enseignant());
                        String enseignant = enseign.getNom();
                        Groupe gro = new Groupe();
                        GroupeDAO grd = new GroupeDAO();
                        gro = grd.findId(valeur2);
                        date[2]=enseignant+","+gro.getNom(); //ou valeur a la place de enseignant
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
                        date[3] = salle+","+site;
                        //on récupère le jour de la semaine
                        int day = seance.getDate().getDay();

                        day++;
                        
                        if(seance.getHeure_debut() ==800) {
                        donnees[0][day]="<html>" + date[0] +"<br>" + date[1]  +"<br>" +date[2] + "<br>" +date[3] +"</html>";
                        } else if(seance.getHeure_debut() ==930) {
                            donnees[1][day]="<html>" + date[0]  +"<br>" + date[1]  +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                        } else if (seance.getHeure_debut()==1100){
                            donnees[2][day]="<html>" + date[0] +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                        } else if (seance.getHeure_debut()==1230){
                            donnees[3][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                        } else if (seance.getHeure_debut()==1400){
                            donnees[4][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                        } else if (seance.getHeure_debut()==1530){
                            donnees[5][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                        } else if (seance.getHeure_debut()==1700){
                            donnees[6][day]="<html>" + date[0] +"<br>" + date[1] +"<br>" +date[2]+  "<br>" +date[3] +"</html>";
                        } else if (seance.getHeure_debut()==1830){
                            donnees[7][day]="<html>" + date[0]  +"<br>" + date[1] +"<br>" +date[2] +  "<br>" +date[3] +"</html>";
                        }
                        for(int i=0;i<4;i++){
                            System.out.println(date[i]);
                        }
                    }
                }
                for(int i=0;i<4;i++){
                    for(int j=0;j<6;j++){
                        System.out.println(donnees[i][j]);
                    }
                }
                if(i!=0){
                    t.get(i).setVisible(true);
                    t.get(i-1).setVisible(false);
                }
                else{
                    t.get(i).setVisible(true);
                }
                i++;
            }
        }
    }
    
}