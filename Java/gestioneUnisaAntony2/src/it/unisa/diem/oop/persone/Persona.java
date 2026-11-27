/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.persone;

import java.io.Serializable;

/**
 *
 * @author Antonio
 */
//metti gli stessi tipi parametrici!! non mettere il criterio che usi.
public class Persona implements Clonabile<Persona>, Comparable<Persona>,Serializable{
    //si parte sempre da sopra! Dall'alto
    //TUTTE LE CALSSI ereditano dalla classe object dei metodi pubblici. SEMPRE
    
    private String nome;    //col default questo sarebbe default. Lo vede chi è nello stesso pacchetto
    /*Con protected anche la classe che estende lo vede, anche fuori dal package, ma non il main
    Altre classi nello stesso pacchetto vedono comunque. Quindi private- default-protected-public
    */
    private String cognome;
    private String codiceFiscale;
    
    
    //public Persona(){}
    
    public Persona(String nome,String cognome,String codiceFiscale){
        this.nome=nome;
        this.cognome=cognome;
        this.codiceFiscale=codiceFiscale;
    }
    
    
    public String getNome(){
        return this.nome;
    }
    public String getCognome(){
        return this.cognome;
    }
    public String getCodiceFiscale(){
        return this.codiceFiscale;
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }
    public void setCognome(String cognome){
        this.cognome=cognome;
    }
    public void setCodiceFiscale(String codiceFiscale){
        this.codiceFiscale=codiceFiscale;
    }
    
   
    /*
    L'annotazione aiuta il compilatore a verificare se la firma del metodo esiste nella superclasse.
    è una cosa opzionale certo, ma la devi mettere per un fatto di ordine, leggibilità e precauzione
    */
    @Override   //questa è un'annotazione marcatrice java
    public String toString(){
        return "Nome:\t\t"+ nome + "\nCognome:\t" + cognome + "\nCodice Fiscale:\t" + codiceFiscale+"\n";
     //gli overraide sono leciti su qualsiasi suerclasse   
    }
    
    //stampa info ti serve per fare cose particolari MA se scrivi tutto in formato stringa sovrascrivi una toString
    
    /*Sovrascriviamo equals. Diciamo che due persone sono uguali se hanno lo stesso codice fiscale. Perché questo attributo
        è univoco per ogni oggetto. Se non lo tieni devi controllare TUTTO
    */
    @Override
    public final boolean equals(Object obj){
        /*Non puoi passare persona! Chi ti ha detto che stai confrontando le persone? */
        //verifica i due casi degeneri
        if (obj==null)
            return false;
        if (this==obj)
            return true;
        //potresti usare instance of, ma NON sarebbe simmetrica. Questa implementazione qua è supportata dalla documentazione
        if (this.getClass()!=obj.getClass())//restituisce un oggetto, quindi != non si potrebbe fare
             return false;
            /*il metodo get class permette di accedere alla struttura di una classe, che è unica e ha un riferimento, quindi la puoi controllare*/
            /*Se per le tue esigenze vuoi farlo fallo. Ma se poi la vuoi specializzare è meglio che maniteni la simmetria ora. Se non
                lo vuoi sovrascrivere metti final al metodo*/
        //if (!(obj instanceof Persona))//anche studente è istanza di persona!
            /*non è la prassi instanceof!*/
           
        //SERVE IL DOWNCAST!
        Persona p=(Persona) obj;
        
        
        //con le stringhe non funziona ==. Quindi devi fare
        return this.codiceFiscale.equals(p.codiceFiscale); //eventualmente aggiungi delle &
    }
    
        //OVERRIDE DELL'HASH CODE in combo con l'equals
    
//     @Override
//    public int hashCode(){
//        //cosa che normalmente vuoi fare, così se la stringa non è allocata non fai casino
//        return this.codiceFiscale==null?0:this.codiceFiscale.hashCode();
//        /*e se l'hash code dipende da più parametri?? Fai moltiplicazioni e addizioni successive*/
//        
//        
//    }  
    
    @Override
    public int hashCode(){
        int result=17;//non troppo grande!
        result= 31* result+ this.nome.hashCode();//poi 31 è uno meno una potenza di 2
        result= 31* result+ this.codiceFiscale.hashCode();
        //l'ordine pure ha un peso!
        return result;
    }

//    @Override
//    public Persona clona() {
//        return null;
//    }

    @Override
    public Persona clona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override //qui CI VUOLE PERSONA, non Object
    public int compareTo(Persona o) {
        //confronto lessicografico dei CF. Richiama le compare to degli oggetti che già esistono
        //EZ! Questo è come si fa l'ordine naturale
        return this.codiceFiscale.compareTo(o.codiceFiscale);
        
    }
    

    
}
