/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneaeromobili;

import java.io.Serializable;

/**
 *
 * @author gabri
 */
public abstract class Aeromobile implements Cloneable, Serializable {
    private final String codice;
    private final int numeroSequenziale;
    
    private static int contatore;
    
    public Aeromobile(String codice) {
        this.codice = codice;
        numeroSequenziale = contatore;
        contatore++;
    }
    
    public String getCodice() {return this.codice;}
    public int getNumeroSeuquenziale() {return this.numeroSequenziale;}
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    @Override
    public String toString() {
        return "\nAeromobile n. "+ numeroSequenziale + " - Codice = " + codice;
    }
    
}
