/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Article;
import MODEL.Details;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 */
public class DaoDetails {
    private final String SQL_INSERT="INSERT INTO `details` (`commande_id`, `article_id`, `qte`, `prix`, `montant`) VALUES (?,?,?,?,?);";
    private final String SQL_SELECT_COMMANDE="select * from details ";    
    private final String SQL_SELECT_REFERENCE="select * from article where reference=?";


    
     private final DaoMysql mysql;
    
    public DaoDetails(){
        mysql=new DaoMysql();
    }         
    
    
     public int insert(Details details){
        int nbreLigne=0;                                   
        try {
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_INSERT); 
            mysql.getPs().setInt(1,details.getCommande().getNumero());
            mysql.getPs().setInt(2,details.getArticle().getId());            
            mysql.getPs().setInt(3,details.getQte());
            mysql.getPs().setInt(4,details.getPrix());
            mysql.getPs().setInt(5,details.getMontant());                 
            nbreLigne=mysql.executeMisAJour();                           
        } catch (SQLException ex) {
            System.out.println("Erreur");
        }finally{
            mysql.closeConnexion();
        }            
    return nbreLigne;
    }
     
     
      public List<Details> findAll(){
        List<Details>lDetails=new ArrayList<>();        
        try {
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_SELECT_COMMANDE);            
            ResultSet rs=mysql.executeSelect();
            while(rs.next()){
                Details details=new Details();
                    details.setQte(rs.getInt("qte"));
                    details.setPrix(rs.getInt("prix"));
                    details.setMontant(rs.getInt("montant"));
                Article article=new Article();
                    article.setLibelle(rs.getString("libelle"));                                       
                lDetails.add(details);  
            }
        } catch (SQLException ex) {         
        }finally{
            mysql.closeConnexion();
        }                        
        return lDetails;
    }  
     
     public Article findArticleByReference(String reference){
        Article article=null;
        
        try {
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_SELECT_REFERENCE);
            mysql.getPs().setString(1,reference);            
            ResultSet rs=mysql.executeSelect();        
            if(rs.next()){   
                article=new Article();
                    article.setLibelle(rs.getString("libelle"));
                    article.setStock(rs.getInt("stock")); 
                Details details=new Details();
                    details.setQte(rs.getInt("qte"));      
            }
        } catch (SQLException ex) {            
        }
                
        return article;        
    }        
           
}
