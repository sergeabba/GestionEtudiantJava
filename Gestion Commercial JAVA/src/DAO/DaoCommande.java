/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Commande;
import java.sql.SQLException;

/**
 *
 * @author serge abba
 */
public class DaoCommande implements IDao<Commande>{
    private final String SQL_INSERT="INSERT INTO `commande` (`numero`,`date`) VALUES (?,?)";
    
    private final DaoMysql mysql;
    
    public DaoCommande(){
        mysql=new DaoMysql();
    }
                 

    @Override
    public int insert(Commande commande){
        int nbreLigne=0;        
        try{
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_INSERT);            
            mysql.getPs().setInt(1,commande.getNumero()); 
            mysql.getPs().setInt(2,commande.getDate()); 
            nbreLigne=mysql.executeMisAJour();
        }catch (SQLException ex) {
           System.out.println("Erreur d'insertion");
        }finally{
           mysql.closeConnexion();
        }           
    return nbreLigne;
    }
    
}
