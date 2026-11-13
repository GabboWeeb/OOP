/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.persone;

/**
 *
 * @author Antonio
 */
//import it.unisa.diem.oop.persone.Persona;

//genera errore con un costruttore non di default
public abstract class PersonaUnisa extends Persona{
    //abstract: puoi solo specializzarla in altre classi. Non è collegato ai metodi astratti
    //serve una sottoclasse che la concretizza (estende)
    //come la rendiamo figlia della classe persona? con extends, che vuole un costruttore vuoto nella superclasse
    
    private String matricola;
    
    public PersonaUnisa(String nome,String cognome,String codiceFiscale, String matricola){
        //vuoi invocare il costruttore della superclasse prima!!!
        super(nome,cognome,codiceFiscale);
        //questo step qui sopra è evitabile solo se la superclasse ha un costruttore senza parametri
        this.matricola=matricola;
    }
    
    
    public String getMatricola(){
        return this.matricola;
    }
    
    public void setMatricola (String matricola){
        this.matricola=matricola;
        //super.nome;// è visibile!!! anche in un altro package
    }
    
    
    //stai accedendo a tutti i metodi della superclasse con visibilità pubblica, default, protected
    @Override
    public String toString(){
        
        return " ==== RUOLO: "+ this.getRuolo()+ " ===== \n" + super.toString() + "Matricola:\t"+this.matricola;
        
    }
    //questo è un metodo concreto anche perché non ha lo spec. abstract
    /*sarebbe bello non poter istanziare direttamente una classe perché
    Questa classe è troppo generica. Dovremmo rendere questa classe una classe astratta!!
    Questa classe allora non sarebbe istanziabile se non attraverso un altro oggetto
    Una classe astratta POTREBBE stare in mezzo a due classi concrete, non devi per forza partire da classi solo astratte!!
    
    */
    
    //una classe astratta può contenere metodi astratti ma non per forza
    //fornisci parametri e tipo restituito MA non metti l'implementazione, guarda studente
    //questi metodi forzano le sottoclassi a implementare questo servizio usando un override
    public abstract String getRuolo();
    /*Pur essendo astratto questo metodo, sai cosa ritorna e lo puoi usare nei metodi della STESSA classe astratta*/
    
    
}
