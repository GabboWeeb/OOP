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
public  class Creanda implements InterfacciaMadre {
    
    protected  int numero=3;
    
    {numero=4;}
    public Creanda (int numero){
        this.numero=numero;
    }
    
    public static void vuoto (Object o){
        Creanda c = new Creanda(3);
        System.out.println("Ho preso un'interfaccia");
        return;
    }
    
    @Override
    public void metodoStretto(String a){
    }
    
    @Override
    public void metodo(){
    
    }
    
    public int getNumero () throws IllegalArgumentException{
        return this.numero;
        //throw new IllegalArgumentException("Not supported yet.");
        //return this.numero;
    }
    public Exception metodoEccetto(){
        return null;
    }
    
    public int metodoInt(InterfacciaMadre m){
        return 3;
    }
    
    public void metodoStupido (String s){
        if(s instanceof String){
            return;
        } else{
            System.out.println("222");
            
        }
        int a=2;
        
    
    }
    
    @Override
    public String toString (){
        return "AAAAA";
    }
    
    public void stringaMetodo(){
        System.out.println( toString());
    }
    
}
