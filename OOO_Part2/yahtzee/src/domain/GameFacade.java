package domain;

import java.util.ArrayList;
import java.util.Hashtable;

import controller.PlayerController;
import ui.Observer;

public class GameFacade implements Subject{
	
	PlayerGroup playerGroup = new PlayerGroup();
	YahtzeeDice yathzeeDice = new YahtzeeDice();
	ArrayList<Observer> observerList = new ArrayList<Observer>();
	Hashtable<Player, PlayerController> gamePains = new Hashtable<Player, PlayerController>();
	int groupsize ;
	int beurt;
	
	private void regPlayer(Player player){
		playerGroup.add(player);
	}

	public void throwDice() {
		yathzeeDice.ThrowDice();		
	}
	public void playerTurn() {
		groupsize = playerGroup.getList().size();
		
	}
	
	public void setStageCorrectly() {
		// deze gaat alle buttons invisile zetten bij elke juist stage/ player controller 
		// TODO implementeren 
	}
	
	public ArrayList<Die> getDice() {
		return yathzeeDice.getDice();
	}
	
	public String getActivePlayer() {
		return playerGroup.getActivePlayer();
	}
	
	public void keepDie(Die die) {
		yathzeeDice.keepDie(die);
		notiffy();
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
		Player player = new Player(name);
		regPlayer(player);
		return player;
	}
}


