/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cours.Liste;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abbas
 */
public class Exercice1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        1-Créer une liste de string 
        2-ajouter des elements dans la liste 
        4-supprimer des elements 
        3-affichage de la liste 
        5- modifier un element de la liste
        6-rechercher un elements dans la liste
        */
        // 1- creer une liste string
        List<String> lString=new ArrayList();
        
        //2- ajouter des elements
        lString.add("Bonjour");
        lString.add("Au revoir");
        lString.add("Les Etudiants de la LIAGE 3");
        
        //3-affichage de la liste
            //methode 1
            for (String elt:lString){
            System.out.println(elt);
            }
            lString.add(0, "Debut");
            lString.forEach((elt) -> {
                System.out.println(elt);
        });
            //4-supprimer des elements
            lString.remove("Debut");
            lString.remove(2);
            System.out.println("Affichage apres suppression");
            lString.forEach((elt) -> {
                System.out.println(elt);
            });
            
            //5-modifier un element de la liste
            lString.set(0, "Bonsoir");
            System.out.println("Affichage Modification ");
            lString.forEach((elt) -> {
                System.out.println(elt);
            });
            
            //6-rechercher un elements dans la liste
            if(lString.contains("Bonsoir")==true){
                System.out.println("Element Existe");
            }else{
                System.out.println("Element n'existe pas");
            }
            
            
    }
    
}
