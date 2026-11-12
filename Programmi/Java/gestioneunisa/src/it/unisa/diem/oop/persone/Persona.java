/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.persone;

/**
 *
 * @author lucagreco
 */
public class Persona {
    
    
    private String nome;
    private String cognome;
    private String codiceFiscale;
    
    
    
    
 //   public Persona() {}
    
    public Persona(String nome, String cognome, String codiceFiscale) {
    
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
    
    
    }
    
    
    public String getNome() {
    
        return nome;
    
    }
    
    public String getCognome() {
    
        return cognome;
    
    }
    
    public String getCodiceFiscale() {
    
        return codiceFiscale;
    }
    
    
    public void setNome(String nome) {
    
    
        this.nome = nome;
    }
    
    public void setCognome(String cognome) {
    
        this.cognome = cognome;
    
    }
    
    
    public void setCodiceFiscale(String codiceFiscale) {
    
        this.codiceFiscale = codiceFiscale;
    
    }
    
    @Override
    public String toString() {
    
        
    
        return "Nome: " + nome + '\n' + "Cognome:" + cognome + '\n' + "Codice Fiscale:" + codiceFiscale + '\n' ;
    
    }
    
}
