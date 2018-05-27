package state;

import controller.PlayerController;
import ui.GameStage;

public class EndStage extends GameStageState{

	public EndStage(PlayerController gameStage) {
		super(gameStage);
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public String getState() {
		return "end game";
	}
}
