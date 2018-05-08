package ui;

import java.util.Optional;

import javafx.scene.control.TextInputDialog;

public class InputDialog {
	
	TextInputDialog tid = new TextInputDialog();
	
	public String ShowAndWait() {
		tid.setTitle("Register player");
		tid.setHeaderText("Register a new player");
		tid.setContentText("Please enter your name: ");
		
		Optional<String> result = tid.showAndWait();
		if (result.isPresent()) {
			return result.get();
		}
		return "cancel";
	}
	
}
