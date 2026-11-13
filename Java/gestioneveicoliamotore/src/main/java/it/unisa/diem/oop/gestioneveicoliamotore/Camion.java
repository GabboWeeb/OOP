/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.gestioneveicoliamotore;


/**
 *
 * @author GabboWeeb
 */
public class Camion extends Veicolo {
    private final int numeroAssi;

    public Camion(String numTelaio, String modello, String alimentazione, String targa, int numeroAssi) {
	super(numTelaio, modello, alimentazione, targa);
	this.numeroAssi = numeroAssi;
    }

    public int getNumeroAssi() {
	return numeroAssi;
    }
	
    @Override
    public boolean controllaTarga() {
        String targa = getTarga();
        if(targa.length() != 8)
            return false; 
        else if(Character.isDigit(targa.charAt(0)))
            return false;
	else if(Character.isDigit(targa.charAt(1)))
            return false;
        else if(Character.isLetter(targa.charAt(2)))
            return false;
        else if(Character.isLetter(targa.charAt(3)))
            return false;
        else if(Character.isLetter(targa.charAt(4)))
            return false;
        else if(Character.isLetter(targa.charAt(5)))
            return false;
        else if(Character.isLetter(targa.charAt(6)))
            return false;
        else if(Character.isLetter(targa.charAt(7)))
            return false;
        else
            return true;
    }

    @Override
    public String toString() {
        return "\nVeicolo: Camion" + "\n"
        + super.toString() + "\n"
        + "Numero di Assi: " + numeroAssi;
    }
}

