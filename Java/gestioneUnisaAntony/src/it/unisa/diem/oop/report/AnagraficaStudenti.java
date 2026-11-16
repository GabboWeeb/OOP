/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.report;

import it.unisa.diem.oop.persone.Studente;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author gabri
 */
public class AnagraficaStudenti {
    
    private String descrizione;
    //Chiave String, Studente valore
    private Map<String,Studente> anagrafica;
    
    public AnagraficaStudenti(String descrizione) {
        this.descrizione = descrizione;
        
        //this.anagrafica = new HashMap<>();
        
        //Controllo di uguaglianza effettuato sulla chiave
        this.anagrafica = new TreeMap<>();
    }
    
    public void aggiungi(Studente s) {
        //putIfAbsent.. aggiunge l'elemento solo se non c'è
        //put invece lo sovrascrive
        
        this.anagrafica.putIfAbsent(s.getMatricola(), s);
    }
    
    public void rimuovi(Studente s) {
        this.anagrafica.remove(s.getMatricola());
    }
    
    public Studente cerca(String matricola) {
        return this.anagrafica.get(matricola);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(this.descrizione + '\n');
        //sb.append(this.anagrafica).append("\n");
        
        //
        for(Studente s : anagrafica.values()) {
            System.out.println(s);
        }
        
        return sb.toString();
    }
}
