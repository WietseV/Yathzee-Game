package scoring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import domain.Die;

public class FullHouse implements Catagory {
	@Override
	public Integer score(ArrayList<Die> dice) {
		if (!validate(dice)) return 0;
		return 25;
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

}
