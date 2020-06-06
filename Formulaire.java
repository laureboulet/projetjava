/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import modele.Connexion;

/**
 *
 * @author laure et clemence
 */
public class Formulaire extends JFrame{
    public Connexion maconnexion;
    public JTextField login;
    public JPasswordField passwd;
    public JLabel mail, mdp, message;
    public JButton boutonlog;
    public JPanel pan;
    public Edt table = new Edt();
    
    
    public Formulaire(){
        this.setBounds(500,200,350,200);
        this.setTitle("Connexion à votre emploi du temps");
        //this.setBackground(Color.blue);
        
        //creation du panneau
        pan = new JPanel();
        pan.setLayout(null);
        //pan.setBackground(Color.cyan);
        //creation des textes
        login = new JTextField();
        login.setBounds(150, 20, 200, 25);
        passwd = new JPasswordField();
        passwd.setBounds(150,50,165,25);
        
        //creation des labels
        mail = new JLabel("Mail");
        mail.setBounds(10, 20, 100, 25);
        mdp = new JLabel("Mot de passe");
        mdp.setBounds(10,50,100,25);
        message = new JLabel("");
        message.setBounds(10,110,300,25);
        
        //creation du bouton de connexion
        boutonlog = new JButton("Se connecter");
        boutonlog.setBounds(10,80,80,25);
        boutonlog.setSize(125,30);
        
        //ajout des objets graphiques à notre panneau
        pan.add(mail);
        pan.add(login);
        pan.add(mdp);
        pan.add(passwd);
        pan.add(boutonlog);
        pan.add(message);
        
        this.getContentPane().add(pan);
        this.setVisible(true);
        //Définition de l'action du bouton
        /* boutonlog.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
            //Via cette instruction, on se connecte pour avoir acces a l'edt
            String user = login.getText();
            String password = passwd.getText();
            if((user.equals("clemence"))&&(password.equals("ece"))){
                setVisible(false);
                table = new Edt();
                table.setVisible(true);
            }
            else{
                message.setText("Login refused");
            }
            }
        });*/
        
        // pour fermer la fenetre
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                System.exit(0); // tout fermer												System.exit(0); // tout fermer
            }
        });
    }
}
