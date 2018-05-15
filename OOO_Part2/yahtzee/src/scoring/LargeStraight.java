package scoring;

import java.util.ArrayList;
import java.util.Collections;

import domain.Die;

public class LargeStraight implements Catagory {

	@Override
	public Integer score(ArrayList<Die> dice) {
		if (!validate(dice)) return 0;
		return 40;
	}
	
	
	public boolean validate(ArrayList<Die> dice) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (Die die : dice) {
			list.add(die.getNumber());
		}
		Collections.sort(list);
		
		return (
				(
					list.get(0) == 1 &&
					list.get(1) == 2 && 				
					list.get(2) == 3 &&
					list.get(3) == 4 && 
					list.get(4) == 5 
				)
				||
				(
					list.get(0) == 2 &&
					list.get(1) == 3 && 				
					list.get(2) == 4 &&
					list.get(3) == 5 && 
					list.get(4) == 6 
				
				)
			);
	}

}
