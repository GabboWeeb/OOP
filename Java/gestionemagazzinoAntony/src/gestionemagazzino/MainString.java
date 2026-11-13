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
public class MainString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String p1= "Ciao";
        
        p1="Benvenuti";
        //questo crea un nuovo oggetto e sposta il riferimento di p1
        String p2 = new String("Ciao");
        
        String p3 = p1 + ";\n" + p2;
        
        //ma concatenare con + spreca memoria!!
        //ogni concatenazione genera un nuovo prodotto
        
        System.out.println(p3);
        
        Prodotto vp[]=new Prodotto[3];
        
        vp[0]=new Prodotto();
        vp[1]=new Prodotto();
        vp[2]=new Prodotto();
        String c="";
        for(int i=0;i<vp.length;i++){
            
            c+= vp[i].getDescrizione();
            
        }
        
        System.out.println("Risultato della concatenazione: " + c);
        //bello vero? concatenare in maniera iterativa consuma UN SACCO di memoria
        //tutti i prodotti intermedi consumano memoria e non sono utili (stringhe immutabili). Quidni usiamo una
        //classe che gestisce le stringhe ma non come elementi immutabili
        
        StringBuilder sb = new StringBuilder();
         for(int i=0;i<vp.length;i++){
            
            sb.append(vp[i].getDescrizione());
            
        }
        //il metodo che produce una stringa
        System.out.println("Risultato della concatenazione: " + sb.toString());
        
        //come confronti le stringhe? Non con == perché confronteresti i riferimenti associati ai nomi
        
        String s1="LELE";
        String s2="LELE"; //la JVM fa un magheggio, vede se esiste già quella stringa, in teoria dovrebbero essere riferimenti diversi
        //ma sarebbero riferimenti a oggetti immutabili uguali, poco efficiente tenerli separati no? String pull
        String s3= new String("LELE"); //non soggetto a string pull, funziona solo per la sintassi contratta
        if (s1==s2){//prova con s3
            System.out.println("Sono uguali i riferimenti, non ho controllato il contenuto però");
        }
        //usare == su stringhe non è una buona idea quindi. Serve un metodo che vale per TUTTI gli oggetti
        //Ecco qui equals()
        
        if (s1.equals(s2) & s2.equals(s3)){
        
            System.out.println(s1+" "+s2+ " "+s3+ " Contengono TUTTI la stessa cosa!");
            
        }
        //come vedi se i due prodotti sono uguali? Poi vediamo
        
        
    }
    
}
