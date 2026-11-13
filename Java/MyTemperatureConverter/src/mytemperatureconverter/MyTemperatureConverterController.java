/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytemperatureconverter;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.util.StringConverter;

/**
 *
 * @author gabri
 */
public class MyTemperatureConverterController {
    private final MyTemperatureConverterView view;
    private final SimpleStringProperty celsiusString;
    private final SimpleStringProperty fahrString;
    
    public MyTemperatureConverterController(MyTemperatureConverterView view, SimpleStringProperty celsiusString, SimpleStringProperty fahrString) {
        this.view = view;
        this.celsiusString = new SimpleStringProperty("");
        this.fahrString = new SimpleStringProperty("");
        
        //Versione con StringConverter personalizzato
        bindCelsiusWithFahr();
        bindInvertToMode();
        bindInputToConversion();
        bindConversionToResult();
        
        //Versione alternativa con NumberBinding
        //initBindings();
    }
    
    public void bindInvertToMode() {
        view.lbl1.textProperty().bind(Bindings.when(view.cb.selectedProperty()).then("Fahr to Celsius").otherwise("Celsius to Fahr"));
    }
    
    public void bindCelsiusWithFahr() {
        Bindings.bindBidirectional(celsiusString, fahrString, new StringConverter<String>() {
            //Fahr -> Celsius
            @Override
            public String toString(String object) {
                try {
                    return Float.toString((Float.valueOf(object) - 32) * 5/9);
                } catch(NumberFormatException ex) {
                    return "";
                }
            }
            
            //Celsius -> Fahr
            @Override
            public String fromString(String object) {
                try {
                    return Float.toString((Float.valueOf(object) * 5/9) + 32);
                } catch(NumberFormatException ex) {
                    return "";
                }
            }
            
        });
    }
    
    public void bindInputToConversion() {
        celsiusString.bind(view.tf.textProperty());
        
        view.cb.setOnAction(event -> {
            if(view.cb.isSelected()) {
                celsiusString.unbind();
                fahrString.bind(view.tf.textProperty());
            } else {
                
            }
        });    
        
    }
    
    public void bindConversionToResult() {
    
    }
}
