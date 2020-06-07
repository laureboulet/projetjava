/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author laure et clemence
 */
public class Recapitulatif extends JPanel{
    private JTable tableau2;
    //private JTextField filtre;
    //private JLabel filtreLabel;
    //private JButton btnfiltre;
    //private JPanel f;
    public String[] header = {"Matières","Première séance","Dernière séance","Durée","Nb."};
    /**
     * constructeur
     */
    public Recapitulatif(){
        //creation du tableau d'affichage des récapitulatifs des cours
        
        Object[][] data = { 
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
        
        Modele model2 = new Modele(data,header);
        tableau2 = new JTable(model2); 
        /*f = new JPanel();
        btnfiltre = new JButton("Filtrer");
        btnfiltre.setSize(125,30);
        filtre = new JTextField();
        filtre.setPreferredSize(new Dimension(200, 25));
        filtreLabel = new JLabel("Filtrez par matière: ");
        f.add(filtreLabel);
        f.add(filtre);
        f.add(btnfiltre);*/
        setLayout(new BorderLayout());
        //add(f,BorderLayout.NORTH);
        add(new JScrollPane(tableau2),BorderLayout.CENTER);
       
    }
    
    public void SetData(Object[][] data){
        System.out.println("wesh c'est ttl " + data[0][0] );
        tableau2.setModel(new Modele(data,header));
        
    }
}
