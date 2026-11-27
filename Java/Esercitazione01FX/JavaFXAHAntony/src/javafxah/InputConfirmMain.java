/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxah;

import javafx.geometry.Insets;
import javafx.application.Application;
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
public class InputConfirmMain extends Application {
    
    @Override
    public void start(Stage primaryStage) { //contenitore principale, contiene una scena
        //LAYOUT descritto con un approccio bottom up
        
        
        //row1
        Label lbl1 = new Label();
        lbl1.setText("Input:");
        TextField tfd1 = new TextField();
                
        //row2
        Label lbl2 = new Label();
        TextField tfd2 = new TextField();
        lbl2.setText("Confirm input:");     
        
        Button btn = new Button();
        btn.setText("Ok");
        
        GridPane root = new GridPane();
        //root.setAlignment(Pos.CENTER);
        
        GridPane.setConstraints(lbl1, 0, 0);
        GridPane.setConstraints(tfd1, 1, 0);
        GridPane.setConstraints(lbl2, 0, 1);
        GridPane.setConstraints(tfd2, 1, 1);
        GridPane.setConstraints(btn, 1, 2);
        
        GridPane.setMargin(lbl1, new Insets(5));
        GridPane.setMargin(tfd1, new Insets(5));
        GridPane.setMargin(lbl2, new Insets(5));
        GridPane.setMargin(tfd2, new Insets(5));
        GridPane.setMargin(btn, new Insets(5));
        
        root.getChildren().addAll(lbl1,tfd1,lbl2,tfd2,btn);
        
        /* Fine Versione con GridPane */
        
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("InputConfirm");
        primaryStage.setScene(scene);
        primaryStage.show();
                
        
        //Bindings
        
        BooleanBinding ex = Bindings.or(tfd1.textProperty().isEmpty(), tfd1.textProperty().isNotEqualTo(tfd2.textProperty()));
        
        btn.disableProperty().bind(ex);
        
        //Azione al click sul bottone btn
        
        /* Versione con lambda expression */
        btn.setOnAction(event -> buttonAction());
        
        /* Versione con classe anonima
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                buttonAction();
            }
        });
        */
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private void buttonAction(){
        //VIEW
        Stage nuovoStage= new Stage();
        
        Label lbl=new Label("Input confermato!");
        VBox root=new VBox();
        root.getChildren().add(lbl);
        root.setAlignment(Pos.CENTER);
        Scene nuovaScene= new Scene(root,200*1.6,200);
        nuovoStage.setTitle("Conferma");
        nuovoStage.setScene(nuovaScene);
        
        
        
        
        //BEHAVIOUR
        
        nuovoStage.initModality(Modality.APPLICATION_MODAL);
        nuovoStage.show();
        
    }
}
