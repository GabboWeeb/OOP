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
public class MainArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Hello world!\n(In un nuovo Main!)");
        
        //introducing un nuovo oggetto, gli array!
        //le [] non specificano la grandezza del'array!!
        int v[];
        v= new int[2]; //un costruttore!!
        //sono state allocate due oggetti di tipo intero settati a 0
        
        
        
        for (int i=0;i<v.length;i++){   //c'è un attributo pubblico, leggibile ma non modificabile (final)
            System.out.println(v[i]); //tutti a 0, anche se sfori dal limiti
            //se sfori e accedi fuori dal range viene sollevata un'eccezione
        }
                
        System.out.println("-------");
        //l'array NON è una collezione dinamica, se vuooi aggiungere altro
        //la collezione è anche attraversabile col costrutto for each
        for (int a:v){
            System.out.println(a);
        }
        //poco utile perché spesso non vuoi visualizzarlo tutto, ma solo alcuni elementi dell'array
        
        System.out.println("---Array di prodotti---");
        
        Prodotto vp[];
        vp= new Prodotto[3];
        for(int i=0;i<vp.length;i++){
            System.out.println(vp[i]);//System.out.println(vp[i].getDescrizione);
        }
        //l'array è un oggetto, abbiamo allocato tre attibuti, tre riferimenti, questo stapa 3 riferimenti 
        //i riferimenti esistono, ma non puntano a nulla :0
        //quindi ora o li tieni già e li colleghi o li costruisci oggi
        
        Prodotto p= new Prodotto();
        vp[0]=p;
        vp[1]=new Prodotto();
        vp[2]=new Prodotto();
        
         for(int i=0;i<vp.length;i++){
            System.out.println(vp[i].getCodice());//System.out.println(vp[i].getDescrizione);
        }
        //quini l'array di oggetti contiene solo i riferienti ad altri oggetti, quello di interi contneva gli interi. 
        //cancellare l'array non cancella gli oggetti puntati
        
        
        
        
        
        
        
        
        
    }
    
}
