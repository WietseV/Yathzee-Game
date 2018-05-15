package domain;

import java.util.Random;

public class Die {

	private int number;
	Random randomGen = new Random();
	boolean playable = true;
	
	public void throwDie() {
		setNumber(randomGen.nextInt(6) + 1);
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public boolean isPlayable() {
		return playable;
	}
	public void setPlayable(boolean playable) {
		this.playable = playable;
	}
	
	
}
