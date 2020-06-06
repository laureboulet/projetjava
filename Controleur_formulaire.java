/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vue.Formulaire;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import modele.Connexion;
import modele.Utilisateur;
import modele.UtilisateurDAO;
import vue.Edt;
import vue.Modele;

/**
 *
 * @author laure et clemence
 */
public class Controleur_formulaire {
    
    public Controleur_formulaire(){
        
    }
    
    public Controleur_formulaire(Formulaire form){
        
        
        
        form.boutonlog.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
            //Via cette instruction, on se connecte pour avoir acces a l'edt
            String user = form.login.getText();
            String password = form.passwd.getText();
            Utilisateur ut = new Utilisateur();
            UtilisateurDAO ud = new UtilisateurDAO();
            ut = ud.login(user, password);
            int id = ut.getId();
            if(id==0){
                form.message.setText("Login refused");
            }
            else{
                form.setVisible(false);
                Controleur_edt edt = new Controleur_edt(ut);
                
            }
            }
        });
    }
}
