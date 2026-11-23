/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycelsiustofahrconverter;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

/**
 *
 * @author Antonio
 */
public class MyCelsiusToFahrConverter extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //view
        MyCelsiusToFahrConverterView view = new MyCelsiusToFahrConverterView();
        
        MyCelsiusToFahrConverterController controller = new MyCelsiusToFahrConverterController(view);
        
        //TODO da fare tutte le chiamate
        
        Scene scene = new Scene(view, 300*1.618, 300);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
