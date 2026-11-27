/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxah;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Antonio
 */
public class InputConfirmBehaviour {
    
    InputConfirmViewAlt view;
    
    public InputConfirmBehaviour(InputConfirmViewAlt view){
        this.view=view;
    }
    
    public void setBehaviour(){
        
        BooleanBinding b =Bindings.or(view.tfd1.textProperty().isNotEqualTo(view.tfd2.textProperty()),
                view.tfd1.textProperty().isEmpty());
        view.btn.disableProperty().bind(b);
        /*vincoliamo la proprietà del bottone di essere disabilitato a un binding booleano
        questo binding è il risultato della or tra due binding booleani, 
        ottenuti dal confronto delle text properties dei tfd con i metodi delle string properties
        */
        
        view.btn.setOnAction(e->buttonAction());
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
