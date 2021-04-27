/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Categorie;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Serge abba
 */
public class DaoCategorie implements IDao<Categorie> {
     private final String SQL_INSERT="INSERT INTO `categorie` (`libelle`) VALUES (?)";
    private final String SQL_SELECT_ALL="select * from categorie";
    
    private final DaoMysql mysql;
    
    public DaoCategorie(){
        mysql=new DaoMysql();
    }
                 
        
     @Override
    public int insert(Categorie categorie){
        int nbreLigne=0;        
        try{
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_INSERT);            
            mysql.getPs().setString(1,categorie.getLibelle());                    
            nbreLigne=mysql.executeMisAJour();
        }catch (SQLException ex) {
           System.out.println("Erreur d'insertion");
        }finally{
           mysql.closeConnexion();
        }           
    return nbreLigne;
    }
    
    public List<Categorie> findAll(){
        List<Categorie>lCategorie=new ArrayList<>();        
        try {
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_SELECT_ALL);            
            ResultSet rs=mysql.executeSelect();
            while(rs.next()){
                Categorie categorie=new Categorie();
                categorie.setId(rs.getInt("id"));
                categorie.setLibelle(rs.getString("libelle"));                
                lCategorie.add(categorie);
            }
        } catch (SQLException ex) {         
        }finally{
            mysql.closeConnexion();
        }                        
        return lCategorie;
    }  
    
    
}
