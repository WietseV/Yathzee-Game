package scoring;

import java.util.ArrayList;

import domain.Die;

public class Chance implements Catagory {
	 Integer score;
	@Override
	public void score(ArrayList<Die> dice) {
		score = 0;
		for (Die die : dice) {score += die.getNumber();}
	}

	@Override
	public Integer getScore() {
		return this.score;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Chance";
	}

}
