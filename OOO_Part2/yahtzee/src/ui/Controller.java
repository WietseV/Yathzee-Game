package ui;

import domain.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller extends Application {

	@Override
	public void start(Stage primaryStage) {
		Game game = new Game();
		
		InputDialog inputDialog = new InputDialog();
		String name = inputDialog.ShowAndWait();
		game.regPlayer(name);
		System.out.println(name);
//		Scene scene = new Scene(inputPane,400,400);
//		primaryStage.setScene(scene);
//		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
