package controller;

import java.util.ArrayList;
import java.util.Optional;

import com.sun.xml.internal.bind.v2.runtime.Name;

import domain.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class Controller {

	private GameFacade gameFacade = new GameFacade();
	private TextInputDialog tid = new TextInputDialog();
	private String name = "";

	public void start() {
		ArrayList<PlayerController> playerConList = new ArrayList<PlayerController>();
		
		
		while(true) {
			
		TextInputDialog tid = new TextInputDialog();
		tid.setTitle("Register player");
		tid.setHeaderText("Register a new player");
		tid.setContentText("Please enter your name: ");
		
		Optional<String> result = tid.showAndWait();
		if (result.isPresent()) {
			name = result.get();
		}
		else break;
		gameFacade.regPlayer(name);
		
		playerConList.add(new PlayerController(gameFacade, name));
		
		}
		
		for(PlayerController pc : playerConList) {
			pc.startGame();
		}
//		Scene scene = new Scene(inputPane,400,400);
//		primaryStage.setScene(scene);
//		primaryStage.show();
	}
}
