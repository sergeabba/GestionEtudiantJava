/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.commerciale;

import METIER.Service;
import MODEL.Article;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Djiby DIOP
 */
public class ViewArticleController implements Initializable {
    
    private Service METIER;
    ObservableList <Article> obArticles;
     
    @FXML
    private TextField textLibelle;
    @FXML
    private TextField textPrix;
    @FXML
    private TextField textStock;  
    @FXML
    private TableColumn<Article,String> tbcId;
    @FXML
    private TableColumn<Article,String> tbcLibelle;
    @FXML
    private TableColumn<Article,String> tbcStock;
    @FXML
    private TableColumn<Article,String> tbcPrix;        
    @FXML
    private TableView<Article> tblArticle;
    @FXML
    private TableColumn<Article,String> tbcReference;
    @FXML
    private TextField textReference;

    
  
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    METIER=new Service();
        obArticles=FXCollections.observableArrayList(METIER.listerArticle());
        
        loadTable();
    }
        
    private void loadTable(){
            tbcId.setCellValueFactory(new PropertyValueFactory<>("id"));
            tbcReference.setCellValueFactory(new PropertyValueFactory<>("reference"));
            tbcLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
            tbcStock.setCellValueFactory(new PropertyValueFactory<>("stock"));  
            tbcPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));  
            tblArticle.setItems(obArticles);
    }     
      
    @FXML
    private void handleEnregistrerArticle(ActionEvent event) {
         String reference=textReference.getText();  
         String libelle=textLibelle.getText();
         int stock=Integer.parseInt(textStock.getText());
         int prix=Integer.parseInt(textPrix.getText());

        Article article=new Article(reference,libelle,stock,prix);
        if (METIER.enregistrerArticle(article)){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Catégorie ajoutée avec succès");
            alert.setTitle("Information");
            alert.show();
            obArticles.add(article);
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Erreur d'insertion");
            alert.setTitle("Erreur");
            alert.show();   
        }
    }  

}
