package views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class endScreen {
	
	Scene scene ;
	VBox vbox ;
	Label winner ;
	Label loser ;
	Button close ;
	
	public endScreen() {
		vbox = new VBox() ;
		winner = new Label("first player Winner") ;
		winner.setId("winner");
		loser = new Label("Second Player Loser") ;
		close = new Button("Close") ;
		vbox.getChildren().addAll(winner , loser , close);
		
		vbox.setAlignment(Pos.CENTER);
		scene = new Scene(vbox) ;
		
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
	}
	
	
}
