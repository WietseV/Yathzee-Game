package ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class GameApp extends Application {

	@Override
	public void start(Stage primaryStage) {
		Controller controller = new Controller();
		controller.start();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
