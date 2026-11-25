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
public class CodeCheckIT implements CodeChecker {
    
    @Override
    public boolean check(String codice) {
        if(codice.length() != 7) {
            return false; 
        }
        if(!codice.startsWith("IT")) {
            return false;
        }
        if(!Character.isLetter(codice.charAt(2))) {
            return false;
        }
	if(!Character.isLetter(codice.charAt(3))) {
            return false;
        }
	if(!Character.isDigit(codice.charAt(4))) {
            return false;
        } 
        if(!Character.isDigit(codice.charAt(5))) {
            return false;
        }
        if(!Character.isDigit(codice.charAt(6))) {
            return false;
        }
        else { 
            return true;
        }
    }
}

