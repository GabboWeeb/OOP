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
public abstract class NetworkDevice implements NetworkInterface{
    
    private static int format=1;
    private final int address;
    private NetworkInterface connection;
    
    public NetworkDevice(){
       this.address=format++;
       this.connection=null;
    }
    
    @Override
    public void accept(NetworkInterface sourceInterface, int sourceAddress,int destAddress, String message){
        if(destAddress!=this.address) return;
        process(sourceAddress, message);
        
    }
    
    @Override
    public void connect(NetworkInterface other){
        this.connection=other;
    }
    
    @Override
    public boolean equals(Object other){
        if(other==null) return false;
        if(other==this) return true;
        if(!(other instanceof NetworkDevice)) return false;
        NetworkDevice n= (NetworkDevice) other;
        return n.address==this.address;
    }
    
    public int getAddress(){
        return this.address;
    }
    public NetworkInterface getConnection(){
        return this.connection;
    }
    
    @Override
    public int hashCode(){
        return Integer.hashCode(this.address);
    }
    
    protected abstract void process(int sourceAddress, String message);
    
    @Override
    public String toString(){
        return "Device "+this.address;
    }
    
}
