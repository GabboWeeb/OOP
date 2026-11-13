/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.rimesse;
import it.unisa.diem.oop.veicoli.*;
import it.unisa.diem.oop.eccezioni.*;
/**
 *
 * @author Antonio
 */
// QUESTO FILE NON VA MODIFICATO

public class TestRimessa {

    public static void main(String[] args) {
        Autorimessa autorimessa = new Autorimessa(5, "Parcheggio E1");
        try{
            try{
                autorimessa.entra(new Camion("sdf244", "Fiat CX45", "Gasolio", "TT656671", 4));
            }catch (TargaNonValidaException ex) {
                System.out.println(ex);
            }
            try{
               autorimessa.entra(new Camion("spl265", "Volvo PTG", "Gasolio", "YH96671", 6));
            }catch (TargaNonValidaException ex) {
                System.out.println(ex);
            }
            try{
                autorimessa.entra(new Autovettura("mk23t", "Fiat Punto", "Metano", "EA566FM", 5));
            }catch (TargaNonValidaException ex) {
                System.out.println(ex.getMessage());
            }
            try{
               autorimessa.entra(new Autovettura("cgt612", "Fiat Idea", "Gasolio", "AQ9Y7UUU", 5));
            }catch (TargaNonValidaException ex) {
                System.out.println(ex.getMessage());
            }
            try{
                autorimessa.entra(new Moto("das7896", "Honda Hornet", "Benzina", "AT51233", false));
            }catch (TargaNonValidaException ex) {
                System.out.println(ex.getMessage());
            }
            try{
                autorimessa.entra(new Moto("gdt7896", "Suzuki Bandit", "Benzina", "AT5123N", false));
            }catch (TargaNonValidaException ex) {
                System.out.println(ex.getMessage());
            }
            
            
        
        }  catch (AutorimessaPienaException ex) {
            System.out.println(ex.getMessage());
        } finally{ //utile per deallocare le risorse, qualcosa che fai in ogni caso (chiudi sempre lo stream ad esempio)
            System.out.println(autorimessa);
        }
        /*Se avessi fatto il catch su BoxException, fare ex.getMessage avrebbe dato il risultato giusto perché il metodo
            è polimorfico. Ex chiama il getMessage in maniera polimorfica. Il dinamic binding recupera il metodo giusto
        */
        
            
            
           
            

        
        

    }

}
