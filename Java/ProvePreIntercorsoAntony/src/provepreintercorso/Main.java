/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provepreintercorso;
import java.util.*;
import static provepreintercorso.Delenda.*;
import static provepreintercorso.Creanda.*;
/**
 *
 * @author Antonio
 */
public class Main extends Object  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NullPointerException {
        // TODO code application logic here
        
//        Creanda a=new Creanda (22);
//        System.out.println(a.getNumero());
//        
//        Delenda d= new Delenda (a);
//        System.out.println(d.getNum());
//        System.out.println(a.getNumero());
//        String s=null;
//        s.toString();
//          List<Integer> list=new ArrayList<>();

//        Double d= new Double(8.33333);
//        Double d6= new Double(4.0);
//        
//        System.out.println((new Double(5)).compareTo(new Double(4.9)));
        
//        System.out.println(Double.compare(14.550, 14.55));
//        
//        List<String> l= new ArrayList<>();
//        l.add("ciao");
//        l.add(null);
//        //l.add('a');
//        
//        InterfacciaMadre interf=null;
//        Creanda.vuoto(interf);
//        int i=0,j=0;

//        Delenda d = new Delenda(new Creanda(5));
//        
//        d.metodoEccezioneNC(0);
//
//
//        List l= new ArrayList();
//        l.add("1");
//        l.add('2');
//        l.add(3);
        
//         ore

        // Delenda.vuoto(null);
        
        List l= new ArrayList();
        List l2= new ArrayList<>();
        List<Object> l3= new ArrayList<>();
        List<Object> l4= new ArrayList();
//        List<int> l5= new ArrayList<>();
        List<Integer> l5= new ArrayList<>();//std
        List<Integer> l6= new ArrayList();
//        List<Object> l7= new ArrayList<String>();
        List l7= new ArrayList<String>();
//       List<> l7= new ArrayList();
        
        
        
        l.add(null);
        l.add(3);
        l.add('c');
        l.add("Sese");
        l.add("1");
        l.add("1");
        l.add(new Double(3));
        l.add(new NullPointerException());
        
        //Delenda.vuoto(null);

        System.out.println(new Double(3.4));
        System.out.println(l);
        Creanda c= new Creanda(1);
        c.stringaMetodo();
        System.out.println(c.getNumero());
        
        Creanda.vuoto(2);
        
        
    }
    
}
