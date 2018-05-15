package scoring;

import java.util.ArrayList;

import domain.Die;

public class Fours implements Catagory {

	@Override
	public Integer score(ArrayList<Die> dice) {
		Integer score = 0;
		for (Die die : dice) {
			if (die.getNumber() == 4) {
				score+=4;
			}
		}
		return score;
	}

}
