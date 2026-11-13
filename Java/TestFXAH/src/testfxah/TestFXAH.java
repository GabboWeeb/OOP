/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfxah;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author gabri
 */
public class TestFXAH extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Label lbl = new Label();
        
        TextField tfd = new TextField();
        
        Button btn = new Button();
        btn.setText("Cliccami");
        
        btn.setOnAction(e -> {
            
            lbl.textProperty().unbind();
            
            //handleClick(e);
            lbl.setText(tfd.getText());
            System.out.println(e);
        });
        
        lbl.textProperty().bind(tfd.textProperty());
        
        //StackPane root = new StackPane();
        VBox root = new VBox();
        
        //Intercettare eventi
        root.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> {
            if(tfd.getText().isEmpty()) {
                e.consume();
            }
        });
        
        root.setAlignment(Pos.CENTER);
        
        root.setSpacing(20);
        
        root.setPadding(new Insets(40));
        
        root.getChildren().addAll(lbl,tfd,btn);
        
        Scene scene = new Scene(root, 300, 250);
        
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
