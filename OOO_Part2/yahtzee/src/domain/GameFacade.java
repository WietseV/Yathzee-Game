package domain;

import java.util.ArrayList;

import ui.Observer;

public class GameFacade implements Subject{
	
	PlayerGroup playerGroup = new PlayerGroup();
	YahtzeeDice yathzeeDice = new YahtzeeDice();
	ArrayList<Observer> observerList = new ArrayList<Observer>();

	public void regPlayer(String name){
		playerGroup.add(name);
	}

	public void throwDice() {
		yathzeeDice.ThrowDice();	
		notiffy();
	}
	
	public ArrayList<Die> getDice() {
		return yathzeeDice.getDice();
	}
	
	public String getActivePlayer() {
		return playerGroup.getActivePlayer();
	}
	
	public void keepDie(Die die) {
		yathzeeDice.keepDie(die);
		
	}
	
	public void PlayWithDie(Die die) {
		yathzeeDice.playWithDie(die);
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

	public Player createPlayer(String name) {
		return new Player(name);
	}
}


