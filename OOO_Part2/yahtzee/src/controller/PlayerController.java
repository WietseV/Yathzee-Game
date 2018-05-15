package controller;

import domain.GameFacade;
import ui.GameStage;

public class PlayerController {
	
	private GameFacade gameFacade = new GameFacade();
	private String playerName = new String();
	GameStage gameStage;

	public PlayerController(GameFacade gameFacade, String name) {
		this.gameFacade = gameFacade;
		this.playerName = name;
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
