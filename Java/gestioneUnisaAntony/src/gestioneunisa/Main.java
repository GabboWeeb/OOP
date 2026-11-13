/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneunisa;

//import it.unisa.diem.oop.persone.PersonaUnisa;
//import it.unisa.diem.oop.persone.Persona;
import it.unisa.diem.oop.persone.*;
import static javafx.application.Platform.exit;
/**
 *
 * @author Antonio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persona p= new Persona("Antonio","Borriello","BRRNTN...");
//        Persona p2= new Studente("Carletto","Borriello","BRRNTN...","124567",28);
//        Studente s2=(Studente)p;
//        
//        System.out.println(p2);
//        System.out.println("\n\n\nJNSKJNAJ\n\n\n");
        //tutte le classi ereditano dalla classe object
        
        
       // exit();
        System.out.println(p.toString());//output: it.unisa.diem.oop.persone.Persona@4f2410ac
        /*Questa rappresentazione ti dà il nome completo della classe, completo del package
        La classe persona è identificata univocamente da tutto il package... 36:00
        + una @ e la rappresentazione esadecimale del codice hash dell'oggetto
        
        dovremmo ridefinire u metodo che già esiste nella superclasse
        */
        
        //anche questo chiama la to_string
        //System.out.println(p);
        
        /*PersonaUnisa pa= new PersonaUnisa("Antonio","Borriello","BRRNTN...","06127...");//non è più istanziabile perché astratta!!
        System.out.println("\nOra stampo una classe figlia:");
        System.out.println(pa.toString());*/
        
        /*il nome s ti permette di accedere ai metodi pubblici della classe. Con una gerarchia di questo tipo
         *
        */
        Studente s = new Studente("Antonio","Borriello","BRRNTN...","06127...",28.75);
        System.out.println("\nOra stampo una classe figlia della precedente:");
        System.out.println(s.toString());
        
        Docente d= new Docente("Leo","Run Do","A-U-R-A","1234..","Java"); //se iniziasse con Persona o anche PersonaUnisa, anche se è astratto!!!!
        System.out.println(d.toString());
        //Docente d1=d; // non funziona perché comunque sono tipi diversi. Java non è sicuro a tempo di compilazione che si può fare
        //il downcast si può fare con un cast esplicito
        //Docente d1 = (Docente) d;
        //questo funziona, ma puoi forzare QUALSIASI COSA, quindi anche una vera var persona in docente
        
        /*Come fai a essere sicuro se un nome è istanza di una certa classe o no? Seerve per il downcast, l'upcast funziona sempre*/
        
        Tecnico t= new Tecnico ("Ins","Erviente","InsjsIOAJSI","152437","DIEM");
        System.out.println(t.toString());
        
        /*Questo è un upcast, è un'operazione di casting sicura e implicita che permette
        assegni
        l'oggetto
        
        Object oppure Persona vanno bene
        
        */
        Persona strange = new Studente("Antonio","Borriello","BRRNTN...","WTF...",28.75);
        //ora però non vedi lo spazio dei metodi della classe specifica, ma quella della
        System.out.println(strange.toString());
        /*Il metodo, pur avendo lo stesso nome,
        La scelta del codice da eseguire viene fatta a livello dinamico
        strnge è di tipo persona me referenzia un oggetto di tipo studente
        Hai perso getRuolo() ma la to string resta specializzata
        
        Se sai che tipo di oggetto è PUOI FARE IL DOWNCAST!!!
        
        */
        
        System.out.println("--------ARRAY--------");
        
        //facciamo un array di persone allora!!
        PersonaUnisa persone[]= new PersonaUnisa[4];
        //persone[0]=p;
        persone[1]=s;
        persone[2]=d;
        persone[3]=t;
        
        //for each?
        for (int i=1; i<persone.length;i++){
            //System.out.println(persone[i].toString()); //la versione specializzata funziona per tutti!! W O W
            System.out.println(persone[i].getRuolo());
            if (persone[i] instanceof Studente){ //downcast sicuro! //avrebbe restituito true anche per instanceof Persona
                Studente s1=(Studente) persone[i];
                System.out.println("Portetto da privacy: "+ s1.getRuolo());
            }
            //HANNO UNA DIFFERENZA, ma per ora sono equivalenti
            if (persone[i].getClass()== Docente.class){     //avrebbe restituito false per Persona.class
                Docente d1= (Docente)persone[i];
                System.out.println("Il docente insegna "+ d1.getInsegnamento());
            }
            
        }
        
        
        
        
    }
    
}
