/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author laure et clemence
 */
public class Edt extends JFrame{
    public JTable tableau/*, tableau2*/;
    public JPanel edt;
    public Recapitulatif recap;
    public JTabbedPane emploi;
    public JFrame ajouter = new JFrame();
    public JComboBox filtre;
    public JMenuBar menu = new JMenuBar();
    public JMenu cours = new JMenu("Cours");
    public JMenu groupes = new JMenu("Groupes");
    public JMenu enseignants = new JMenu("Enseignants");
    public JMenu salles = new JMenu("Salles");
    public JMenuItem cours1 = new JMenuItem("Modifier le type du cours");
    public JMenuItem cours2 = new JMenuItem("Modifier le nom du cours");
    public JMenuItem cours3 = new JMenuItem("Déplacer la séance");
    public JMenuItem cours4 = new JMenuItem("Ajouter une séance");
    
    public JMenuItem groupes2 = new JMenuItem("Ajouter à une séance");
    public JMenuItem groupes3 = new JMenuItem("Enlever à une séance");
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
        recap = new Recapitulatif();
        edt.setLayout(new BorderLayout());
        edt.setBackground(Color.red);
        recap.setLayout(new GridLayout());
        
        //creation du filtre d'affichage de l'emploi du temps pour admin et referent pedagogique
        filtre = new JComboBox();
        filtre.addItem("Cours");
        filtre.addItem("Groupes");
        filtre.addItem("Enseignants");
        filtre.setPreferredSize(new Dimension(50, 25));
        
        //creation des menus 
        this.cours.add(cours1);
        this.cours.add(cours2);
        this.cours.add(cours3);
        
        cours4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
            Maj nouv = null;
                nouv = new Maj(ajouter, "Ajouter une séance", true);
                nouv.setVisible(true);
            }         
        });  
        this.cours.add(cours4);
        this.groupes.add(groupes2);
        this.groupes.add(groupes3);
        this.enseignants.add(enseignants2);
        this.enseignants.add(enseignants3);
        this.salles.add(salles1);
        this.salles.add(salles2);
        this.menu.add(cours);
        this.menu.add(groupes);
        this.menu.add(enseignants);
        this.menu.add(salles);
        this.menu.add(filtre);
        
        //creation des onglets
        emploi = new JTabbedPane();
        emploi.addTab("Emploi du temps", edt); //emploi du temps
        emploi.addTab("Récapitulatifs des cours", recap); //recap des cours
        
        //creation du tableau d'affichage des récapitulatifs des cours
        /*Object[][] data = { 
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
        //ou alors juste List<Seance> seances = new ArrayList<Seance>();
        String[] header = {"Matières","Première séance","Dernière séance","Durée","Nb."};
        Modele model2 = new Modele(data,header);
        tableau2 = new JTable(model2);*/
        
        //creation du tableau d'affichage de l'emploi du temps
        /*Object[][] date = {{"etat"},{"nomcours","typecours"},{"enseignant","groupe"},{"salle","site"}};
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
        tableau.addMouseListener(new MouseAdapter(){ 
            @Override
            public void mousePressed(MouseEvent e) {
                int r = tableau.rowAtPoint(e.getPoint());
                if (r >= 0 && r < tableau.getRowCount()) {
                    tableau.setRowSelectionInterval(r, r);
                } else {
                    tableau.clearSelection();
                }
                int rowindex = tableau.getSelectedRow();
                int colindex = tableau.getSelectedColumn();
                if (rowindex < 0 || colindex < 1) //pour ne pas avoir de popup a la colonne des heures
                    return;
                if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) { //clic droit
                    Maj nouv = null;
                    nouv = new Maj(ajouter, "Ajouter ou modofier une séance", true);
                    nouv.setVisible(true);
                }
                else{ //clic gauche
                    JPopupMenu popup = createPopupMenu();
                    popup.show(e.getComponent(), e.getX(), e.getY());
                        
                }           
            }
        });
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
    
    /* Methode de construction du menu qui change l'état de la séance */
    public JPopupMenu createPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu();
        
        JMenuItem valide = new JMenuItem( "Validée" );
        valide.setMnemonic( 'V' );
        popupMenu.add(valide);
        
        popupMenu.addSeparator();
        
        JMenuItem annule = new JMenuItem( "Annulée" );
        annule.setMnemonic( 'A' );
        popupMenu.add(annule);
        
        popupMenu.addSeparator();
        
        JMenuItem encours = new JMenuItem( "En cours de validation" );
        encours.setMnemonic( 'E' );
        popupMenu.add(encours);
 
        return popupMenu;
    }
    
    public JOptionPane createOptionPane(){
        JOptionPane etat = new JOptionPane();
        String[] etats = {"VALIDEE", "ANNULEE", "EN COURS DE VALIDATION"};
        int nom = etat.showOptionDialog(null, 
        "Voulez-vous annuler ou valider la séance ?",
        "Modifier l'etat de la seance",
        JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        etats,
        etats[2]);
        return etat;
    }
}
