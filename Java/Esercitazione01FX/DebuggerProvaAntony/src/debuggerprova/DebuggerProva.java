/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package debuggerprova;

/**
 *
 * @author Antonio
 */
public class DebuggerProva {

    static int factorial(long n){
        int f=1;
        
        for(int i=1;i<=n;i++)
            f*=i;
        return f;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long n=20;
//        int f=factorial(n);
        System.out.println(factorial(n));
    }
    
}
