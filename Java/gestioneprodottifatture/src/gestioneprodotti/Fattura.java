/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneprodotti;

import gestioneclienti.Cliente;

/**
 *
 * @author GabboWeeb
 */
public class Fattura {
    
    private static int contatore;
    
    static {
        contatore = 0;
    }
    
    private final int codice;
    private final int size;
    private final Cliente cliente;
    private final String dataEmissione;
    private final double tassaImposta;
    
    private Prodotto prodotto[];
    private int riemp;
    
    private Fattura(int codice, int riemp, int size, Cliente cliente, String dataEmissione, float tassaImposta) {
        this.codice = codice;
        this.riemp = riemp;
        this.size = size;
        this.cliente = cliente;
        this.dataEmissione = dataEmissione;
        this.tassaImposta = tassaImposta;
        
        this.prodotto = new Prodotto[size];
        
        contatore++;
    }
    
    public Fattura(int size, Cliente cliente, String dataEmissione, float tassaImposta) {
        this(contatore, 0, size, cliente, dataEmissione, tassaImposta);
    }

    public static int getContatore() {
        return contatore;
    }

    public int getCodice() {
        return codice;
    }

    public int getSize() {
        return size;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getDataEmissione() {
        return dataEmissione;
    }

    public double getTassaImposta() {
        return tassaImposta;
    }

    public Prodotto[] getProdotto() {
        return prodotto;
    }

    public int getRiemp() {
        return riemp;
    }
    
    public void aggiungiProdotto(Prodotto p) {
        if(riemp < size) {
            prodotto[riemp] = p;
            riemp++;
        } else {
            System.out.println("Fattura Piena\n");
        }
    }
    
    public double calcolaImponibile() {
        double totale = 0;
           
        for(int i=0;i<riemp;i++) {
            totale += prodotto[i].getCosto();
        }
        
        return totale;
    }

    public double calcolaTotale() {
        double totale = calcolaImponibile();
        
        double tassa = totale*tassaImposta;
        totale += tassa;
        
        return totale;
    }
    
    public String stampaFattura() {
        
        System.out.println("\nFattura ID: "+ codice + "Data di Emissione: "+ dataEmissione +"\n"+ cliente.stampaCliente());
        for(int i=0;i<riemp;i++) {
            System.out.print(prodotto[i].stampaProdotto());
        }
        return "Totale da pagare: " + calcolaTotale();
    }
    
}
