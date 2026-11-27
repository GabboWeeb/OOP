/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxah;

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
 * @author Antonio
 */
public class Main extends Application {
    
    @Override //parametro è il riferimento allo stage, già istanziato
    public void start(Stage primaryStage) {
        Label lbl=new Label();
        TextField tfd= new TextField();
        Button btn = new Button();
        btn.setText("Cliccami!!");//action== legato a un oggetto grafico
        //btn.setOnAction(value);
        btn.setOnAction(e->{
            lbl.textProperty().unbind();
            //se qui ci fosse handleClick(e), per usare la stessa funzione su più pulsanti. La funzione può sare chi l'ha chiamata e orendere delle decisioni
            //utile se hai due pulsanti che fanno la stessa cosa, o anche quasi
            lbl.setText(tfd.getText());
            System.out.println(e); //per capire chi è la sorgente!!
            /*una text property è una classe osservabile. In java fx esiste il binding (tipico dei luìinguaggi reattivi):
                puoi leggere direttamente le notifivhe e inerire il binding
            */
        });
        
        lbl.textProperty().bind(tfd.textProperty()); //funziona grazie alle propietà!! ma perdi il controllo sulla label se non lo svincoli prima
        
        
        //StackPane root = new StackPane(); //la radice è di solito un contenitore!
        VBox root=new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);//spaziatura tra gli oggetti
        root.setPadding(new Insets(40)); //spaziatura uniforme tutto intorno
        
        //proviamo a filtrare l'evento del pulsante se il textbox è vuoto
        
        root.addEventFilter(MouseEvent.MOUSE_RELEASED, e->{ //e è sttointeso di tipo ActionEvent
            if(tfd.getText().isEmpty())
                e.consume();
        });
        
        root.getChildren().addAll(lbl,tfd,btn);
        Scene scene = new Scene(root, 300, 250); //dimensioni della finestra
        
        primaryStage.setTitle("Hello World!"); //titolo
        primaryStage.setScene(scene);   //impostare una scena
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);//metodo statico per far partire javaFX
    }
    
}


//puoi bindare due proprietà alla stessa?