package views;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class pick {


	Label fpLabel ;
	Label ftLabel ;

	Label spLabel ;
	Label stLabel ;
	
	HBox hbox;
	Label topLabel ;
	Label details ;

	VBox fpl ;
	VBox spr ;
	TilePane tilepane ;
	
	Button captainAmericaSlct ;
	Button deadpoolSlct ;
	Button drStrangeSlct;
	Button electroSlct;
	Button ghostRiderSlct;
	Button helaSlct ;
	Button hulkSlct ;
	Button icemanSlct ;
	Button ironmanSlct ;
	Button lokiSlct ;
	Button quicksilverSlct ;
	Button spidermanSlct ;
	Button thorSlct ;
	Button venomSlct ;
	Button yellowjacketSlct ;
	
	Button champion1 ;
	Button champion2 ;
	Button champion3 ;
	Button champion4 ;
	Button champion5 ;
	Button champion6 ;
	
	Button nextPage;
  
	
	BorderPane borderpane ;
	Scene scene ;

	public pick() {
		borderpane =new BorderPane(); 
		
		fpLabel =new Label() ;
		spLabel =new Label() ;
		
		hbox = new HBox();
		
		topLabel =new Label("choose 3 champions for first player \n\n\n\n");
		
		hbox.getChildren().add(topLabel);
		
		tilepane = new TilePane(Orientation.HORIZONTAL); 
		tilepane.setPrefColumns(3);
		tilepane.setVgap(10);
		tilepane.setHgap(10);

		fpl = new VBox(10); //fpl = first player left
		spr = new VBox(10); //spr = second player right

		fpl.getChildren().add(fpLabel);
		spr.getChildren().add(spLabel);

		captainAmericaSlct = new Button("Captain America");
		deadpoolSlct = new Button("Deadpool");
		drStrangeSlct = new Button("Dr Strange");
		electroSlct = new Button("Electro");
		ghostRiderSlct = new Button("Ghost Rider");
		helaSlct = new Button("Hela");
		hulkSlct = new Button("Hulk");
		icemanSlct = new Button("Iceman");
		ironmanSlct = new Button("Ironman");
		lokiSlct = new Button("Loki");
		quicksilverSlct = new Button("Quicksilver");
		spidermanSlct = new Button("Spiderman");
		thorSlct = new Button("Thor");
		venomSlct = new Button("Venom");
		yellowjacketSlct = new Button("Yellow Jacket");
		
		captainAmericaSlct.setMinSize(160, 60);
		deadpoolSlct.setMinSize(160, 60);
		drStrangeSlct.setMinSize(160, 60);
		electroSlct.setMinSize(160, 60);
		ghostRiderSlct.setMinSize(160, 60);
		helaSlct.setMinSize(160, 60);
		hulkSlct.setMinSize(160, 60);
		icemanSlct.setMinSize(160, 60);
		ironmanSlct.setMinSize(160, 60);
		lokiSlct.setMinSize(160, 60);
		quicksilverSlct.setMinSize(160, 60);
		spidermanSlct.setMinSize(160, 60);
		thorSlct.setMinSize(160, 60);
		venomSlct.setMinSize(160, 60);
		yellowjacketSlct.setMinSize(160, 60);
		
		champion1   = new Button();
		champion2   = new Button();
		champion3   = new Button();
		champion4   = new Button();
		champion5   = new Button();
		champion6   = new Button();
		
		nextPage = new Button("new game");
		nextPage.setId("nextPage");
		
		tilepane.getChildren().addAll(captainAmericaSlct,deadpoolSlct,drStrangeSlct,electroSlct,ghostRiderSlct
				,helaSlct,hulkSlct,icemanSlct,ironmanSlct,
				lokiSlct,quicksilverSlct,spidermanSlct, thorSlct, venomSlct, yellowjacketSlct);
		tilepane.setPrefRows(4);
		tilepane.setAlignment(Pos.TOP_CENTER);
		borderpane.setCenter(tilepane);
		
		borderpane.setTop(hbox);
	
		hbox.setAlignment(Pos.CENTER);
		
		borderpane.setRight(spr);
		borderpane.setLeft(fpl);
		// getStylesheets().add(getClass().getResource("application.css").toExternalForm());


		//scene = new Scene(borderpane , 1000, 500) ;
		scene = new Scene(borderpane ) ;
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

	}




}
