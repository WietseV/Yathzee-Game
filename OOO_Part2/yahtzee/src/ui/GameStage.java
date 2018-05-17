package ui;

import java.util.ArrayList;

import controller.PlayerController;
import domain.Die;
import domain.GameFacade;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import scoring.Catagories;

public class GameStage implements Observer {

	private PlayerController playerController;
	private GameFacade game;
	private Stage primarystage = new Stage();
	private Button rollDiceButton = new Button("Roll Dice");
	private Label namePlayerTurn;
	private Label turn = new Label("De beurt is aan");
	private ArrayList<Button> buttons = new ArrayList<Button>();
	GridPane dicepane = new GridPane();
	private Button endTurnButton;
	private ComboBox<Catagories> combo;
	

	public GameStage(PlayerController playerController) {
		this.playerController = playerController;
		this.game = playerController.getGameFacade();
	}

	public void show() {
		initiateButtons();
		VBox root = addVBoxMain();
		Scene scene = new Scene(root, 800, 600);
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
		vbox.getChildren().add(rollDiceButton);
		rollDiceButton.setOnAction(new GameHandler());
		dicepane = addDice();
		vbox.getChildren().add(dicepane);
		combo = makeDropDown();
		vbox.getChildren().add(combo);
		endTurnButton = new Button("ok");
		endTurnButton.setOnAction(new EndTurn());
		vbox.getChildren().add(endTurnButton);
		return vbox;
	}

	public HBox addHboxTurn() {
		HBox box = new HBox();
		box.setSpacing(5);
		namePlayerTurn = new Label(game.getActivePlayerName());
		box.getChildren().add(turn);
		box.getChildren().add(namePlayerTurn);
		return box;
	}

	public void initiateButtons() {
		for (int i = 0; i < game.getAMOUNT_OF_DICE(); i++) {
			buttons.add(new Button(""));
		}
	}

	public GridPane addDice() {
		GridPane box = new GridPane();
		box.setHgap(20);
		box.setVgap(20);
		for (int i = 0; i < buttons.size(); i++) {
			box.add(buttons.get(i), i, 1);
			buttons.get(i).setOnAction(new SwitchHandler());
		}
		return box;
	}

	public void setDicePositions() {
		ArrayList<Die> dice = game.getDice();
		for (int i = 0; i < buttons.size(); i++) {
			if (!dice.get(i).isPlayable()) {
				dicepane.getChildren().remove(buttons.get(i));
				dicepane.add(buttons.get(i), i, 2);
			}
		}
	}

	public void showDice(ArrayList<Die> dice) {
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).setText(Integer.toString(dice.get(i).getNumber()));
		}
	}
	
	public ComboBox<Catagories> makeDropDown(){
	    ComboBox<Catagories> cbxStatus = new ComboBox<>();
	    cbxStatus.setItems( FXCollections.observableArrayList( Catagories.values()));
	    cbxStatus.getSelectionModel().selectFirst();
	    return cbxStatus;
	  }
	
	public void disableUI() {
		rollDiceButton.setVisible(false);
		rollDiceButton.setManaged(false);
		combo.setVisible(false);
		combo.setManaged(false);
		endTurnButton.setVisible(false);
		endTurnButton.setManaged(false);
//		dicepane.setVisible(false);
		dicepane.setMouseTransparent(true);
	}
	
	public void enableUI() {
		rollDiceButton.setVisible(true);
		rollDiceButton.setManaged(true);
		combo.setVisible(true);
		combo.setManaged(true);
		endTurnButton.setVisible(true);
		endTurnButton.setManaged(true);
//		dicepane.setVisible(true);
		dicepane.setMouseTransparent(false);
	}
	
	@Override
	public void update() {
		ArrayList<Die> dice = game.getDice();
		showDice(dice);
		setDicePositions();
		namePlayerTurn.setText(game.getActivePlayerName());
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
			ArrayList<Die> dice = game.getDice();
			int index = buttons.indexOf((Button) event.getSource());
			game.keepDie(dice.get(index));
		}
	}
	
	class EndTurn implements EventHandler<ActionEvent>{
		 
	    @Override
	    public void handle(ActionEvent event) {
	      //facade.nextPlayersTurn();
	      //TODO 
	      //1. Neem uw combobox value
	      //2.Krijg uw strategy score //Story5
	      //
	    	game.nextPlayerTurn();
	    	game.notiffy();
	    }
	    
	  }
}
