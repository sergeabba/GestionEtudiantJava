 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Article;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author serge abba
 * 
 */
public class DaoArticle implements IDao<Article>{
     private final String SQL_INSERT;
     private final String SQL_SELECT_ALL;

    
    
    private final DaoMysql mysql;
    
    public DaoArticle (){
        this.SQL_SELECT_ALL = "select * from article";
        this.SQL_INSERT = "INSERT INTO `article` (`reference`, `libelle`, `stock`, `prix`) VALUES (?,?,?,?)";
        mysql=new DaoMysql();
    }
    
    
     @Override
    public int insert(Article article){
        int nbreLigne=0;        
       try{
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_INSERT);            
            mysql.getPs().setString(1,article.getReference());
            mysql.getPs().setString(2,article.getLibelle());
            mysql.getPs().setInt(3,article.getStock());
            mysql.getPs().setInt(4,article.getPrix());            
            nbreLigne=mysql.executeMisAJour();
        }catch (SQLException ex) {
           System.out.println("Erreur d");
        }finally{
           mysql.closeConnexion();
        }      
    return nbreLigne;
    }
    
    /**
     *
     * @return
     */
    public List<Article> findAll(){
        List<Article>lArticle=new ArrayList<>();        
        try {
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_SELECT_ALL);            
            ResultSet rs=mysql.executeSelect();
            while(rs.next()){
                Article article=new Article();
                article.setId(rs.getInt("id"));
                article.setReference(rs.getString("reference"));
                article.setLibelle(rs.getString("libelle"));
                article.setStock(rs.getInt("stock"));
                article.setPrix(rs.getInt("prix"));
                lArticle.add(article);
            }
        } catch (SQLException ex) {         
        }finally{
            mysql.closeConnexion();
        }                        
        return lArticle;
    }          
     
     
   
    
}
