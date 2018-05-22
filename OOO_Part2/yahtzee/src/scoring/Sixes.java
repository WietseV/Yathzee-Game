package scoring;

import java.util.ArrayList;

import domain.Die;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Sixes implements Catagory {
	SimpleIntegerProperty scored = new SimpleIntegerProperty(0);
	SimpleStringProperty name = new SimpleStringProperty("SIXES");
	@Override
	public void score(ArrayList<Die> dice) {
		int score = 0;
		for (Die die : dice) {
			if (die.getNumber() == 6) {
				score+=6;
			}
		}
		scored.set(score);
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
