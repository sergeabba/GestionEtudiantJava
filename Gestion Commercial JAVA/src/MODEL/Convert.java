/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author serge abba
 */
public class Convert {
     public  static String listToString(List<String> profil){
        String stringProfil="";
        stringProfil = profil.stream().map((elt) -> elt+";").reduce(stringProfil, String::concat);
        return stringProfil;
    }
    
    public static List<String> stringToList (String profil){
        List<String> lProfil=new ArrayList<>(); 
        String tab[]= profil.split(";");
        for(String elt:tab){
            lProfil.add(elt);
        }
        return lProfil;
    }
}
