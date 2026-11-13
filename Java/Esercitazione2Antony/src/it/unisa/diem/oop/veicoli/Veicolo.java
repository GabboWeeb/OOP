/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.veicoli;

/**
 *
 * @author Antonio
 */
public abstract class Veicolo {
    private final String numTelaio;
    private final String modello;
    private final String alimentazione;
    private String targa;
    
    
    
    Veicolo(String numTelaio, String modello, String alimentazione, String targa){
        this.numTelaio=numTelaio;
        this.modello=modello;
        this.alimentazione=alimentazione;
        this.targa=targa;
        /*
        if(!this.controllaTarga()){
            System.out.println("Errore nell'inserimento della targa!");
            this.targa="NOT VALID";
        } */
        
    }
    
    public String getNumTelaio(){
        return this.numTelaio;
    }
    public String getModello(){
        return this.modello;
    }
    public String getAlimentazione(){
        return this.alimentazione;
    }
    public String getTarga(){
        return this.targa;
    }
    
    public void setTarga(String targa){
        /*
        if(!this.controllaTarga()){
            System.out.println("Errore nell'inserimento della targa!");
        } else{
            this.targa=targa;
        }*/
        this.targa=targa;
    }
    
    public abstract boolean controllaTarga();
    
    @Override
    public String toString(){
        StringBuilder tmp= new StringBuilder();
        tmp.append("Telaio = ");
        tmp.append(this.numTelaio);
        tmp.append(", Modello = ");
        tmp.append(this.modello);
        tmp.append(", Targa = ");
        tmp.append(this.targa);
        
        
        return tmp.toString();
        
    }
    
    
    
}
