/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinputconfirmmvc;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author 
 */
public class MyInputConfirmController {
    
    MyInputConfirmView view;

    public MyInputConfirmController(MyInputConfirmView view) {
        
        this.view = view;
        
        view.btn.setOnAction(event -> buttonAction());
        
    }
    
    public void initBindings() {
    
    
        BooleanBinding bb = Bindings.or(view.tfd1.textProperty().isEmpty(), view.tfd1.textProperty().isNotEqualTo(view.tfd2.textProperty()));
        
        view.btn.disableProperty().bind(bb);
    
    
    }
    
    private void buttonAction() {
        
        /* Stampa su standard output */
        System.out.println("Input confirmed!");
        
        /* Nuova finestra di conferma (con StackPane) */
        Stage newWindow = new Stage();
        newWindow.setTitle("Confirmation");
        
        // Rendiamo la finestra modale (bloccante)
        newWindow.initModality(Modality.APPLICATION_MODAL);

        Label message = new Label("Input confirmed!");
        StackPane secondaryLayout = new StackPane(message);
        secondaryLayout.setPadding(new Insets(20));

        Scene secondScene = new Scene(secondaryLayout, 250, 150);
        newWindow.setScene(secondScene);
        newWindow.show();
    }
    
}
