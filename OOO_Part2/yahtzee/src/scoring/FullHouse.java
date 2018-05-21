package scoring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import domain.Die;

public class FullHouse implements Catagory {
	Integer score;
	@Override
	public void score(ArrayList<Die> dice) {
		if (!validate(dice)) this.score = 0;
		this.score = 25;
	}
	
	
	public boolean validate(ArrayList<Die> dice) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (Die die : dice) {
			list.add(die.getNumber());
		}
		Collections.sort(list);
		Set<Integer> set = new HashSet<>();
		for (int i : list) {
		    set.add(i);
		}
		return ((set.size() == 2) && (list.get(0) == list.get(1)) && (list.get(3) == list.get(4)));
	}


	@Override
	public Integer getScore() {
		return this.score;
	}


	@Override
	public String getName() {
		return "FullHouse";
	}

}
