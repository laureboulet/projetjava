/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.Controleur_formulaire;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import modele.Utilisateur;
import modele.DAO;
import modele.Etudiant;
import modele.EtudiantDAO;
import modele.Seance;
import modele.SeanceDAO;
import modele.UtilisateurDAO;


/**
 *
 * @author laure et clemence
 */
public class Vue {
    public static void main (String[] args){
        
        Formulaire login = new Formulaire();
        Controleur_formulaire controleur = new Controleur_formulaire(login);
        
       /* UtilisateurDAO  us = new UtilisateurDAO();
        Utilisateur newus = new Utilisateur();
        List<Utilisateur> ut = new ArrayList<>();
        Etudiant newet= new Etudiant();
        EtudiantDAO et = new EtudiantDAO();
        Seance newse = new Seance();
        SeanceDAO se = new SeanceDAO();
        Seance setamp = new Seance();
        /*newus.setEmail("lb@lb.fr");
        newus.setPasswd("test");
        newus.setNom("boulet");
        newus.setPrenom("laure");
        newus.setDroit(1);
        
        //test create sur utilisateur
        newus = us.create(newus); */
        
       // test find sur utilisateur
       //ut = us.find("boulet");
       
       //test update sur utilisateur
      /* newus.setNom("boulet");
       newus.setPasswd("test2");
       newus = us.update(newus);*/
      
      //test delete sur utilisateur
      /*newus.setNom("boulet");
      us.delete(newus);*/
      
      //test find login utilisateur
     /* String email="laure@test";
      String mdp = "mdp1";
      newus= us.login(email, mdp);
      /*if(newus.getEmail()==null){
          System.out.println("Connexion refusée");
      }
      else{
      System.out.println(newus.getEmail()); 
      System.out.println(newus.getPasswd());
      System.out.println(newus.getNom());
      System.out.println(newus.getPrenom());
      System.out.println(newus.getDroit());
      }*/
      
      //test find groupe etudiant à partir de l'id d'un utilisateur
      /*int id_ut = newus.getId();
      newet = et.find(id_ut);
      System.out.println(newet.getId_groupe());*/
      
      //test find seance à partir de données entrées on get l'id
      /*newse.setSemaine(3);
      //on doit adapter le format pour qu'il devienne une date
      String dat="2000-09-12";
      Date date=Date.valueOf(dat);
      newse.setDate(date);
      newse.setHeure_debut(18);
      newse.setHeure_fin(19);
      newse.setEtat(2);
      newse.setId_cours(1);
      newse.setId_type(1);
      
      newse = se.find(newse);
      //on crée une nouvelle seance tampon pour pouvoir update la précédente 
      int id = newse.getId();
      setamp.setId(id);
      setamp.setSemaine(4);
      setamp.setDate(date);
      setamp.setHeure_debut(12);
      setamp.setHeure_fin(13);
      setamp.setEtat(2);
      setamp.setId_cours(1);
      setamp.setId_type(1);
      System.out.println(id);
      newse = se.update(setamp);*/
      
      
      //test creation d'une seance
     /* newse.setSemaine(5);
      String dat="2020-05-06";
      Date date=Date.valueOf(dat);
      newse.setDate(date);
      newse.setHeure_debut(17);
      newse.setHeure_fin(19);
      newse.setEtat(2);
      newse.setId_cours(1);
      newse.setId_type(1);
      
      se.create(newse);*/
    }
}
