/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneunisa;

import it.unisa.diem.oop.persone.Studente;
import it.unisa.diem.oop.report.AnagraficaStudenti;

/**
 *
 * @author gabri
 */
public class MainAnagrafica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Studente s1 = new Studente ("Mario","Bianchi","MRS0003","061270001",28);
        Studente s2 = new Studente ("Mario","Bianchi","MRS0003","061270001",28);
        Studente s3 = new Studente ("Stefano","Bianchi","SRS0003","061270002",27);
        Studente s4 = new Studente ("Ernesta","Bianchi","ERS0004","061270003",28);
        
        AnagraficaStudenti as = new AnagraficaStudenti("INGINF");
        as.aggiungi(s1);
        as.aggiungi(s2);
        as.aggiungi(s3);
        as.aggiungi(s4);
        
        System.out.println(as);
        
        Studente s = as.cerca("061270002");
        Studente ss = as.cerca("061");
        
        System.out.println("Prima ricerca:  "+ s);
        System.out.println("Seconda ricerca: " + ss);
    }
    
}
