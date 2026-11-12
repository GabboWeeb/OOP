/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.persone.eccezioni;

/**
 *
 * @author Antonio
 */

//fallo finire in exception e un nome rappresentativo
public class VotoNonValidoException extends RuntimeException{
    //manca l'extend attenzione!! controllata -estende> exception (e servono i catch!!); non controllata -estende> Runtime exception
    //non obbliga i try catch!! Ma essendo non controllata se la spammi rischi di arrestare il processo per ogni cosa storta che succede

    /**
     * Creates a new instance of <code>VotoNonValidoException</code> without
     * detail message.
     */
    public VotoNonValidoException() {
    }

    /**
     * Constructs an instance of <code>VotoNonValidoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public VotoNonValidoException(String msg) {
        super(msg);
    }
}
