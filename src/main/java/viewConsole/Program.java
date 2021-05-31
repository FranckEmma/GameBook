package viewConsole;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Program extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");

		Parent root = FXMLLoader.load(getClass().getResource("/maquette.fxml"));
	
		//Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
		Scene scene = new Scene(root, 640, 480);
		stage.setTitle("Helmo- GameBook"); 
		stage.setScene(scene);
		stage.show(); 
	}

    public static void main(String[] args) {
        launch(args);
    }

}