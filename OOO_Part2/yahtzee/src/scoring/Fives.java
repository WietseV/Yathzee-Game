package scoring;

import java.util.ArrayList;

import domain.Die;

public class Fives implements Catagory {
	Integer score;
	@Override
	public void score(ArrayList<Die> dice) {
		score = 0;
		for (Die die : dice) {
			if (die.getNumber() == 5) {
				score+=5;
			}
		}
	}
	@Override
	public Integer getScore() {
		return this.score;
	}
	@Override
	public String getName() {
		return "Fives";
	}

}
