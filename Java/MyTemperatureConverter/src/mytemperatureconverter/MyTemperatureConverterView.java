package mytemperatureconverter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leonardorundo
 */

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MyTemperatureConverterView extends VBox {
    
    //Tutti gli attributi sono public per poter essere ereditati dal controller, se privati implementare i get
    
    //Label Con la scritta "Celsius to Fahr" o "Fahr to Celsius"
    public final Label lblMode;
    
    //TextField di input
    public final TextField txtInput;
    
    //Label con la scritta "Result:" (costante) e il risultato numerico
    public final Label lblResult;
    
    //CheckBox che inverte il comportamento del lblMode, txtInput e lblResult.
    //Per lblMode scambia una StringProperty con un'altra StringProperty costante tramite il metodo bindInvertToMode()
    //Il txtInput viene "legato" (binding) legato tramite la textProperty a celsiusString o FahrString, 
    //  in caso di eventi sul checkBox, si slega da uno e passa all'altra StringProperty tramite il metodo bindInputToConversion()
    //Per lblResult tramite il metodo bindCelsiusWithFahr effettuiamo un bindBidirectional che ci permette di
    //  "controllare" i legami in maniera bidirezionale permettendoci di passare da un comportamento all'altro grazie all'uso
    //  di due StringProperty e uno StringConverter (astratto) che ci permette di implementare due metodi per decidere quali calcoli fare.
    public final CheckBox chkInvert;

    public MyTemperatureConverterView() {
        
        //serve per caricare il costruttore di VBox dato che tutti i blocchi della scena sono inseriti verticalmente.
        super();
        
        //Setto uno spaziamento degli elementi inseriti nel nostro VBox (root) di 10.
        this.setSpacing(10);
        //Setto la posizione (centrale) degli elementi inseriti nel nostro VBox (root);
        this.setAlignment(Pos.CENTER);

        //Creo l'oggetto Label associato.
        this.lblMode = new Label();
        //this.getChildren() ci permette di "richiedere" tutti gli elementi (children) associati al VBox.
        //  Questo ci permette di usare il metodo add per l'aggiunta del label. 
        this.getChildren().add(lblMode);
        
        //Creo un oggetto HBox che ci permette di disporre i blocchi inseriti all'interno dell'HBox orizzontalmente
        HBox hBoxInput = new HBox();
        //Same of 46
        hBoxInput.setSpacing(10);
        //Same of 48
        hBoxInput.setAlignment(Pos.CENTER);
        //Aggiunto all'HBox un nuovo label senza associargli un riferimento dato che non serve controllarlo tramite controller.
        hBoxInput.getChildren().add(new Label("Input:"));
        //Creo l'oggetto TextField associato.
        this.txtInput = new TextField();
        //Lo aggiungo all HBox.
        hBoxInput.getChildren().add(txtInput);
        //Aggiungo l'HBox alla root (VBox)
        this.getChildren().add(hBoxInput);
        /*
            P.S. Avrei ache potuto fare:
            
            //Creazione degli oggetti che mi servono (L'ordine non è importante, l'aggiunta si)
            HBox hBoxInput = new HBox();
            hBoxInput.setSpacing(10);
            hBoxInput.setAlignment(Pos.CENTER);
            
            this.txtInput = new TextField();
            
            //addAll è un metodo che può essere utilizzato sui children dell'elemento che ci permette di aggiungere
            //  più elementi con l'ordine di aggiunta al metodo.
            hBoxInput.getChildren().addAll(new Label("Input:"),txtInput);
        
            this.getChildren().add(hBoxInput);
        */
        
        //Same
        HBox hBoxResult = new HBox();
        hBoxResult.setSpacing(10);
        hBoxResult.setAlignment(Pos.CENTER);
        
        //Vale lo stesso discorso di sopra.
        hBoxResult.getChildren().add(new Label("Result:"));
        this.lblResult = new Label();
        hBoxResult.getChildren().add(lblResult);
        this.getChildren().add(hBoxResult);
        
        //Creo l'oggetto CheckBox
        this.chkInvert = new CheckBox("<--->");
        this.getChildren().add(chkInvert);
    }


    
}
