/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Test;

import DAO.DaoCommande;
import MODEL.Commande;

/**
 *
 * @author serge abba
 */
public class TestDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        DaoCommande daoCommande=new DaoCommande();
        Commande Commande=new Commande(001,29);
        daoCommande.insert(Commande);
        
        //daoArticle.findAll().forEach((article)->{
          //  System.out.println(article);            
       // });
       
       
        //DaoUtilisateur daoUtilisateur=new DaoUtilisateur();
        //Client client=new Client("gp","gp",77,"six");
        //daoUtilisateur.insert(client);
    }
        
        
        
     
}
