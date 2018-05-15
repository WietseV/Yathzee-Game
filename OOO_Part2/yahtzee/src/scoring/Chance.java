package scoring;

import java.util.ArrayList;

import domain.Die;

public class Chance implements Catagory {

	@Override
	public Integer score(ArrayList<Die> dice) {
		Integer score = 0;
		for (Die die : dice) {score += die.getNumber();}
		return score;
	}

}
