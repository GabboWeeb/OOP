/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxah;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Antonio
 */
public class InputConfirmViewAlt {
    
    Label lbl1;
    Label lbl2;
    TextField tfd1;
    TextField tfd2;
    Button btn;
    
    public InputConfirmViewAlt(Stage primaryStage){
        //LAYOUT descritto con un approccio bottom up
        //per una GridPane
        
        //dichiara le foglie
        lbl1= new Label();
        lbl2= new Label();
        tfd1= new TextField();
        tfd2= new TextField();
        btn = new Button();
        
        //assegna una descrizione
        lbl1.setText("Input:");
        lbl2.setText("Conferma Input:");
        btn.setText("Fatto");
        
//        //nodi padri dei precedenti, dichiara-> associa i figli -> alignment -> spacing
//        HBox row1= new HBox();
//        row1.getChildren().addAll(lbl1,tfd1);
//        row1.setAlignment(Pos.CENTER);
//        row1.setSpacing(10);
//        
//        HBox row2= new HBox();
//        row2.getChildren().addAll(lbl2,tfd2);
//        row2.setAlignment(Pos.CENTER);
//        row2.setSpacing(10);
        

    
//        VBox root=new VBox(); //radice dell'albero dei nodi
        GridPane root = new GridPane();
        GridPane.setConstraints(lbl1, 0, 0);
        GridPane.setConstraints(tfd1, 1, 0);
        GridPane.setConstraints(lbl2, 0, 1);
        GridPane.setConstraints(tfd2, 1, 1);
        GridPane.setConstraints(btn, 1, 2);
        
        GridPane.setMargin(lbl1, new Insets(1));
        GridPane.setMargin(tfd1, new Insets(2)); 
        GridPane.setMargin(lbl2, new Insets(4));
        GridPane.setMargin(tfd2, new Insets(8));
        GridPane.setMargin(btn, new Insets(16));
         
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(lbl1,lbl2,tfd1,tfd2,btn);
        
        
        
        Scene scene = new Scene (root,600*1.618,400); //sfondo per gli elementi della UI, contiene il grafo di nodi
        primaryStage.setTitle("Input Confirm Stage");//titolo dello stage
        primaryStage.setScene(scene);//collegamento dello stage alla scene
    }
    
}
