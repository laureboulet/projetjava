
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author laure et clemence
 */
public abstract class DAO<T> {
    
    //on se connecte à la BDD
    public Connection connect = Connexion.getInstance();
    
    
    
  
    /**crée dans la BDD
     * 
     * @param obj
     * @return 
     */
    public abstract T create(T obj);
    
   
    /**On recherche un objet à partir de son id 
     * 
     * @param nom
     * @return 
     */
    public abstract List<T> find(String nom);
    /*
    //Met à jour les données
    //@param obj
    //@return T
    public abstract T update(T obj);
    
    //supprime dans la BDD
    //@param obj
    public abstract void delete(T obj);*/
    
}
