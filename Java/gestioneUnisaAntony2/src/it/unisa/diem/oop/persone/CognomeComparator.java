/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.persone;
import java.util.Comparator;
/**
 *
 * @author Antonio
 */
public class CognomeComparator implements Comparator<Persona>{
    
    @Override//meglio usare le compare to degli oggetti. Con gli interi fai la differenza. Ma con i double meglio di no
    public int compare (Persona o1, Persona o2){
        //buono ma fallisce per i cognomi uguali
        //return o1.getCognome().compareTo(o2.getCognome());
        //nel caso di pareggio deve valere l'ordine naturale!!
        if (o1.getCognome().equals(o2.getCognome())){
            return o1.compareTo(o2);
        }
        
        //Double.compare(double1,double2);

        return o1.getCognome().compareTo(o2.getCognome());
        
        
    }
    /*Le classi wrapper sono comode per confrontare i double*/
    
}
