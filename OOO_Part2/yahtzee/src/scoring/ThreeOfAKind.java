package scoring;

import java.util.ArrayList;

import domain.Die;

public class ThreeOfAKind implements Catagory {

	@Override
	public Integer score(ArrayList<Die> dice) {
		if (!validate(dice)) return 0;
		Integer score = 0;
		for (Die die : dice) {score += die.getNumber();}
		return score;
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

}
