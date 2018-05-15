package scoring;

import java.util.ArrayList;

import domain.Die;

public class Twos implements Catagory {

	@Override
	public Integer score(ArrayList<Die> dice) {
		Integer score = 0;
		for (Die die : dice) {
			if (die.getNumber() == 2) {
				score+=2;
			}
		}
		return score;
	}

}
