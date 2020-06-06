/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 *
 * @author laure et clemence
 */
public class Edt extends JFrame{
    public JTable tableau, tableau2;
    public JPanel edt, recap;
    public JTabbedPane emploi;
    public JOptionPane etat;
    public JMenuBar menu = new JMenuBar();
    public JMenu cours = new JMenu("Cours");
    public JMenu groupes = new JMenu("Groupes");
    public JMenu enseignants = new JMenu("Enseignants");
    public JMenu salles = new JMenu("Salles");
    public JMenuItem cours1 = new JMenuItem("Modifier le type du cours");
    public JMenuItem cours2 = new JMenuItem("Modifier le nom du cours");
    public JMenuItem cours3 = new JMenuItem("Déplacer la séance");
    public JMenuItem cours4 = new JMenuItem("Ajouter une séance");
    public JMenuItem cours5 = new JMenuItem("Annuler une séance");
    public JMenuItem cours6 = new JMenuItem("Valider une séance");
    public JMenuItem groupes1 = new JMenuItem("Affecter à une séance");
    public JMenuItem groupes2 = new JMenuItem("Ajouter à une séance");
    public JMenuItem groupes3 = new JMenuItem("Enlever à une séance");
    public JMenuItem enseignants1 = new JMenuItem("Affecter à une séance");
    public JMenuItem enseignants2 = new JMenuItem("Ajouter à une séance");
    public JMenuItem enseignants3 = new JMenuItem("Enlever à une séance");
    public JMenuItem salles1 = new JMenuItem("Salles disponibles");
    public JMenuItem salles2 = new JMenuItem("Affecter à une séance");
    
    public Edt(){
        
    }
    
    public Edt(Modele mod){
        this.setTitle("Emploi du temps");
        this.setBounds(200, 0, 1000, 800);
        
        //creation des panneaux
        edt = new JPanel();
        recap = new JPanel();
        edt.setLayout(new BorderLayout());
        edt.setBackground(Color.red);
        recap.setLayout(new GridLayout());
        //creation des menus 
        this.cours.add(cours1);
        this.cours.add(cours2);
        this.cours.add(cours3);
        this.cours.add(cours4);
        this.cours.add(cours5);
        this.cours.add(cours6);
        this.groupes.add(groupes1);
        this.groupes.add(groupes2);
        this.groupes.add(groupes3);
        this.enseignants.add(enseignants1);
        this.enseignants.add(enseignants2);
        this.enseignants.add(enseignants3);
        this.salles.add(salles1);
        this.salles.add(salles2);
        this.menu.add(cours);
        this.menu.add(groupes);
        this.menu.add(enseignants);
        this.menu.add(salles);
        
        //creation des onglets
        emploi = new JTabbedPane();
        emploi.addTab("Emploi du temps", edt);
        emploi.addTab("Récapitulatifs des cours", recap);
        
        //creation du tableau d'affichage des récapitulatifs des cours
        Object[][] data = { //ou alors juste List<Seance> seances = new ArrayList<Seance>();
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
        String[] header = {"Matières","Première séance","Dernière séance","Durée","Nb."};
        Modele model2 = new Modele(data,header);
        tableau2 = new JTable(model2);
        recap.add(new JScrollPane(tableau2),BorderLayout.CENTER);
        //creation du tableau d'affichage de l'emploi du temps
       /* Object[][] date = {{"etat"},{"nomcours","typecours"},{"enseignant","groupe"},{"salle","site"}};
        Object[][] donnees = {
                    {"8:00-9:30","<html>" + date[0][0]  +"<br>" + date[1][0] + date[1][1] +"<br>" +date[2][0] +date[2][1] +"</html>","","","","",""},
                    {"9:30-11:00","","","","","",""},
                    {"11:00-12:30","","","","","",""},
                    {"12:30-14:00","","","","","",""},
                    {"14:00-15:30","","","","","",""},
                    {"15:30-17:00","","","","","",""},
                    {"17:00-18:30","","","","","",""},
                    {"18:30-20:00","","","","","",""},
                    {"20:00-21:30","","","","","",""}};
        
        //date,salle,site,nom et type de cours,enseignant,groupe
        String[] entetes = {" ","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi"};
        Modele model = new Modele(donnees,entetes);*/
        tableau = new JTable(mod);
        tableau.setRowHeight(80);
        tableau.setGridColor(Color.gray);
        //tableau.setForeground(Color.red); couleur de l'ecriture
        //tableau.setBackground(Color.green);
        tableau.getTableHeader().setFont(new Font("TimesNewRoman", Font.PLAIN, 13));
        //pour reduire la taille de la premiere colonne
        tableau.getColumnModel().getColumn(0).setPreferredWidth(20);
        tableau.setDefaultRenderer(JComponent.class, new TableComponent());
        edt.add(new JScrollPane(tableau),BorderLayout.CENTER);
        //JTextArea editor = new JTextArea();
        //JScrollPane scrollEditor = new JScrollPane( editor );   
        //JSplitPane splitter = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT, emploi, scrollEditor );
        
        //ajout des objets à notre fenetre
        this.getContentPane().add(menu,BorderLayout.NORTH);
        this.getContentPane().add(emploi,BorderLayout.CENTER);
        
        // pour fermer la fenetre
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                System.exit(0); // tout fermer												System.exit(0); // tout fermer
            }
        });
    }
}
