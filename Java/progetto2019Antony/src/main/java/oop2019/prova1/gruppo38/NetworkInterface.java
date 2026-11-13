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
public interface NetworkInterface {
 
    
    void accept(NetworkInterface sourceInterface, int sourceAddress, int destAddress, String message);
    
    void connect(NetworkInterface other);
    
}
