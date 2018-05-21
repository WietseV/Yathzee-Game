package scoring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import domain.Die;

public class Yahtzee implements Catagory {
	Integer score;
	@Override
	public void score(ArrayList<Die> dice) {
		if (!validate(dice)) score = 0;
		score = 50;
	}
	
	
	public boolean validate(ArrayList<Die> dice) {
		Set<Integer> set = new HashSet<>();
		for (Die die : dice) {
			set.add(die.getNumber());
		}
		return (set.size()==1);
	}


	@Override
	public Integer getScore() {
		return this.score;
	}


	@Override
	public String getName() {
		return "Yahtzee";
	}


}
