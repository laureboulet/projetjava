/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laure et clemence 
 */
public class Seance_enseignantsDAO extends DAO<Seance_enseignants> {

    
    public Seance_enseignants create(Seance_enseignants obj) {
        try {
            PreparedStatement prepare = this.connect
                    .prepareStatement("INSERT INTO seance_enseignants (Id_seance, Id_enseignant) VALUES(?,?)");
				prepare.setInt(1, obj.getId_seance());
                                prepare.setInt(2, obj.getId_enseignant());
				
				
				prepare.executeUpdate();
				
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
    }

  
    public Seance_enseignants update(Seance_enseignants obj) {
        Seance_enseignants se = new Seance_enseignants();
        ResultSet result  = null;
        try {
            
            PreparedStatement prepare = this.connect
                    .prepareStatement("SELECT * FROM seance_enseignants WHERE Id_seance=? AND Id_enseignant = ? ");
				prepare.setInt(1, obj.getId_seance());
                                prepare.setInt(2, obj.getId_enseignant());
				
				
            result=prepare.executeQuery();
            
            while(result.next()){
                se.setId_seance(result.getInt(1));
                se.setId_enseignant(result.getInt(2));
            }
           
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return se;
    }


    public void delete(Seance_enseignants obj) {
        try{
            PreparedStatement prepare = this.connect
                    .prepareStatement("DELETE FROM seance_enseignants WHERE Id_seance =? AND Id_enseignant=?");
            prepare.setInt(1, obj.getId_seance());
            prepare.setInt(2, obj.getId_enseignant());
            
            prepare.executeUpdate ();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public Seance_enseignants find(int id) {
        Seance_enseignants obj = new Seance_enseignants();
        ResultSet result  = null;
        //obligation de mettre sous le format date spécial sql
        
        try {
                 
            PreparedStatement prepare = this.connect
                    .prepareStatement("SELECT * FROM seance_enseignants WHERE Id_seance=? ");
            prepare.setInt(1, id);
            
            
            result=prepare.executeQuery();
            
            while(result.next()){
                obj.setId_seance(result.getInt(1));
                obj.setId_enseignant(result.getInt(2));
            }    
            
            //System.out.println(obj.getId());
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return obj;
    }
    
    public List<Seance_enseignants> findList(int id){
        List<Seance_enseignants> obj= new ArrayList<>();
        ResultSet result  = null;
        try {
            
            PreparedStatement prepare = this.connect
                    .prepareStatement("SELECT * FROM seance_enseignants WHERE Id_enseignant =?");
            prepare.setInt(1, id);
            result=prepare.executeQuery();
            
            Seance_enseignants seance = null;
            
            while(result.next()){
                seance = new Seance_enseignants();
                seance.setId_seance(result.getInt(1));
                seance.setId_enseignant(result.getInt(2));
              
                obj.add(seance);
            }
            
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return obj;
    }
}
