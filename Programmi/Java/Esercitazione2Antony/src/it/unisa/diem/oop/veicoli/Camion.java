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
public class Camion extends Veicolo {
    private final int numeroAssi;
    
    public Camion(String numTelaio, String modello, String alimentazione, String targa, int numeroAssi){
        super(numTelaio, modello, alimentazione, targa);
        this.numeroAssi=numeroAssi;
    }
    
    public int getNumeroAssi(){
        return this.numeroAssi;
    }
    
    @Override
    public boolean controllaTarga(){
        //usando charAt
        String targa= super.getTarga();
        if(targa.length()!=8){
            return false;
        }
        
        for(int i=0;i<2;i++){
            if(Character.isLetter(targa.charAt(i))==false)
                return false;
        }
        for(int i=2;i<8;i++){
            if(Character.isDigit(targa.charAt(i))==false)
                return false;
        }
       
        return true;
        
        //return super.getTarga().matches("^[a-zA-Z]{2}\\d{5}$");
    
    }
    
    @Override 
    public String toString(){
        StringBuilder tmp= new StringBuilder();
        
        tmp.append(super.toString());
        tmp.append(", Numero posti = ");
        tmp.append(this.numeroAssi);
        
        return tmp.toString();
    
    }
    
}
