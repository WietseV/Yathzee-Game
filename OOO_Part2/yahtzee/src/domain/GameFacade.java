package domain;

import ui.Observer;

public class GameFacade implements Subject{
	
	PlayerGroup playerGroup = new PlayerGroup();

	public void regPlayer(String name){
		playerGroup.add(name);
	}

	@Override
	public void add(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notiffy() {
		// TODO Auto-generated method stub
		
	}
}


