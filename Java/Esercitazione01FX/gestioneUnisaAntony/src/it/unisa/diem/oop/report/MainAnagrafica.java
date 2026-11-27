/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.report;

import it.unisa.diem.oop.persone.Studente;
import java.io.IOException;

/**
 *
 * @author Antonio
 */
public class MainAnagrafica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Studente s1= new Studente ("Joe","Star","CF3","029837298",23);
        Studente s2= new Studente ("Joe","Star","CF3","029837298",23);
        Studente s3= new Studente ("William","Star","F3","0237298",24);
        Studente s4= new Studente ("Averell","Star","CF","37298",26);
        
        AnagraficaStudenti a = new AnagraficaStudenti("Ing Inf");
        
        a.aggiungi(s1);
        a.aggiungi(s2);
        a.aggiungi(s3);
        a.aggiungi(s4);
        
        System.out.println(a);
        
        Studente s = a.cerca("029837298");
        Studente ss = a.cerca("a");
        
        System.out.println("\n -------- \n");
        System.out.println(s);
        System.out.println(ss);
//        
//        
//        a.salvaDOS("anagrafica.bin");
//        
//        AnagraficaStudenti a1 = AnagraficaStudenti.leggiDIS("anagrafica.bin");
//        System.out.println(a1);
//        System.out.println("==== SERIALIZZAZIONE ====");
//        
//        //a.salvaOBJ("anagrafica.obj");
//        AnagraficaStudenti a2= AnagraficaStudenti.leggiOBJ("anagrafica.obj");
//        //non funziona perchè le classi non sono compatibili: hanno UID diversi, perché se hai modificato una classe cambia il suo uid
//        /*l'uid è un long e si può gestire manualmente, ma se lo gestisci tu ti devi ricordare di cambiarlo. Vorresti farlo perché l'uid cambia per TUTTO, anche per uno spazio in più*/
//        //se risalvi ancora non funziona perchè it.unisa.diem.oop.persone.Studente; no valid constructor: personaUnisa non è serializzabile e il supertipo ha solo costruttori con parametri
//        //sposta la 
//        System.out.println(a2);
       
        a.salvaCSV();
        AnagraficaStudenti a2 = AnagraficaStudenti.leggiCSVScan("Ing Inf.csv");
        System.out.print(a2);
    }
    
}
