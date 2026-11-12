/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.persone.eccezioni;

/**
 *
 * @author lucagreco
 */

// eccezione non controllata
public class VotoNonValidoException extends RuntimeException{

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
