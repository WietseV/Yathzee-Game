package scoring;

import java.util.ArrayList;

import domain.Die;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class FourOfAKind implements Catagory {
	SimpleIntegerProperty scored = new SimpleIntegerProperty(0);
	SimpleStringProperty name = new SimpleStringProperty("FOUR_OF_A_KIND");
	@Override
	public void score(ArrayList<Die> dice) {
		int score = 0;
		if (!validate(dice)) score =0 ;
		else for (Die die : dice) score += die.getNumber();
		
		scored.set(score);
	}
	
	
	public boolean validate(ArrayList<Die> dice) {
		for (int i = 1; i <= 6; i++) {
			int count = 0;
			for (int j = 0; j < 5; j++) {
				if (dice.get(j).getNumber() == i) {
					count++;
				}
				if (count > 3) {
					return true;
				}
			}
		}
		
		return false;
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
