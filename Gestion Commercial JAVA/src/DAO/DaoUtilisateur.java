/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Client;
import MODEL.Utilisateur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * author serge abba
 */
public class DaoUtilisateur {
    private final String SQL_INSERT="INSERT INTO `utilisateur` (`nom`, `prenom`, `login`, `pwd`,`profil_id`) VALUES (?,?,?,?,?);";
    private final String SQL_SELECT_CONNECT="select * from utilisateur where login=? and pwd=?";
    private final String SQL_SELECT_ALL="select * from utilisateur";
    private final String SQL_INSERT_CLIENT="INSERT INTO `utilisateur` (`nom`, `prenom`, `telephone`,`adresse`) VALUES (?,?,?,?);";
    private final String SQL_SELECT_CLIENT="select * from client  where telephone=?";

  

    
     private final DaoMysql mysql;
    
    public DaoUtilisateur (){
        mysql=new DaoMysql();
    }         
    
    
     public int insert(Utilisateur utilisateur){
        int nbreLigne=0;        
        try{
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_INSERT);            
            mysql.getPs().setString(1,utilisateur.getNom());
            mysql.getPs().setString(2,utilisateur.getPrenom());
            mysql.getPs().setString(3,utilisateur.getLogin());
            mysql.getPs().setString(4,utilisateur.getPwd());
            //mysql.getPs().setInt(5,utilisateur.getProfil().getId());
            nbreLigne=mysql.executeMisAJour();
        }catch (SQLException ex) {
           System.out.println("Erreur d'insertion");
        }finally{
           mysql.closeConnexion();
        }           
    return nbreLigne;
    }
     
    /**
     *
     * @return
     */
    public List<Utilisateur> findAll(){
        List<Utilisateur>lUtilisateur=new ArrayList<>();        
        try {
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_SELECT_ALL);            
            ResultSet rs=mysql.executeSelect();
            while(rs.next()){
                Utilisateur utilisateur=new Utilisateur();
                utilisateur.setId(rs.getInt("id"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setLogin(rs.getString("login"));
                utilisateur.setPwd(rs.getString("pwd"));
                //utilisateur.setProfil(rs.getString("profil_id"));
                lUtilisateur.add(utilisateur);
            }
        } catch (SQLException ex) {         
        }finally{
            mysql.closeConnexion();
        }                        
        return lUtilisateur;
    }  
     
    /**
     *
     * @param login
     * @param pwd
     * @return
     */
    public Utilisateur findUserConect( String login, String pwd){
        Utilisateur utilisateur=null;
         try {
        mysql.ouvrirConnexionBD();
        mysql.preparerRequete(SQL_SELECT_CONNECT);
        mysql.getPs().setString(1,login);              
        mysql.getPs().setString(2,pwd);
        
        ResultSet rs=mysql.executeSelect();
        if(rs.next()){                                
                
                utilisateur=new Utilisateur();
                          
                utilisateur.setId(rs.getInt("id"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setLogin(rs.getString("login"));
                utilisateur.setPwd(rs.getString("pwd"));
        }
        } catch (SQLException ex) {
            Logger.getLogger(DaoUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }                
        return utilisateur;
    }
    
    /**
     *
     * @param client
     * @return
     */
    public int insert(Client client){
        int nbreLigne=0;        
        try{
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_INSERT_CLIENT);            
            mysql.getPs().setString(1,client.getNom());
            mysql.getPs().setString(2,client.getPrenom());
            mysql.getPs().setInt(3,client.getTelephone());
            mysql.getPs().setString(4,client.getAdresse());           
            nbreLigne=mysql.executeMisAJour();
        }catch (SQLException ex) {
           System.out.println("Erreur d'insertion");
        }finally{
           mysql.closeConnexion();
        }           
    return nbreLigne;
    }
     
    /**
     *
     * @param telephone
     * @return
     */
    public Client findClientByTelephone(String telephone){
        Client client=null;
        
        try {
            mysql.ouvrirConnexionBD();
            mysql.preparerRequete(SQL_SELECT_CLIENT);
            mysql.getPs().setString(1,telephone);            
            ResultSet rs=mysql.executeSelect();        
            if(rs.next()){   
                client=new Client();
                client.setNom(rs.getString("nom"));
                client.setPrenom(rs.getString("prenom"));                
                client.setAdresse(rs.getString("adresse"));                
            }
        } catch (SQLException ex) {            
        }
                
        return client;        
    }     
    
}
