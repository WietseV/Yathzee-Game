package controller;

import domain.GameFacade;
import ui.GameStage;

public class PlayerController {
	
	private GameFacade gameFacade;
	private String player;
	GameStage gameStage;

	public PlayerController(GameFacade gameFacade, String name) {
		this.gameFacade = gameFacade;
		this.player = name;
	}

	public GameFacade getGameFacade() {
		return gameFacade;
	}

	public String getPlayerName() {
		return player;
	}

	public void startGame() {
		this.gameStage = new GameStage(this);
		gameFacade.add(gameStage);
		gameStage.show();
	}
}
