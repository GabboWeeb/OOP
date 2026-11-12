/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provepreintercorso;
import java.util.*;
/**
 *
 * @author Antonio
 */
public class Delenda {
    
    private final int num;
    
    public Delenda (Creanda a){
        
        this.num=a.getNumero();
        a=null;
    }
    
    public static NullPointerException vuoto (Object o) throws Exception{
        Creanda c = new Creanda(3);
        System.out.println("Sono in delenda");
        return null;
    }
    
    public int getNum () {
        ArrayList al= new ArrayList<Delenda>();
        return this.num;
    }
    
    public int metodoEccezioneNC(int q)throws NullPointerException{
        if(q==0)
            throw new NullPointerException("Ciao");
        return 3;
    }
    
}
