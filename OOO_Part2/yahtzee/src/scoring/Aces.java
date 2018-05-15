package scoring;

import java.util.ArrayList;

import domain.Die;

public class Aces implements Catagory {

	@Override
	public Integer score(ArrayList<Die> dice) {
		Integer score = 0;
		for (Die die : dice) {
			if (die.getNumber() == 1) {
				score++;
			}
		}
		return score;
	}

}
