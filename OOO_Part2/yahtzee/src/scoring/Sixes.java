package scoring;

import java.util.ArrayList;

import domain.Die;

public class Sixes implements Catagory {

	@Override
	public Integer score(ArrayList<Die> dice) {
		Integer score = 0;
		for (Die die : dice) {
			if (die.getNumber() == 6) {
				score+=6;
			}
		}
		return score;
	}

}
