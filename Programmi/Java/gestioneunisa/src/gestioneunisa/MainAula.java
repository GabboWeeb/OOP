/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneunisa;

import it.unisa.diem.oop.persone.Docente;
import it.unisa.diem.oop.persone.Persona;
import it.unisa.diem.oop.persone.Studente;
import it.unisa.diem.oop.persone.Tecnico;
import it.unisa.diem.oop.spazi.Accessibile;
import it.unisa.diem.oop.spazi.Aula;
import it.unisa.diem.oop.spazi.eccezioni.AccessibileException;
import it.unisa.diem.oop.spazi.eccezioni.AccessibilePienoException;
import it.unisa.diem.oop.spazi.eccezioni.AccessibileVuotoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucagreco
 */
public class MainAula {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Accessibile a = new Aula("B",10);
        
        
        
        try {
            a.esce();
            a.entra(new Persona("Mario", "Rossi","MRS0001"));
            
        } catch (AccessibileException ex) {
          
            
           System.err.println(ex); 
           // Logger.getLogger(MainAula.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
         // catch multipli
       
        
       
        try {
        a.entra(new Studente("Fabio", "Rossi", "FBR0001","061270001", 28));
        
        a.entra(new Studente("Luigi", "Bianchi", "LBH0001","061270011", 28));
         
        a.entra(new Studente("Lorenzo", "Grigi", "LGR0001","061270021", 29));
       
        a.entra(new Docente("Andrea", "Bianchi", "ABN0001", "330001", "ASD"));
        
        a.entra(new Docente("Saverio", "Bianchi", "SBN0001", "330010", "TSW"));
        
        a.entra(new Tecnico("Luigi", "Rossi", "LGR0001", "450001", "DIEM"));
        
        }
        catch(AccessibileException ex) {
            System.out.println("qualcosa");
        }
        
  //      a.esce();
        
  //      a.esce();
        
        
        System.out.println(a);
        
        
    }
    
}
