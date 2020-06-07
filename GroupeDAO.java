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
public class GroupeDAO extends DAO<Groupe>{

    @Override
    public Groupe create(Groupe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Groupe update(Groupe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Groupe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * on recupère toutes les informations d'un groupe dans un objet groupe a partir de son id
     * @param id
     * @return 
     */
    public Groupe find(int id) {
        Groupe obj = new Groupe();
        ResultSet result  = null;
        //obligation de mettre sous le format date spécial sql
        
        try {
                 
            PreparedStatement prepare = this.connect
                    .prepareStatement("SELECT * FROM groupe WHERE ID=? ");
            prepare.setInt(1, id);
            
            
            result=prepare.executeQuery();
            
            while(result.next()){
                obj.setId(result.getInt(1));
                obj.setNom(result.getString(2));
                obj.setId_promotion(result.getInt(3));
            }    
            
            //System.out.println(obj.getId());
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return obj;
    }
    
    
    /**
     * on recupère l'ensemble dans groupes
     * @return 
     */
    public List<Groupe> findAll(){
        List<Groupe> obj= new ArrayList<>();
        Statement statement = null;
        ResultSet result  = null;
        try { 
            String sql="SELECT * FROM groupe";
            statement = this.connect.createStatement();
            result=statement.executeQuery(sql);
            Groupe gr = null;

            while(result.next()){
                gr = new Groupe();
                gr.setId(result.getInt(1));
                gr.setNom(result.getString(2));
                gr.setId_promotion(result.getInt(3));
               
                

                obj.add(gr);
            }

           

        }catch(SQLException e){
            e.printStackTrace();
        }

        return obj;
    }
    
    
    /**
     * on recupère un objet groupe contenant son id à partir de son nom
     * @param nom
     * @return 
     */
    public Groupe findId(String nom){
        Groupe obj = new Groupe();
        ResultSet result  = null;
        //obligation de mettre sous le format date spécial sql
        
        try {
                 
            PreparedStatement prepare = this.connect
                    .prepareStatement("SELECT * FROM groupe WHERE Nom=? ");
            prepare.setString(1, nom);
            
            
            result=prepare.executeQuery();
            
            while(result.next()){
                obj.setId(result.getInt(1));
                obj.setNom(result.getString(2));
                obj.setId_promotion(result.getInt(3));
            }    
            
            //System.out.println(obj.getId());
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return obj;
    }
}
