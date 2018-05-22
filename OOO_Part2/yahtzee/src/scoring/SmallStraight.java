package scoring;

import java.util.ArrayList;
import java.util.Collections;

import domain.Die;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SmallStraight implements Catagory {
	SimpleIntegerProperty scored = new SimpleIntegerProperty(0);
	SimpleStringProperty name = new SimpleStringProperty("SmallStraight");
	@Override
	public void score(ArrayList<Die> dice) {
		int score;
		if (!validate(dice)) score = 0;
		score = 30;
		scored.set(score);
	}
	
	
	public boolean validate(ArrayList<Die> dice) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int counter = 0;
		for (Die die : dice) {
			list.add(die.getNumber());
		}
		Collections.sort(list);
		
		for (int i = 0; i < list.size() - 1; i++)
	      {
	          if (list.get(i+1) == list.get(i)+ 1)
	          {
	              counter++;
	          }
	          else if (list.get(i+1) == list.get(i))
	          {
	              continue;
	          }
	          else
	          {
	              counter = 0;
	          }
	          if (counter == 3) return true;
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
