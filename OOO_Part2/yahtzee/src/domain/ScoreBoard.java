package domain;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import scoring.Catagories;
import scoring.Catagory;

public class ScoreBoard {

	ObservableList<Catagory> data = FXCollections.observableArrayList();
	HashSet<String> takenScores = new HashSet<String>();
	
	public void setScore(Catagory cat) throws Exception {
		if(takenScores.add(cat.getName())) data.add(cat);
		else throw new Exception();
	}

	public ObservableList<Catagory> getDataList() {
		return this.data;
	}
	
	public Integer getTotalScore() {
		Integer totalPoints = 0;
		for (Catagory cat: data) {
			totalPoints += cat.getScore();
		}
		return totalPoints;
	}
}
