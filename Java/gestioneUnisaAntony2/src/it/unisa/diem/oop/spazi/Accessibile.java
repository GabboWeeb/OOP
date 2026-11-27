/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.spazi;
import it.unisa.diem.oop.persone.Persona;
import it.unisa.diem.oop.spazi.eccezioni.*;
/**
 *
 * @author Antonio
 */

/*una bella collezione, un'astrazione comportamentale che forza le classi a implementare questa interfaccia*/
public interface Accessibile {
    //vogliamo riferirci a OGNI tipo di spazio
    /*un'interfaccia può essere implementata da una classe o estesa da altre interfacce generando una gerarchia
        ma non un albero, di interfacce
    le convenzioni sono identiche, l'unica coa che cambia è interface al posto di class
    
    */
    
    void entra(Persona p) throws AccessibileException ;//da implementare!!
    Persona esce() throws AccessibileVuotoException ;//metodi astratti, senza visibilità
    /*una raccolta di metodi intrinsecamente astratti che devono essere necessariamente ridefiniti*/
    
    
}
