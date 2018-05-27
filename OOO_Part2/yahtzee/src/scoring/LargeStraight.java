package scoring;

import java.util.ArrayList;
import java.util.Collections;

import domain.Die;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class LargeStraight implements Catagory {
	SimpleIntegerProperty scored = new SimpleIntegerProperty(0);
	SimpleStringProperty name = new SimpleStringProperty("LARGE_STRAIGHT");
	@Override
	public void score(ArrayList<Die> dice) {
		int score;
		if (!validate(dice)) score = 0;
		else score = 40;
		scored.set(score);
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


	@Override
	public Integer getScore() {
		return scored.get();
	}


	@Override
	public String getName() {
		return name.get();
	}

}
