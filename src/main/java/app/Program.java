package app;


import java.io.IOException;

import controller.Controller;
import controller.impl.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;
import view.FXMLGameBookController;

public class Program extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
      
        Parent root;
		//Parent root = FXMLLoader.load(getClass().getResource("/MainWindow.fxml"));
        FXMLLoader chargeurFXML = new FXMLLoader(getClass().getResource("/MainWindow.fxml"));
		
		Controller crt = new MainController(new Book(" "),new DisplayGraph(), new ValidateGameBook());
		FXMLGameBookController viewFxml = new FXMLGameBookController(crt);
		chargeurFXML.setController(viewFxml);
		crt.setView(viewFxml);
		
		root = chargeurFXML.load();		
		Scene scene = new Scene(root);
		stage.setTitle("Helmo- GameBook"); 
		stage.setScene(scene);
		stage.show(); 
	}

    public static void main(String[] args) {
        launch(args);
    }

}