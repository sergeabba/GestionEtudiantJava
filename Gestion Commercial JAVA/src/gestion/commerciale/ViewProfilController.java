/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.commerciale;

import METIER.Service;
import MODEL.Profil;
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
public class ViewProfilController implements Initializable {
    
    private Service METIER;
    ObservableList <Profil> obProfils;

    @FXML
    private TextField textLibelle;
    @FXML
    private TableView<Profil> tblListeProfil;
    @FXML
    private TableColumn<Profil,String> tbcId;
    @FXML
    private TableColumn<Profil,String> tbcLibelle;
    @FXML
    private Button handleCreerProfil;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         METIER=new Service();
         obProfils=FXCollections.observableArrayList(METIER.listerProfil());
        
        loadTable();
    }    
    
    private void loadTable(){
            tbcId.setCellValueFactory(new PropertyValueFactory<>("id"));
            tbcLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));               
            tblListeProfil.setItems(obProfils);
    }    

    @FXML
    private void handleCreerProfil(ActionEvent event) {
        String libelle=textLibelle.getText();        
        Profil pro=new Profil(libelle);
        if (METIER.creerProfil(pro)){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Profil ajouté avec succès");
            alert.setTitle("Information");
            alert.show();
            obProfils.add(pro);
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Erreur d'insertion");
            alert.setTitle("Erreur");
            alert.show();   
        }
    }
}
