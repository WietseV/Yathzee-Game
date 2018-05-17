package domain;

import java.util.*;

public class PlayerGroup {
	
	private List<Player> playerList = new ArrayList<Player>();
	private int currentActivePlayer = 0;
	private int nextPlayer = 1;

	public void add(Player player) {
		playerList.add(player);
	}
	
	public List<Player> getList() {
		return playerList;
	}
	
	public Player getFirstPlayer() {
		return playerList.get(0);
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
}
