/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.persone;

/**
 *
 * @author Antonio
 */
//T è un parametro che specificherai quando la implementi. Se non lo fai ci metto object
public interface Clonabile <T> {
    //gestiamo oggetti che possono essere clonati
    
    T clona();
    
    /*Vuoi estendere questa interfaccia anche ad altre classi? Non puoi perché qui sopra compare persona. Puoi mettere il tipo object!
    ed è quello che tipicamente si faceva (fai i controlli ogni volta e se tutto va a buon fine fai il downcast!). Ora esiste il parametro tipo
    
    
    SHALLOW COPY e DEEP COPY
    */
    
}
