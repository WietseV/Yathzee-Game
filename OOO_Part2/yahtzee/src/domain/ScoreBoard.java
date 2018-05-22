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
	public void setScore(Catagory cat) {
		if(takenScores.add(cat.getName())) data.add(cat);
		
	}

	public ObservableList<Catagory> getDataList() {
		return this.data;
	}
}
