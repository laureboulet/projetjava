/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laure et clemence 
 */
public class Seance_groupesDAO extends DAO<Seance_groupes>{

    /**
     * on crée un objet seance groupe dans la bbd a partir d'une seance et d'un groupe
     * @param se
     * @param gr
     * @return 
     */
    public Seance_groupes createS(Seance se, Groupe gr) {
        Seance_groupes obj = new Seance_groupes();
        try {
            PreparedStatement prepare = this.connect
                    .prepareStatement("INSERT INTO seance_groupes (Id_seance, Id_groupe) VALUES(?,?)");
				prepare.setInt(1, se.getId());
                                prepare.setInt(2, gr.getId());
				
				
				prepare.executeUpdate();
				
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
    }

    /**
     * on met a jour une seance groupe (souvent le groupe pour une seance)
     * @param obj
     * @return 
     */
    public Seance_groupes update(Seance_groupes obj) {
        Seance_groupes se = new Seance_groupes();
        ResultSet result  = null;
        try {
            
            PreparedStatement prepare = this.connect
                    .prepareStatement("SELECT * FROM seance_groupe WHERE Id_seance=? AND Id_groupe = ? ");
				prepare.setInt(1, obj.getId_seance());
                                prepare.setInt(2, obj.getId_groupe());
				
				
            result=prepare.executeQuery();
            
            while(result.next()){
                se.setId_seance(result.getInt(1));
                se.setId_groupe(result.getInt(2));
            }
           
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return se;
    
    }

    /**
     * on supprime un objet seance_groupes (un element de la table)
     * @param obj 
     */
    public void delete(Seance_groupes obj) {
        try{
            PreparedStatement prepare = this.connect
                    .prepareStatement("DELETE FROM seance_groupes WHERE Id_seance =? AND Id_groupe=?");
            prepare.setInt(1, obj.getId_seance());
            prepare.setInt(2, obj.getId_groupe());
            
            prepare.executeUpdate ();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    /**
     * on recupère la liste des seances pour un groupe donné 
     * @param groupe
     * @return 
     */
    public List<Seance_groupes> find(int groupe){
        List<Seance_groupes> obj= new ArrayList<>();
        ResultSet result  = null;
        try {
            
            PreparedStatement prepare = this.connect
                    .prepareStatement("SELECT * FROM seance_groupes WHERE Id_groupe =?");
            prepare.setInt(1, groupe);
            result=prepare.executeQuery();
            
            Seance_groupes seance = null;
            
            while(result.next()){
                seance = new Seance_groupes();
                seance.setId_seance(result.getInt(1));
                seance.setId_groupe(result.getInt(2));
              
                obj.add(seance);
            }
            
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return obj;
    }
    
    /**
     * on recupère un objet Seance_groupes et toutes ses données à partir de son idee de seance
     * @param id
     * @return 
     */
    public Seance_groupes findS(int id) {
        Seance_groupes obj = new Seance_groupes();
        ResultSet result  = null;
        //obligation de mettre sous le format date spécial sql
        
        try {
                 
            PreparedStatement prepare = this.connect
                    .prepareStatement("SELECT * FROM seance_groupes WHERE Id_seance=? ");
            prepare.setInt(1, id);
            
            
            result=prepare.executeQuery();
            
            while(result.next()){
                obj.setId_seance(result.getInt(1));
                obj.setId_groupe(result.getInt(2));
            }    
            
            //System.out.println(obj.getId());
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return obj;
    }

    @Override
    public Seance_groupes create(Seance_groupes obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
