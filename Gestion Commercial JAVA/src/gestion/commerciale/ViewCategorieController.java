/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.commerciale;

import METIER.Service;
import MODEL.Categorie;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author serge abba
 */
public class ViewCategorieController implements Initializable {
    
    private Service METIER;
    ObservableList <Categorie> obCategories;

    @FXML
    private TextField textLibelle;
    @FXML
    private TableView<Categorie> tblListeCategorie;
    @FXML
    private TableColumn<Categorie,String> tbcId;
    @FXML
    private TableColumn<Categorie,String> tbcLibelle;
    @FXML
    private Button handleCreerCategorie;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         METIER=new Service();
         obCategories=FXCollections.observableArrayList(METIER.listerCategorie());
        
        loadTable();
    }    
    private void loadTable(){
            tbcId.setCellValueFactory(new PropertyValueFactory<>("id"));
            tbcLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));               
            tblListeCategorie.setItems(obCategories);
    }    

    @FXML
    private void handleCreerCategorie(ActionEvent event) {
        String libelle=textLibelle.getText();        
        Categorie categorie=new Categorie(libelle);
        if (METIER.creerCategorie(categorie)){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Catégorie ajoutée avec succès");
            alert.setTitle("Information");
            alert.show();
            obCategories.add(categorie);
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Erreur d'insertion");
            alert.setTitle("Erreur");
            alert.show();   
        }
    }
}
