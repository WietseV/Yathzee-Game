package ui;

import java.util.ArrayList;
import java.util.List;

import controller.PlayerController;
import domain.Die;
import domain.GameFacade;

import domain.YahtzeeDice;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import scoring.Catagories;

public class GameStage implements Observer {
	/*
	 * Aangezien de gamestage hetgene is wat moet update als een andere speler gooit
	 * wordt dit de observer. De subject is dan game. Denk ik. of misschien wel
	 * player controller. dit moet ik nog beter bekijken.
	 */
	PlayerController playerController;
	Label namePlayerTurn;
	Label turn;
	ArrayList<Button> buttons = new ArrayList<Button>();
	Button rollDiceButton;
	Stage primarystage;
	private GameFacade game;
	HBox keptDice= new HBox();
	Button endTurnButton;
	public GameStage(PlayerController playerController) {
		this.playerController = playerController;
		this.game = playerController.getGameFacade();
	}
	/*
	 * Ik gebruik een vbox zodat alle elementen onder elkaar komen en ik steek er
	 * een hbox tussen zodat twee labels langs elkaar staan
	 */
	// TODO scene en stage aanmaken hehe
	// ik weet niet hoe alles werkt

	public void show() {

		/* hier komt een dobbelstenen pane */
		/* play button met een actionhandeler toevoegen voor dobbelenstenen te gooien */
		primarystage = new Stage();
		initiateButtons();
		VBox root = addVBoxMain();
		Scene scene = new Scene(root, 400, 400);
		primarystage.setScene(scene);
		primarystage.setTitle(playerController.getPlayerName());
		primarystage.show();

	}

	public VBox addVBoxMain() {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10));
		vbox.setSpacing(8);
		HBox hBox = addHboxTurn();
		vbox.getChildren().add(hBox);
		rollDiceButton = new Button("Roll Dice");
		vbox.getChildren().add(rollDiceButton);
		rollDiceButton.setOnAction(new GameHandler());
		HBox dice = addDice(); 
		HBox otherDice = keptDice;
		vbox.getChildren().add(dice);
		vbox.getChildren().add(otherDice);
		ComboBox<Catagories> combo = makeDropDown();
		vbox.getChildren().add(combo);
		
		endTurnButton = new Button("ok");
		endTurnButton.setOnAction(new EndTurn());
		vbox.getChildren().add(endTurnButton);
		return vbox;
	}

	public HBox addHboxTurn() {
		HBox box = new HBox();
		box.setSpacing(5);
		turn = new Label("De beurt is aan");
		namePlayerTurn = new Label(game.getActivePlayer());
		
		box.getChildren().add(turn);
		box.getChildren().add(namePlayerTurn);
		return box;
	}
	
	public void initiateButtons() {
		Button dice1 = new Button("");
		Button dice2= new Button("");
		Button dice3= new Button("");
		Button dice4= new Button("");
		Button dice5= new Button("");
		buttons.add(dice1);
		buttons.add(dice2);
		buttons.add(dice3);
		buttons.add(dice4);
		buttons.add(dice5);
	}

	public HBox addDice() {
		HBox box = new HBox();
		for (Button button: buttons) {
			box.getChildren().add(button);
			button.setOnAction(new SwitchHandler());
		}
		return box;
	}
	
	public ComboBox<Catagories> makeDropDown(){
		ComboBox<Catagories> cbxStatus = new ComboBox<>();
		cbxStatus.setItems( FXCollections.observableArrayList( Catagories.values()));
		cbxStatus.getSelectionModel().selectFirst();
		return cbxStatus;
	}
	
	public void addDiceToSecondRow(Button button) {
		keptDice.getChildren().add(button);
	}
	
	@Override
	public void update() {
		ArrayList<Die> dice = game.getDice();
		showDice(dice);
		
	}

	public void showDice(ArrayList<Die> dice) {
		for (int i = 0; i < buttons.size();i++) {
			buttons.get(i).setText(Integer.toString(dice.get(i).getNumber()));
		}
	}

	class GameHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			game.throwDice();
			ArrayList<Die> dice = game.getDice();
			showDice(dice);
		}

	}
	class SwitchHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			addDiceToSecondRow((Button)event.getSource());
			ArrayList<Die> dice = game.getDice();
			int index = buttons.indexOf((Button)event.getSource());
			game.keepDie(dice.get(index));

		}

	}
	
	class EndTurn implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			
			//TODO 
			//1. Neem uw combobox value
			//2.Krijg uw strategy score //Story5
			//
		}
		
	}
}
