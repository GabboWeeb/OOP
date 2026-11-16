/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystudentlistah;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 *
 * @author Antonio
 */
public class FXMLDocumentController implements Initializable {
    

    @FXML
    private MenuItem saveButton;
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField CodeField;
    @FXML
    private Button addButton;
    @FXML
    private Button removeButton;
    @FXML
    private TableView<Student> studentTable;
    // che cosa sono <?> e <?,?> ????
    @FXML
    private TableColumn<Student, String> nameClm;
    @FXML
    private TableColumn<Student, String> surnameClm;
    @FXML
    private TableColumn<Student, String> codeClm;
    
    private ObservableList<Student> studentList;
    
    //metodo imposto dall'interfaccia. Il controller ha un costruttore di default, questo estende il suo lavoro se serve
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        studentList= FXCollections.observableArrayList();
        studentTable.setItems(studentList);
        //colonne
        nameClm.setCellValueFactory(r->{
            return new SimpleStringProperty(r.getValue().getName());
        });
        surnameClm.setCellValueFactory(r-> new SimpleStringProperty(r.getValue().getSurname()));//contratta
        //strada più veloce
        codeClm.setCellValueFactory(new PropertyValueFactory("code"));
        /*Con le annotazioni e cose incredibili, scorri il modello, cerca un get con code dopo, case insensitive*/
        
        //EDITING COLONNE
        nameClm.setCellFactory(TextFieldTableCell.forTableColumn());
        surnameClm.setCellFactory(TextFieldTableCell.forTableColumn());
        codeClm.setCellFactory(TextFieldTableCell.forTableColumn());
        
    }    

    @FXML
    private void openFile(ActionEvent event) {
    }

    @FXML
    private void saveFile(ActionEvent event) {
    }

    @FXML
    private void quitApp(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void addStudent(ActionEvent event) {
    
        studentList.add(new Student(nameField.getText(),surnameField.getText(),CodeField.getText()));
        System.out.println(studentList);
            
    
    }

    @FXML
    private void removeStudent(ActionEvent event) {
        Student s = studentTable.getSelectionModel().getSelectedItem();
        studentList.remove(s);
    }

    @FXML
    private void updateCode(TableColumn.CellEditEvent<Student,String> event) {
        Student s = studentTable.getSelectionModel().getSelectedItem();
        s.setCode(event.getNewValue());
    }

    @FXML
    private void updateName(TableColumn.CellEditEvent<Student,String> event) {
        Student s = studentTable.getSelectionModel().getSelectedItem();
        s.setName(event.getNewValue());
    }

    @FXML
    private void updateSurname(TableColumn.CellEditEvent<Student,String> event) {
        Student s = studentTable.getSelectionModel().getSelectedItem();
        s.setSurname(event.getNewValue());
    }
    
}
