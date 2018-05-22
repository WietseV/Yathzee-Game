package domain;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import controller.PlayerController;
import ui.Observer;

public class GameFacade implements Subject {

	private final int AMOUNT_OF_DICE = 5;
	private PlayerGroup playerGroup = new PlayerGroup();
	private YahtzeeDice yathzeeDice = new YahtzeeDice(AMOUNT_OF_DICE);
	private ArrayList<Observer> observerList = new ArrayList<Observer>();

	Hashtable<Player, PlayerController> gamePains = new Hashtable<Player, PlayerController>();
	int groupsize;
	int turn;
	Player turnToPlayer;

	// TODO add PLayCon turn player
	public void regPlayer(String name, PlayerController playCon) {
		Player player = new Player(name);
		playerGroup.add(player);
		addPlayerAndPlaycon(player, playCon);
	}

	public void setStageCorrectly(Player player) {
		// setNextPlayerTurn();
		// de getNextPlayer bestond ql dus ge kunt die gewoon gebruiken
		// turnToPlayer = playerGroup.getNextPlayer();
		// PlayerController playcon = gamePains.get(turnToPlayer);
		// geen idee wa ge hiermee van plan waart dus ff in commentaar gezet
		List<Player> playersList = playerGroup.getList();
		for (Player p : playersList) {
			gamePains.get(p).disableStageUi();
		}
		gamePains.get(player).enableStageUi();
	}

	public void addPlayerAndPlaycon(Player player, PlayerController playCon) {
		// deze gaat alle buttons invisible zetten bij elke juist stage/ player
		// controller
		// TODO implementeren
		gamePains.put(player, playCon);
	}

	private void regPlayer(Player player) {
		playerGroup.add(player);
	}

	public Player createPlayer(String name) {
		Player player = new Player(name);
		regPlayer(player);
		return player;
	}

	public void throwDice() {
		yathzeeDice.ThrowDice();
		notiffy();
	}

	public int getAMOUNT_OF_DICE() {
		return AMOUNT_OF_DICE;
	}

	public ArrayList<Die> getDice() {
		return yathzeeDice.getDice();
	}

	public Player getActivePlayer() {
		return playerGroup.getActivePlayer();
	}

	public String getActivePlayerName() {
		return playerGroup.getActivePlayerName();
	}
	
	public void firstTurn() {
		Player player = getActivePlayer();
		setStageCorrectly(player);
	}
	public void nextPlayerTurn() {
		// deze functie moet alle stage disable 
		// en dan van de juiste speler visible maken 
		playerGroup.setNextPlayer();
		Player player = getActivePlayer();
		setStageCorrectly(player);
	}
	
	public void callCulatedScore() {
		
	}
	public void keepDie(Die die) {
		yathzeeDice.keepDie(die);
		notiffy();
	}

	public void PlayWithDie(Die die) {
		yathzeeDice.playWithDie(die);
		notiffy();
	}

	@Override
	public void add(Observer o) {
		observerList.add(o);
	}

	@Override
	public void remove(Observer o) {
		observerList.remove(o);
	}

	@Override
	public void notiffy() {
		for (Observer o : observerList) {
			o.update();
		}
	}
}