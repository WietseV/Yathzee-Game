package ui;

import java.util.ArrayList;

import controller.PlayerController;
import domain.Die;
import domain.GameFacade;
import domain.YahtzeeDice;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameStage implements Observer {
	/*
	 * Aangezien de gamestage hetgene is wat moet update als een andere speler gooit
	 * wordt dit de observer. De subject is dan game. Denk ik. of misschien wel
	 * player controller. dit moet ik nog beter bekijken.
	 */
	PlayerController playerController;
	Label namePlayerTurn;
	Label turn;
	Button dice1 = new Button("");
	Button dice2= new Button("");
	Button dice3= new Button("");
	Button dice4= new Button("");
	Button dice5= new Button("");
	Button rollDiceButton;
	Stage primarystage;
	private GameFacade game;
	
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
		vbox.getChildren().add(dice);
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

	public HBox addDice() {
		HBox box = new HBox();
		box.getChildren().add(dice1);
		box.getChildren().add(dice2);
		box.getChildren().add(dice3);
		box.getChildren().add(dice4);
		box.getChildren().add(dice5); 
		return box;
	}
	
	public HBox addDiceToSecondRow(Button button) {
		HBox box = new HBox();
		box.getChildren().add(button);
		return box;
	}

	@Override
	public void update() {
		ArrayList<Die> dice = game.getDice();
		updateDice(dice);
		
	}

	public void updateDice(ArrayList<Die> dice) {
		// UPDATE STEEN	 wordt opgeroepen als er op de button word gepushed 
		this.dice1.setText(Integer.toString(dice.get(0).getNumber()));
		this.dice2.setText(Integer.toString(dice.get(1).getNumber()));
		this.dice3.setText(Integer.toString(dice.get(2).getNumber()));
		this.dice4.setText(Integer.toString(dice.get(3).getNumber()));
		this.dice5.setText(Integer.toString(dice.get(4).getNumber()));
		// TODO -> dit kan veel beter.. stel dat ik nu 7 stenen heb, moet ik weer een
		// steen toevoegen.
	}

	class GameHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			// TODO eerst de stenen gooien. vb code die nu anders moet aangezien player geen eigen 
			//	stenen heeft.
			
			game.throwDice();
			ArrayList<Die> dice = game.getDice();
			updateDice(dice);
			game.notiffy();
			// player.throwDice();
			// ArrayLis<Die> dice = player.getDice();
			// updateSteen(dice)
			
			// dit is hoe ik denk dat het er uit moet zien. 
			// heb nu mijn

		}

	}
}
