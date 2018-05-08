package ui;

import domain.Game;
import javafx.application.Application;
import javafx.stage.Stage;

public class PlayerController {
	
	Game game = new Game();
	String playerName = new String();

	public PlayerController(Game game, String playerName) {
		this.game = game;
		this.playerName = playerName;
	}

	public void start() {
		System.out.println("its jhon ceenaaa!");
	}
}
