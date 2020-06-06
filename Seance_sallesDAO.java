/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author laure et clemence
 */
public class Seance_sallesDAO extends DAO<Seance_salles>{

 
    public Seance_salles create(Seance_salles obj) {
        try {
            PreparedStatement prepare = this.connect
                    .prepareStatement("INSERT INTO seance_salles (Id_seance, Id_salle) VALUES(?,?)");
				prepare.setInt(1, obj.getId_seance());
                                prepare.setInt(2, obj.getId_salle());
				
				
				prepare.executeUpdate();
				
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
    }


    public Seance_salles update(Seance_salles obj) {
        Seance_salles se = new Seance_salles();
        ResultSet result  = null;
        try {
            
            PreparedStatement prepare = this.connect
                    .prepareStatement("SELECT * FROM seance_salles WHERE Id_seance=? AND Id_salle = ? ");
				prepare.setInt(1, obj.getId_seance());
                                prepare.setInt(2, obj.getId_salle());
				
				
            result=prepare.executeQuery();
            
            while(result.next()){
                se.setId_seance(result.getInt(1));
                se.setId_salle(result.getInt(2));
            }
           
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return se;

    }


    public void delete(Seance_salles obj) {
        try{
            PreparedStatement prepare = this.connect
                    .prepareStatement("DELETE FROM seance_salles WHERE Id_seance =? AND Id_salle=?");
            prepare.setInt(1, obj.getId_seance());
            prepare.setInt(2, obj.getId_salle());
            
            prepare.executeUpdate ();
            
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    
    public Seance_salles find(int id) {
        Seance_salles obj = new Seance_salles();
        ResultSet result  = null;
        //obligation de mettre sous le format date spécial sql
        
        try {
                 
            PreparedStatement prepare = this.connect
                    .prepareStatement("SELECT * FROM seance_salles WHERE Id_seance=? ");
            prepare.setInt(1, id);
            
            
            result=prepare.executeQuery();
            
            while(result.next()){
                obj.setId_seance(result.getInt(1));
                obj.setId_salle(result.getInt(2));
            }    
            
            System.out.println("l'id de la salle est"+obj.getId_salle());
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return obj;
    }
}
