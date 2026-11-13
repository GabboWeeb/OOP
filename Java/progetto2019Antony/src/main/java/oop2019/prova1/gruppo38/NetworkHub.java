/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2019.prova1.gruppo38;
import java.util.*;
/**
 *
 * @author Antonio
 */
public class NetworkHub implements NetworkInterface{
    
    private final String id;
    private final Set<NetworkInterface> connessioni;
    
    public NetworkHub(String id){
        this.id=id;
        this.connessioni=new HashSet<>();
    }
    
    public String getId(){
        return this.id;
    }
    
    @Override
    public void accept(NetworkInterface sourceInterface, int sourceAddress, int destAddress, String message){
        for (NetworkInterface c: this.connessioni){
            if(! sourceInterface.equals(c)){
                System.out.println("Hub "+ id+": da "+ sourceAddress + " via "+ sourceInterface + " per "+ destAddress+": " + message + '\n');
                c.accept(this,sourceAddress,destAddress,message);
            }
        }
    }
    
    @Override
    public void connect(NetworkInterface other){
        this.connessioni.add(other);
    }
    
    @Override
    public boolean equals(Object other){
        if(other==null) return false;
        if(other==this) return true;
        if(other.getClass()!=this.getClass()) return false;
        NetworkHub n= (NetworkHub) other;
        return n.id.equals(this.id);
    }
    
    
    @Override
    public int hashCode(){
        return this.id==null? 0 : this.id.hashCode();
    }
    
    public void printConnections(){
        System.out.println("\nConnessioni di: " + this.toString());
        for(NetworkInterface n: this.connessioni){
            System.out.println( n.toString());
        }
    }
    
    public String toString(){
        return "Hub" + this.id;
    }
    
}
