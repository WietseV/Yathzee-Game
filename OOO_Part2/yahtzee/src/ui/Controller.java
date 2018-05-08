package ui;

import java.util.Optional;

import com.sun.xml.internal.bind.v2.runtime.Name;

import domain.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class Controller {

	private Game game = new Game();
	private TextInputDialog tid = new TextInputDialog();
	private String name = "";

	public void start() {
		
		tid.setTitle("Register player");
		tid.setHeaderText("Register a new player");
		tid.setContentText("Please enter your name: ");
		
		Optional<String> result = tid.showAndWait();
		if (result.isPresent()) {
			name = result.get();
		}
		name = "cancel";
		
		game.regPlayer(name);
		PlayerController playerController = new PlayerController(game, name);
		playerController.start();
//		Scene scene = new Scene(inputPane,400,400);
//		primaryStage.setScene(scene);
//		primaryStage.show();
	}
}
