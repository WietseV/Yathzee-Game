package domain;

public class Game {
	
	PlayerGroup playerGroup = new PlayerGroup();

	public void regPlayer(String name){
		playerGroup.add(name);
	}
}


