/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.commerciale;

import METIER.Service;
import MODEL.Profil;
import MODEL.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author serge abba
 */
public class ViewUtilisateurController implements Initializable {
    
     private Service METIER;
    ObservableList<Profil> obProfils;    
    ObservableList <Utilisateur> obUsers;    

    @FXML
    private TableView<Utilisateur> tblUsers;
    @FXML
    private TableColumn<Utilisateur,String> tbcNom;
    @FXML
    private TableColumn<Utilisateur,String> tbcPrenom;
    @FXML
    private TableColumn<Utilisateur,String> tbcProfil;
    @FXML
    private TextField textLogin;
    @FXML
    private TextField textPwd;
    @FXML
    private TextField textPrenom;
    @FXML
    private TextField textNom;
    @FXML
    private ComboBox<Profil> cmbProfil;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        METIER=new Service();
       obUsers=FXCollections.observableArrayList(METIER.listerUtilisateur());
       cmbProfil.setItems(obProfils);        
       loadTable();
    }    
    
    private void loadTable(){
            tbcNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            tbcPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom")); 
            tbcProfil.setCellValueFactory(new PropertyValueFactory<>("profil"));               
            tblUsers.setItems(obUsers);
    }    

    @FXML
    private void handleCreerUtilisateur(ActionEvent event) {
        String login=textLogin.getText(); 
        String pwd=textPwd.getText();        
        String nom=textNom.getText();        
        String prenom=textPrenom.getText();
        Profil profil=this.cmbProfil.getValue();
        Utilisateur utilisateur=new Utilisateur(login,pwd,nom,prenom);
        if (METIER.creerUtilisateur(utilisateur)){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Utilisateur créé avec succès");
            alert.setTitle("Information");
            alert.show();
            obUsers.add(utilisateur);
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Erreur d'insertion");
            alert.setTitle("Erreur");
            alert.show();   
        }        
    }
    
}
