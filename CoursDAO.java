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
public class CoursDAO extends DAO<Cours>{

    @Override
    public Cours create(Cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cours update(Cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * On récupère un objet cours contenant toutes les informations necessaires avec pour paramètre l'id du cours
     * @param id
     * @return 
     */
    public Cours find(int id){
        Cours obj = new Cours();
        ResultSet result  = null;
        //obligation de mettre sous le format date spécial sql
        
        try {
                 
            PreparedStatement prepare = this.connect
                    .prepareStatement("SELECT * FROM cours WHERE ID=? ");
            prepare.setInt(1, id);
            
            
            result=prepare.executeQuery();
            
            while(result.next()){
                obj.setId(result.getInt(1));
                obj.setNom(result.getString(2));
            }    
            
            //System.out.println(obj.getId());
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return obj;
    }
    
    
    /**
     *  On récupère un objet cours contenant toutes les informations necessaires avec pour paramètre le nom du cours
     * @param nom
     * @return 
     */
    public Cours findId(String nom){
        Cours obj = new Cours();
        ResultSet result  = null;
        //obligation de mettre sous le format date spécial sql
        
        try {
                 
            PreparedStatement prepare = this.connect
                    .prepareStatement("SELECT * FROM cours WHERE Nom=? ");
            prepare.setString(1, nom);
            
            
            result=prepare.executeQuery();
            
            while(result.next()){
                obj.setId(result.getInt(1));
                obj.setNom(result.getString(2));
            }    
            
            //System.out.println(obj.getId());
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return obj;
    }
}
