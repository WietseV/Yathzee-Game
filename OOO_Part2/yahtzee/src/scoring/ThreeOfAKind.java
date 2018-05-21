package scoring;

import java.util.ArrayList;

import domain.Die;

public class ThreeOfAKind implements Catagory {
	Integer score;
	@Override
	public void score(ArrayList<Die> dice) {
		if (!validate(dice)) score = 0;
		score = 0;
		for (Die die : dice) {score += die.getNumber();}
	}
	
	
	public boolean validate(ArrayList<Die> dice) {
		for (int i = 1; i <= 6; i++) {
			int count = 0;
			for (int j = 0; j < 5; j++) {
				if (dice.get(j).getNumber() == i) {
					count++;
				}
				if (count > 2) {
					return true;
				}
			}
		}
		
		return false;
	}


	@Override
	public Integer getScore() {
		return this.score;
	}


	@Override
	public String getName() {
		return "ThreeOfAKind";
	}

}
