/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.rimessa;

import it.unisa.diem.oop.gestioneveicoliamotore.Veicolo;
import it.unisa.diem.oop.rimessa.eccezioni.BoxException;

/**
 *
 * @author GabboWeeb
 */
public abstract class Box {
    
    public int maxPosti;
    private String nome;

    public Box(int maxPosti, String nome) {
        this.maxPosti = maxPosti;
        this.nome = nome;
    }

    public int getMaxPosti() {
        return maxPosti;
    }

    public void setMaxPosti(int maxPosti) {
        this.maxPosti = maxPosti;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract void entra(Veicolo v) throws BoxException;

    public abstract Veicolo esce() throws BoxException;

    @Override
    public String toString() {
        return "info BOX:" + "\n" 
            + "Nome: " + nome + "\n"
            + "Max posti: " + maxPosti + "\n";
    }

}

