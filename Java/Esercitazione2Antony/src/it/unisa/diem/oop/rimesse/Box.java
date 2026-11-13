/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.rimesse;
import it.unisa.diem.oop.veicoli.Veicolo;
import it.unisa.diem.oop.eccezioni.*;
public abstract class Box {

           public int maxPosti;
           private String nome;
           

    public Box(int maxPosti, String nome) {
               this.maxPosti=maxPosti;
               this.nome=nome;
    }

    public int getMaxPosti() {
            return this.maxPosti;
    }

    public void setMaxPosti(int maxPosti) {
            this.maxPosti=maxPosti;
    }

    public String getNome() {
               return this.nome;
    }

    public void setNome(String nome) {
                this.nome=nome;
    }

    public abstract void entra( Veicolo v ) throws TargaNonValidaException,AutorimessaPienaException; //meglio essere selettivi al massimo

    public abstract Veicolo esce() throws AutorimessaVuotaException ;

    @Override
    public String toString() {
        
        StringBuilder sb=new StringBuilder("Nome Box=");
        sb.append(this.nome);
        sb.append(", Capienza= ");
        sb.append(this.maxPosti);
        return sb.toString();
    }

}
