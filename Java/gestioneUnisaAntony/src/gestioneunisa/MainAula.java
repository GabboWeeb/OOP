/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneunisa;
import it.unisa.diem.oop.persone.*;
import it.unisa.diem.oop.spazi.Aula;

/**
 *
 * @author Antonio
 */
import it.unisa.diem.oop.spazi.Accessibile;
import it.unisa.diem.oop.spazi.eccezioni.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MainAula {

    /**
     * @param args the command line arguments
     */
    
    
    //puoi fare  throws AccessibileVuotoException  sul metodo del main. Noi non vogliamo che il programma si arresti
    //non conviene rilanciare l'eccezione controllata sul main! A chi andrebbe? a nessuno e terina il programma
    public static void main(String[] args) {
        Accessibile a=new Aula("B",3); //Il limite delle classi astratte è solo per allocare spazio, ma non per dichiarare una variabile!!
        //anche l'interfaccia accessibile eredita da object!!
        
        try {
            a.esce();
            /*Anche qui ci sta un problema se sta da solo!!
                comunque questo è un blocco, puoi metterci quante istruzioni vuoi.
            Se un'eccezione scatta allora l'esecuzione passa al catch
            */
            a.entra(new Persona("Joe","Dalton","JDLTN")); //puoi aggiungere un nuovo blocco catch (come un else)
            
            
        } catch (AccessibileException ex )/*cattura SOLO le eccezioni di quel tipo, anche in or eventualmente, o con la gerarchia*/ {
            //AccessibileVuotoException | AccessibilePienoException ex
            /*Mettendo SOLO Exception controlli anche quelle Runtime, le controlli TUTTE*/
            //Logger.getLogger(MainAula.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Aula vuota!!!");
            System.err.println(ex);
        } /*catch (AccessibilePienoException ex) {  //comportamento diverso per ogni eccezione? Catch multipli (concatenati)
            //darebbe errore perché il primo che può raccogliere si prende tutto! Questo codice è irraggiungibile ma al contrario avrebbe senso!!
            Logger.getLogger(MainAula.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        //puoi mettere dentro al try-catch le istruzioni che non vuoi eseguire se l'eccezione salta!!
         
        //anche entra genera un'eccezione
        try{
            a.entra(new Studente("AmbroJoe","Dalton","MBRJD","061271891",20));
            a.entra(new Studente("Carlo","Rambaldi","CLRRMB","0612754515",25));
            a.entra(new Studente("SerJoe","Dalton","SRJDLTN","061274324",29));
            a.entra(new Docente("Dario","Fo","DF","12523682","Letteratura moderna"));
            a.entra(new Docente("Leo","Run Do","LRND","15626152","ASD"));
            a.entra(new Tecnico("Sandra","Mocini","SNDRLISR","12767681","DIEM"));
            //è un problema perché a è di tipo accessibile
            /*Se facciamo riferimento a un metodo di un'interfaccia dobbiamo 
                Non puoi sovrascrivere un metodo aumentando il numero di cose da lanciare. In caso contrario l'upcast sarebbe rotto 
            9:30 again
            La sottoclasse può eliminare le eccezioni, ma non aggiungerle. 
            
            .*/
            
            
        } catch (AccessibileException ex ){
            
        } finally{
            System.out.println("Sempre eseguito!");
            /*utile per rilasciare le risorse, chiudi sempre i file no? Che vada bene o male */
        }
        System.out.println(a);
        /* 1:39
        Accessibile prevede tutte le eccezioni e la sua sottoclasee solo una sottoclasse. è sicuro avere un
        L'upcast è sempre possibile
        Se a fosse accessibile allora non lo devi gestire
        Se a dosse classe allora lo devi lanciare
        non è possibile perché l'upcsast è sempre possibile.
        
        le eccezioni vengono analizzate a tempo di compilazione, sulla base delle reference e non delle cose referenziate
        */
        
        
        
        
        
        
        
    }
    
}
