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
public class EnseignantDAO extends DAO<Enseignant>{

    @Override
    public Enseignant create(Enseignant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enseignant update(Enseignant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Enseignant obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //on cherche le groupe d'un enseignant pour un id utilisateur donné 
    public Enseignant find(int id) {
        Enseignant obj= new Enseignant();
        ResultSet result  = null;
        
        try {
            PreparedStatement prepare = this.connect
                    .prepareStatement("SELECT * FROM enseignant WHERE ID_utilisateur=? ");
            prepare.setInt(1, id);
            
            result=prepare.executeQuery();
            
            while(result.next()){
                
                obj.setId_utilisateur(result.getInt(1));
                obj.setId_cours(result.getInt(2));
            }    
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return obj;   
    }
}
