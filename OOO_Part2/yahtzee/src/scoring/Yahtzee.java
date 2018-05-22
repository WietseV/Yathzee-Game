package scoring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import domain.Die;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Yahtzee implements Catagory {
	SimpleIntegerProperty scored = new SimpleIntegerProperty(0);
	SimpleStringProperty name = new SimpleStringProperty("Yathzee");
	@Override
	public void score(ArrayList<Die> dice) {
		int score;
		if (!validate(dice)) score = 0;
		else score = 50;
		scored.set(score);
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
		return scored.get();
	}


	@Override
	public String getName() {
		return name.get();
	}


}
