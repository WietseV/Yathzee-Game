package domain;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import controller.PlayerController;
import scoring.Catagories;
import state.GameStageState;
import state.PlayStage;
import ui.Observer;

public class GameFacade implements Subject {

	private final int AMOUNT_OF_DICE = 5;
	private PlayerGroup playerGroup = new PlayerGroup();
	private YahtzeeDice yathzeeDice = new YahtzeeDice(AMOUNT_OF_DICE);
	private ArrayList<Observer> observerList = new ArrayList<Observer>();

	private Hashtable<Player, PlayerController> gamePanes = new Hashtable<Player, PlayerController>();
	private ScoreBoard currentPlayerScoreBoard;
	private int groupsize;
	private int turn = 3;

	private Player turnToPlayer;

	// TODO add PLayCon turn player
	public void regPlayer(String name, PlayerController playCon) {
		Player player = new Player(name);
		playerGroup.add(player);
		addPlayerAndPlaycon(player, playCon);
	}

	public void setStageCorrectly(Player player) {
		// setNextPlayerTurn();
		// de getNextPlayer bestond al dus ge kunt die gewoon gebruiken
		// turnToPlayer = playerGroup.getNextPlayer();
		// PlayerController playcon = gamePains.get(turnToPlayer);
		// geen idee wa ge hiermee van plan waart dus ff in commentaar gezet
		
		
		/*List<Player> playersList = playerGroup.getList();
		for (Player p : playersList) {
			gamePanes.get(p).setWatchState();
		}
		turn = 3;
		gamePanes.get(player).setPlayState();*/
		
		List<Player> playersList = playerGroup.getList();
		for (Player p : playersList) {
			if (gamePanes.get(p).getState() instanceof PlayStage);
		}
	}

	public void addPlayerAndPlaycon(Player player, PlayerController playCon) {
		// deze gaat alle buttons invisible zetten bij elke juist stage/ player
		// controller
		// TODO implementeren
		gamePanes.put(player, playCon);
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
		if (this.turn > 0) {
			yathzeeDice.ThrowDice();
			setTurn(--turn);
			notiffy();
		}else endPlayerTurn();
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
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

	public ScoreBoard getPlayerScorBoard() {
		currentPlayerScoreBoard = turnToPlayer.getScoreBoard();
		return currentPlayerScoreBoard;
	}

	public void firstTurn() {
		turnToPlayer = getActivePlayer();
		GameStageState state = gamePanes.get(turnToPlayer).getState();
		state.play();
	}

	public void nextPlayerTurn() {
		// deze functie moet alle stage disable
		// en dan van de juiste speler visible maken
		clearDice();
		GameStageState state = gamePanes.get(turnToPlayer).getState();
		state.watch();
		
		turn = 3;
		
		playerGroup.setNextPlayer();
		turnToPlayer = getActivePlayer();
		
		state = gamePanes.get(turnToPlayer).getState();
		state.play();
		
		
	}

	public void endPlayerTurn() {
		
		Player player = getActivePlayer();
		gamePanes.get(player).endTurnUi();
	}

	public void callCulatedScore(Catagories cat) throws Exception {
		turnToPlayer.calculateScore(cat, yathzeeDice);
	}

	public void keepDie(Die die) {
		yathzeeDice.keepDie(die);
		notiffy();
	}
	
	public void returnDie(Die die) {
		yathzeeDice.returnDie(die);
		notiffy();
	}

	public void PlayWithDie(Die die) {
		yathzeeDice.playWithDie(die);
		notiffy();
	}
	public void clearDice() {
		yathzeeDice.clear();
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
