/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycelsiustofahrconverter;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.util.StringConverter;

/**
 *
 * @author Antonio
 */
public class MyCelsiusToFahrConverterController {
    private final MyCelsiusToFahrConverterView view;
    private final SimpleStringProperty celsiusString;
    private final SimpleStringProperty fahrString;
    
    public MyCelsiusToFahrConverterController( MyCelsiusToFahrConverterView view){
        this.view=view;
        this.celsiusString= new SimpleStringProperty("");
        this.fahrString= new SimpleStringProperty("");
        
        //personalizzo lo StringConverter
        bindCelsiusWithFahr();
        bindInvertToMode();
        bindInputToConversion();
        bindConversionToResult();
        
    }
    
    private void bindInvertToMode(){
        view.lblMode.textProperty().
                bind(Bindings.when(view.chkInvert.selectedProperty())
                .then("Fahr to Celsius")
                .otherwise("Celsius To Fahr"));
    }
    
    private void bindCelsiusWithFahr(){
        Bindings.bindBidirectional(celsiusString, fahrString, new StringConverter<String>(){
            @Override
            public String fromString (String s){
               try {
                    return Float.toString(Float.valueOf(s)*9/5+32);
                } catch (Exception e){
                    return "";
                }
            }
            
            @Override
            public String toString (String s){
                try {
                    return Float.toString((Float.valueOf(s)-32)*5/9);
                } catch (Exception e){
                    return "";
                }
            }
            
        });
    }
    
    public void bindInputToConversion(){
        this.celsiusString.bind(view.txtInput.textProperty());
        
        view.chkInvert.setOnAction(e->{
            if (view.chkInvert.isSelected()){
                this.celsiusString.unbind();
                this.fahrString.bind(view.txtInput.textProperty());
            }else{
                this.fahrString.unbind();
                this.celsiusString.bind(view.txtInput.textProperty());
            }
        
        });
    
    }
    
    public void bindConversionToResult(){
        view.lblResult.textProperty().bind(Bindings.when(view.chkInvert.selectedProperty()).then(this.celsiusString).otherwise(this.fahrString)); //forse è al contrario
    }
    
}
