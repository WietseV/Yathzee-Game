package domain;

import scoring.Catagories;

import java.util.ArrayList;



import scoring.*;

public class Player {

	private String name;
	private ScoreFactory scoreFactory= new ScoreFactory();
	private ScoreBoard scoreBoard = new ScoreBoard();
	
	public Player(String name) {
		setName(name);
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void calculateScore (Catagories cat, YahtzeeDice diceeee) throws Exception {
		Catagory cata = scoreFactory.getCata(cat);
		ArrayList<Die> dice = diceeee.getDice();
		cata.score(dice);
		scoreBoard.setScore(cata);
	}
	
	public ScoreBoard getScoreBoard() {
		return this.scoreBoard;
	}
	
	public Integer getScore() {
		return scoreBoard.getTotalScore();
	}
}
