package domain;

import java.util.*;

public class PlayerGroup {
	
	private List<Player> playerList = new ArrayList<Player>();
	private int currentActivePlayer = 0;
	private int nextPlayer = 1;
	private Player winner;

	public void add(Player player) {
		playerList.add(player);
	}
	
	public List<Player> getList() {
		return playerList;
	}
	
	public Player getFirstPlayer() {
		return playerList.get(0);
	}
	public void removePlayer(Player player) {
		playerList.remove(player);
	}
	public void setNextPlayer() {
		currentActivePlayer = nextPlayer;
		if (nextPlayer < playerList.size()-1) {
			nextPlayer++;
		} else {
			nextPlayer = 0;
		}
	}

	public Player getActivePlayer() {
		return playerList.get(currentActivePlayer);
	}
	
	public String getActivePlayerName() {
		return playerList.get(currentActivePlayer).getName();
	}
	
	public Player getWinner() {
		
		for(Player p :playerList) {
			if (winner == null ) winner = p;
			else if (winner.getScore() < p.getScore() ) winner = p;
		}
		return winner;
	}
}
