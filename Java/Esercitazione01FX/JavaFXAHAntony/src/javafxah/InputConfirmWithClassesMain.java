/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxah;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Antonio
 */
public class InputConfirmWithClassesMain extends Application {
     
    @Override
    public void start(Stage primaryStage) { //contenitore principale, contiene una scena
        InputConfirmViewAlt view = new InputConfirmViewAlt(primaryStage);
        InputConfirmBehaviour b= new InputConfirmBehaviour (view);
        b.setBehaviour();
        primaryStage.show();//mostra tutto
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
