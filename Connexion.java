/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laure et clemence
 */
public class Connexion {
    //URL de connection
    private static String url = "jdbc:mysql://localhost:3306/projetjava?useSSL=false";
    // Nom "user"
    private static String user="root";
    // Mot de passe
    private static String passwd="";
    
    //objet de connection
    public static Connection connect;
    
    /**retourne l'instance ou la crée si elle n'existe pas
     * 
     * @return 
     */
    public static Connection getInstance(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if(connect==null){
            System.out.println(url);
            System.out.println(user);
            System.out.println(passwd);

                        
            try{
                connect=DriverManager.getConnection(url, user, passwd);
            }catch(SQLException e){
                e.printStackTrace();
            }
           
        }
         return connect;
    }
    
    
}
