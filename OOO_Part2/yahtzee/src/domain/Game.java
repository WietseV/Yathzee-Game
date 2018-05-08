package domain;

public class Game {
	
	PlayerGroup playerGroup = new PlayerGroup();

	public void regPlayer(String name){
		Player player = new Player(name);
		playerGroup.add(player);
	}
}


