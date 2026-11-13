/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.spazi;

import it.unisa.diem.oop.persone.Persona;

import it.unisa.diem.oop.spazi.eccezioni.* ;
/**
 *
 * @author Antonio
 */
public class Aula extends Spazio {
    //attributi
    private Persona persone[];
    private int riemp;
    
    public Aula(String descrizione, int maxPosti){
         super(descrizione, maxPosti);
         this.persone=new Persona[maxPosti];
         //this.riemp=0;//?
    }
    
    
    
    
    @Override
    public boolean isVuoto() {
       return riemp==0;
    }

    @Override
    public boolean isPieno() {
        return riemp==persone.length;//max length
    }

    @Override
    public String getTipo() {
        return "AULA";
    }
    
    //il gestore gestirà
    @Override
    public void entra(Persona p)throws AccessibilePienoException{ //puoi lanciare di meno!! Anche nulla va bene
        //con throws AccessibileException e sopra throws AccessibilePienoException non funziona perché è un'eccezione più ampia della supercalsse
        if (this.isPieno()){
            /*System.out.println("L'aula è piena!!");
            return;*/
            
            //puoi lanciare le sottoclassi di quell'eccezione!!
            throw new AccessibilePienoException();
            
        }
        this.persone[riemp++]=p;
    }

    @Override
    public Persona esce() throws AccessibileVuotoException {
        /*Se il metodo appartiene alla gerarchia allora non ti puoi inventare sta rba ora. Le eccezione le puoi rimuovere ma NON aggiungere
            quindi ora dobbiamo mettere throws anche nella superclasse
        */
        if (this.isVuoto()){
//            System.out.println("L'aula è già vuota!!");
//            return null;
                //se gestissi tu il problema non avrebbe senso lanciare l'eccezione, gestiscila e basta
                //la lanci per passare l'onere a chi la raccoglie, il chiamante. Il chiamante può rilanciarla o gestirla col try-catch.
                //un throw dentro a un try catch si può fare, ma è eccessivo, gestiscilo e basta
            throw new AccessibileVuotoException(); 
            //ma questa è un'eccezione controllata!!
            /*funziona come gli altri oggtti, pui fare la new anche prima, ma è comodo farlo inline no?*/
        }
        Persona p=this.persone[--riemp];
        this.persone[riemp]=null;//così liberi la strada al gabage collector NONEVERO, p resta
        /*Togliamo anche il riferimento logico!!*/
        return p;
    }
    
    @Override
    public String toString (){
        StringBuilder sb=new StringBuilder(super.toString());//antimonio
        
        for (int i=0;i<this.riemp;i++){
            sb.append(this.persone[i]);//chiama automaticamente la to string!
        }
        
        
        return sb.toString();
        
    }
    
}
