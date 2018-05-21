package domain;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import scoring.Catagories;
import scoring.Catagory;

public class ScoreBoard {

	ArrayList<Catagory> sortScoring;
	public ScoreBoard() {
		//sortScoring = new ArrayList<Catagories>(EnumSet.allOf(Catagories.class));
		sortScoring = new ArrayList<Catagory>();
	}
	
	public void setScore(Catagory cat) {
		sortScoring.add(cat);
	}
}
