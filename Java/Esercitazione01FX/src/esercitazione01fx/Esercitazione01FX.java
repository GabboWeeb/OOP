/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercitazione01fx;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author gabri
 */
public class Esercitazione01FX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        VBox root = new VBox();
        
        Scene scene = new Scene(root, 300, 250);
        
        Label lbl1 = new Label();
        Label lbl2 = new Label();
        
        TextField tfd1 = new TextField();
        TextField tfd2 = new TextField();
        
        Button btn = new Button();
        
        lbl1.setText("Input:");
        lbl2.setText("Confirm Input:");
        btn.setText("OK");
        
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
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(row1,row2,btn);
        root.setSpacing(20);
        
        //Con GridPane
        //Da fare
        //Fine GridPane
        
        primaryStage.setTitle("Controlla Stringhe Uguali");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //Bindings
        BooleanBinding ex = Bindings.or(tfd1.textProperty().isEmpty(),tfd1.textProperty().isNotEqualTo(tfd2.textProperty()));
        btn.disableProperty().bind(ex);
        
        //Quando premi il bottone
        btn.setOnAction(event -> buttonAction());
        /*
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                buttonAction();
            }
        }); 
        */
    }
    
    
    //////////////////////////
    //////////////////////////
    ////////////////////////// InputConfirmView classe
    ////////////////////////// InputConfirmControl classe
    //////////////////////////
    //////////////////////////
    
    private void buttonAction() {
        System.out.println("Input Confirmed!");
        
        //Nuova finestra di conferma
        Stage newWindow = new Stage();
        newWindow.setTitle("Conferma");
        
        //rendiamo la finestra modale (bloccante)
        newWindow.initModality(Modality.APPLICATION_MODAL);
        
        Label message = new Label("Input confirmed");
        StackPane secondaryLayout = new StackPane(message);
        secondaryLayout.setPadding(new Insets(20));
        
        Scene secondScene = new Scene(secondaryLayout, 250, 150);
        newWindow.setScene(secondScene);
        newWindow.show();
        
    }
}
