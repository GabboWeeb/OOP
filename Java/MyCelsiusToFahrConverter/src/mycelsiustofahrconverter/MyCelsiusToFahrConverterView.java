/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycelsiustofahrconverter;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 *
 * @author Antonio
 */
public class MyCelsiusToFahrConverterView extends VBox{
    public final Label lblMode;
    public final Label lblResult;
    public final TextField txtInput;
    public final CheckBox chkInvert;
    
    public MyCelsiusToFahrConverterView(){

        super();
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        
        this.lblMode= new Label(); 
        this.getChildren().add(this.lblMode);
        HBox hboxInput = new HBox();
        hboxInput.setSpacing(10);
        hboxInput.setAlignment(Pos.CENTER);
        hboxInput.getChildren().add(new Label("Input:"));
        this.txtInput = new TextField();
        hboxInput.getChildren().add(txtInput);
        this.getChildren().add(hboxInput);

        HBox hboxResult = new HBox();
        hboxResult.setSpacing(10);
        hboxResult.setAlignment(Pos.CENTER);
        hboxResult.getChildren().add(new Label("Result:"));
        this.lblResult = new Label();
        hboxResult.getChildren().add(lblResult);
        this.getChildren().add(hboxResult);

        this.chkInvert = new CheckBox("<--->");
        this.getChildren().add(chkInvert);
    
    }
}
