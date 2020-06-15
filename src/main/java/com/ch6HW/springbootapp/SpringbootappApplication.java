package com.ch6HW.springbootapp;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class SpringbootappApplication extends Application{
  static Scene scene ;
	public static void main(String[] args) {
		//SpringApplication.run(Springbootapp2Application.class, args);
	
        launch(args);
        }
   // private Object SpringbootappApplication;
    

    @Override
    public void start(Stage primaryStage) throws Exception {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TableViewPane.fxml"));
        loader.setControllerFactory(SpringApplication.run(SpringbootappApplication.class)::getBean);
        Pane pane = loader.load();
         scene = new Scene(pane);
        primaryStage.setTitle("JPA with Spring boot");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
