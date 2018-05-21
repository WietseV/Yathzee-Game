package scoring;

import java.util.ArrayList;

import domain.Die;

public class Twos implements Catagory {
	Integer score;
	@Override
	public void score(ArrayList<Die> dice) {
		Integer score = 0;
		for (Die die : dice) {
			if (die.getNumber() == 2) {
				score+=2;
			}
		}
	}

	@Override
	public Integer getScore() {
		return score;
	}

	@Override
	public String getName() {
		return "Twos";
	}

}
