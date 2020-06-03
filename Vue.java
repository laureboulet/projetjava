/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.util.ArrayList;
import java.util.List;
import modele.Utilisateur;
import modele.DAO;
import modele.UtilisateurDAO;

/**
 *
 * @author laure et clemence
 */
public class Vue {
    public static void main (String[] args){
        
        DAO<Utilisateur>  us = new UtilisateurDAO();
        Utilisateur newus = new Utilisateur();
        List<Utilisateur> ut = new ArrayList<>();
        /*newus.setEmail("lb@lb.fr");
        newus.setPasswd("test");
        newus.setNom("boulet");
        newus.setPrenom("laure");
        newus.setDroit(1);

        newus = us.create(newus); */
       
       ut = us.find("boulet");
    }
}
