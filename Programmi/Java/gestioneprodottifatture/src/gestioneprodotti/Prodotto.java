/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneprodotti;

/**
 *
 * @author GabboWeeb
 */
public class Prodotto {
    
    private final int codice;
    private final String descrizione;
    private final double costo;
    private final String dataProduzione;
    
    public Prodotto(int codice, String descrizione, double costo, String dataProduzione) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.costo = costo;
        this.dataProduzione = dataProduzione;
    }
    
    public int getCodice() {
        return codice;
    }
    
    public String getDescrizione() {
        return descrizione;
    }
    
    public double getCosto() {
        return costo;
    }
    
    public String getDataProduzione() {
        return dataProduzione;
    }
    
    public String stampaProdotto() {
        return codice +": "+ descrizione +"(Costo: "+ costo +")---Data di Produzione: "+ dataProduzione +"\n";
    }
    
}
