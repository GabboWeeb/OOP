/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneaeromobili;

/**
 *
 * @author gabri
 */
public class CodeCheckEN implements CodeChecker {
    
    @Override
    public boolean check(String codice) {
        if(codice.length() != 6)
            return false; 
        if(!codice.startsWith("EN"))
            return false;
        else if(Character.isDigit(codice.charAt(2)))
            return false;
	else if(Character.isDigit(codice.charAt(3)))
            return false;
	else if(Character.isLetter(codice.charAt(4)))
            return false; 
        else if(Character.isLetter(codice.charAt(5)))
            return false;
        else 
            return true;
    }
}
