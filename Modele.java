/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author laure et clemence
 */
public class Modele extends AbstractTableModel{
    private Object[][] donnees;
    private String[] entetes;
    
    public Modele(Object[][] donnees, String[] entetes){
        this.donnees = donnees;
        this.entetes = entetes;
    }
    
    //retourne le nb de colonnes
    public int getColumnCount(){
        return this.entetes.length;
    }
    
    //retourne le nb de lignes
    public int getRowCount(){
        return this.donnees.length;
    }
    
    //retourne la valeur a l emplacement specifie
    public Object getValueAt(int lig, int col){
        return this.donnees[lig][col];
    }
    
    //retourne le titre de la colonne a l'indice specifie
    public String getColumnName(int col){
        return this.entetes[col];
    }
    
    //Retourne la classe de la donnée de la colonne
    public Class getColumnClass(int col){
      //On retourne le type de la cellule à la colonne demandée
      //les types de données sont les mêmes quelle que soit la ligne
      //On choisit donc la première ligne
      return this.donnees[0][col].getClass();
    }
    //retourne vrai si la cellule est editable
    public boolean isCellEditable(int lig, int col){
        if(getValueAt(0,col)instanceof JButton)
            return false;
        if(getColumnName(0)==" ")
            return col == 0 ? false : true ;
        return true;
    }
    
    //
}
