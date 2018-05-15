package scoring;

import java.util.ArrayList;

import domain.Die;

public interface Catagory {

	public abstract Integer score(ArrayList<Die> dice);
}
