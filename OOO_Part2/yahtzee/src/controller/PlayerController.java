package controller;

import domain.GameFacade;
import state.*;
import ui.EndScreenStage;
import ui.GameStage;

public class PlayerController {

	private GameFacade gameFacade;
	private String player;
	private GameStage gameStage;
	private Integer turnNumber = 0; 
	private GameStageState state;
	private PlayStage playState;
	private WatchStage watchState;
	private EndStage endState;
	private EndScreenStage eSS;
	

	public void startGame() {
		this.gameStage = new GameStage(this);
		gameFacade.add(gameStage);
		gameStage.show();
		setState(watchState);
	}

	public PlayerController(GameFacade gameFacade, String name) {
		this.gameFacade = gameFacade;
		this.player = name;
		playState = new PlayStage(this);
		watchState = new WatchStage(this);
		endState = new EndStage(this);
	}

	public GameStageState getState() {
		return state;
	}

	public void setState(GameStageState state) {
		this.state = state;
		setStageCorrectrly();
	}

	public PlayStage getPlayState() {
		return playState;
	}

	public void setPlayState(PlayStage playState) {
		this.playState = playState;
	}

	public WatchStage getWatchState() {
		return watchState;
	}

	public void setWatchState(WatchStage watchState) {
		this.watchState = watchState;
	}

	public EndStage getEndState() {
		return endState;
	}

	public void setEndState(EndStage endState) {
		this.endState = endState;
	}

	public GameFacade getGameFacade() {
		return gameFacade;
	}

	public String getPlayerName() {
		return player;
	}
	
	public GameStage getGameStage() {
		return gameStage;
	}
	
	public Integer getTurnNumber() {
		return turnNumber;
	}

	public void disableStageUi() {
		gameStage.disableUI();
	}
	
	public void enableStageUi() {
		turnNumber++;
		gameStage.enableUI();
	}
	
	public void endTurnUi() {
		gameStage.endTurn();
	}
	
	public int getTurn() {
		return gameFacade.getTurn();
	}
	
	public void setStageCorrectrly() {
		
		if (getState() instanceof WatchStage) disableStageUi();
		else if (getState() instanceof PlayStage) enableStageUi();
		else {
			gameStage.close();
			createEndScreen();
			gameFacade.endTheGame();
		}
		
	}

	private void createEndScreen() {
		eSS = new EndScreenStage(gameFacade.getWinner(), this);
		eSS.show();
		
	}
}
