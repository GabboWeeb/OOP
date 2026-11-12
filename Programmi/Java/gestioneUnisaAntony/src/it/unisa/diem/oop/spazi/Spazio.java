/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.spazi;

/**
 *
 * @author Antonio
 */

//non più estende! ma implementa
public abstract class Spazio implements Accessibile {
    /*Come nelle classi, se lo rendi abstract non lo devi implementare!! Deve essere implementata dalla prima classe concreta*/
    
    //faciamo una classe aula e una lboratorio
    
    //modelliamo degli spazi generici
    private String descrizione;
    private int maxPosti;
    
    public Spazio(String descrizione, int maxPosti){
        this.descrizione=descrizione;
        this.maxPosti=maxPosti;
    
    }
    
    public String getDescrizione (){
        return this.descrizione;
    }
    public void setDescrizione (String descrizione){
        this.descrizione=descrizione;
    }
    public int getMaxPosti (){
        return this.maxPosti;
    }
    public void setMaxPosti (int maxPosti){
        this.maxPosti=maxPosti;
    }
    
    public abstract boolean isVuoto();  //per convenzione iniziano con is le funzioni booleane
    public abstract boolean isPieno();
    public abstract String getTipo();
    
    @Override
    public String toString(){
        return this.getTipo()+" : "+this.descrizione+" Capienza: "+ this.maxPosti+"\n";
        
    }
    
    
}
