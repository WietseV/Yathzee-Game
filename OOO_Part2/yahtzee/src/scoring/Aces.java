package scoring;

import java.util.ArrayList;

import domain.Die;

public class Aces implements Catagory {
	Integer score = 0;
	@Override
	public void score(ArrayList<Die> dice) {
		score = 0;
		for (Die die : dice) {
			if (die.getNumber() == 1) {
				score++;
			}
		}
	}

	@Override
	public Integer getScore() {
		return this.score;
		
	}

	@Override
	public String getName() {
		return "ACES";
	}

}
