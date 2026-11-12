/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provepreintercorso;

/**
 *
 * @author Antonio
 */
public interface InterfacciaMadre{
    static void metodoStatico(){
        System.out.println("Ciao");
    }
    
    void metodoStretto(String a);
    void metodo();
    
}
