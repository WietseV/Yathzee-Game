package ui;

import controller.PlayerController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameStage  implements Observer{
	/* Aangezien de gamestage hetgene is wat moet update als een andere speler gooit
	 * wordt dit de observer. De subject is dan game. Denk ik. of misschien wel player controller. dit moet
	 * ik nog beter bekijken. */
	PlayerController playerController;
	Label namePlayerTurn;
	Label turn;
	Button button;
	
	public GameStage (PlayerController playerController) {
		this.playerController = playerController;
	}
	/*Ik gebruik een vbox zodat alle elementen onder elkaar komen
	 * en ik steek er een hbox tussen zodat twee labels langs elkaar staan
	 * */
	// TODO scene en stage aanmaken hehe 
	// ik weet niet hoe alles werkt
	
	
	public void show() {
		
		/*hier komt een dobbelstenen pane */
		/*play button met een actionhandeler toevoegen voor dobbelenstenen te gooien*/
		Stage primarystage = new Stage();
		VBox root = addVBoxMain();
		Scene scene = new Scene(root,400,400);
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
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
