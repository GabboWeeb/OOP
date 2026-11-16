/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytemperatureconverter;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

/**
 *
 * @author leonardorundo
 */
public final class MyTemperatureConverterController {
    
    //Mi serve un attributo della classe controller che mantenga il riferimento della view visualizzata per
    //  utilizzare i metodi del controller sulla view.
    private final MyTemperatureConverterView view;
    
    // Attributi di tipo StringProperty che modellano lo stato interno dell'applicazione
    // in termini di valori correnti di temperatura in Celsius e Fahrenheit
    // (coerentemente con la modalità operativa della GUI)
    
    //Detto in altre parole, ne bastava una che faceva entrambi i comportamenti, ma così facendo è
    //  più semplice da gestire e da visionare. Definisce una distinzione chiara sia per la rappresentazione
    //  nella GUI che del controller.
    private final StringProperty celsiusString;
    private final StringProperty fahrString;

    public MyTemperatureConverterController(MyTemperatureConverterView view) {
        this.view = view;
        
        //Qui bisogna usare l'oggetto concreto, non l'interfaccia (Simple)
        //Entrambe al loro interno hanno un "testo" vuoto
        this.celsiusString = new SimpleStringProperty("");
        this.fahrString = new SimpleStringProperty("");
        
        // 1. Versione con StringConverter personalizzato
        //L'ordine di questi metodi non è importante.
        
        //bindCelsiusWithFahr() crea un legame bidirezionale tra celsiusString e fahrString in modo da passare
        //  da una SimpleStringProperty all'altra ogni volta che una delle due viene "legata" (e l'altra slegata) o viceversa.
        //Nei parametri oltre le due property (caratteristiche osservabili) dobbiamo aggiungere uno StringConverter che ci permetta di
        //  modificare il valore numerico, in questo caso float, a string. (Non effettuiamo NumberBinding)
        bindCelsiusWithFahr();
        
        //bindInvertToMode() Prende il label lblMode e sulla base della CheckBox mostra una scritta sul Label (Celsius to Fahr o Fahr to Celsius)
        bindInvertToMode();
        
        //bindToConversion() definisce il comportamento dinamico dato dalla "check" del CheckBox, ovvero,
        //  slega la proprietà inizialmente legata al TextField (celsiusString) e la scambia con l'altra (fahrString)
        bindInputToConversion();
        
        //bindConversionToResult() definisce il comportamento che leva il label che mostra il risultato con la 
        //  giusta SimpleStringProperty
        bindConversionToResult();
        
        // 2. Versione alternativa con NumberBinding
        //initBindings();
    }

    // 1. Versione modulare con StringConverter personalizzato
    
    public void bindInvertToMode() {
        //view.lblMode.textProperty(), prendo la proprietà osservabile testo che sta nel lblMode che sta in view.
        view.lblMode.textProperty()
                //.bind, lego la proprietà osservabile quando il checkbox è selezionato (view.chkInvert.selectedProperty()) con:
                .bind(Bindings.when(view.chkInvert.selectedProperty())
                        //  "Fahr to Celsius"    
                        .then("Fahr to Celsius")
                        //  altrimenti: "Celsius to Fahr"
                        .otherwise("Celsius to Fahr"));
    }

    // *** Bidirectional Binding ***
    
    //Questo metodo lega due proprietà osservabili in maniera tale che al cambiare di una delle due, viene aggiornata l'altra e viceversa.
    //Lo stringConverter serve per la conversione e avviene in maniera molto specifica.
    /*
        1. Inizialmente tramite bindInputToConversion viene legata celsiusString al txtInput.
        2. Tramite bindConversionToResult viene legato il label che mostra il risultato con fahrString
        3. Tramite bindCelsiusWithFahr viene creato un legame tra celsiusString e fahrString (se cambia uno cambia l'altro).
        4. Lo string converter prende celsiusString e applica il metodo fromString e la bindBidirectional mette il risultato del metodo in fahrString
        5. Dato che fahrString è associato al label di risultato, viene mostrato la conversione.
        6. Se premiamo il checkbox:
            7. Tramite bindInputToConversion viene slegata celsiusString dal txtInput e viene legato fahrString a txtInput
            8. Tramite bindConversionToResult è già legato fahrString o celsiusString al lblResult tramite la condizione del when e passa tra then o otherwise (non avviene nessun unbind())  
            9. Lo string converter prende fahrString e applica il metodo toString e la bindBidirectional mette il risultato del metodo in celsiusString
    
        P.S. usando lo stringConverter preveniamo il caso in cui vengano inseriti valori non numerici
                così facendo evitiamo delle RuntimeException
    */       
    public void bindCelsiusWithFahr() {
        Bindings.bindBidirectional(celsiusString, fahrString, new StringConverter<String>() {
            // toString: Fahr -> Celsius (From primo_parametro To secondo_parametro)
            @Override
            public String toString(String object) {
                try {
                    return Float.toString((Float.valueOf(object) - 32) * 5/9);
                } catch (NumberFormatException ex) {
                    return "";
                }
            }

            // fromString: Celsius -> Fahr (From primo_parametro To secondo_parametro)
            @Override
            public String fromString(String string) {
                try {
                    return Float.toString(Float.valueOf(string) * 9/5 + 32);
                } catch (NumberFormatException ex) {
                    return "";
                }
            }
        });
    }
    
    //Questa funzione lega la SimpleStringProperty corrispondente (inizialmente celsiusString) al textfield.
    //Questa funzione permette alla celsiusString di osservare il cambiamento del texfield, inoltre, in caso
    //  venga premuto il checkbox slega e lega con l'altra proprietà e viceversa.
    public void bindInputToConversion() {
        //Lego la proprietà al texfield inizialmente
        celsiusString.bind(view.txtInput.textProperty());
        
        //Verifico se avviene un evento, ovvero se il checkbox viene premuto
        view.chkInvert.setOnAction(event -> {
            //Se è selezinato mi serve fahrString, quindi slego celsiusString e lego fahrString
            if (view.chkInvert.isSelected()) {
                celsiusString.unbind();
                fahrString.bind(view.txtInput.textProperty());
            } else {
                //Altrimenti
                fahrString.unbind();
                celsiusString.bind(view.txtInput.textProperty());
            }
        });
    }
    
    //Questo metodo lega la conversione del valore inserito all'interno del textField
    //con il label che mostra il risultato. In altre parole, senza questa funzione lblResult non mostra il risultato calcolato da bindCelsiusWithFahr().
    public void bindConversionToResult() {
        //view.lblResult.textProperty(), prendo la proprietà osservabile testo che sta nel lblResult che sta in view.
        view.lblResult.textProperty()
                //.bind, lego la proprietà osservabile quando il checkbox è selezionato (view.chkInvert.selectedProperty()) con:
                .bind(Bindings.when(view.chkInvert.selectedProperty())
                        //La simpleStringProperty celsiusString
                        .then(celsiusString)
                        //Altrimenti
                        .otherwise(fahrString));
    }
    
    // 2. Versione alternativa con binding numerici (NumberBinding)
    
    private void initBindings(){
        
        DoubleProperty inputValue = new SimpleDoubleProperty();
        
        //Il convertitore da Double a String già è esistente quindi non uso una classe anonima
        StringConverter sc = new DoubleStringConverter();
        
        //Effettuo il bind bidirezionale tra il campo di testo del textField e una doubleProperty.
        Bindings.bindBidirectional(view.txtInput.textProperty(), inputValue, sc);
        
        //Effettuo le conversioni e i binding
        NumberBinding outputCtoF = Bindings.multiply(inputValue, 1.8).add(32);
        NumberBinding outputFtoC = Bindings.subtract(inputValue, 32).multiply(0.555);
        
        //Aggiorno il binding del lblResult sulla base del checkbox e decido quali due NumberBinding mostrare
        view.lblResult.textProperty().bind(
                Bindings.when(view.chkInvert.selectedProperty())
                        .then(outputFtoC.asString("%.2f"))
                        .otherwise(outputCtoF.asString("%.2f"))
        );
        
        //Aggiorno il binding della scritta costante sulla base del checkbox
        view.lblMode.textProperty().bind(
                Bindings.when(view.chkInvert.selectedProperty())
                    .then("Fahr to Celsius")
                    .otherwise("Celsius to Fahr")
        );
        
        
    }
    
}
