/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.gestioneprodotti;
import it.unisa.diem.oop.gestioneclienti.Cliente;
/**
 *
 * @author Antonio
 */
public class Fattura {

    private static int id; //andava bene anche =1
    private final int code;
    private int lMax; //dimensione fisica massima
    private int length;//dimensione logica array
    private Prodotto array[];
    private final Cliente destinatario;
    private final String dataEmissione;
    private final float percentuale;
    
    static{
        id=1;
    }
    
    public Fattura(int lMax, Cliente destinatario, String dataEmissione, float percentuale){
        this.code=id++;
        this.lMax=lMax;
        this.length=0;
        this.array= new Prodotto[this.lMax];
        this.destinatario=destinatario;
        this.dataEmissione=dataEmissione;
        this.percentuale=percentuale;  
        
        //System.out.println(this.lMax);
    }
    
    public int getCode (){
        return this.code;
    }
    public int getLMax (){
        return this.lMax;
    }
    public int getLength (){
        return this.length;
    }
    public Prodotto[] getArray (){
        return this.array;
    }
    
    public Prodotto getProdotto (int i){
        if (i<this.length){
            return this.array[i];
        } else{
            System.out.println("Non esiste questo prodotto nella fattura!!");
            return null;
        }
        
    }
    
    public Cliente getDestinatario (){
        return this.destinatario;
    }
    
    public String getDataEmissione (){
        return this.dataEmissione;
    }
    
    public float getPercentuale (){
        return this.percentuale;
    }

    void aggiungiProdotto(Prodotto p){
        if(this.length>=this.lMax){
            /*Prodotto newArray [] = new Prodotto [this.length+1];
            this.lMax=this.length+1;
            for (int i=0;i<this.length;i++){
                newArray[i]=this.array[i];
            }
            newArray[this.length++]=p;
            this.array=newArray;
            //soluzione che ho fatto io sopra, quella efficiente sotto
            */
            //int nuovaL = (this.length==0)? 10: this.length*2;
            //this.array=  copyOf()
            this.array[this.length++]=p;
            this.lMax=this.length+1;
        }else{
            this.array[this.length++]=p;
        }
    }
    
    private double calcolaImponibile(){
        double accumulatore =0.0;
        for (int i=0;i<this.length;i++)
            accumulatore+=this.array[i].getCosto()*this.percentuale;
        return accumulatore ;
    }
       
    private double calcolaTotale(){
        double accumulatore =0.0;
        for (int i=0;i<this.length;i++)
            accumulatore+=this.array[i].getCosto();
        return accumulatore + this.calcolaImponibile();
    }
    
    public String stampaFattura(){
        StringBuilder tmp= new StringBuilder();
        tmp.append("===== FATTURA ID: ");
        tmp.append(this.code);
        tmp.append(" (");
        tmp.append(this.dataEmissione);
        tmp.append(") =====\n");
        tmp.append(this.destinatario.stampaCliente());
        for (int i=0;i<this.length;i++){
            tmp.append("\n");
            tmp.append(this.array[i].stampaProdotto());
        }
        
        //String.format()
        
        tmp.append("\n-------------------\nTotale da pagare: €");
        tmp.append(this.calcolaTotale());
        
        return tmp.toString();
        
        
        /* 
        Puoi usare le regex. Linguaggi e traduttori
        Lambda (programmazione funzione)
        
        */
    
    }
    
    
    
}
