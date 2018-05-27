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
	private Integer maxTurn = 13;
	private Hashtable<Player, PlayerController> gamePanes = new Hashtable<Player, PlayerController>();
	private ScoreBoard currentPlayerScoreBoard;
	private int groupsize;
	private int turn = 3;
	private GameStageState state;
	private Player turnToPlayer;
	private Player winner;
	// TODO add PLayCon turn player
	public void regPlayer(String name, PlayerController playCon) {
		Player player = new Player(name);
		playerGroup.add(player);
		addPlayerAndPlaycon(player, playCon);
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
		state = gamePanes.get(turnToPlayer).getState();
		state.play();

	}

	public void nextPlayerTurn() {
	
		clearDice();
		
		state = gamePanes.get(turnToPlayer).getState();
		state.watch();
		
		turn = 3;
		
		playerGroup.setNextPlayer();
		turnToPlayer = getActivePlayer();
		
		state = gamePanes.get(turnToPlayer).getState();
		if (maxTurn == gamePanes.get(turnToPlayer).getTurnNumber()) state.end();
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
	
	public Player getWinner() {
		if ( winner == null) setWinner();
		return winner;
	}
	
	private void setWinner() {
		winner = playerGroup.getWinner();
	}

	public void endTheGame() {
		if (!playerGroup.getList().isEmpty()) {
			
			playerGroup.setNextPlayer();
			
			turnToPlayer = getActivePlayer();
			playerGroup.removePlayer(turnToPlayer);
			
			state = gamePanes.get(turnToPlayer).getState();
			state.end();
		}
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
