package state;

import controller.PlayerController;
import ui.GameStage;

public abstract class GameStageState {

	PlayerController gameStage;
	
	public GameStageState(PlayerController gameStage) {
		this.gameStage = gameStage;
	}
	
	public String getState() {
		return null;
	}
	
	public void play() {
		throw new IllegalArgumentException("sorry, no can do");
	}
	
	public void watch() {
		throw new IllegalArgumentException("sorry, no can do");

	}
	
	public void end() {
		throw new IllegalArgumentException("sorry, no can do");

	}
}
