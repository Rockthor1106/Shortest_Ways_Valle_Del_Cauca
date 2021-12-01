package ui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private MainController mainController;

	public static void main(String[] args) {
		launch(args);
	}
	
	public Main() throws IOException {
		mainController = new MainController(); 
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
		
		fxmlLoader.setController(mainController);
		
		Parent root = fxmlLoader.load();
		
		Group group = new Group();
		group.getChildren().add(root);
		group.getChildren().add(mainController.getGroup());
		
		Scene scene = new Scene(group);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ICESI Travels");
		primaryStage.setResizable(true);
		primaryStage.show();
	}
}
