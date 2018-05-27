package ui;

import controller.PlayerController;
import domain.Player;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EndScreenStage {
	
	
	// TODO hier komt dan een layout van wie heeft gewonnen en hoe het er uit ziet
	private Stage primarystage = new Stage();
	private Label labelWinner;
	private Player winningPlayer;
	private PlayerController playerController;
	
	public EndScreenStage(Player player, PlayerController playerController) {
		setWinningPlayer(player);
		setPlayerController(playerController);
		show();
	}
	
	public Player getWinningPlayer() {
		return winningPlayer;
	}

	public void setWinningPlayer(Player winningPlayer) {
		this.winningPlayer = winningPlayer;
	}

	public PlayerController getPlayerController() {
		return playerController;
	}

	public void setPlayerController(PlayerController playerController) {
		this.playerController = playerController;
	}

	public void show() {
		HBox root = createRoot();
		Scene scene = new Scene(root, 800, 600);
		primarystage.setScene(scene);
		primarystage.setTitle(playerController.getPlayerName());
		primarystage.show();

	}

	private HBox createRoot() {
		HBox box = new HBox();
		labelWinner = new Label("The winner is " + winningPlayer.getName());
		box.getChildren().add(labelWinner);
		return box;
	}
}
