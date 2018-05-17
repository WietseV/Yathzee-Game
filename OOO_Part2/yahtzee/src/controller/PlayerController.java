package controller;

import domain.GameFacade;
import ui.GameStage;

public class PlayerController {

	private GameFacade gameFacade;
	private String player;
	private GameStage gameStage;

	public void startGame() {
		this.gameStage = new GameStage(this);
		gameFacade.add(gameStage);
		gameStage.show();
	}

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

}
