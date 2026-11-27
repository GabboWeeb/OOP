/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxah;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
 * @author Antonio
 */
public class NewFXRundoMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //LAYOUT. Una pagina che ne blocca un'altra ha un comportamento modale
        VBox root= new VBox(); //setta la root
        //setta gli oggetti, dal basso o dall'alto, è comodo dal basso dell'albero
        
        //per ogni nodo parent dichiaralo, mettici i nodi, spacing e alignment
        
        Button btn= new Button();
        btn.setText("Ok");
        
        
        Label lbl1=new Label();
        Label lbl2=new Label();
        TextField tfd1= new TextField ();
        TextField tfd2= new TextField ();
        
        
        
        HBox row1= new HBox();
        HBox row2= new HBox();
        row1.getChildren().addAll(lbl1,tfd1);
        row2.getChildren().addAll(lbl2,tfd2);
        root.getChildren().addAll(row1,row2,btn);
        
        root.setAlignment(Pos.CENTER);
        row1.setAlignment(Pos.CENTER);
        row2.setAlignment(Pos.CENTER);
        root.setSpacing(10);//spaziatura tra gli oggetti
        row1.setSpacing(30);//spaziatura tra gli oggetti
        row2.setSpacing(5);//spaziatura tra gli oggetti
        
        lbl1.setText("Input:");
        lbl2.setText("Conferma:");
        
        
        //--- fine LAYOUT
        //COMPORTAMENTO trova una proprietà osservabile (finisce con property)
        //lega l'abilitazione del bottone a ?
        BooleanBinding ex= Bindings.or(tfd1.textProperty().isEmpty(), tfd1.textProperty().isNotEqualTo(tfd2.textProperty()));       // tfd1.textProperty().isEmpty()
        //tfd1.textProperty().isNotEqualTo(tfd2.textProperty());
        btn.disableProperty().bind(ex); 
        
        //lambda per interfacce funzionali. Azione on click. Chiama una funzione, molto chill
        btn.setOnAction(eset->buttonAction());
        
//        btn.setOnAction(new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent e) {
//                buttonAction();
//            }
//        });
        
        
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Esercizio del 6-11-2026");
        primaryStage.setScene(scene);
        primaryStage.show();
        
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private void buttonAction(){
        Stage newWindow=new Stage();
        
        //dettagli insignifcanti inficiano le interazioni dell'utente
        newWindow.initModality(Modality.APPLICATION_MODAL);
        
        Label msg= new Label("Gotcha");
        StackPane secondo= new StackPane(msg);
        
        Scene secondScene= new Scene(secondo,100,100);
        newWindow.setScene(secondScene);
        newWindow.show();
    }
    
}


/*
Come lo dividi in classi?
Disaccoppiamo layout (view) e behaviour(controllo)

Va in una classe input confirm view
Il controllo va in tutta la classe input confirm control

tutto gesito da una classe application
*/