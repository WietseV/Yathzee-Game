package scoring;

import java.util.ArrayList;

import domain.Die;

public class Threes implements Catagory {

	@Override
	public Integer score(ArrayList<Die> dice) {
		Integer score = 0;
		for (Die die : dice) {
			if (die.getNumber() == 3) {
				score+=3;
			}
		}
		return score;
	}

}
