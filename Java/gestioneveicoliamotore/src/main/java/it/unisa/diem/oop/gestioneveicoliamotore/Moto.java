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
public class Moto extends Veicolo {
    private final boolean guidaLibera;

    public Moto(String numTelaio, String modello, String alimentazione, String targa, boolean guidaLibera) {
        super(numTelaio, modello, alimentazione, targa);
        this.guidaLibera = guidaLibera;
    }

    public boolean getGuidaLibera() {
	return guidaLibera;
    }
	
    @Override
    public boolean controllaTarga() {
	String targa = getTarga();
	if(targa.length() != 7)
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
	else 
            return true;
    }

    @Override
    public String toString() {
	return "\nVeicolo: Moto" + "\n"
            + super.toString() + "\n"
            + "Guida Libera: " + guidaLibera;
    }
}
