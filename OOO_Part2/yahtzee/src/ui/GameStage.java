package ui;

import java.util.ArrayList;

import controller.PlayerController;
import domain.Die;
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
	Label dice1;
	Label dice2;
	Label dice3;
	Label dice4;
	Label dice5;
	Button rollDiceButton;
	Stage primarystage;
	public GameStage(PlayerController playerController) {
		this.playerController = playerController;
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
		HBox dobbelstenen = addDobbelstenen();
		vbox.getChildren().add(dobbelstenen);
		return vbox;
	}

	public HBox addHboxTurn() {
		HBox box = new HBox();
		box.setSpacing(5);
		turn = new Label("De beurt is aan");
		namePlayerTurn = new Label(playerController.getPlayerName());
		box.getChildren().add(turn);
		box.getChildren().add(namePlayerTurn);
		// TODO methode aanmaken die laat zien aan wie het de beurt is.
		return box;
	}

	public HBox addDobbelstenen() {
		HBox box = new HBox();
		box.getChildren().add(dice1);
		box.getChildren().add(dice2);
		box.getChildren().add(dice3);
		box.getChildren().add(dice4);
		box.getChildren().add(dice5);

		return box;
	}

	@Override
	public void update() {
		// TODO wanner en hoe update 
		
	}

	public void updateSteen(ArrayList<Die> dice) {
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
			// TODO
			// player.throwDice();
			// ArrayLis<Die> dice = player.getDice();
			// updateSteen(dice)

		}

	}
}
