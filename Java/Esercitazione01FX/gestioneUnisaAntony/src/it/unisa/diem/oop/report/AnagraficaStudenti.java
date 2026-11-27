/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.report;

import it.unisa.diem.oop.persone.Studente;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio
 */
public class AnagraficaStudenti implements Serializable {
    private String descrizione;
    private Map<String,Studente> anagrafica;//non iterabili!!
    //per le chiavi usa sempre oggetti immmutabili!! 
    //Garantisci i requisiti di uguaglianza e confrontabilità. rendili final
    
    public AnagraficaStudenti (String descrizione){
        this.descrizione = descrizione;
        this.anagrafica = new TreeMap<>();
    }
    
    public void aggiungi (Studente s){
        //per inserire un elemento? Non esiste l'add, ma la put
        this.anagrafica.putIfAbsent(s.getMatricola(), s);
    }
    
    public void rimuovi (Studente s){
        this.anagrafica.remove(s.getMatricola());
    }
    
    public Studente cerca (String matricola){
        return this.anagrafica.get(matricola);//se la riicerca fallisce restituisce null senza eccezioni!!
    }    
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Anagrafica");
        
        //sb.append(this.descrizione+'\n'+this.anagrafica);
        //stampa qualcosa così
        /*
 AnagraficaIng Inf
{37298= ==== RUOLO: Studente ===== 
Nome:		Averell
Cognome:	Star
Codice Fiscale:	CF
Matricola:	37298
Voto Medio:	26.0
, 029837298= ==== RUOLO: Studente ===== 
Nome:		Joe
Cognome:	Star
Codice Fiscale:	CF3
Matricola:	029837298
Voto Medio:	23.0
, 0237298= ==== RUOLO: Studente ===== 
Nome:		William
Cognome:	Star
Codice Fiscale:	F3
Matricola:	0237298
Voto Medio:	24.0
}
        */
        //utili generatori di collezioni
        //anagrafica.keySet()
        //anagrafica.entrySet();
        
        for (Studente s: this.anagrafica.values()){ //non iterabile. i valori possono essere a loro volta collezioni
            //il registro delle presenze usa un Localdate come chiave e ogni elemento è una collezione degli studenti rilevati in quella data!!!
            sb.append(s);
        }
        return sb.toString();
    }
    
    //----18 11
    public void salvaDOS(String nomeFile) throws IOException{ //che serve solo al blocco finally
        FileOutputStream fos= null; 
        BufferedOutputStream bos = null; //nuovo decoratore
        DataOutputStream dos=null;
        //se vuoi decorare fos, FOS è troppo nudo così. Per ora non mettiamo il buffer ma solo l'interpretazione
        try {
            //throws FileNotFoundException (questa è un'opzione. Proa a gestirla però)
            fos= new FileOutputStream(nomeFile); //lancia FileNotFoundException
            bos = new BufferedOutputStream(fos); //nuovo decoratore (livello di bufferizzazione)
            dos= new DataOutputStream(bos);//livello di interpretazione
            //ora serve un protocollo di scrittura!
            dos.writeUTF(this.descrizione); //anche lui lancia un'eccezione IOException, superclasse di FileNotFoundException 
            
            for (Studente s : this.anagrafica.values() ){
                dos.writeUTF(s.getNome()); //mette lui i terminatori di stringa
                dos.writeUTF(s.getCognome());
                dos.writeUTF(s.getCodiceFiscale());
                dos.writeUTF(s.getMatricola());
                dos.writeUTF(s.getRuolo());
                dos.writeDouble(s.getVotoMedio());
            }
        } catch ( IOException ex) {
            Logger.getLogger(AnagraficaStudenti.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally{
            dos.close();//se è buffered la scrittura, senza close potrebbe non scrivere niente perché c'è un buffer in mezzo che aspetta proprio la close per il trasferimento
        }
        
    }
    
    public static AnagraficaStudenti leggiDIS (String nomeFile){
        //usiamo il try catch fatto appositamente per gli stream
        //non abbiamo il set della descrizione, la inizializziamo dopo o aggiungi un setDescrizione()
        AnagraficaStudenti a =null;
        
        //try con risorse + dichiarazione a cascata
        /*la decorazione più esterna è DIS, da arrichchire con una lettura bufferizzata*/
        try (DataInputStream dis=new DataInputStream(new BufferedInputStream(new FileInputStream(nomeFile)))){
            String descrizione = dis.readUTF();
            a= new AnagraficaStudenti(descrizione);
            
            while(true){
                String nome = dis.readUTF();
                String cognome = dis.readUTF();
                String codiceFiscale = dis.readUTF();
                String matricola = dis.readUTF();
                String ruolo = dis.readUTF();
                Double votoMedio = dis.readDouble();
                
                Studente s = new Studente (nome,cognome,codiceFiscale,matricola,votoMedio);
                a.aggiungi(s);
                //questa versione è ottimizzata, usi lo spazio solo per salvare gli attributi che vuoi rendere persistenti.
                //questo diventa un mal di testa se vuoi salvare una collezione, o riferimenti a... ecc.
                //in che ordine salvare le cose? Invece di preoccuparci, serializziamo l'oggetto (per INTERO)
            }
        
        } catch (EOFException e){
            System.out.println("Lettura terminata!");
        } catch (IOException ex) {
            Logger.getLogger(AnagraficaStudenti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return a;
        
    }
    
    //------
    /*Non titti gli oggetti sono serializzabili, devono implementare serializable, che è un'interfaccia di annotazione (senza niente dentro)
    Per serializzare dei sottotipi di un tipo non serializzabile ti serve che il supertipo abbia un costruttore senza parametri (penso)
    */
    
    public void salvaOBJ (String nomeFile) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomeFile)))){
            oos.writeObject(this);
        } catch (IOException ex) {
            Logger.getLogger(AnagraficaStudenti.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static AnagraficaStudenti leggiOBJ (String nomeFile){
        AnagraficaStudenti a=null;
        
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomeFile)))){
            a=(AnagraficaStudenti) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(AnagraficaStudenti.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnagraficaStudenti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return a;
    
    }
    
    
    public void salvaCSV(){
        /*di solito il nome di un CSV riga è la descrizione*/
        String nomefile = this.descrizione+".csv";
        try ( PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(nomefile)))){
            pw.println("NOME;COGNOME;CODICEFISCALE;MATRICOLA;VOTOMEDIO");//la prima riga sono le descrizioni colonne separate da ; tranne l'ultima
            for(Studente s : this.anagrafica.values()){
                pw.append(s.getNome()).append(';');
                pw.append(s.getCognome()).append(';');
                pw.append(s.getCodiceFiscale()).append(';');
                pw.append(s.getMatricola()).append(';');
                pw.println(s.getVotoMedio());
            }
        } catch (IOException ex) {
            Logger.getLogger(AnagraficaStudenti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public static AnagraficaStudenti leggiCSV(String nomefile){
        
        String descrizione = nomefile.split("\\.")[0]; //si prende il nome del file wtfffff (l'array è [descrizione, estensione])
        //. in una regex è un qualsiasi carattere!! non è un . carattere! Ma un solo \ non basta perché nelle stringhe il \ viene formattato come un carattere di escape che non arriva alla regex
        AnagraficaStudenti a=new AnagraficaStudenti(descrizione);
        try(BufferedReader br = new BufferedReader(new FileReader(nomefile))){
            //leggi il file riga per riga
            if(br.readLine()==null) return null; //se non ritorna null, consuma la prima riga, ottimo
            String linea = null;
            while((linea=br.readLine())!=null){
                String campi[]=linea.split(";"); //ottieni un array dei campi!! Tokenizzazione
                Studente s= new Studente (campi[0],campi[1],campi[2],campi[3],Double.parseDouble(campi[4]));//campi[4] non è una stringa. Wrappiamola
                a.aggiungi(s);
            }
        } catch (IOException ex) {
            Logger.getLogger(AnagraficaStudenti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    
    }
    
    
    public static AnagraficaStudenti leggiCSVScan(String nomefile){
        
        String descrizione = nomefile.split("\\.")[0]; //si prende il nome del file wtfffff (l'array è [descrizione, estensione])
        //. in una regex è un qualsiasi carattere!! non è un . carattere! Ma un solo \ non basta perché nelle stringhe il \ viene formattato come un carattere di escape che non arriva alla regex
        AnagraficaStudenti a=new AnagraficaStudenti(descrizione);
        try(Scanner s =new Scanner( new BufferedReader(new FileReader(nomefile)))){
            //setta delimintatori e localizzazione. Lo scanner è comodo ma toglie la compatibilità tra i tipi di file savati. 
            //Forse le tue fine riga sono \r\n, ma quelle di qualcun altro no
            s.useDelimiter("[;\\r\\n]+");
            s.useLocale(Locale.US);
            if (s.nextLine()== null) return null;
            while(s.hasNext()){//!! assumi che il csv sia ben formato e le colonne siano sempre le stesse per ogni riga, che non è detto
                String nome = s.next(); //dovresti fare l'if per tutti!
                String cognome = s.next();
                String codiceFiscale = s.next();
                String matricola = s.next();
                Double votoMedio = s.nextDouble(); //dovresti catchare le eccezioni, per la mancanza di un separatore (. o ,) e se magari non è un double
                
                Studente st = new Studente(nome,cognome,codiceFiscale,matricola,votoMedio);
                a.aggiungi(st);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AnagraficaStudenti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
    }
    
}
