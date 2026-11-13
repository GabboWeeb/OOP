/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myknotconverter;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

/**
 *
 * @author gabri
 */
public class MyKnotConverter extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        //Campo di testo di input
        TextField input = new TextField();
        Label symbols = new Label();
        Label output = new Label();
        
        //Setto il testo in maniera costante
        symbols.setText("km/h ---> kts");
        
        //Setto un numero preferenziale di colonne
        input.setPrefColumnCount(7);
        
        //Disposizione degli oggetti in orizzontale
        HBox root = new HBox();
        
        //aggiungo i miei elementi
        root.getChildren().addAll(input, symbols, output);
        
        //Aggiungo spaziatura degli elementi
        root.setSpacing(15);
        
        //Centro gli elementi
        root.setAlignment(Pos.CENTER);
        
        
        //Gestione logica
        DoubleProperty inputValue = new SimpleDoubleProperty();
        
        //Facciamo questa cosa perche nella valutazione dei tipi generici della bindBidirectional, dsc è double, mentre inputValue è number, e quindi è incompatibile
        StringConverter dsc = new DoubleStringConverter();
        
        //Vogliamo convertire in maniera automatica il testo in double (entrambi osservabili)
        Bindings.bindBidirectional(input.textProperty(), inputValue, dsc);
        
        NumberBinding outputDisplay = inputValue.divide(1.852);
        
        output.textProperty().bind(outputDisplay.asString("%.2f"));
        
        Scene scene = new Scene(root, 400, 300);
        
        primaryStage.setTitle("MyKnotConverter");
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
