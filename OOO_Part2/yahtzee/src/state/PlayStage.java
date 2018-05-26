package state;

import controller.PlayerController;
import ui.GameStage;

public class PlayStage extends GameStageState{

	public PlayStage(PlayerController gameStage) {
		super(gameStage);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void watch() {
		this.gameStage.setState(this.gameStage.getWatchState());
	}
}
