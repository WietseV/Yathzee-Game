package domain;

import java.util.ArrayList;

import ui.Observer;

public class GameFacade implements Subject{
	
	PlayerGroup playerGroup = new PlayerGroup();
	ArrayList<Observer> observerList = new ArrayList<Observer>();

	public void regPlayer(String name){
		playerGroup.add(name);
	}

	
	
	@Override
	public void add(Observer o) {
		observerList.add(o);
	}

	@Override
	public void remove(Observer o) {
		// TODO Auto-generated method stub
		observerList.remove(o);
	}

	@Override
	public void notiffy() {
		// TODO Auto-generated method stub
		for(Observer o: observerList){
			o.update();
		}
	}
}


