/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionemagazzino;

/**
 *
 * @author Antonio
 */
public class Prodotto { //si antepone class!
    //spazio per
    //attributi, variabili d'istanza o campi
    //sarebbe bello nascondere lo stato dei campi e renderli accessibili solo alle nostre condizioni, 
    //solo se le modifiche sono accettabili
    
    //introduciamo il modificatore private, è buona norma
    //private impedisce di leggere o modificare dall'esterno
    
    //!!!il livello di visibilità di default NON coincide con il modificatore private
    
    //ma se è privato come leggi e scrivi? con i servizi offerti ai metodi
    //è buona pratica avere quasi tutto private e dei metodi di accesso appositi
    
    //è attaccato agli altri ma viene prima
    //Come inizializzi il contatore? o in linea, con poche static o con l'inizializzatore statico, guarda i metodi
    private static int contatore;//=1 //in corsivo!! è statico. Una var statica viene allocata ancora prima che un oggetto sia istanziato, prima di una NEW
    //meta-area: l'allocazione succede quando la CLASSE, non l'oggetto, viene messo in memora, con le info sulla strutttura e il codice bytecode dei metodi
    //ci sono anche i metadati e le variabili statiche 35:00
    //Java NON precarica le classi, ma carica l'oggetto se viene caricato nel codice
    //nell'heap ci sono solo gli attributi d'istanza 

    //FINAL= per le var di sola lettura, permette di verificare anche se fai cavolate nel codice, perché avrai errore se provi a fare assegnazioni
    //quindi ti bruci l'assegnazione col costruttore
    //tutti FINAL== oggetto IMMUTABILE, comodo per la concorrenza nel multithreading
    private final int codice;     //se lo inizializzi qui cambi i valori di default:  =43
    private String descrizione;
    private String dataDiProduzione;
    private float costo;
    
    
    private String tags[]; //un array di stringhe come attributo!!
    //c'è un array in mezzo: tra classe e elementi dell'array c'è aggregazione, tra classe e array c'è composizione
    private int riemp;
    public final int nTags=3;
    /*DUE SCELTE numero di tag fissati? Se no devi passare il numero a un costruttore
    Lo inizializzi sempre nel costruttore. Prendi il più geerico
    
    */
    
    
    
    
    //anche quando non richiesto, è buona pratica il private
    /* spazio per*/
    //metodi
    
    //ne serve innanzitutto uno che stampa i campi. Stampa info!
    //public = massima visibilità, puoi usarlo OVUNQUE, anche dove default non arriva
    public void stampaInfo () {
        //descrizione=null; QUESTO avrebbe avuto priorità su descrizione della classe
        System.out.println("---Prodotto---");
        System.out.print("Codice: ");
        System.out.println(codice);         //non serve il punto! sei dentro la classe!
        System.out.print("Costo: ");
        System.out.println(this.costo);
        System.out.print("Data di Produzione: ");
        System.out.println(this.dataDiProduzione);  //this non è necessario, ma aiuta per la leggibilità se vuoi
        System.out.print("Descrizione: ");
        System.out.println(descrizione);
        
        System.out.print("Tags: ");
       
        for (int i=0;i<riemp;i++){
            System.out.print(tags[i]+ " ");
        }
        System.out.println();
        
    }
    
    //puoi usare qualsiasi nome per scegliere come fornire e modificare i numeri, ma in generale si usano get e set
    //metodi get per ottenere delle info, anche non esplicitamente espressi un un campo (come per i num. complessi)
    //i get forniscono i valori dei campi o delle grandezze computate (deducibili dai campi)
    public int getCodice (){
        return codice;
    }    //getter!
    public String getDescrizione (){
        return descrizione;
    }
    public String getDataDiProduzione (){
        return dataDiProduzione;
    }
    public float getCosto (){
        return costo;
    }
    //non devi per forza fare le get per ogni campo
    
    //ma come li modifichi gli attributi? Usi i metodi setter, di solito sono dele procedure (void)
    
    //java raccomanda per un fatto di ordine di usare lo stesso nome di variabile
    //codice mette in ombra (shadowing) la variabile d'istanza. This accede a TUTTI gli attributi e i metodi perché stai dentro alla classe
    /*public void setCodice(int codice){ //due variabili codice? usi this. per riferirti all'istanza corrente dell'oggetto
        this.codice = codice;       //this è il segnaposto dell'oggetto che subirà questo metodo
                                    //qui dentro, con this, vedi TUTTO quello che la classe prodotto possiede        
                                    //in stampa info non c'è ambiguità quindi this non è servita
    }*/
    // se un campo è in sola lettura (immutabile) non scrivi il suo set. Il modificatore final rende i ampi modificabili UNA volta 
    //oppure usa il secondo costruttore e non mettere set
    public void setDescrzione(String descrizione){ 
        this.descrizione=descrizione;
    }
    //senza questo set potresti rendere qell'attributo di sola lettura. Il concetto è rafforzato dalla parola chiave final
    // un attrobuto final è assegnabile UNA sola volta
    public void setDataDiProduzione(String dataDiProduzione){ 
        this.dataDiProduzione=dataDiProduzione;
    }
    public void setCosto(float costo){ 
        this.costo=costo;
    }
    
    public void aggiungiTag (String tag){
        if(riemp== nTags){
            System.out.println("Errore!!! Non puoi aggiungere altri tag!!");
            return;
        }
        this.tags[riemp++]= tag;
    }
    
    //il costruttore Prodotto() c'è semore nelle classi, è un metodo particolare e restituisce il riferimento al nuovo oggetto prodotto
    //creato
    //facciamoci il nostro costruttore!!
    //il costruttore può NON essere unico!! e vale per tutti i metodi (overloading del metodo)
    //un costruttore senza parametri è analogo al costruttore di default, ma è esplicito
    public Prodotto(){
        this (-1,0.0F,"0000-00-00","Non disponibile");
        //this ->() è un costruttore della tua classe,
        //più leggibile di due costruttori distinti
        /*
        this.codice=-1;
        this.costo=0.0F;
        this.dataDiProduzione="0000-00-00";
        this.descrizione="Non disponibile";
       */
        
        
    }
    //il costruttore potrebbe inizializzare tutto con i parametri
    //OVERLOADING, più versioni dello stesso metodo che differiscono per tipo e numero di parametri.
    public Prodotto(int codice,float costo,String dataDiProduzione, String descrizione){  //basta che la firma sia diversa, i nomi NON contano
        //non usi il set per efficienza e perché con la final potresti NON avere le set
        //puoi modificare la var. statica nei costruttori (TUTTI)
        this.codice=contatore;
        this.costo=costo;
        this.dataDiProduzione=dataDiProduzione;
        this.descrizione=descrizione;
        this.tags= new String[this.nTags];
        contatore++;
        
    }
    
    
    //offriamo il servizio di duplicazione
    
    public Prodotto clona(){
        //puoi toggliere this.codice e ora incrementa il codice ogni volta
        return new Prodotto(this.costo, this.dataDiProduzione, this.descrizione);  //new restituisce il rif. a una nuova istanza di Prodotto
    
    }
    
    //un nuovo overloading per fornire un nuovo servizio: 3 int->stringa
    public void setDataDiProduzione(int anno, int mese, int giorno){
        // da fare con le future skill sulle stringhe
    }
    
    //con il get data come ottieni 3 interi invece di una stringa? sarebbe un'ottima cosa restituire un nuovo oggetto data!
    //esise una classe specifica, local date
    //facciamo restituire solo un int per ora
    //l'overloading NON funziona cambiando il tipo restituito!! Si caratterizza per il nome del metodo e dal tipo e numero di argomenti
    /*public int getDataDiProduzione(){
        
    }*/
    
    
            /*se io volessi contare quante istanze di Prodotto esistono? Usi un counter, oppure usi lo spazio statico. Puoi definire un attributo statico!
        le variabili d'istanza si contrappongono alle variabili di classe, variabili comuni a tutti gli oggetti della stessa classe
        */
    
    //un nuovo cotruttore senza codice
    public Prodotto (float costo,String dataDiProduzione, String descrizione){
        this(contatore,costo,dataDiProduzione,descrizione);
        //puoi usare il contatore come codice!!
    }
    
    //comunque non puoi associare una deallocazione a un deremento del contatore.
    
    
    //CONSIDERAZIONI
    //sarebbe meglio rendere privati anche gli attributi di classe
    
    
    public static int getContatore (){  //corsivo
        //il problema sta nel fatto che sarebbe bello averlo come metodo di classe, non di istanza, devi avere un0istanza dell'oggetto per poterlo richiamare
        //serve un metodo statico!!
        return contatore;
        
        //this.codice=1 //è un ERRORE! this indica un oggetto (istanziato) specifico, ma ha senso nel contesto dinamico, non in quello statico
        //quindi in un metodo d'istanza (dinamico) puoi accedere allo statico
        //ma nel metodo statico non ha senso accedere al dinamico a alle variabili di istanza 
    }
    
    //inizializzatore static!! eseguito quando il contatore viene inizializzato a 0
    //non c'è un analogo statico del costruttore
    static{
        contatore=0;
    }
    
    //esiste anche per le var di itanza in realtà, poco usato, HA PRECEDENZA SUL COSTRUTTORE, usalo se non dipende da nessun parametro
    //{
        //this.codice=1; //rompe le scatole al costruttore
    //}
    
    //l'ordine è sempre: inizializzatore di classe, di istanza, cotruttori
    
    //final riferito a degli attributi di istanza rafforza il concetto che un attributo non lo puoi modificare due volte
    //final su variabili statiche le rende delle costanti di compilazione. static final int codice DEVI inizializzarlo subito e 
    //a livello di efficienza viene assimilat a una costante di compilazione, lo sostituisce direttamente senza dover controllare in memoria
    //un analogo delle define
    
    
    //final con una var pubblica? Dall'esterno non la puoi modificare, ci puoi accedere in sola lettura, anche public final codice funziona bene
    //se la esponi direttamente non devi esporla con un metodo, che è meno efficiente,
    //MA public final codice viola l'incapsulamento (che è un problema non solo per le modifiche) che compromette la manutenibilità. 
    //Così esponi il tipo di codice, al sua forma di rappresentazione, magari codice non sarà sempre un int. con public final codice non puoi cambiare il tipo 
    // o la rappresentazione
    //incapsulamento: sicurezza dati, manutenibilità
    //rendilo subito accessibile SOLO se sei sicuro di poterla gestire sta roba
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //----------
    //inizio registrazione
    
    //una classe è utilizzabile anche prima che istanzi un progetto
    //ma hai accesso a metodi e attributi statici prima di generare un oggetto, già al caricamento della classe
    //puoi definire anche i metodi di classe
    
    
    
}
