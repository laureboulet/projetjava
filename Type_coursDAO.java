/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.List;

/**
 *
 * @author laure et clemence
 */
public class Type_coursDAO extends DAO<Type_cours>{

    @Override
    public Type_cours create(Type_cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //on cherche le groupe de l'etudiant pour un id utilisateur donné
  
    public Type_cours find(String nom) {
        Type_cours obj = new Type_cours();
        return obj;
    }

    @Override
    public Type_cours update(Type_cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Type_cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
