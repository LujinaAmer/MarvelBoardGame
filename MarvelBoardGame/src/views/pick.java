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
	
	
	// Center
	VBox vbox;
	Label instructions ;
	Button choosen ;
	Label details ;
	
	
	
	//bottom 
	HBox abilities ;
	Button ab1;
	Button ab2;
	Button ab3;
	
	
	// left , right 
	VBox fpl ;
	VBox spr ;
	
	//top 
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
		
		
	
		
		tilepane = new TilePane(Orientation.HORIZONTAL); 
//		tilepane.setPrefColumns(3);
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
		
		captainAmericaSlct.setId("champSlct");
		deadpoolSlct.setId("champSlct");
		drStrangeSlct.setId("champSlct");
		electroSlct.setId("champSlct");
		ghostRiderSlct.setId("champSlct");
		helaSlct.setId("champSlct");
		hulkSlct.setId("champSlct");
		icemanSlct.setId("champSlct");
		ironmanSlct.setId("champSlct");
		lokiSlct.setId("champSlct");
		quicksilverSlct.setId("champSlct");
		spidermanSlct.setId("champSlct");
		thorSlct.setId("champSlct");
		venomSlct.setId("champSlct");
		yellowjacketSlct.setId("champSlct");
		
		captainAmericaSlct.setMinSize(150, 0);
		deadpoolSlct.setMinSize(150, 0);
		drStrangeSlct.setMinSize(150, 0);
		electroSlct.setMinSize(150, 0);
		ghostRiderSlct.setMinSize(150, 0);
		helaSlct.setMinSize(150, 0);
		hulkSlct.setMinSize(150, 0);
		icemanSlct.setMinSize(150, 0);
		ironmanSlct.setMinSize(150, 0);
		lokiSlct.setMinSize(150, 0);
		quicksilverSlct.setMinSize(150, 0);
		spidermanSlct.setMinSize(150, 0);
		thorSlct.setMinSize(150, 0);
		venomSlct.setMinSize(150, 0);
		yellowjacketSlct.setMinSize(0, 0);
		
		
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
		//tilepane.setPrefRows(4);
		
		tilepane.setAlignment(Pos.TOP_CENTER);
		
		
		// new center
		vbox = new VBox();
		
		instructions =new Label("choose 3 champions for first player \n\n\n\n");
		choosen = new Button() ;
		choosen.setMinSize(105,140);
		details = new Label() ;
		vbox.getChildren().addAll(instructions , choosen , details);
		vbox.setAlignment(Pos.CENTER);
		
		// bottom 
		abilities = new HBox(10);
		ab1 = new Button();
		ab2  = new Button();
		ab3  = new Button();
		ab1.setMinSize(200, 100);
		ab2.setMinSize(200, 100);
		ab3.setMinSize(200, 100);
		abilities.getChildren().addAll(ab1,ab2,ab3);
		abilities.setAlignment(Pos.CENTER);
		
		borderpane.setTop(tilepane);
		borderpane.setCenter(vbox);
		borderpane.setRight(spr);
		borderpane.setLeft(fpl);
		borderpane.setBottom(abilities);
		
	


		scene = new Scene(borderpane ) ;
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

	}




}
