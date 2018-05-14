package controller;

import domain.GameFacade;
import domain.Player;
import javafx.application.Application;
import javafx.stage.Stage;
import ui.GameStage;

public class PlayerController {
	
	private GameFacade gameFacade = new GameFacade();
	private String playerName = new String();
	GameStage gameStage;

	public PlayerController(GameFacade gameFacade, Player player) {
		this.gameFacade = gameFacade;
		this.playerName = player.getName();
	}

	public GameFacade getGameFacade() {
		
		return gameFacade;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void startGame() {
		this.gameStage = new GameStage(this);
		gameFacade.add(gameStage);
		gameStage.show();
	}
}
