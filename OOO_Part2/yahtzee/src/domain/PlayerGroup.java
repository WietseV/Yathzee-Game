package domain;

import java.util.*;

public class PlayerGroup {
	
	private List<Player> playerList = new ArrayList<Player>();

	public void add(Player player) {
		playerList.add(player);
	}
	
	public List<Player> getList() {
		return playerList;
	}
}
