/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch6HW.springbootapp;

import com.ch6HW.springbootapp.models.Registration;
import com.ch6HW.springbootapp.repository.CourseRepository;
import com.ch6HW.springbootapp.repository.RegistrationRepository;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * FXML Controller class
 *
 * @author Abu Yasser
 */
@Component
public class AddCourseController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private TextField txtStudentId;
    @FXML
    private TextField txtCourseId;
    @FXML
    private TextField txtLabel;
    @FXML
    private Button addButton;

    @Autowired
    RegistrationRepository rr;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backButtonHandle(ActionEvent event) throws IOException {
            Pane addCourse = FXMLLoader.load(getClass().getResource("TableViewPane.fxml"));
          SpringbootappApplication.scene =  new Scene(addCourse);
          Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
          window.setScene(SpringbootappApplication.scene);
          window.show();
    }

    @FXML
    private void addButtonHandle(ActionEvent event) {
          Registration r = new Registration();
          Integer courseid  = Integer.parseInt(this.txtCourseId.getText());
          Integer studentid  = Integer.parseInt(this.txtStudentId.getText());
        
         r.setCourseid(courseid);
         r.setStudentid(studentid);
         String semester = this.txtLabel.getText();
         r.setSemester(semester);
         rr.save(r);
    }
    
}
