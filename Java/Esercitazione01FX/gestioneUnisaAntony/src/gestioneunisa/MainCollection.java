/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneunisa;

import it.unisa.diem.oop.persone.Persona;
import it.unisa.diem.oop.persone.Studente;

import it.unisa.diem.oop.persone.CognomeComparator;
import java.util.*;
import java.util.List;
/**
 *
 * @author Antonio
 */
public class MainCollection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persona p1= new Persona ("Joe","Dalton","CF2");
        Persona p2= new Persona ("Joe","Dalton","CF1");
        boolean test =p1.equals(p2); //troppo discriminante se non sovrascritto!

        Studente s= new Studente ("Joe","Star","CF3","029837298",23);
        test=p1.equals(s);
        System.out.println(test);
        
        List<Persona>  c;//non basta, collection non è concreta
        //interfaccia a sx e il tipo concreto a dx. Di solito le implementazioni hanno più metodi delle interfacce
        /*Linked list contiene i metodi di una coda. mettere l'interfaccia a sx è più leggibile. Con LL non hai i metodi per accedere all'i-mo elemento
        Con List=LL puoi farlo. Cosa puoi fare? guarda l'interfaccia. Come lo fai lo fa l'implementazione.Per una stessa interfaccia ogni gerarchia funziona!!
        */
        c=new LinkedList<>();//sarebbe ripetitivo mettere di nuovo persona (type inference)
        c.add(p1);
        c.add(p2);
        c.add(s);//upcast, va bene!
        System.out.println(c); //[p1,p2,s]
        
        //attraversamento?
        for(Persona p:c){
            System.out.println(p.getNome());
        }
        
        Persona p6=null;
        //oppure ottieni un iteratore
        Iterator<Persona> it=c.iterator();
        while (it.hasNext()){
            Persona p3=it.next();
            System.out.println(p3.getCognome());
            
            if(p3.getCognome().equals("KILL")){
                //it.remove();//il migliore! cancella quello che dici tu!
                //c.remove(p3);//non ideale
                /*Non funziona perché l'oggetto da distruggere ha lo stesso codice fiscale degli altri!!
                    Eventualmente puoi salvarti in una variabile locale l'oggetto incriminato
                */
                p6=p3;
            }
                    
        }
        //lo elimini fuori!!
        c.remove(p6);//comunque non funzione per il CF!
        System.out.println(c);
        System.out.println("\n\n =====SEaTh il senzascaglie ===== \n\n");
        
        
        
        
        Set<Persona> sp;
        sp= new HashSet<>();
        
        sp.add(p1);
        sp.add(p2);
        sp.add(s);
        
        System.out.println(sp);
        
        System.out.println("\n\n =====il TREEsSETte===== \n\n");
        //si affida SOLO alla compare to, non all'equals. Quindi devi fare tutto coerente così imlementazioni 
        //diverse rappresentano gli oggetti allo stesso modo (nelle stesse quantità)
        Set<Persona> sp1;
        
        sp1=new TreeSet<>();
        sp1.add(p1);
        sp1.add(p2);
        sp1.add(s);
        
        System.out.println(sp1);
        System.out.println("\n\n =====il TREEsSETte COMPARATOR===== \n\n");
        
        Set<Persona> sp2;
        //usiamo un nuovo costruttore, che accetta i parametri, l'oggetto comparatore
        
        sp2=new TreeSet<>(new CognomeComparator());
        sp2.add(p1);
        sp2.add(p2);
        sp2.add(s);
        //MA cognomi uguali non vengono inseriti, anche se sono due persone! Non bene
        System.out.println(sp2);
                
                
        
    }
    
}
