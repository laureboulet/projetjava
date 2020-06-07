/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author laure et clemence
 */
public class Maj extends JDialog{
    public MajInfo info = new MajInfo();
    private boolean sendData;
    private JLabel etatLabel, nomLabel, typeLabel, salleLabel, enseignantLabel, groupeLabel,dateLabel;
    public JRadioButton tranche1, tranche2, tranche3, tranche4, tranche5, tranche6, tranche7, tranche8, tranche9;
    public JComboBox etat;
    public JComboBox type;
    public JComboBox enseignant, groupe, salle;
    public JTextField nom;
    public JTextField date;
    public JPanel control = new JPanel();
    public JButton okBouton = new JButton("OK");
    
    /**
     * constructeur
     * @param parent
     * @param title
     * @param modal 
     */
    public Maj(JFrame parent, String title, boolean modal){
        //On appelle le construteur de JDialog correspondant
        super(parent, title, modal);
        //On spécifie une taille
        this.setSize(800, 500);
        //La position
        this.setLocationRelativeTo(null);
        //La boîte ne devra pas être redimensionnable
        this.setResizable(false);
        //Enfin on l'affiche
        //this.setVisible(true);
        this.initComponent();
    }
    
    //cas ou notreMaj renverra le contenu
    /**
     * donnees affichées
     * @return 
     */
    public MajInfo showMaj(){
        this.sendData = false;
        this.setVisible(true);
        return this.info;
    }
    
    /**
     * champs à remplir
     */
    public void initComponent(){
    
    //L'etat de la séance
    JPanel panEtat = new JPanel();
    panEtat.setBackground(Color.white);
    panEtat.setPreferredSize(new Dimension(220, 60));
    etat = new JComboBox();
    etat.addItem("Validée");
    etat.addItem("En cours de validation");
    etatLabel = new JLabel("Type : ");
    panEtat.add(etatLabel);
    panEtat.add(etat);
    
    //Le nom du cours (JComboBox?)
    JPanel panNom = new JPanel();
    panNom.setBackground(Color.white);
    panNom.setPreferredSize(new Dimension(250, 60));
    nom = new JTextField();
    nom.setPreferredSize(new Dimension(100, 25));
    panNom.setBorder(BorderFactory.createTitledBorder("Matière de la séance"));
    nomLabel = new JLabel("Matière :");
    panNom.add(nomLabel);
    panNom.add(nom);

    //Le type de cours
    JPanel panType = new JPanel();
    panType.setBackground(Color.white);
    panType.setPreferredSize(new Dimension(220, 60));
    panType.setBorder(BorderFactory.createTitledBorder("Type de cours"));
    type = new JComboBox();
    type.addItem("Cours magistral");
    type.addItem("TD/TP");
    type.addItem("Projet");
    typeLabel = new JLabel("Type : ");
    panType.add(typeLabel);
    panType.add(type);

    //L'enseignant
    JPanel panEnseignant = new JPanel();
    panEnseignant.setBackground(Color.white);
    panEnseignant.setBorder(BorderFactory.createTitledBorder("Enseignant"));
    panEnseignant.setPreferredSize(new Dimension(260, 60));
    enseignant = new JComboBox();
    enseignant.addItem("A determiner");
    

    enseignantLabel = new JLabel("Enseignant : ");
    enseignant.setPreferredSize(new Dimension(100, 25));
    panEnseignant.add(enseignantLabel);
    panEnseignant.add(enseignant);

    //Le groupe
    JPanel panGroupe = new JPanel();
    panGroupe.setBackground(Color.white);
    panGroupe.setPreferredSize(new Dimension(220, 60));
    panGroupe.setBorder(BorderFactory.createTitledBorder("Groupe(s) assistant à la séance"));
    groupeLabel = new JLabel("Groupe : ");
    groupe = new JComboBox();
    groupe.setPreferredSize(new Dimension(90, 25));
    panGroupe.add(groupeLabel);
    panGroupe.add(groupe);
    groupe.addItem("A determiner");

    //La salle
    JPanel panSalle = new JPanel();
    panSalle.setBackground(Color.white);
    panSalle.setPreferredSize(new Dimension(220, 60));
    panSalle.setBorder(BorderFactory.createTitledBorder("Nom de la salle"));
    salle = new JComboBox();
    salle.addItem("A determiner");
    
    salleLabel = new JLabel("Salle : ");
    salle.setPreferredSize(new Dimension(90, 25));
    panSalle.add(salleLabel);
    panSalle.add(salle);

    //date
    JPanel panDate = new JPanel();
    panDate.setBackground(Color.white);
    panDate.setPreferredSize(new Dimension(220, 60));
    //DateFormat format = new SimpleDateFormat("YYYY-MM-DD");
    date = new JTextField();
    date.setPreferredSize(new Dimension(100, 25));
    panDate.setBorder(BorderFactory.createTitledBorder("Date de la séance"));
    dateLabel = new JLabel("Date :");
    panDate.add(dateLabel);
    panDate.add(date);
    
    
    //heures
    JPanel panHoraire = new JPanel();
    panHoraire.setBackground(Color.white);
    panHoraire.setBorder(BorderFactory.createTitledBorder("Horaires"));
    panHoraire.setPreferredSize(new Dimension(440, 130));
    tranche1 = new JRadioButton("8:00-9:30");
    tranche1.setSelected(true);
    tranche2 = new JRadioButton("9:30-11:00");
    tranche3 = new JRadioButton("11:00-12:30");
    tranche4 = new JRadioButton("12:30-14:00");
    tranche5 = new JRadioButton("14:00-15:30");
    tranche6 = new JRadioButton("15:30-17:00");
    tranche7 = new JRadioButton("17:00-18:30");
    tranche8 = new JRadioButton("18:30-20:00");
    tranche9 = new JRadioButton("20:00-21:30");
    ButtonGroup bg = new ButtonGroup();
    bg.add(tranche1);
    bg.add(tranche2);
    bg.add(tranche3);
    bg.add(tranche4);
    bg.add(tranche5);
    bg.add(tranche6);
    bg.add(tranche7);
    bg.add(tranche8);
    bg.add(tranche9);
    panHoraire.add(tranche1);
    panHoraire.add(tranche2);
    panHoraire.add(tranche3);
    panHoraire.add(tranche4);
    panHoraire.add(tranche5);
    panHoraire.add(tranche6);
    panHoraire.add(tranche7);
    panHoraire.add(tranche8);
    panHoraire.add(tranche9);
    
    JPanel content = new JPanel();
    content.setBackground(Color.white);
    content.add(panEtat,BorderLayout.WEST);
    content.add(panNom,BorderLayout.NORTH);
    content.add(panType);
    content.add(panEnseignant,BorderLayout.EAST);
    content.add(panGroupe);
    content.add(panSalle);
    content.add(panDate);
    content.add(panHoraire,BorderLayout.SOUTH);

    
    //JButton okBouton = new JButton("OK");
    
    /*okBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {        
        info = new MajInfo(etat.getSelectedItem().toString(), nom.getText(), (String)type.getSelectedItem(), (String)enseignant.getSelectedItem(),(String)groupe.getSelectedItem(),(String)salle.getSelectedItem(),(String)date.getText(),getHoraire());
        //setVisible(false);
      }

      public String getHoraire(){
        return (tranche1.isSelected()) ? tranche1.getText() : 
               (tranche2.isSelected()) ? tranche2.getText() : 
               (tranche3.isSelected()) ? tranche3.getText() : 
               (tranche4.isSelected()) ? tranche4.getText() :
               (tranche5.isSelected()) ? tranche5.getText() :
               (tranche6.isSelected()) ? tranche6.getText() :
               (tranche7.isSelected()) ? tranche7.getText() :
               (tranche8.isSelected()) ? tranche8.getText() :
               (tranche9.isSelected()) ? tranche9.getText() :
                tranche1.getText();  
      }

      /*public String getDate(){
        return (date.getText().equals("")) ? "180" : date.getText();
      }     
    });*/
         
    control.add(okBouton);


    JButton cancelBouton = new JButton("Annuler");
    cancelBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
      }      
    });

    //control.add(okBouton);
    control.add(cancelBouton);

    //this.getContentPane().add(panEtat, BorderLayout.WEST);
    this.getContentPane().add(content);
    this.getContentPane().add(control, BorderLayout.SOUTH);
  } 
}
