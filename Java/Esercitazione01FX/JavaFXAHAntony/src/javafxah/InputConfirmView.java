/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxah;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Antonio
 */
public class InputConfirmView extends VBox {
    
    Label lbl1;
    Label lbl2;
    TextField tfd1;
    TextField tfd2;
    Button btn;
    
    public InputConfirmView(Stage primaryStage){
        //LAYOUT descritto con un approccio bottom up
        
        
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
        
        //nodi padri dei precedenti, dichiara-> associa i figli -> alignment -> spacing
        HBox row1= new HBox();
        row1.getChildren().addAll(lbl1,tfd1);
        row1.setAlignment(Pos.CENTER);
        row1.setSpacing(10);
        
        HBox row2= new HBox();
        row2.getChildren().addAll(lbl2,tfd2);
        row2.setAlignment(Pos.CENTER);
        row2.setSpacing(10);
        
        //al posto della rooot qui va this
//        VBox root=new VBox(); //radice dell'albero dei nodi
//        root.getChildren().addAll(row1,row2,btn);
//        root.setAlignment(Pos.CENTER);
//        root.setSpacing(30);

        
        this.getChildren().addAll(row1,row2,btn);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(30);

        
        Scene scene = new Scene (this,600*1.618,400); //sfondo per gli elementi della UI, contiene il grafo di nodi
        primaryStage.setTitle("Input Confirm Stage");//titolo dello stage
        primaryStage.setScene(scene);//collegamento dello stage alla scene
    }
    
}
