/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author laure et clemence
 */
public class Login extends JPanel{
    //private CardLayout cl = new CardLayout();
    protected JTextField login;
    protected JPasswordField passwd;
    protected JLabel mail, mdp, message;
    //protected String phrase;
    protected JButton boutonlog;
    
    //methode qui crée le formulaire
    public Login(){
        setSize(350,200);
        setLayout(null);
        setBackground(Color.blue);
        
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
        //creation des boutons 
        boutonlog = new JButton("Se connecter");
        boutonlog.setBounds(10,80,80,25);
        boutonlog.setSize(125,30);
        
        //ajout des objets graphiques à notre panneau
        add(mail);
        add(login);
        add(mdp);
        add(passwd);
        add(boutonlog);
        add(message);
        
        
        //Définition de l'action du bouton
        /*boutonlog.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
            //Via cette instruction, on se connecte pour avoir acces a l'edt
            String user = login.getText();
            String password = passwd.getText();
            if((user.equals("clemence"))&&(password.equals("ece"))){
                //phrase = "ok";
                message.setText("ok");
                //cl.next(pan);
            }
            else{
                message.setText("Login refused");
            }
            }
        });*/
    }
}
