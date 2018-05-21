package scoring;

import java.util.ArrayList;

import domain.Die;

public interface Catagory {
	Integer score = null;
	public abstract void score(ArrayList<Die> dice);
	public abstract Integer getScore();
	public abstract String getName();
	
}
