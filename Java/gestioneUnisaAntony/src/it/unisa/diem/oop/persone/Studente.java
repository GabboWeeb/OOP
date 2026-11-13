/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.persone;

import it.unisa.diem.oop.persone.eccezioni.VotoNonValidoException;

/**
 *
 * @author Antonio
 */
/*puoi ereditare SOLO da una sola classe
//non esiste l'ereditarietà multipla in JAVA, ma in c++ si ad esempio
l'interfacci permette di prendere più interfacce e poi la specializzi tu in maniera univoca
quindi è un ALBERO questa roba!
*/ 
public class Studente extends PersonaUnisa {
    private double votoMedio;
    
    public Studente(String nome,String cognome,String codiceFiscale,String matricola ,double votoMedio){
        super(nome,cognome,codiceFiscale,matricola);
        //eccezione!!
        if(votoMedio<18 || votoMedio > 31){
            //throw new RuntimeException("Voto non valido."); //generale, con un'eccezione non controllata generica
            throw new VotoNonValidoException("Il voto "+votoMedio+" non lo puoi assegnare!!" ); 
        }
        
        
        this.votoMedio=votoMedio;
    
    }
    
    public double getVotoMedio (){
        return this.votoMedio;
    }
    public void setVotoMedio (double votoMedio){
        this.votoMedio=votoMedio;
    }
    
    @Override
    public String toString(){
    
        return super.toString()+"\nVoto Medio:\t"+this.votoMedio+"\n";
    }
    
    //la classe conreta li DEVE implementare
    @Override
    public String getRuolo(){
        return "Studente";
    }
    
    
    
}
