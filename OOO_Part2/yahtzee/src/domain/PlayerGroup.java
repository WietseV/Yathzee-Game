package domain;

import java.util.*;

public class PlayerGroup {
	
	private List<Player> playerList = new ArrayList<Player>();
	private int currentActivePlayer = 0;

	public void add(Player player) {
		playerList.add(player);
	}
	
	public List<Player> getList() {
		return playerList;
	}
	
	public Player getFirstPlayer() {
		return playerList.get(0);
	}
	
	public Player getNextPlayer() {
		if (currentActivePlayer < playerList.size()) {
			currentActivePlayer++;
			Player player = playerList.get(currentActivePlayer);
			return player;
		} else {
			currentActivePlayer = 0;
			Player player = playerList.get(currentActivePlayer);
			return player;
		}
	}

	public String getActivePlayer() {
		return playerList.get(currentActivePlayer).getName();
	}
}
