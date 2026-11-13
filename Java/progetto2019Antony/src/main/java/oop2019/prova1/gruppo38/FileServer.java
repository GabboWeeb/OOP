/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2019.prova1.gruppo38;

/**
 *
 * @author Antonio
 */
public class FileServer extends NetworkDevice {
    
    @Override
    protected void process(int sourceAddress, String message){
        if (super.getConnection()==null){
            throw new NetworkException("Il server non è collegato a un dispositivo.");
        }
        System.out.println(toString()+ "Su richiesta di "+ sourceAddress + ": " + message);
        accept(super.getConnection(),this.getAddress(), sourceAddress, "Dati risposta: "+ message);    
    
    }
    
    @Override
    public String toString(){
        return super.toString()+" File Server"+ super.getAddress();
    }
    
}
