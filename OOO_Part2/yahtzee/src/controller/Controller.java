package controller;

import java.util.ArrayList;
import java.util.Optional;



import domain.*;
import javafx.scene.control.TextInputDialog;

public class Controller {

	private GameFacade gameFacade = new GameFacade();
	private String name = "";

	public void start() {
		ArrayList<PlayerController> playerConList = new ArrayList<PlayerController>();
		while (true) {
			TextInputDialog tid = new TextInputDialog();
			tid.setTitle("Register player");
			tid.setHeaderText("Register a new player");
			tid.setContentText("Please enter your name: ");

			Optional<String> result = tid.showAndWait();
			if (result.isPresent() && !result.equals("")) {
				name = result.get();
			} else
				break;
			if (name.equals(""))
				break;

//			playerConList.add(new PlayerController(gameFacade, name));
//			gameFacade.createPlayer(name); <-- returned een playr werd niks meegedaan
			
			PlayerController playCon = new PlayerController(gameFacade, name);
			playerConList.add(playCon);
			gameFacade.regPlayer(name, playCon);
			
		}

		for (PlayerController pc : playerConList) {
			pc.startGame();
		}
		
		gameFacade.firstTurn();
	}
}
