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

    public Seance_groupes create(Seance_groupes obj) {
        try {
            PreparedStatement prepare = this.connect
                    .prepareStatement("INSERT INTO seance_groupes (Id_seance, Id_groupe) VALUES(?,?)");
				prepare.setInt(1, obj.getId_seance());
                                prepare.setInt(2, obj.getId_groupe());
				
				
				prepare.executeUpdate();
				
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
    }

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
    
}
