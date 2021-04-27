/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Profil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author serge abba
 */
public class DaoProfil implements IDao<Profil> {
    private final String SQL_INSERT="INSERT INTO `profil` (`libelle`) VALUES (?)";
    private final String SQL_SELECT_ALL="select * from profil";
    
    private final DaoMysql mysql;
    
    /**
     *
     */
    public DaoProfil (){
        mysql=new DaoMysql();
    }
                 
    /**
     *
     * @param profil
     * @return
     */
    @Override
    public int insert(Profil profil){
        int nbreLigne=0;        
        try{
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_INSERT);            
            mysql.getPs().setString(1,profil.getLibelle());                    
            nbreLigne=mysql.executeMisAJour();
        }catch (SQLException ex) {
           System.out.println("Erreur d'insertion");
        }finally{
           mysql.closeConnexion();
        }           
    return nbreLigne;
    }
    
    public List<Profil> findAll(){
        List<Profil>lProfil=new ArrayList<>();        
        try {
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_SELECT_ALL);            
            ResultSet rs=mysql.executeSelect();
            while(rs.next()){
                Profil pro=new Profil();
                pro.setId(rs.getInt("id"));
                pro.setLibelle(rs.getString("libelle"));                
                lProfil.add(pro);
            }
        } catch (SQLException ex) {         
        }finally{
            mysql.closeConnexion();
        }                        
        return lProfil;
    }  
    
}

