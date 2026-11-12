/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.rimesse;
import it.unisa.diem.oop.eccezioni.*;
import it.unisa.diem.oop.veicoli.Veicolo;
public class Autorimessa extends Box {

    private final Veicolo veicoli[];
    private int coda; 
    /*la testa di una coda (struttura dati) è l'estremità da cui viene rimosso l'elemento, mentre la coda è l'estremità da cui viene inserito un nuovo elemento*/
    private int testa;
    private int riemp;
  
    public Autorimessa(int maxPosti, String nome) {
        super(maxPosti,nome);
        this.veicoli= new Veicolo [maxPosti];
        //gli attributi di istanza interi sono inzializzati per default a 0, inizializzarli esplicitamente è lecito ma superfluo
    }

    private boolean autorimessaPiena() {
               return this.riemp==super.maxPosti;//oppure riemp == veicoli.length;
    }

    private boolean autorimessaVuota() {
                return this.riemp==0;
    }

    @Override
    public void entra( Veicolo v ) throws TargaNonValidaException,AutorimessaPienaException{
            if(!v.controllaTarga()){
                throw new TargaNonValidaException("Il veicolo:\n"+v.toString()+"\nnon ha una taga valida.\n");
            } else if (this.autorimessaPiena()){
                throw new TargaNonValidaException("L'autorimessa è piena!!");
            }
            veicoli[coda]=v;
            riemp++;
            coda=(coda+1)%maxPosti;
    }

    @Override
    public Veicolo esce() throws AutorimessaVuotaException {

            if (this.autorimessaVuota()){
                throw new AutorimessaVuotaException("L'autorimessa è vuota!");
            } 
            Veicolo v=veicoli[testa];
            veicoli[testa]=null; //per il garbage collector
            testa=(testa+1)%maxPosti;
            riemp--;
            return v;
    }

    @Override
    public String toString() {
        
        StringBuilder sb=new StringBuilder(super.toString());
        sb.append("\nVeicoli presenti:");
        for (int i=testa;i<testa+riemp;i++){
            sb.append("\n");
            sb.append(veicoli[i%maxPosti].toString());
            
        }
        return sb.toString();
    }

}
