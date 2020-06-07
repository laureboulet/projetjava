/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.List;

/**
 *
 * @author laure et clemence
 */
public class EtudiantDAO extends DAO<Etudiant>{

    
    
    @Override
    public Etudiant create(Etudiant obj) {
        
        return obj;
    }

    
    
    /**on cherche le groupe d'un etudiant pour un id utilisateur donné 
     * 
     * @param id
     * @return 
     */
    public Etudiant find(int id) {
        Etudiant obj= new Etudiant();
        ResultSet result  = null;
        
        try {
            PreparedStatement prepare = this.connect
                    .prepareStatement("SELECT * FROM etudiant WHERE ID_utilisateur=? ");
            prepare.setInt(1, id);
            
            result=prepare.executeQuery();
            
            while(result.next()){
                
                obj.setId_utilisateur(result.getInt(1));
                obj.setNumero(result.getInt(2));
                obj.setId_groupe(result.getInt(3)); 
            }    
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return obj;   
    }
    

    
    @Override
    public Etudiant update(Etudiant obj) {
        return obj;
    }

   
    @Override
    public void delete(Etudiant obj) {

    }
    
}
