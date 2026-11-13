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
public class Autovettura extends Veicolo {
    
    private final int numeroPosti;
    
    public Autovettura (String numTelaio, String modello, String alimentazione, String targa, int numeroPosti){
        super( numTelaio,  modello, alimentazione, targa);
        this.numeroPosti=numeroPosti;
    
    }
    
    public int getNumeroPosti(){
        return this.numeroPosti;
    }
    
    
    @Override //leggibile!!
    public boolean controllaTarga(){
        String targa= this.getTarga(); //va bene nulla, this o super!
        if (targa.length() !=7){ //nelle stringhe è un metodo, negli array è una classe
            return false;
        } else {    //via di C
           
            for(int i=0;i<2;i++){//non funziona l'accesso indicizzato
                if (!Character.isLetter(targa.charAt(i)))
                    return false;
            }
            for(int i=2;i<5;i++){
                if (!Character.isDigit(targa.charAt(i)))
                    return false;
            }
            for(int i=5;i<7;i++){
                if (!Character.isLetter(targa.charAt(i)))
                    return false;
            }
        }
        
        
        //return targa.matches("^[a-zA-Z]{2}\\d{3}[a-zA-Z]{2}$");
        //getTarga()
                
               
    
        return true;
    }
    
    @Override
    public String toString(){
        StringBuilder tmp= new StringBuilder();
        
        tmp.append(super.toString());
        tmp.append(", Numero posti = ");
        tmp.append(this.numeroPosti);
        
        return tmp.toString();
    
    }
    
}
