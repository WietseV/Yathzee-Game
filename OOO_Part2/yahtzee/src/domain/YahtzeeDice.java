package domain;

import java.util.ArrayList;

public class YahtzeeDice {

	private ArrayList<Die> dice = new ArrayList<Die>();
	private ArrayList<Die> savedDice = new ArrayList<Die>();
	private ArrayList<Die> playableDice = new ArrayList<Die>();
	private int amountOfDice = 0;

	public YahtzeeDice(int amountOfDice) {
		setDice(amountOfDice);
	}

	public int getAmountOfDice() {
		return amountOfDice;
	}

<<<<<<< HEAD
		dice.add(dieOne);
		dice.add(dieTwo);
		dice.add(dieTree);
		dice.add(dieFour);
		dice.add(dieFive);
		
		for (Die die: dice) {
			setStandaard(die);
		}
=======
	public void setAmountOfDice(int amountOfDice) {
		this.amountOfDice = amountOfDice;
>>>>>>> master
	}

	public void ThrowDice() {
		for (Die die : dice) {
			if (die.isPlayable())
				die.throwDie();
		}
	}

	public ArrayList<Die> getDice() {
		return dice;
	}

	private void setDice(int amountOfDice) {
		for (int i = 0; i < amountOfDice; i++) {
			dice.add(new Die());
		}
	}

	public void keepDie(Die die) {
		playableDice.remove(die);
		savedDice.add(die);
		die.setPlayable(false);
	}
	
<<<<<<< HEAD
	public void setStandaard(Die die) {
		die.setNumber(1);
	}
	
=======
	public void returnDie(Die die) {
		playableDice.add(die);
		savedDice.remove(die);
		die.setPlayable(true);
	}
	

	public void playWithDie(Die die) {
		savedDice.remove(die);
		playableDice.add(die);
		die.setPlayable(true);
	}

	
	
	public void clear() {
		for (Die die: dice) {
			die.setNumber(0);
		}
		for (Die die: savedDice) {
			die.setNumber(0);

		}
		for (Die die: playableDice) {
			die.setNumber(0);

		}
	}
>>>>>>> master
}
