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
    
    private final MyTemperatureConverterView view;
    
    // Attributi di tipo StringProperty che modellano lo stato interno dell'applicazione
    // in termini di valori correnti di temperatura in Celsius e Fahrenheit
    // (coerentemente con la modalità operativa della GUI)
    private final StringProperty celsiusString;
    private final StringProperty fahrString;

    public MyTemperatureConverterController(MyTemperatureConverterView view) {
        this.view = view;
        this.celsiusString = new SimpleStringProperty("");
        this.fahrString = new SimpleStringProperty("");
        
        // 1. Versione con StringConverter personalizzato
        //bindCelsiusWithFahr();
        //bindInvertToMode();
        //bindInputToConversion();
        //bindConversionToResult();
        
        // 2. Versione alternativa con NumberBinding
        initBindings();
    }

    // 1. Versione modulare con StringConverter personalizzato
    public void bindInvertToMode() {
        view.lblMode.textProperty()
                .bind(Bindings.when(view.chkInvert.selectedProperty())
                        .then("Fahr to Celsius")
                        .otherwise("Celsius to Fahr"));
    }

    // *** Bidirectional Binding ***
    public void bindCelsiusWithFahr() {
        Bindings.bindBidirectional(celsiusString, fahrString, new StringConverter<String>() {
            // toString: Fahr -> Celsius
            @Override
            public String toString(String object) {
                try {
                    return Float.toString((Float.valueOf(object) - 32) * 5/9);
                } catch (NumberFormatException ex) {
                    return "";
                }
            }

            // fromString: Celsius -> Fahr
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

    public void bindInputToConversion() {
        celsiusString.bind(view.txtInput.textProperty());
        
        view.chkInvert.setOnAction(event -> {
            if (view.chkInvert.isSelected()) {
                celsiusString.unbind();
                fahrString.bind(view.txtInput.textProperty());
            } else {
                fahrString.unbind();
                celsiusString.bind(view.txtInput.textProperty());
            }
        });
    }

    public void bindConversionToResult() {
        view.lblResult.textProperty()
                .bind(Bindings.when(view.chkInvert.selectedProperty())
                        .then(celsiusString)
                        .otherwise(fahrString));
    }
    
    // 2. Versione alternativa con binding numerici (NumberBinding)
    
    private void initBindings(){
        
        DoubleProperty inputValue = new SimpleDoubleProperty();
        StringConverter sc = new DoubleStringConverter();
        Bindings.bindBidirectional(view.txtInput.textProperty(), inputValue, sc);
        
        NumberBinding outputCtoF = Bindings.multiply(inputValue, 1.8).add(32);
        NumberBinding outputFtoC = Bindings.subtract(inputValue, 32).multiply(0.555);
        
        view.lblResult.textProperty().bind(
                Bindings.when(view.chkInvert.selectedProperty())
                        .then(outputFtoC.asString("%.2f"))
                        .otherwise(outputCtoF.asString("%.2f"))
        );
        
        view.lblMode.textProperty().bind(
                Bindings.when(view.chkInvert.selectedProperty())
                    .then("Fahr to Celsius")
                    .otherwise("Celsius to Fahr")
        );
        
        
    }
    
}
