/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;
import modele.Connexion;

//https://github.com/AlexandreLEMERET/FAC_EDT


/**
 *
 * @author laure et clemence
 */
public class Fenetre extends JFrame{
    //attributs
    private Connexion maconnexion;
    private CardLayout cl = new CardLayout();
    private JPanel pan = new JPanel();
    private Login card1 = new Login();
    private Grille card2 = new Grille();
    String[] listContent = {"CARD_1", "CARD_2"};
    
    public Fenetre(){
        //mise en page de la fenetre visible
        this.setTitle("Emploi du temps");
        this.setBounds(200, 0, 1000, 800);
        this.setResizable(true);
        
        pan.setLayout(cl);
        
        //On ajoute les cartes à la pile avec un nom pour les retrouver
        pan.add(card1, listContent[0]);
        pan.add(card2, listContent[1]);
        
        this.getContentPane().add(pan);
        card1.boutonlog.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
            //Via cette instruction, on se connecte pour avoir acces a l'edt
            String user = card1.login.getText();
            String password = card1.passwd.getText();
            if((user.equals("clemence"))&&(password.equals("ece"))){
                cl.next(pan);
            }
            else{
                card1.message.setText("Login refused");
            }
            }
        });
        this.setVisible(true);
        
        // pour fermer la fenetre
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                System.exit(0); // tout fermer												System.exit(0); // tout fermer
            }
        });
    }	   
}