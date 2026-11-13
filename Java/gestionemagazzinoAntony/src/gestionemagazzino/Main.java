/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionemagazzino;

/**
 *
 * @author Antonio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//in corsico, main non lo istanzi perché è statico, sta sempre in memoria. Viene sempre invocato il metodo Main, senza istanziare  main
        
        
        //stampa
        int a;  //variabile locale!! scope solo qui. Iniziano con la lettera minuscola!
        a=42;
        System.out.println(a);
        
        //è una var di classe, ci puoi accedere PRIMA di istanziare qualsiasi oggetto!
        //System.out.println(Prodotto.contatore);
        
        Prodotto p;         //nasce una variabile non inizializzata
        //p.codice=0;       NON FUNZIONA! perchè non è ancora inizializzato
        
        p=null;             //useless per quello che sai ora. Usa new
        //p.codice=0;       COMUNQUE NON FUNZIONA perché p non punta a nulla
        p=new Prodotto();   //questa funzione alloca lo spazio nell'heap per contenere gli attributi di p.
                            //p ora contiene l'indirizzo del suo oggetto, ma ora i puntatori non sono fatti tuoi
                            //l'oggetto continuerà ad esistere dopo il main ma non è più puntato da nessuno. Passerà il
                            // garbage collector a deallocare l'oggetto, prima o poi
        //System.out.println(Prodotto.contatore);
        //System.out.println(p.costo);    //ora tutti gli attributi hanno valori di default
        //p.codice=1;
        //System.out.println(p.codice);   //puoi modificare gli attributi, non bello
        //ORA NON LI PUOI MODIFICARE!!! non sono accessibili, neanche in lettura, se privati
        p.aggiungiTag("Nero");
        p.aggiungiTag("Legno");
        p.aggiungiTag("Ferro");
        p.aggiungiTag("Gabbo");
        
        p.stampaInfo();
       // p.setCodice(44);
        p.setCosto(12.3F);
        //System.out.println(p.getCodice());
        p.stampaInfo();
        
        Prodotto p1;
        //System.out.println(Prodotto.contatore);
        p1=p; //lo stesso oggetto referenziato da due nomi!!
       // p1.setCodice(20);
        p.stampaInfo();     //due nomi, stesso oggetto! Anche p avrà costo cambiato, perché p1 e p sono porte e l'oggetto è la stanza

        
        System.out.println("Ora uso l'overloading");
        
        Prodotto p2;
        p2= new Prodotto(44.3F,"2006-10-20","Un oggetto nuovo!");
        p2.stampaInfo();
        
        //System.out.println(Prodotto.contatore);
        Prodotto p3=p2.clona();
        
       // p3.setCodice(300);
        p2.stampaInfo();
        p3.stampaInfo();
        //non cambiano entrambi!!
        //System.out.println(Prodotto.contatore);
        
        p3=null; //p3 non punta più all'oggetto di prima, prima o poi il garbage collector libererà lo spazio 
        //annullare un riferimento permette a un oggetto di non essere più raggiungibile e di essere rimosso dal garbage collector
        
        //String è una classe ma la trattiamo come un tipo primitivo. Con la sintassi punto hai accesso a tutte le relatie operazioni
        
        
        
        //----

        //per gli attributi statici usa classe.varstatica
        //System.out.println(Prodotto.contatore);
        
    }
    
}
