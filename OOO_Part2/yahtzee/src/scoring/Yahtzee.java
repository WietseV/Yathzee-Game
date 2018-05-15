package scoring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import domain.Die;

public class Yahtzee implements Catagory {

	@Override
	public Integer score(ArrayList<Die> dice) {
		if (!validate(dice)) return 0;
		return 50;
	}
	
	
	public boolean validate(ArrayList<Die> dice) {
		Set<Integer> set = new HashSet<>();
		for (Die die : dice) {
			set.add(die.getNumber());
		}
		return (set.size()==1);
	}


}
