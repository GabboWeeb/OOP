/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytemperatureconverter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author gabri
 */
public class MyTemperatureConverter extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        MyTemperatureConverterView view = new MyTemperatureConverterView();
        MyTemperatureConverterController controller = new MyTemperatureConverterController(view, view.tf.textProperty(), view.lbl3.textProperty());
        
        Scene scene = new Scene(view, 300, 250);
        
        primaryStage.setTitle("My Temperature Controller");
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
