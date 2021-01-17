/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author abbas
 */
public interface IDao<T> {
    /*
    public int insert (Classe classe)
    public int insert (Details details)
    public int insert (Personne pers)
    //Genericité
    */
    public int insert(T objet);
    
    
    
}
