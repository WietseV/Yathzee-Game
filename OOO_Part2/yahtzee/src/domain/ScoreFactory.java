package domain;

import scoring.*;

public class ScoreFactory {

	public Catagory getCata(Catagories cat) {
		Catagory cata = null;

		if (cat == Catagories.ACES) {
			cata = new Aces();
		} else if (cat == Catagories.CHANCE) {
			cata = new Chance();
		} else if (cat == Catagories.FIVES) {
			cata = new Fives();
		} else if (cat == Catagories.FOUR_OF_A_KIND) {
			cata = new FourOfAKind();
		} else if (cat == Catagories.FOURS) {
			cata = new Fours();
		} else if (cat == Catagories.FULL_HOUSE) {
			cata = new FullHouse();
		} else if (cat == Catagories.LARGE_STRAIGHT) {
			cata = new LargeStraight();
		} else if (cat == Catagories.SIXES) {
			cata = new Sixes();
		} else if (cat == Catagories.SMALL_STRAIGHT) {
			cata = new SmallStraight();
		} else if (cat == Catagories.THREE_OF_A_KIND) {
			cata = new ThreeOfAKind();
		} else if (cat == Catagories.THREES) {
			cata = new Threes();
		} else if (cat == Catagories.TWOS) {
			cata = new Twos();
		} else if (cat == Catagories.YAHTZEE) {
			cata = new Yahtzee();
		}

		return cata;

	}
}
