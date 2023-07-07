package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class taketurn {


	HBox top ;
	Label orderlabel ;
	Button endTurn ;

	VBox left;
	Button picCurr ;
	Label curr ;
	Label useLeaderAbility ;
	Button leaderAbility ;

	VBox right ;
	Label fpLabel ;
	Label spLabel ;

	Label Champ1 ;
	Label Champ2 ;
	Label Champ3 ;

	Label Champ4 ;
	Label Champ5 ;
	Label Champ6 ;



	HBox bottom ;
	// bottom for action button 
	Button move;
	Button attack ;
	Button ability1 ;
	Button ability2 ;
	Button ability3 ;
	Button punch ;

	GridPane directions ;
	Button upD;
	Button downD ;
	Button leftD;
	Button rightD ;

	GridPane board ;
	Button P0 ;
	Button P1 ;
	Button P2 ;
	Button P3 ;
	Button P4 ;
	Button P5 ;
	Button P6 ;
	Button P7 ;
	Button P8 ;
	Button P9 ;
	Button P10;
	Button P11;
	Button P12;
	Button P13;
	Button P14;
	Button P15;
	Button P16;
	Button P17;
	Button P18;
	Button P19;
	Button P20;
	Button P21;
	Button P22;
	Button P23;
	Button P24;
	Rectangle r ;

	Label singeltargetUse ;

	Tooltip t1;


	BorderPane borderpane ;
	Scene scene ;

	public taketurn() {

		borderpane =new BorderPane(); 

		top =new HBox() ;
		orderlabel = new Label("") ;
		orderlabel.setMinWidth(800);
		endTurn =new Button("end turn") ;
		top.getChildren().addAll(orderlabel , endTurn);
		top.setAlignment(Pos.BASELINE_RIGHT);
		borderpane.setTop(top);


		left =new VBox();
		left.setMinWidth(200);

		picCurr = new Button();
		picCurr.setMinSize(105, 140);
		Label current = new Label("Current");
		curr = new Label () ;

		leaderAbility = new Button("Leader Ability");

		useLeaderAbility  =new Label(" leader ability label ") ;

		left.getChildren().addAll(current ,picCurr, curr,useLeaderAbility , leaderAbility);
		borderpane.setLeft(left);



		right = new VBox();
		fpLabel = new Label("First Player") ;
		Champ1 =new Label() ;
		Champ2 =new Label() ;
		Champ3 =new Label() ;

		spLabel = new Label("second player");
		Champ4 =new Label() ;
		Champ5 = new Label();
		Champ6 =  new Label();

		fpLabel.setId("fpl");
		Champ1.setId("fpl");
		Champ2.setId("fpl");
		Champ3.setId("fpl");

		spLabel.setId("spl");
		Champ4.setId("spl");
		Champ5.setId("spl");
		Champ6.setId("spl");

		right.getChildren().addAll(fpLabel, Champ1, Champ2, Champ3, spLabel,Champ4, Champ5 , Champ6);
		borderpane.setRight(right);

		bottom = new HBox();
		// bottom for action button 
		move = new Button("move");
		attack = new Button("attack");
		ability1 = new Button("ability1 button");
		ability2 =new Button("ability2 button") ;
		ability3 = new Button("ability3 button");
		punch = new Button("punch");


		directions = new GridPane() ;
		upD = new Button("Up");
		downD  =new Button("Down");
		leftD = new Button("Left");
		rightD = new Button("Right") ;
		upD.setMinSize(150, 0);
		downD.setMinSize(150, 0);
		leftD.setMinSize(150, 0);
		rightD.setMinSize(150, 0);
		directions.getChildren().addAll(upD , leftD , downD , rightD);

		GridPane.setConstraints(upD,2,0);
		GridPane.setConstraints(leftD,1,1);
		GridPane.setConstraints(downD,2,1);
		GridPane.setConstraints(rightD,3,1);
		directions.setAlignment(Pos.BOTTOM_CENTER);
		directions.setVgap(5);
		directions.setHgap(5);
		singeltargetUse = new Label("choose a target on board") ;

		bottom.getChildren().addAll(move, attack , ability1 , ability2 ,ability3 );
		bottom.setMinHeight(50);
		//bottom.setAlignment(Pos.CENTER);

		// add nodes to bottom in main

		borderpane.setBottom(bottom);


		// center

		P0 =new Button("P0");
		P1 =new Button("P1");
		P2 =new Button("P2");
		P3 =new Button("P3");
		P4 =new Button("P4");
		P5 =new Button("P5");
		P6 =new Button("P6");
		P7 =new Button("P7");
		P8 =new Button("P8");
		P9 =new Button("P9");
		P10 =new Button("P10");
		P11=new Button("P11");
		P12 =new Button("P12");
		P13=new Button("P13");
		P14=new Button("P14");
		P15=new Button("P15");
		P16=new Button("P16");
		P17=new Button("P17");
		P18=new Button("P18");
		P19=new Button("P19");
		P20=new Button("P20");
		P21=new Button("P21");
		P22=new Button("P22");
		P23=new Button("P23");
		P24=new Button("P24");
		r= new Rectangle();  

		board = new GridPane();
		board.setVgap(10);
		board.setHgap(10);
		board.getChildren().addAll(P0,P1,P2,P3,P4,P5,P6,P7,P8,P9,P10,P11,P12,P13,P14,P15,P16,P17,P18,P19,P20,P21,P22,P23,P24);
		board.setPadding(new Insets(5,5,5,5));
		board.setAlignment(Pos.CENTER);

		P0.setMinSize(160, 60);
		P1.setMinSize(160, 60);
		P2.setMinSize(160, 60);
		P3.setMinSize(160, 60);
		P4.setMinSize(160, 60);
		P5.setMinSize(160, 60);
		P6.setMinSize(160, 60);
		P7.setMinSize(160, 60);
		P8.setMinSize(160, 60);
		P9.setMinSize(160, 60);
		P10.setMinSize(160, 60);
		P11.setMinSize(160, 60);
		P12.setMinSize(160, 60);
		P13.setMinSize(160, 60);
		P14.setMinSize(160, 60);
		P15.setMinSize(160, 60);
		P16.setMinSize(160, 60);
		P17.setMinSize(160, 60);
		P18.setMinSize(160, 60);
		P19.setMinSize(160, 60);
		P20.setMinSize(160, 60);
		P21.setMinSize(160, 60);
		P22.setMinSize(160, 60);
		P23.setMinSize(160, 60);
		P24.setMinSize(160, 60);

		GridPane.setConstraints(P20,0,0);
		GridPane.setConstraints(P21,1,0);
		GridPane.setConstraints(P22,2,0);
		GridPane.setConstraints(P23,3,0);
		GridPane.setConstraints(P24,4,0);



		GridPane.setConstraints(P15,0,1);
		GridPane.setConstraints(P16,1,1);
		GridPane.setConstraints(P17,2,1);
		GridPane.setConstraints(P18,3,1);
		GridPane.setConstraints(P19,4,1);

		GridPane.setConstraints(P10,0,2);
		GridPane.setConstraints(P11,1,2);
		GridPane.setConstraints(P12,2,2);
		GridPane.setConstraints(P13,3,2);
		GridPane.setConstraints(P14,4,2);

		GridPane.setConstraints(P5,0,3);
		GridPane.setConstraints(P6,1,3);
		GridPane.setConstraints(P7,2,3);
		GridPane.setConstraints(P8,3,3);
		GridPane.setConstraints(P9,4,3);

		GridPane.setConstraints(P0,0,4);
		GridPane.setConstraints(P1,1,4);
		GridPane.setConstraints(P2,2,4);
		GridPane.setConstraints(P3,3,4);
		GridPane.setConstraints(P4,4,4);




		borderpane.setCenter(board);


		//scene = new Scene(borderpane, 1000, 500);
		scene = new Scene(borderpane ) ;
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());


	}





}
