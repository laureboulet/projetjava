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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laure et clemence
 */
public class UtilisateurDAO extends DAO<Utilisateur>{
    
    public Utilisateur create(Utilisateur obj){
        try {
            PreparedStatement prepare = this.connect
                    .prepareStatement("INSERT INTO utilisateur (Email, Passwd, Nom, Prenom, Droit) VALUES(?, ?, ?, ?, ?)");
				prepare.setString(1, obj.getEmail());
                                prepare.setString(2, obj.getPasswd());
				prepare.setString(3, obj.getNom());
				prepare.setString(4, obj.getPrenom());
				prepare.setInt(5, obj.getDroit());

				
				prepare.executeUpdate();
				
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
    }
    
    
    //find par rapport au nom
    public List<Utilisateur> find(String nom){
        List<Utilisateur> obj= new ArrayList<>();
        Statement statement = null;
        ResultSet result  = null;
        try {
            nom = "'%" + nom +"%'"; 
            String sql="SELECT * FROM utilisateur WHERE Nom Like " + nom;
            statement = this.connect.createStatement();
            result=statement.executeQuery(sql);
            Utilisateur util = null;
            
            while(result.next()){
                util = new Utilisateur();
                util.setEmail(result.getString(2));
                util.setPasswd(result.getString(3));
                util.setNom(result.getString(4));
                util.setPrenom(result.getString(5));
                util.setDroit(result.getInt(6));
                
                obj.add(util);
            }
            
            for(Utilisateur ut : obj){
                System.out.println(ut.getEmail());
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return obj;
    }

    
     //find par rapport a l'email+passwd
    public Utilisateur login(String email, String mdp){
        Utilisateur obj= new Utilisateur();
        ResultSet result  = null;
        
        try {
            PreparedStatement prepare = this.connect
                    .prepareStatement("SELECT * FROM utilisateur WHERE Email=? AND Passwd=? ");
            prepare.setString(1, email);
            prepare.setString(2, mdp);
            
            result=prepare.executeQuery();
            
            
            
            
            while(result.next()){
                obj.setId(result.getInt(1));
                obj.setEmail(result.getString(2));
                obj.setPasswd(result.getString(3));
                obj.setNom(result.getString(4));
                obj.setPrenom(result.getString(5));
                obj.setDroit(result.getInt(6));
            }    
            
            if(obj.getEmail()==null){
                System.out.print("Connexion refusée");
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return obj;
    }

     public Utilisateur findNom(int id){
        Utilisateur obj= new Utilisateur();
        ResultSet result  = null;
        
        try {
            PreparedStatement prepare = this.connect
                    .prepareStatement("SELECT * FROM utilisateur WHERE ID=? ");
            prepare.setInt(1, id);
          
            result=prepare.executeQuery();
            
            
            while(result.next()){
                obj.setId(result.getInt(1));
                obj.setEmail(result.getString(2));
                obj.setPasswd(result.getString(3));
                obj.setNom(result.getString(4));
                obj.setPrenom(result.getString(5));
                obj.setDroit(result.getInt(6));
            }    
            
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return obj;
    }
    
    public Utilisateur update(Utilisateur obj){
        try{
            PreparedStatement prepare = this.connect
                    .prepareStatement("UPDATE utilisateur SET Passwd=? WHERE Nom=?");
            prepare.setString(1, obj.getPasswd());
            prepare.setString(2,obj.getNom());
            
            prepare.executeUpdate();
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return obj;
    }
    
    public void delete(Utilisateur obj){
        try{
            PreparedStatement prepare = this.connect
                    .prepareStatement("DELETE FROM utilisateur WHERE Nom =?");
            prepare.setString(1, obj.getNom());
            
            prepare.executeUpdate ();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}

   
    
    
    

