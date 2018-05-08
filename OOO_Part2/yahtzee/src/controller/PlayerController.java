package controller;

import domain.GameFacade;
import javafx.application.Application;
import javafx.stage.Stage;
import ui.GameStage;

public class PlayerController {
	
	private GameFacade gameFacade = new GameFacade();
	private String playerName = new String();

	public PlayerController(GameFacade game, String playerName) {
		this.gameFacade = game;
		this.playerName = playerName;
	}

	public GameFacade getGameFacade() {
		return gameFacade;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void startGame() {
		GameStage gameStage = new GameStage(this);
		gameStage.show();
	}
}
