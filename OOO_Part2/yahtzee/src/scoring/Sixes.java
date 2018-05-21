package scoring;

import java.util.ArrayList;

import domain.Die;

public class Sixes implements Catagory {
	Integer score;
	@Override
	public void score(ArrayList<Die> dice) {
		score = 0;
		for (Die die : dice) {
			if (die.getNumber() == 6) {
				score+=6;
			}
		}
	}
	@Override
	public Integer getScore() {
		return this.score;
	}
	@Override
	public String getName() {
		return "Sixes";
	}

}
