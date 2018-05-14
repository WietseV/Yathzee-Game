package domain;

import java.util.ArrayList;

public class YahtzeeDice {

	/* Deze klassen dient ervoor op de 5 dobbelstenen te creeeren */

	// ik weet niet als het handig is om ofwel telkens een nieuwe instansie te maken
	// van
	// yathzeedice voor elke worp of gewoon dat de stenen worden aangepast.
	// ik ga het nu bij het 2e houden. stenen worden aangepast.
	ArrayList<Die> dice = new ArrayList<Die>();

	public YahtzeeDice() {
		setDice();
	}

	public void ThrowDice() {
		for (Die die : dice) {
			die.throwDie();
		}
	}

	public ArrayList<Die> getDice() {
		return dice;
	}
	
	private void setDice() {
		Die dieOne = new Die();
		Die dieTwo = new Die();
		Die dieTree = new Die();
		Die dieFour = new Die();
		Die dieFive = new Die();

		dice.add(dieOne);
		dice.add(dieTwo);
		dice.add(dieTree);
		dice.add(dieFour);
		dice.add(dieFive);
	}
	
}
