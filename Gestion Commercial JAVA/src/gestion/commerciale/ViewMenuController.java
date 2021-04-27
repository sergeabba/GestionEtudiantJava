/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.commerciale;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author serge abba 
 */
public class ViewMenuController implements Initializable {

    @FXML
    private AnchorPane AnchorContent;
    
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            loadView("ViewProfil");
        } catch (IOException ex) {
            Logger.getLogger(ViewMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
     public void loadView(String view) throws IOException{
        AnchorPane viewLoding=FXMLLoader.load(getClass().getResource(view+".fxml"));
        AnchorContent.getChildren().add(viewLoding);
    }

    
   
    @FXML
    private void handleLoaViewArticle(ActionEvent event) throws IOException {
        loadView("ViewArticle");
    }

    @FXML
    private void handleLoaViewUtilisateur(ActionEvent event) throws IOException {
        loadView("ViewUtilisateur");
    }

    @FXML
    private void handleLoaViewProfil(ActionEvent event) throws IOException {
        loadView("ViewProfil");
    }

    @FXML
    private void handleLoaViewCategorie(ActionEvent event) throws IOException {
        loadView("ViewCategorie");
    }

    @FXML
    private void handleLoaViewCommande(ActionEvent event) throws IOException {
        loadView("ViewCommande");
    }

    @FXML
    private void handleDeconnexion(ActionEvent event) throws IOException {
         AnchorContent.getScene().getWindow().hide();
         AnchorPane view= FXMLLoader.load(getClass().getResource("ViewConnexion.fxml"));
            Scene scene= new Scene(view);
            Stage stage= new Stage();
            stage.setScene(scene);
            stage.showAndWait();
    }
   
}
