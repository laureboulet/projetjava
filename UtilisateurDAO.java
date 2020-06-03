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
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO utilisateur (Email, Passwd, Nom, Prenom, Droit) VALUES(?, ?, ?, ?, ?)");
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


}

   
    
    
    

