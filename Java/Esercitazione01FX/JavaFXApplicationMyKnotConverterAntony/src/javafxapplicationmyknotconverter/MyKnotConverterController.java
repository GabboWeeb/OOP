/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationmyknotconverter;

import javafx.beans.binding.*;
import javafx.beans.property.*;
import javafx.util.*;
import javafx.util.converter.*;

/**
 *
 * @author Antonio
 */
public class MyKnotConverterController {
    private MyKnotConverterView view;
    
    public MyKnotConverterController(MyKnotConverterView view){
        this.view=view;
        initBindings();
    }
    
    private void initBindings(){
        DoubleProperty inputValue = new SimpleDoubleProperty();
        //solo DoublePropery() non va bene perché è una classe asratta!
        StringConverter dsc = new DoubleStringConverter(); 
        //solo StringConverter() non va bene perché è una classe asratta!
        
        Bindings.bindBidirectional(view.inputTextProperty(),inputValue,dsc);
        
        NumberBinding output = inputValue.divide(1.852);
        
        view.displayTextProperty().bind(output.asString("%.2f"));
        
        view.setResetAction(e -> {
            inputValue.set(0); //non è una modifica, chiami un metodo!
        
        });
        
    }
            
}
