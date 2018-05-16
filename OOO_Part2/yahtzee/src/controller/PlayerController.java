package controller;

import domain.GameFacade;
import domain.Player;
import ui.GameStage;

public class PlayerController {
	
	private GameFacade gameFacade = new GameFacade();
	private Player player;
	GameStage gameStage;

	public PlayerController(GameFacade gameFacade, Player player) {
		this.gameFacade = gameFacade;
		this.player = player;
	}

	public GameFacade getGameFacade() {
		
		return gameFacade;
	}

	public String getPlayerName() {
		return player.getName();
	}

	public void startGame() {
		this.gameStage = new GameStage(this);
		gameFacade.add(gameStage);
		gameStage.show();
	}
}
