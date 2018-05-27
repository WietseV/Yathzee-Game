package scoring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import domain.Die;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class FullHouse implements Catagory {
	SimpleIntegerProperty scored = new SimpleIntegerProperty(0);
	SimpleStringProperty name = new SimpleStringProperty("FULLHOUSE");
	@Override
	public void score(ArrayList<Die> dice) {
		int score;
		if (!validate(dice)) score = 0;
		else score = 25;
		scored.set(score);
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
		return scored.get();
	}


	@Override
	public String getName() {
		return name.get();
	}

}
