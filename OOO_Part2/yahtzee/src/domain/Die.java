package domain;

import java.util.Random;

public class Die {

	private int number;
	Random randomGen = new Random();
	
	public void throwDie() {
		setNumber(randomGen.nextInt(6) + 1);
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
