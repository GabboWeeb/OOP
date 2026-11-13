/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinputconfirmmvc;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author 
 */
public class MyInputConfirmView extends VBox {
    
    Label lbl1;
    Label lbl2;
    TextField tfd1;
    TextField tfd2;
    Button btn;

    public MyInputConfirmView() {
        
        lbl1 = new Label();
        lbl2 = new Label();
        tfd1 = new TextField();
        tfd2 = new TextField();
        btn = new Button();
        
        lbl1.setText("Input:");
        lbl2.setText("Confirm input:");
        btn.setText("Ok");
        
        //row1 
        
        HBox row1 = new HBox();
        row1.getChildren().addAll(lbl1, tfd1);
        row1.setSpacing(10);
        row1.setAlignment(Pos.CENTER);
        
        //row2
        
        HBox row2 = new HBox();
        row2.getChildren().addAll(lbl2, tfd2);
        row2.setSpacing(10);
        row2.setAlignment(Pos.CENTER);
        
       //container
        
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(row1,row2,btn);
        this.setSpacing(20);
        
        
        
    }
    
    
    
    
    
}
