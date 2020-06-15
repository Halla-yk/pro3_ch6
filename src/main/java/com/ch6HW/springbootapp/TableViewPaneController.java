/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch6HW.springbootapp;

import com.ch6HW.springbootapp.models.Students;
import com.ch6HW.springbootapp.repository.StudentRepository;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * FXML Controller class
 *
 * @author Abu Yasser
 */
@Component
public class TableViewPaneController implements Initializable {

    @FXML
    private TextField txtFieldID;
    @FXML
    private TextField txtFieldName;
    @FXML
    private TextField txtFieldMajor;
    @FXML
    private TextField txtFieldGrade;
    @FXML
    private TableView<Students> tableView;
    @FXML
    private TableColumn<Students, Integer> tcID;
    @FXML
    private TableColumn<Students,String> tcName;
    @FXML
    private TableColumn<Students,String> tcMajor;
    @FXML
    private TableColumn<Students,Double> tcGrade;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteAdd;
    @FXML
    private Button buttonUpdate;
    @FXML
    private Button buttonAddCourse;
    @FXML
    private Button sqlStatement;
    @Autowired
   StudentRepository studentRepository;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
               tcID.setCellValueFactory(new PropertyValueFactory("id"));
         tcName.setCellValueFactory(new PropertyValueFactory("name"));
         tcMajor.setCellValueFactory(new PropertyValueFactory("major"));
         tcGrade.setCellValueFactory(new PropertyValueFactory("grade"));
         tableView.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedStudent() );
           try{
             showStudent();
          
         }catch(Exception ex){}
         
    }    

    @FXML
    private void textFieldStudentIdHandle(ActionEvent event) {
    }

    @FXML
    private void addButtonHandle(ActionEvent event) {
          Students s = new Students();
        s.setName(this.txtFieldName.getText());
        s.setMajor(this.txtFieldMajor.getText());
        s.setGrade(Double.parseDouble(this.txtFieldGrade.getText()));
         studentRepository.save(s);
        
    }

    @FXML
    private void deleteAddHandle(ActionEvent event) {
        Students std =  studentRepository.findById(Integer.parseInt(txtFieldID.getText())).get();
         studentRepository.delete(std);
    }

    @FXML
    private void buttonUpdateHandle(ActionEvent event) {
     Students s =  studentRepository.findById(Integer.parseInt(txtFieldID.getText())).get();
      s.setName(this.txtFieldName.getText());
        s.setMajor(this.txtFieldMajor.getText());
        s.setGrade(Double.parseDouble(this.txtFieldGrade.getText()));
         studentRepository.save(s);
     
        
    }

    @FXML
    private void addCourseHandle(ActionEvent event) throws IOException {
       Pane addCourse = FXMLLoader.load(getClass().getResource("AddCourse.fxml"));
       SpringbootappApplication.scene =  new Scene(addCourse);
          Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
          window.setScene(SpringbootappApplication.scene);
          window.show();
    }

    @FXML
    private void sqlHandle(ActionEvent event) {
    }
       private void showStudent(){
           List<Students> std = studentRepository.findAll();
           tableView.getItems().setAll(std);
 
    }

        private void showSelectedStudent(){
        Students student = tableView.getSelectionModel().getSelectedItem();
        if(student != null){
        txtFieldID.setText(String.valueOf(student.getId()));
        txtFieldName.setText(student.getName());
        txtFieldGrade.setText(String.valueOf(student.getGrade()));
        txtFieldMajor.setText(String.valueOf(student.getMajor()));
        }

        }
        
        private void resetTextField(){
        this.txtFieldGrade.setText("");
        this.txtFieldID.setText(" ");
        this.txtFieldName.setText("");
        this.txtFieldMajor.setText(" ");
        
       }
 
}
