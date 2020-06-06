/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

/**
 *
 * @author laure et clemence 
 */
public class SeanceDAO extends DAO<Seance>{

    
    public Seance create(Seance obj) {
            try {
            PreparedStatement prepare = this.connect
                    .prepareStatement("INSERT INTO seance (Semaine, Date, Heure_debut, Heure_fin, Etat, Id_cours, Id_type) VALUES(?, ?, ?, ?, ?, ?, ?)");
				prepare.setInt(1, obj.getSemaine());
                                prepare.setDate(2, obj.getDate());
				prepare.setInt(3, obj.getHeure_debut());
				prepare.setInt(4, obj.getHeure_fin());
				prepare.setInt(5, obj.getEtat());
                                prepare.setInt(6, obj.getId_cours());
                                prepare.setInt(7, obj.getId_type());

				
				prepare.executeUpdate();
				
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;    
    }

    //methode qui permet de mettre a jour une seance avec toutes les données sur la base de son ID
    public Seance update(Seance obj) {
        try{
            PreparedStatement prepare = this.connect
                    .prepareStatement("UPDATE seance SET Semaine=?,Date=?,Heure_debut=?,Heure_fin=?,Etat=?,ID_cours=?,ID_type=? WHERE ID=?");
            prepare.setInt(1, obj.getSemaine());
            prepare.setDate(2,obj.getDate());
            prepare.setInt(3,obj.getHeure_debut());
            prepare.setInt(4, obj.getHeure_fin());
            prepare.setInt(5, obj.getEtat());
            prepare.setInt(6, obj.getId_cours());
            prepare.setInt(7, obj.getId_type());
            prepare.setInt(8,obj.getId());
            
            prepare.executeUpdate();
           
        }catch(SQLException e){
            e.printStackTrace();
        }
        return obj;    
    }
    
    
    //methode qui trouve une seance avec ses données (toutes sauf l'id) nous permet de determiner justement cet id
    public Seance find(int id){
        Seance obj = new Seance();
        ResultSet result  = null;
        //obligation de mettre sous le format date spécial sql
        /*long date = obj.getDate().getTime();
        java.sql.Date date2 = new java.sql.Date(date);*/
            
        
        try {
                 
            PreparedStatement prepare = this.connect
                    .prepareStatement("SELECT * FROM seance WHERE ID=? ");
            prepare.setInt(1, id);
            
            
            result=prepare.executeQuery();
            
            
            //Date dat=Date.valueOf(result.getString(3));
            
            while(result.next()){
                obj.setId(result.getInt(1));
                //obj.setDate(dat);
                obj.setHeure_debut(result.getInt(4));
                obj.setHeure_fin(result.getInt(5));
                obj.setEtat(result.getInt(6));
                obj.setId_cours(result.getInt(7));
                obj.setId_type(result.getInt(8));
            }    
            
            //System.out.println(obj.getId());
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return obj;
    }


    @Override
    public void delete(Seance obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
