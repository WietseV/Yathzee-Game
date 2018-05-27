package state;

import controller.PlayerController;
import ui.GameStage;

public class WatchStage extends GameStageState{

	public WatchStage(PlayerController gameStage) {
		super(gameStage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play() {
		this.gameStage.setState(this.gameStage.getPlayState());
	}
	
	@Override
	public void end() {
		this.gameStage.setState(this.gameStage.getEndState());
	}
	
	
	@Override
	public String getState() {
		return "WatchState";
	}
}
