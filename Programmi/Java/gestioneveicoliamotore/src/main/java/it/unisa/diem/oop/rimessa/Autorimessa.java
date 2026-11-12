/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.rimessa;

import it.unisa.diem.oop.gestioneveicoliamotore.Veicolo;
import it.unisa.diem.oop.rimessa.eccezioni.AutorimessaPienaException;
import it.unisa.diem.oop.rimessa.eccezioni.AutorimessaVuotaException;
import it.unisa.diem.oop.rimessa.eccezioni.TargaNonValidaException;

/**
 *
 * @author GabboWeeb
 */
public class Autorimessa extends Box {
    
    private final Veicolo veicoli[];
    private int testa;
    private int coda;
    private int riemp;
  
    public Autorimessa(int maxPosti, String nome) {
        super(maxPosti, nome);
        riemp = 0;
        testa = 0;
        coda = 0;
        veicoli = new Veicolo[maxPosti];
    }

    private boolean autorimessaPiena() {
        return riemp == super.maxPosti; //il prof nel suo codice ha scritto riemp == veicoli.length
    }

    private boolean autorimessaVuota() {
        return riemp == 0;
    }

    @Override
    public void entra(Veicolo v) throws TargaNonValidaException, AutorimessaPienaException {
        if(autorimessaPiena()) {
            throw new AutorimessaPienaException("Autorimessa Piena");
        } else if(!v.controllaTarga()) {
            throw new TargaNonValidaException("La targa del veicolo con numero di telaio: " + v.getNumTelaio() + ", non e' valida");
        } else {
            veicoli[coda] = v;
            coda = (coda+1)%super.maxPosti;
            riemp++;
        }
    }

    @Override
    public Veicolo esce() throws AutorimessaVuotaException {
        if(autorimessaVuota()) {
            throw new AutorimessaVuotaException("Autorimessa Vuota");
        } else {
            Veicolo veicolo = veicoli[testa];
            veicoli[testa] = null;
            testa = (testa+1)%super.maxPosti;
            riemp--;
            return veicolo;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(super.toString());
        sb.append("\nVeicoli presenti:\n");
        
        for(int i=0;i<riemp;i++) {
            sb.append((veicoli[(testa+i)%maxPosti]));
            sb.append("\n");
        }
        
        return sb.toString();
    }

}

