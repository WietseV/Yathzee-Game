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
	int turn;
	Player turnToPlayer;
	
	private void regPlayer(Player player) {
		playerGroup.add(player);
	}
	
	// TODO add PLayCon turn player 
	public void regPlayer(Player player, PlayerController playCon){
		playerGroup.add(player);
		setStageCorrectly(player, playCon);
	}

	public void throwDice() {
		yathzeeDice.ThrowDice();
		notiffy();
	}
	public void setNextPlayerTurn() {
		groupsize = playerGroup.getList().size();
		turn ++;
		turnToPlayer = playerGroup.getList().get(turn%groupsize);
	}
	
	public void getNextPlayerPlain() {
		setNextPlayerTurn();
		PlayerController playcon = gamePains.get(turnToPlayer);
		
		
	}
	
	public void setStageCorrectly(Player player, PlayerController playCon) {
		// deze gaat alle buttons invisile zetten bij elke juist stage/ player controller 
		// TODO implementeren 
		gamePains.put(player, playCon);
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


