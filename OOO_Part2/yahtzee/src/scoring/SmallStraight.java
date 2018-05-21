package scoring;

import java.util.ArrayList;
import java.util.Collections;

import domain.Die;

public class SmallStraight implements Catagory {
	Integer score;
	@Override
	public void score(ArrayList<Die> dice) {
		if (!validate(dice)) score = 0;
		score = 30;
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
		return this.score;
	}


	@Override
	public String getName() {
		return "SmallStraight";
	}
}
