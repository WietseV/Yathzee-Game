package scoring;

import java.util.ArrayList;

import domain.Die;

public class Fives implements Catagory {

	@Override
	public Integer score(ArrayList<Die> dice) {
		Integer score = 0;
		for (Die die : dice) {
			if (die.getNumber() == 5) {
				score+=5;
			}
		}
		return score;
	}

}
