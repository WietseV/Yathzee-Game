package scoring;

import java.util.ArrayList;

import domain.Die;

public class Threes implements Catagory {
	Integer score;
	@Override
	public void score(ArrayList<Die> dice) {
		score = 0;
		for (Die die : dice) {
			if (die.getNumber() == 3) {
				score+=3;
			}
		}
	}
	@Override
	public Integer getScore() {
		return this.score;
	}
	@Override
	public String getName() {
		return "Threes";
	}

}
