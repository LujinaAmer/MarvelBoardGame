package views;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class login{

	TextField firstText;
	TextField secondText ;


	String  fName ;
	String  sName  ;

	Button next ;
	VBox loginLayoutBox ;
	Scene scene ;
	
	public login() {
		
		
		// need css to edit font and resize the text field
		loginLayoutBox =new VBox(20); 
		
		Label firstLabel = new Label("First Player Name:");
		firstText = new TextField("FirstPlayer");
		firstText.setMaxSize(300, 100);

		Label secondLabel = new Label("Second Player Name:");
		secondText =new TextField("SecondPlayer");
		secondText.setMaxSize(300, 100);
		
		
		
		next = new Button("Play");
		next.setId("next");
		
		
		

		loginLayoutBox.setAlignment(Pos.BASELINE_CENTER);

		loginLayoutBox.getChildren().addAll(firstLabel ,firstText, secondLabel ,secondText , next);
		loginLayoutBox.setAlignment(Pos.CENTER);
		
		scene = new Scene(loginLayoutBox ,450.0 ,275.0 );
		
		Image i = new Image("bg.jpg" );
	
		loginLayoutBox.setBackground(new Background(new BackgroundImage(i , BackgroundRepeat.NO_REPEAT ,BackgroundRepeat.NO_REPEAT ,BackgroundPosition.CENTER,null )));
		
//		loginLayoutBox.setBackground(new "bg.jpg");
//		loginLayoutBox.setId("loginLayoutBox");
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

//		#loginLayoutBox{
//		    -fx-background-image: url("bg.jpg");
//		    -fx-background-size:cover;
//		}
//
//
//		.root{
//		    -fx-background-color: #000000
//		}

	}// end of login 


	public static void main(String[] args) {
		
	
	}
	



	private void Next(ActionEvent e) {

	}



}
