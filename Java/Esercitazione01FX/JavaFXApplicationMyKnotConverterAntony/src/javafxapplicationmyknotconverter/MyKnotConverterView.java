/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationmyknotconverter;

import javafx.beans.property.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 *
 * @author Antonio
 */
public class MyKnotConverterView {
    //due strade: con composizione (alpha) ed ereditarietà (beta)
    /*
    alpha espone anche gli altri metodi che magari non vuoi esporre.
    Proviamo a fare un incapsulamento completo della lista
    */
    
    private HBox root;
    private TextField input;
    private Label symbols;
    private Label display;
    private Button reset;
    
    public MyKnotConverterView (){
        root = new HBox();
        input = new TextField();
        symbols = new Label();
        display = new Label();
        reset= new Button();
        this.initComponents();
    }
    
    private void initComponents(){
        symbols.setText(" km/h --> kts");
        reset.setText("Reset");
        input.setPrefColumnCount(7);
        root.getChildren().addAll(input,symbols,display,reset);
        root.setSpacing(15);
        root.setAlignment(Pos.CENTER);
    }
    
    public Parent getRoot(){
        return root;
    }
    
    public StringProperty inputTextProperty(){
        return input.textProperty();
    }
    
    public StringProperty displayTextProperty(){
        return display.textProperty();
    }
    
    //non passiamo il bottone, ma permettiamo al controller di configurarloù
    public void setResetAction (EventHandler<ActionEvent> e ){
        reset.setOnAction(e);
    }
    
    
    
}
