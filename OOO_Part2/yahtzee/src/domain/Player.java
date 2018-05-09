package domain;

import java.util.ArrayList;

public class Player {

	private String name;
	private YahtzeeDice dice;

	public Player(String name) {
		setName(name);
		setDice(new YahtzeeDice());
	}

	private void setName(String name) {
		this.name = name;
	}

	

	public void setDice(YahtzeeDice dice) {
		this.dice = dice;
	}

	/*public void throwDice() {
		dice.generateDice();
	}*/
	
	/*public  ArrayList<Die> getDice() {  // je krijgt een array terug van 6 dobbelstenen 
	return dice.getDice();
	}*/

}
