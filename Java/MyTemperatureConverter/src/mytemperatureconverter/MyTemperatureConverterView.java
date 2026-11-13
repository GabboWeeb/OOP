/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytemperatureconverter;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author gabri
 */
public class MyTemperatureConverterView extends VBox {
    
    Label lbl1;
    Label lbl2;
    Label lbl3;
    Label lbl4;
    
    TextField tf;
    
    CheckBox cb;
    
    public MyTemperatureConverterView() {
        super();
        
        lbl2 = new Label("Input: ");
        tf = new TextField();
        
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        
        this.getChildren().add(lbl1);
        
        HBox hb = new HBox();
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(lbl2,tf);
        this.getChildren().add(hb);
        
        lbl1 = new Label();
        lbl1.setText("Celsius to Fahr");
        
        lbl3 = new Label();
        
        lbl4 = new Label();
        lbl4.setText("<--->");
       
        
        cb = new CheckBox();
        
    }
    
}
