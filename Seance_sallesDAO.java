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

 
    /**
     * on crée un objet seance_salles dans la bdd (une nouvelle ligne a la table)
     * @param obj
     * @return 
     */
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
    
    /**
     * on crée un objet seance_salles dans la bdd (une nouvelle ligne a la table) à partir d'une seance et d'une salle pour respecter les contraintes de clés etrangeres
     * @param se
     * @param sal
     * @return 
     */
     public Seance_salles createS(Seance se, Salle sal) {
         Seance_salles obj = new Seance_salles();
        try {
            PreparedStatement prepare = this.connect
                    .prepareStatement("INSERT INTO seance_salles (Id_seance, Id_salles) VALUES(?,?)");
				prepare.setInt(1, se.getId());
                                prepare.setInt(2, sal.getId());
				
				
				prepare.executeUpdate();
				
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
    }


     /**
      * met a jour un objet (lignet table) seance_salles (souvent mise a jour d'une salle pour une seance donnee)
      * @param obj
      * @return 
      */
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


    /**
     * suppression d'un objet seance_salles dans la bbd (ligne de la table)
     * @param obj 
     */
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
    
    /**
     *trouver une salle a partir de l'id de la seance
     * @param id
     * @return 
     */
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
