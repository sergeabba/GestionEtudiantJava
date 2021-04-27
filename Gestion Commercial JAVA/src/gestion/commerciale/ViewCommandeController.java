/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.commerciale;

import METIER.Service;
import MODEL.Article;
import MODEL.Client;
import MODEL.Commande;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author serge abba
 */
public class ViewCommandeController implements Initializable {
    
    private Service METIER;

    @FXML
    private TextField textPrenom;
    @FXML
    private TextField textTelephone;
    @FXML
    private TextField textNom;   
    @FXML
    private TextField textNumero;
    @FXML
    private TextField textDate;
    @FXML
    private TextField textLibelle;
    @FXML
    private TextField textQteStock;
    @FXML
    private Button btnSearch1;
    @FXML
    private Button btnSearch2;
    @FXML
    private Button btnAdd1;
    @FXML
    private Button btnAdd2;
    @FXML
    private TableView<Article> tblCommande;
    @FXML
    private TableColumn<Article,String> tbcId;
    @FXML
    private TableColumn<Article,String> tbcLibelle;
    @FXML
    private TableColumn<Article,String> tbcPrix;
    @FXML
    private TextField textAdresse;
    @FXML
    private TextField textTelephone1;
    @FXML
    private TextField textNom1;
    @FXML
    private TextField textPrenom1;
    @FXML
    private TextField textAdresse1;
    @FXML
    private TextField textReference;
    @FXML
    private TextField textQteCommande;
    @FXML
    private TableColumn<Article,String> tbcQteCommande;
    @FXML
    private TableColumn<Article,String> tbcMontant;
    @FXML
    private Button handleCreerClient;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO       
    }    

    @FXML
    private void handleCreerClient(ActionEvent event) {         
        String nom=textNom.getText();
        String prenom=textPrenom.getText(); 
        int telephone;
        telephone = Integer.parseInt(textTelephone.getText());
        String adresse= textAdresse.getText();        
        Client client=new Client(nom, prenom, telephone,adresse);
        if (METIER.enregistrerClient(client)){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Client ajouté avec succès");
            alert.setTitle("Information");
            alert.show();
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Erreur d'insertion");
            alert.setTitle("Erreur");
            alert.show();
        }
    }    

    @FXML
    private void handleAjouterCommande(ActionEvent event) {
        int numero=Integer.parseInt(textNumero.getText()); 
        int date=Integer.parseInt(textDate.getText());        
        Commande commande=new Commande(numero,date);
        if (METIER.ajouterCommande(commande)){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Commande ajouté avec succès");
            alert.setTitle("Information");
            alert.show();            
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Erreur d'insertion");
            alert.setTitle("Erreur");
            alert.show();   
        }
    }

    @FXML
    private void handleFindClient(ActionEvent event) {        
    }

    @FXML
    private void handleFindArticle(ActionEvent event) {                
    }

    
}
