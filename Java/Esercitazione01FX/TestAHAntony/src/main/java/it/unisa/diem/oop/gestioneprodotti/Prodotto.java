/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.gestioneprodotti;

/**
 *
 * @author Antonio
 */
public class Prodotto {
    private final int codice;
    private final String descrizione;
    private final double costo;
    private final String dataProduzione;
    
    //costruttore
    public Prodotto(){
        this(-1,"NULL",0.0F,"00-00-0000");
    }
    
    
    public Prodotto(int codice, String descrizione, double costo, String dataProduzione){
        this.codice=codice;
        this.descrizione=descrizione;
        this.costo=costo;
        this.dataProduzione=dataProduzione;
    }
    
    public int getCodice (){
        return this.codice;
    }
    public String getDescrizione (){
        return this.descrizione;
    }
    public double getCosto (){
        return this.costo;
    }
    public String getSataProduzione (){
        return this.dataProduzione;
    }
    
    public String stampaProdotto(){
        StringBuilder tmp= new StringBuilder();
        tmp.append(this.codice);
        tmp.append(": ");
        tmp.append(this.descrizione);
        tmp.append(" (Costo: ");
        tmp.append(this.costo);
        tmp.append(" €) --- Data di produzione: ");
        tmp.append(this.dataProduzione);
        
        return tmp.toString();
    
    }
    
    
}
