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
public class SalleDAO extends DAO<Salle>{

    @Override
    public Salle create(Salle obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Salle update(Salle obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Salle obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Salle find(int id) {
        Salle obj = new Salle();
        ResultSet result  = null;
      
        
        try {
                 
            PreparedStatement prepare = this.connect
                    .prepareStatement("SELECT * FROM salle WHERE ID=? ");
            prepare.setInt(1, id);
            
            
            result=prepare.executeQuery();
            
            while(result.next()){
                obj.setId(result.getInt(1));
                obj.setNom(result.getString(2));
                obj.setCapacite(result.getInt(3));
                obj.setId_site(result.getInt(4));
            }    
            
            //System.out.println(obj.getId());
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return obj;
    }
    
    public Salle findId(String nom) {
        Salle obj = new Salle();
        ResultSet result  = null;
      
        
        try {
                 
            PreparedStatement prepare = this.connect
                    .prepareStatement("SELECT * FROM salle WHERE Nom=? ");
            prepare.setString(1, nom);
            
            
            result=prepare.executeQuery();
            
            while(result.next()){
                obj.setId(result.getInt(1));
                obj.setNom(result.getString(2));
                obj.setCapacite(result.getInt(3));
                obj.setId_site(result.getInt(4));
            }    
            
            //System.out.println(obj.getId());
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return obj;
    }
    
    public List<Salle> findAll(){
        List<Salle> obj= new ArrayList<>();
        Statement statement = null;
        ResultSet result  = null;
        try { 
            String sql="SELECT * FROM salle";
            statement = this.connect.createStatement();
            result=statement.executeQuery(sql);
            Salle sal = null;

            while(result.next()){
                sal = new Salle();
                sal.setId(result.getInt(1));
                sal.setNom(result.getString(2));
                sal.setCapacite(result.getInt(3));
                sal.setId_site(result.getInt(4));
               
                obj.add(sal);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return obj;
    }
}
