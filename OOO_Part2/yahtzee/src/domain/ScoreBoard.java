package domain;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import scoring.Catagories;
import scoring.Catagory;

public class ScoreBoard {
	
	ArrayList<Catagory> sortScoring;
	//try 
		ObservableList<Catagory> data = FXCollections.observableArrayList();
	public ScoreBoard() {
		//sortScoring = new ArrayList<Catagories>(EnumSet.allOf(Catagories.class));
		sortScoring = new ArrayList<Catagory>();
	}
	
	public void setScore(Catagory cat) {
		sortScoring.add(cat);
		data.add(cat);
	}
	
	public ArrayList<Catagory> getListPoints(){
		return this.sortScoring;
	}
	
	public ObservableList<Catagory> getDataList(){
		return this.data;
	}
}
