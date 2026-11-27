/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationmyknotconverter;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.*;
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
 * @author Antonio
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //view
//        TextField input= new TextField();
//        input.setPrefColumnCount(7);
//        Label symbols= new Label();
//        Label display= new Label();
//        Button reset = new Button("Reset");
//
//        symbols.setText(" km/h --> kts(nodi) ");
//        
//        HBox root = new HBox();
//        root.getChildren().addAll(input,symbols,display,reset);
//        root.setSpacing(15);
//        root.setAlignment(Pos.CENTER);
        //root.getChildren().add(btn);
        
        MyKnotConverterView view = new MyKnotConverterView();
        MyKnotConverterController controller = new MyKnotConverterController(view);
        Scene scene = new Scene(view.getRoot(), 300*1.618, 300);
        
        //Behaviour
        //convertiamo una string property a una doublke property
        
       // DoubleProperty  inputValue = new SimpleDoubleProperty();
        
        //double d= Bindings.bindBidirectional(input.textProperty() , inputValue , new DoubleStringConverter());
        /*I metodi generici sono metodi che hanno parametri che possono avere un tipo
            Non funuziona perché Property<Number> e  StringConverter<Double>. non bene
        */
        
        //dichiarazione raw
//        StringConverter dsc = new DoubleStringConverter();
//        
//        Bindings.bindBidirectional(input.textProperty() , inputValue , dsc);
//        
//        NumberBinding output = inputValue.divide(1.852);
//        //serve un binding tra il text property e il display. ma ti serve un tipo osservabile. 
//        //
//        display.textProperty().bind(output.asString("%.2f"));
//        //display.textProperty().bind(input.textProperty());
//        reset.setOnAction(e->{
//            //inputValue.set(0);
//            input.setText("0");
//        });
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
    //mvc
    
}
