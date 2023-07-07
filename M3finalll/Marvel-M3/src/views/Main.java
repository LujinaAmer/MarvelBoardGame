package views;


import javafx.*;





import java.awt.Point;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.DirectoryNotEmptyException;
import java.util.ArrayList;

import engine.Game;
import engine.Player;
import engine.PriorityQueue;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Popup;
import javafx.stage.Stage;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.DamagingAbility;
import model.effects.Effect;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Condition;
import model.world.Cover;
import model.world.Direction;
import model.world.Hero;
import model.world.Villain;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.*;


public class Main extends Application {


	Stage frame;

	Stage frame2;

	login login ;
	pick pick ;
	taketurn taketurn ;
	endScreen endscreen ;
	Scene tryme;

	TilePane t = new TilePane() ;

	Tooltip t1;
	Alert error ;
	Popup popup ;
	
	Player firstPlayer ;
	Player secondPlayer ;
	Game game ;

	public void start(Stage PrimaryStage)  {
		
	
		
	
		try {

			frame = PrimaryStage ;
			frame.setTitle("The Game");



			//            
			// max should be the size of the background image
			//            frame.setMaxHeight(500);
			//            frame.setMaxWidth(500);
			frame.setFullScreen(true);
			//frame.setMaximized(true);


//			Image icon = new Image("mjolnir.png");
//			frame.getIcons().add(icon);

			// for try 
			Button DontClick = new Button("New Game");
			DontClick.setDisable(true);
			t.getChildren().add(DontClick);
			//tryme = new Scene(DontClick);

			//  declare scenes
			login = new login();
			pick =new pick();
			taketurn =new taketurn() ;
			endscreen = new endScreen() ;
			error = new Alert(AlertType.ERROR); 
			
			
			
			
			// login -> pick
			login.next.setOnAction(e  ->  { 

				login.fName = login.firstText.getText();

				login.sName = login.secondText.getText();

				if(login.fName.equals(""))
					login.fName = "FirstPlayer";
				pick.fpLabel.setText(login.fName); 

				if(login.sName.equals(""))
					login.sName = "secondPlayer";
				pick.spLabel.setText(login.sName);
				firstPlayer=new Player(pick.fpLabel.getText());
				secondPlayer=new Player(pick.spLabel.getText());
				
				pick.fpLabel.setText(login.fName + "\n-------------------------------"); 
				pick.spLabel.setText(login.sName+"\n---------------------------------");


				try {
					Game.loadAbilities("Abilities.csv");
					Game.loadChampions("Champions.csv");
					//Game.prepareChampionTurns() ;

				}
				catch(IOException j) {
					
					error.setContentText(j.getMessage());
					//error.initOwner(frame); 
					error.show();
//					popup.show();
				}
			

				frame.setScene(pick.scene);
			
				frame.setFullScreen(true);
				//frame.setMaximized(true);
				error.initOwner(frame); 
			});

			
			 	 
//			for(Node n : taketurn.board.getChildren() )  {
//				if(GridPane.getRowIndex(n)==0 && GridPane.getRowIndex(n)==1) {
//					((Button)n).setText("Its 5");
//					System.out.println("Hi");
//					break;
//					
//				}
//			}
//			
			
			// add champion to teams 
			pick.captainAmericaSlct.setOnAction(e  -> buttonClicked(e)) ;
			pick.deadpoolSlct.setOnAction(e  -> buttonClicked(e)) ;
			pick.drStrangeSlct.setOnAction(e  -> buttonClicked(e)) ;
			pick.electroSlct.setOnAction(e  -> buttonClicked(e)) ;
			pick.ghostRiderSlct.setOnAction(e  -> buttonClicked(e)) ;
			pick.helaSlct.setOnAction(e  -> buttonClicked(e)) ;
			pick.hulkSlct.setOnAction(e  -> buttonClicked(e)) ;
			pick.icemanSlct.setOnAction(e  -> buttonClicked(e)) ;
			pick.ironmanSlct.setOnAction(e  -> buttonClicked(e)) ;
			pick.lokiSlct.setOnAction(e  -> buttonClicked(e)) ;
			pick.quicksilverSlct.setOnAction(e  -> buttonClicked(e)) ;
			pick.spidermanSlct.setOnAction(e  -> buttonClicked(e)) ;
			pick.thorSlct.setOnAction(e  -> buttonClicked(e)) ;
			pick.venomSlct.setOnAction(e  -> buttonClicked(e)) ;
			pick.yellowjacketSlct.setOnAction(e  -> buttonClicked(e)) ;

			// show details of champion
			pick.captainAmericaSlct.setOnMouseEntered(m -> hoverButton(m)) ;
			pick.deadpoolSlct.setOnMouseEntered(m -> hoverButton(m)) ;
			pick.drStrangeSlct.setOnMouseEntered(m -> hoverButton(m)) ;
			pick.electroSlct.setOnMouseEntered(m -> hoverButton(m)) ;
			pick.ghostRiderSlct.setOnMouseEntered(m -> hoverButton(m)) ;
			pick.helaSlct.setOnMouseEntered(m -> hoverButton(m)) ;
			pick.hulkSlct.setOnMouseEntered(m -> hoverButton(m)) ;
			pick.icemanSlct.setOnMouseEntered(m -> hoverButton(m)) ;
			pick.ironmanSlct.setOnMouseEntered(m -> hoverButton(m)) ;
			pick.lokiSlct.setOnMouseEntered(m -> hoverButton(m)) ;
			pick.quicksilverSlct.setOnMouseEntered(m -> hoverButton(m)) ;
			pick.spidermanSlct.setOnMouseEntered(m -> hoverButton(m)) ;
			pick.thorSlct.setOnMouseEntered(m -> hoverButton(m)) ;
			pick.venomSlct.setOnMouseEntered(m -> hoverButton(m)) ;
			pick.yellowjacketSlct.setOnMouseEntered(m -> hoverButton(m)) ;

			pick.nextPage.setOnAction(v  ->  newGame(v) ) ;
			
			taketurn.endTurn.setOnAction(e ->  endTurnClicked(e) );
			
			taketurn.move.setOnAction(e-> movement(e));
			taketurn.attack.setOnAction(e-> attacking(e));
			
			taketurn.ability1.setOnAction(e -> abilityUsed(e));
			taketurn.ability2.setOnAction(e -> abilityUsed(e));
			taketurn.ability3.setOnAction(e -> abilityUsed(e));
			taketurn.punch.setOnAction(e -> punchAbility());
			
			taketurn.ability1.setOnMouseEntered(e -> abilityHover( e));
			taketurn.ability2.setOnMouseEntered(e -> abilityHover( e));
			taketurn.ability3.setOnMouseEntered(e -> abilityHover( e));
			taketurn.punch.setOnMouseEntered(e -> abilityHover( e));
			
			taketurn.leaderAbility.setOnAction(e -> leaderAbilityUse(e));
			
			endscreen.close.setOnAction(e ->   Platform.exit());
			
			frame.setScene(login.scene);
			//frame.setScene(pick.scene);
			//frame.setScene(taketurn.scene);
			//frame.setScene(endscreen.scene);
			frame.show();


		} catch(Exception e) {
			error.setContentText(e.getMessage());
			//error.initOwner(frame); 
			error.show();

		}

	}// every start has an End



	public void buttonClicked( ActionEvent e ) {
		
//		if (((Button)e.getSource()).getText().equals("Captain America"))
//			soundEffect.captainAmerica();
//		if (((Button)e.getSource()).getText().equals("Hulk"))
//			soundEffect.hulk();
//		if (((Button)e.getSource()).getText().equals("Deadpool"))
//			soundEffect.deadpool();
//		if (((Button)e.getSource()).getText().equals("Dr Strange"))
//			soundEffect.drStrange();
//		if (((Button)e.getSource()).getText().equals("Electro"))
//			soundEffect.electro();
//		if (((Button)e.getSource()).getText().equals("Ghost Rider"))
//			soundEffect.ghostRider();
//		if (((Button)e.getSource()).getText().equals("Hela"))
//			soundEffect.hela();
//		if (((Button)e.getSource()).getText().equals("Iceman"))
//			soundEffect.iceman();
//		if (((Button)e.getSource()).getText().equals("Ironman"))
//			soundEffect.ironman();
//		if (((Button)e.getSource()).getText().equals("Loki"))
//			soundEffect.loki();
//		if (((Button)e.getSource()).getText().equals("Quicksilver"))
//			soundEffect.quicksilver();
//		if (((Button)e.getSource()).getText().equals("Spiderman"))
//			soundEffect.spiderman();
//		if (((Button)e.getSource()).getText().equals("Thor"))
//			soundEffect.thor();
//		if (((Button)e.getSource()).getText().equals("Venom"))
//			soundEffect.venom();
//		if (((Button)e.getSource()).getText().equals("Yellow Jacket"))
//			soundEffect.yellowJacket();

		
		if(firstPlayer.getTeam().size() <3) {
			for(int i=0 ; i<Game.getAvailableChampions().size() ; i++) {
				if (((Button)e.getSource()).getText().equals(Game.getAvailableChampions().get(i).getName())) {
					firstPlayer.getTeam().add(Game.getAvailableChampions().get(i));
					pick.fpLabel.setText(pick.fpLabel.getText() + "\n\n" + Game.getAvailableChampions().get(i).getName());
					((Button)e.getSource()).setDisable(true);
				}
			}
			if (firstPlayer.getTeam().size() == 3)
				pick.topLabel.setText("choose 3 champions for seconed player  \n\n\n\n");
		}
		else if(secondPlayer.getTeam().size() <3) {
			pick.topLabel.setText("choose 3 champions for seconed player  \n\n\n\n");
			for(int i=0 ; i<Game.getAvailableChampions().size() ; i++) {
				if (((Button)e.getSource()).getText().equals(Game.getAvailableChampions().get(i).getName())) {
					secondPlayer.getTeam().add(Game.getAvailableChampions().get(i));
					pick.spLabel.setText(pick.spLabel.getText() + "\n\n" + Game.getAvailableChampions().get(i).getName());
					((Button)e.getSource()).setDisable(true);
					if (secondPlayer.getTeam().size() == 3) {
						slctLeader1();
					}

				}

			}
		}		
		else
			slctLeader1(); // set the else condition 
		
		
		
		
	}

	public void coverplace() {
		
		
		for(int i=0; i<Game.getBoardwidth();i++) {
			for(int j=0; j<Game.getBoardheight();j++) {
				if(game.getBoard()[i][j] instanceof Cover) {

					for(int k =0 ; k < taketurn.board.getChildren().size() ; k++) {

						if(GridPane.getRowIndex( ((Button)taketurn.board.getChildren().get(k)))== Math.abs(i-4) &&
								GridPane.getColumnIndex( ((Button)taketurn.board.getChildren().get(k)))== j) {
							((Button)taketurn.board.getChildren().get(k)).setText(" Cover\nHP "+ ((Cover)game.getBoard()[i][j]).getCurrentHP()) ;
						
							break ;
						}
					}

				}
			
			}
		}
		
		for (Champion c : game.getFirstPlayer().getTeam()) {
			String l;
			String type = "" ;
			if(c.equals(game.getFirstPlayer().getLeader())) {
				l = " The Leader";
			}
			else
				l= " Not the leader ";
			if(c instanceof Hero )
				type ="Hero";
			else if (c instanceof Villain)
				type = "Villain";
			else if (c instanceof AntiHero)
				type= "AntiHero";
			for(int i =0 ; i < taketurn.board.getChildren().size() ; i++) {

				if(GridPane.getRowIndex( ((Button)taketurn.board.getChildren().get(i)))== Math.abs(c.getLocation().x-4) &&
						GridPane.getColumnIndex( ((Button)taketurn.board.getChildren().get(i)))== c.getLocation().y) {
					((Button)taketurn.board.getChildren().get(i)).setText(c.getName());
					((Button)taketurn.board.getChildren().get(i)).setStyle("-fx-background-color: #8dc6ff; ");
					((Button)taketurn.board.getChildren().get(i)).setTooltip(new Tooltip(" Name	" +c.getName() +"		MaxHP	"+ c.getMaxHP() + 
							"\n  Mana	"+ c.getMana()+"		MaxActionPointsPerTurn	"+ c.getMaxActionPointsPerTurn() 
							+"\n  AttackDamage	"+ c.getAttackDamage()+"		AttackRange	"+ c.getAttackRange()
							+"\n  speed	"+ c.getSpeed()  + "\n"+effects(c) + "\n" + l + "  "+    type));
					

					break ;
				}
			}
		}

		for (Champion c : game.getSecondPlayer().getTeam()) {
			String l;
			String type = "" ;
			if(c.equals(game.getSecondPlayer().getLeader())) {
				l = " The Leader";
			}
			else
				l= "Not the leader";
			
			if(c instanceof Hero )
				type ="Hero";
			else if (c instanceof Villain)
				type = "Villain";
			else if (c instanceof AntiHero)
				type= "AntiHero";
			
			for(int i =0 ; i < taketurn.board.getChildren().size() ; i++) {

				if(GridPane.getRowIndex( ((Button)taketurn.board.getChildren().get(i)))== Math.abs(c.getLocation().x-4) &&
						GridPane.getColumnIndex( ((Button)taketurn.board.getChildren().get(i)))== c.getLocation().y) {
					((Button)taketurn.board.getChildren().get(i)).setText(c.getName());
					((Button)taketurn.board.getChildren().get(i)).setStyle("-fx-background-color: #7575a3; ");
					((Button)taketurn.board.getChildren().get(i)).setTooltip(new Tooltip(" Name	" +c.getName() +"		MaxHP	"+ c.getMaxHP() + 
							"\n  Mana	"+ c.getMana()+"		MaxActionPointsPerTurn	"+ c.getMaxActionPointsPerTurn() 
							+"\n  AttackDamage	"+ c.getAttackDamage()+"		AttackRange	"+ c.getAttackRange()
							+"\n  speed	"+ c.getSpeed() +"\n  "+ effects(c)+"\n" + l + "  "+    type));
					
					
					break ;
				}
			}
		}
		
		for(int i=0; i<Game.getBoardwidth();i++) {
            for(int j=0; j<Game.getBoardheight();j++) {
                if(game.getBoard()[i][j]==null) {

                    for(int k =0 ; k < taketurn.board.getChildren().size() ; k++) {

                        if(GridPane.getRowIndex( ((Button)taketurn.board.getChildren().get(k)))== Math.abs(i-4) &&
                                GridPane.getColumnIndex( ((Button)taketurn.board.getChildren().get(k)))== j) {
                            ((Button)taketurn.board.getChildren().get(k)).setText(" 	   ");
                            ((Button)taketurn.board.getChildren().get(k)).setStyle("-fx-background-color: #34495e; ");
                        	((Button)taketurn.board.getChildren().get(k)).setTooltip(null);
                            break ;
                        }
                    }

                }

            }
        }
		
		
	}


	public void hoverButton(MouseEvent m) {
		pick.details = new Label() ;
		String s ="";

		

		for(Champion c : Game.getAvailableChampions()) {
			if(c.getName().equals(((Button)m.getSource()).getText())) {
				s +="  Name	" +c.getName() +"		MaxHP	"+ c.getMaxHP() + 
				"\n  Mana	"+ c.getMana()+"		MaxActionPointsPerTurn	"+ c.getMaxActionPointsPerTurn() 
				+"\n  AttackDamage	"+ c.getAttackDamage()+"		AttackRange	"+ c.getAttackRange()
				+"\n  speed	"+ c.getSpeed() +"\n  " ;
				for(Ability a : c.getAbilities()) {
					s+=a.toString() +"\n";
				}

			}
			pick.details.setText(s);		


		}
		pick.borderpane.setBottom(pick.details) ;

		((Button)m.getSource()).setOnMouseExited(e -> {
			pick.borderpane.getChildren().remove(pick.details);
		});

	}
	

	public String abilities(Champion c){
		String abilities="";

//		for(int i=0;i<c.getAbilities().size();i++) {
//
//			abilities+=c.getAbilities().get(i).getName()+"" 
//			+"Cooldown\n"+ c.getAbilities().get(i).getCurrentCooldown()+"/"+ c.getAbilities().get(i).getBaseCooldown() +
//			"\n" + c.getAbilities().get(i).getCastArea() +"\ncast range"+ c.getAbilities().get(i).getCastRange() +
//			"\nMana" + c.getAbilities().get(i).getManaCost()+
//			"\nactionpoints"+ c.getAbilities().get(i).getRequiredActionPoints() ;
//		}
		for(Ability a : c.getAbilities()) {
			abilities += a.toString() ; 
		}
		
		return abilities;
	}


	public String effects(Champion c){
		String effects="applied effects";

		for(int i=0;i<c.getAppliedEffects().size();i++) {

			effects+= c.getAppliedEffects().get(i).getName() + "  Duration "+ c.getAppliedEffects().get(i).getDuration() + "\n";
		}

		return effects;
	}

	
	public void slctLeader1 () {
		pick.topLabel.setText("Please choose your leader first player \n\n\n\n");

		pick.tilepane.getChildren().removeAll(pick.captainAmericaSlct,pick.deadpoolSlct,pick.drStrangeSlct,
				pick.electroSlct,pick.ghostRiderSlct
				,pick.helaSlct,pick.hulkSlct,pick.icemanSlct,pick.ironmanSlct,
				pick.lokiSlct,pick.quicksilverSlct,pick.spidermanSlct, pick.thorSlct, pick.venomSlct, pick.yellowjacketSlct);


		pick.champion1 = new Button(firstPlayer.getTeam().get(0).getName());
		pick.champion2 = new Button(firstPlayer.getTeam().get(1).getName());
		pick.champion3 = new Button(firstPlayer.getTeam().get(2).getName());

		pick.tilepane.getChildren().addAll(pick.champion1,pick.champion2,pick.champion3);

		pick.tilepane.setAlignment(Pos.TOP_CENTER);

		pick.champion1.setOnAction(l  -> leader1Choosed(l));
		pick.champion2.setOnAction(l  -> leader1Choosed(l)) ;
		pick.champion3.setOnAction(l  -> leader1Choosed(l)) ;


	}


	public void slctLeader2 () {

		pick.champion4 = new Button(secondPlayer.getTeam().get(0).getName());
		pick.champion5 = new Button(secondPlayer.getTeam().get(1).getName());
		pick.champion6 = new Button(secondPlayer.getTeam().get(2).getName());


		pick.topLabel.setText("Please choose your leader second player \n\n\n\n");

		pick.tilepane.getChildren().removeAll(pick.champion1,pick.champion2,pick.champion3);

		pick.tilepane.getChildren().addAll(pick.champion4,pick.champion5,pick.champion6);

		pick.tilepane.setAlignment(Pos.TOP_CENTER);



		pick.champion4.setOnAction(l  -> leader2Choosed(l));
		pick.champion5.setOnAction(l  -> leader2Choosed(l)) ;
		pick.champion6.setOnAction(l  -> leader2Choosed(l)) ;

	}



	public  void leader1Choosed(ActionEvent e) {


		for(int i =0 ; i<firstPlayer.getTeam().size(); i++){
			if(firstPlayer.getTeam().get(i).getName().equals(((Button)e.getSource()).getText())){
				firstPlayer.setLeader(firstPlayer.getTeam().get(i));
				break;
			}
		}

		slctLeader2();
	}



	public  void leader2Choosed(ActionEvent e) {
		for(int i =0 ; i<secondPlayer.getTeam().size(); i++){
			if(secondPlayer.getTeam().get(i).getName().equals(((Button)e.getSource()).getText())){
				secondPlayer.setLeader(secondPlayer.getTeam().get(i));
				pick.tilepane.getChildren().removeAll(pick.champion4,pick.champion5,pick.champion6);
				break;
			}

		}
		pick.tilepane.getChildren().add(pick.nextPage);



	}


	public void newGame(ActionEvent e) {
		login.fName = login.firstText.getText();

		login.sName = login.secondText.getText();
		if(login.fName.equals(""))
			login.fName = "FirstPlayer";
		taketurn.fpLabel.setText("\n"+login.fName);
		if(login.sName.equals(""))
			login.sName = "SecondPlayer";
		taketurn.spLabel.setText("\n"+login.sName);

		// start a game

		game = new Game(firstPlayer , secondPlayer);

		updateOrderLabel();
		updateChampLabels();
		updateCurr();
		updateChampAbility();
		updateUseLeaderAbility();
		coverplace() ;
		
		taketurn.bottom.setAlignment(Pos.BASELINE_CENTER);
		frame.setScene(taketurn.scene);
		frame.setFullScreen(true);
		
		//frame.setMaximized(true);
		//game.getCurrentChampion().getName() +"	next :  "+ getNextChampion();
		

	}

	
	public String getNextChampion() {

		PriorityQueue temp = new PriorityQueue( game.getFirstPlayer().getTeam().size() + game.getSecondPlayer().getTeam().size() );
		
		for(Champion c : game.getFirstPlayer().getTeam()) {
			if(!c.getCondition().equals(Condition.INACTIVE))
				temp.insert(c);
		}
		for(Champion c : game.getSecondPlayer().getTeam()) {
			if(!c.getCondition().equals(Condition.INACTIVE))
				temp.insert(c);
		}
		String s= "";
		String ss ="\n		" ;
		int i = 0 ;
		
		while(!temp.isEmpty()) {
			if (((Champion)temp.peekMin()).compareTo(game.getCurrentChampion()) > 0)
				s+= ((Champion)temp.remove()).getName() +"    ";
			if(temp.isEmpty())
				break;
			if (((Champion)temp.peekMin()).compareTo(game.getCurrentChampion()) <= 0)
				ss+= ((Champion)temp.remove()).getName() +"   ";
			if(temp.isEmpty())
				break;
			if (i >15)
				break ;
			i++ ;
		}
		
		return s+ "\n"+ss ;
//		Champion fastest = (Champion) temp.peekMin() ;
//
//		while(!temp.peekMin().equals(game.getCurrentChampion())) {
//			temp.remove() ;
//			if(temp.isEmpty())
//				return fastest.getName() ;
//		}
//		
//		if(temp.isEmpty())
//			return fastest.getName() ;
//		temp.remove();
//		if(temp.isEmpty())
//			return fastest.getName() ;
//		return ((Champion)temp.peekMin()).getName() ;

	}



	public void endTurnClicked(ActionEvent e) {
		// check for the leader
		game.endTurn(); 
		//System.out.println(game.getCurrentChampion().getLocation()); // for trace  
		updateOrderLabel();
		updateChampLabels();
		updateUseLeaderAbility() ;
		updateChampAbility();
		updateCurr();
		
		if(taketurn.bottom.getChildren().contains(taketurn.punch))
			taketurn.bottom.getChildren().remove(taketurn.punch);
		if(game.hasEffect(game.getCurrentChampion(), "Disarm"))
			taketurn.bottom.getChildren().add(taketurn.punch);
		
	}

	public void updateCurr() {
		Champion c = game.getCurrentChampion() ;
		taketurn.curr.setText("Current\n\n"+ game.getCurrentChampion().toString()+"\n" +effects(game.getCurrentChampion()) );
	}
	
	public void updateOrderLabel() {
		
		
		taketurn.orderlabel.setText("Next : "+ getNextChampion() );
	}
	
	
	public void updateChampLabels() {
		
		
		for(int i =0 ; i < game.getFirstPlayer().getTeam().size() ; i++) {
			if(i== 0)
				taketurn.Champ1.setText("\n"+game.getFirstPlayer().getTeam().get(0).getName() +
						"\n "+ game.getFirstPlayer().getTeam().get(0).getCondition()+
						"\n Hp"+ game.getFirstPlayer().getTeam().get(0).getCurrentHP());
			if(i == 1)
				taketurn.Champ2.setText("\n"+game.getFirstPlayer().getTeam().get(1).getName() +
						"\n "+ game.getFirstPlayer().getTeam().get(1).getCondition()+
						"\n Hp"+ game.getFirstPlayer().getTeam().get(1).getCurrentHP());
			
			if(i == 2)
				taketurn.Champ3.setText("\n"+game.getFirstPlayer().getTeam().get(2).getName() +
						"\n "+ game.getFirstPlayer().getTeam().get(2).getCondition()+
						"\n Hp"+ game.getFirstPlayer().getTeam().get(2).getCurrentHP());
		}
		if(game.getFirstPlayer().getTeam().size() ==2 )
			taketurn.Champ3.setText("\nDEAD");
		if(game.getFirstPlayer().getTeam().size() ==1)
			taketurn.Champ2.setText("\nDEAD");
		
		for(int i =0 ; i < game.getSecondPlayer().getTeam().size() ; i++) {
			if(i== 0)
				taketurn.Champ4.setText("\n"+game.getSecondPlayer().getTeam().get(0).getName() +
						"\n "+ game.getSecondPlayer().getTeam().get(0).getCondition()+
						"\n Hp"+ game.getSecondPlayer().getTeam().get(0).getCurrentHP());
			if(i == 1)
				taketurn.Champ5.setText("\n"+game.getSecondPlayer().getTeam().get(1).getName() +
						"\n "+ game.getSecondPlayer().getTeam().get(1).getCondition()+
						"\n Hp"+ game.getSecondPlayer().getTeam().get(1).getCurrentHP());
			if(i == 2)
				taketurn.Champ6.setText("\n"+game.getSecondPlayer().getTeam().get(2).getName() +
						"\n "+ game.getSecondPlayer().getTeam().get(2).getCondition()+
						"\n Hp"+ game.getSecondPlayer().getTeam().get(2).getCurrentHP());
		}
		if(game.getSecondPlayer().getTeam().size() ==2 )
			taketurn.Champ6.setText("\nDEAD");
		if(game.getSecondPlayer().getTeam().size() ==1)
			taketurn.Champ5.setText("\nDEAD");
		
//		for(Node n : taketurn.right.getChildren()) {
//			taketurn.right.getChildren().remove(n);
//		}
//		if(game.getFirstPlayer().getTeam().contains(game.getCurrentChampion())) {
//			taketurn.right.getChildren().addAll(taketurn.Champ4, taketurn.Champ5 , taketurn.Champ6);
//		}
//		if(game.getSecondPlayer().getTeam().contains(game.getCurrentChampion())) {
//			taketurn.right.getChildren().addAll(taketurn.Champ1, taketurn.Champ2 , taketurn.Champ3);
//		}
//		
		
		
		
	}

	public void updateUseLeaderAbility() {
		if(game.getFirstPlayer().getLeader().equals(game.getCurrentChampion()) ) {
			if(!game.isFirstLeaderAbilityUsed()) {
			taketurn.useLeaderAbility.setText("you can use leader ability\n");

			}else {
				taketurn.useLeaderAbility.setText("you already used leader ability\n");
			}
		}
		else	
		if(game.getSecondPlayer().getLeader().equals(game.getCurrentChampion())) {
			if( !game.isSecondLeaderAbilityUsed()) {
			taketurn.useLeaderAbility.setText("you can use leader ability\n");

			}else {
				taketurn.useLeaderAbility.setText("you already used leader ability\n");
			}
		}
		else
			if (!game.getCurrentChampion().equals(game.getFirstPlayer().getLeader())) 
				taketurn.useLeaderAbility.setText("you can't use leader ability\n");
	}
	
	

	
	public void  movement(ActionEvent e){
		
		taketurn.bottom.getChildren().removeAll(taketurn.move , taketurn.attack , taketurn.ability1 , taketurn.ability2,
				taketurn.ability3 );
		
		if(taketurn.bottom.getChildren().contains(taketurn.punch))
			taketurn.bottom.getChildren().remove(taketurn.punch);
		
		taketurn.endTurn.setDisable(true);
		taketurn.bottom.getChildren().addAll( taketurn.leftD,taketurn.upD , taketurn.downD , taketurn.rightD );
		taketurn.bottom.setAlignment(Pos.BASELINE_CENTER);
		
		taketurn.upD.setOnAction(d -> directionmove(Direction.UP));
		taketurn.downD.setOnAction(d -> directionmove(Direction.DOWN));
		taketurn.rightD.setOnAction(d -> directionmove(Direction.RIGHT));
		taketurn.leftD.setOnAction(d -> directionmove(Direction.LEFT));
		
	}
	
	public void directionmove(Direction d) {
		try {
			game.move(d);
			
			//nullify the current champion cell from which he moved from.
		} catch (NotEnoughResourcesException e) {
			error.setContentText(e.getMessage());
			error.show();
		} catch (UnallowedMovementException e) {
			error.setContentText(e.getMessage());
			//error.initOwner(frame); 
			error.show();
		}
		
		coverplace();
		updateCurr();
		updateChampLabels();
		
		taketurn.bottom.getChildren().removeAll(taketurn.upD , taketurn.downD , taketurn.rightD , taketurn.leftD);
		
		taketurn.bottom.getChildren().addAll(taketurn.move,taketurn.attack , taketurn.ability1 , taketurn.ability2,
				taketurn.ability3);
		taketurn.endTurn.setDisable(false);
		if(game.hasEffect(game.getCurrentChampion(), "Disarm"))
			taketurn.bottom.getChildren().add(taketurn.punch);
	
	}
	
	
	public void attacking(ActionEvent e) {
		taketurn.bottom.getChildren().removeAll(taketurn.move , taketurn.attack , taketurn.ability1 , taketurn.ability2,
				taketurn.ability3 );
		if(taketurn.bottom.getChildren().contains(taketurn.punch))
			taketurn.bottom.getChildren().remove(taketurn.punch);
		
		taketurn.bottom.getChildren().addAll(taketurn.leftD ,taketurn.upD , taketurn.downD , taketurn.rightD );
		taketurn.bottom.setAlignment(Pos.BASELINE_CENTER);
		taketurn.endTurn.setDisable(true);
		taketurn.upD.setOnAction(d -> attackdirection(Direction.UP));
		taketurn.downD.setOnAction(d -> attackdirection(Direction.DOWN));
		taketurn.rightD.setOnAction(d -> attackdirection(Direction.RIGHT));
		taketurn.leftD.setOnAction(d -> attackdirection(Direction.LEFT));
		
	}
	
	public void attackdirection(Direction d) {
		try {
			
			game.attack(d);
		} catch (NotEnoughResourcesException | ChampionDisarmedException | InvalidTargetException e) {
			error.setContentText(e.getMessage());
			//error.initOwner(frame); 
			error.show();
		}
		
		coverplace();
		updateCurr();
		updateChampLabels();
		updateOrderLabel();
		endGame() ;
		taketurn.endTurn.setDisable(false);
		taketurn.bottom.getChildren().removeAll(taketurn.leftD ,taketurn.upD , taketurn.downD , taketurn.rightD  );
		
		
		taketurn.bottom.getChildren().addAll(taketurn.move,taketurn.attack , taketurn.ability1 , taketurn.ability2,
				taketurn.ability3 );
		
		if(game.hasEffect(game.getCurrentChampion(), "Disarm"))
			taketurn.bottom.getChildren().add(taketurn.punch);
		
	}
	
	public void updateChampAbility() {
		
		taketurn.ability1.setText(game.getCurrentChampion().getAbilities().get(0).getName());
		taketurn.ability2.setText(game.getCurrentChampion().getAbilities().get(1).getName());
		taketurn.ability3.setText(game.getCurrentChampion().getAbilities().get(2).getName());
		
		if (game.hasEffect(game.getCurrentChampion(), "Disarm"))
			taketurn.bottom.getChildren().add(taketurn.punch);
		
		
		
		
		
	}
	
	public void abilityUsed(ActionEvent e) {
		
		
		for(Ability a : Game.getAvailableAbilities()) {
			if(a.getName().equals(((Button)e.getSource()).getText())) {
				if(a.getCastArea().equals(AreaOfEffect.DIRECTIONAL)) {
					
					if(taketurn.bottom.getChildren().contains(taketurn.punch))
						taketurn.bottom.getChildren().remove(taketurn.punch);
					
					taketurn.bottom.getChildren().removeAll(taketurn.move , taketurn.attack , taketurn.ability1 , taketurn.ability2,
							taketurn.ability3 );
					taketurn.endTurn.setDisable(true);
					taketurn.bottom.getChildren().addAll(taketurn.leftD ,taketurn.upD , taketurn.downD , taketurn.rightD );
					taketurn.bottom.setAlignment(Pos.BASELINE_CENTER);
					
					taketurn.upD.setOnAction(d -> directionalAbilityUsed(Direction.UP ,a));
					taketurn.downD.setOnAction(d -> directionalAbilityUsed(Direction.DOWN , a));
					taketurn.rightD.setOnAction(d -> directionalAbilityUsed(Direction.RIGHT, a));
					taketurn.leftD.setOnAction(d -> directionalAbilityUsed(Direction.LEFT , a));
					
					break ;
				}
				else if(a.getCastArea().equals(AreaOfEffect.SINGLETARGET) ) {
					

						if(taketurn.bottom.getChildren().contains(taketurn.punch))
							taketurn.bottom.getChildren().remove(taketurn.punch);
					
					taketurn.bottom.getChildren().removeAll(taketurn.move , taketurn.attack , taketurn.ability1 , taketurn.ability2,
							taketurn.ability3 );
					taketurn.endTurn.setDisable(true);
					taketurn.bottom.getChildren().add(taketurn.singeltargetUse);
					
					taketurn.P0.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P1.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P2.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P3.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P4.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P5.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P6.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P7.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P8.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P9.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P10.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P11.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P12.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P13.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P14.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P15.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P16.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P17.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P18.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P19.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P20.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P21.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P21.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P22.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P23.setOnAction(s -> singleTargetAbilityUsed(s, a) );
					taketurn.P24.setOnAction(s -> singleTargetAbilityUsed(s, a) );
		
					break ;
				}
				else{
					try {
						game.castAbility(a);
					} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
						error.setContentText(e1.getMessage());
						//error.initOwner(frame); 
						error.show();
					}
					coverplace();
					updateCurr();
					updateChampLabels(); 
					updateOrderLabel();
					endGame() ;
				}
				
				
			}
		}

	}

	public void punchAbility() {

		taketurn.bottom.getChildren().removeAll(taketurn.move , taketurn.attack , taketurn.ability1 , taketurn.ability2,
				taketurn.ability3 , taketurn.punch);
		taketurn.endTurn.setDisable(true);
		taketurn.bottom.getChildren().add(taketurn.singeltargetUse);
				
		
		if( game.hasEffect(game.getCurrentChampion(), "Disarm")) {
				taketurn.P0.setOnAction(s -> singleTargetAbilityUsed(s, game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P1.setOnAction(s -> singleTargetAbilityUsed(s, game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P2.setOnAction(s -> singleTargetAbilityUsed(s, game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P3.setOnAction(s -> singleTargetAbilityUsed(s, game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P4.setOnAction(s -> singleTargetAbilityUsed(s, game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P5.setOnAction(s -> singleTargetAbilityUsed(s,game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P6.setOnAction(s -> singleTargetAbilityUsed(s,game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P7.setOnAction(s -> singleTargetAbilityUsed(s,game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P8.setOnAction(s -> singleTargetAbilityUsed(s, game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P9.setOnAction(s -> singleTargetAbilityUsed(s, game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P10.setOnAction(s -> singleTargetAbilityUsed(s,game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P11.setOnAction(s -> singleTargetAbilityUsed(s, game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P12.setOnAction(s -> singleTargetAbilityUsed(s,game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P13.setOnAction(s -> singleTargetAbilityUsed(s, game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P14.setOnAction(s -> singleTargetAbilityUsed(s, game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P15.setOnAction(s -> singleTargetAbilityUsed(s, game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P16.setOnAction(s -> singleTargetAbilityUsed(s, game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P17.setOnAction(s -> singleTargetAbilityUsed(s, game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P18.setOnAction(s -> singleTargetAbilityUsed(s, game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P19.setOnAction(s -> singleTargetAbilityUsed(s, game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P20.setOnAction(s -> singleTargetAbilityUsed(s, game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P21.setOnAction(s -> singleTargetAbilityUsed(s, game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P21.setOnAction(s -> singleTargetAbilityUsed(s, game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P22.setOnAction(s -> singleTargetAbilityUsed(s, game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P23.setOnAction(s -> singleTargetAbilityUsed(s, game.getCurrentChampion().getAbilities().get(3)));
				taketurn.P24.setOnAction(s -> singleTargetAbilityUsed(s, game.getCurrentChampion().getAbilities().get(3)));
		}

	}

	public void directionalAbilityUsed(Direction d , Ability a) {
		
		try {
			game.castAbility(a, d);
		} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e) {
			error.setContentText(e.getMessage());
			//error.initOwner(frame); 
			error.show();
		}
		
		coverplace();
		updateCurr();
		updateChampLabels();
		updateOrderLabel();
		endGame() ;
		
		taketurn.bottom.getChildren().removeAll(taketurn.upD , taketurn.downD , taketurn.rightD , taketurn.leftD);
		

		
		taketurn.bottom.getChildren().addAll(taketurn.move , taketurn.attack , taketurn.ability1 , taketurn.ability2,
				taketurn.ability3 );
		if(game.hasEffect(game.getCurrentChampion(), "Disarm"))
			taketurn.bottom.getChildren().add(taketurn.punch);
		taketurn.endTurn.setDisable(false);
		
	}

	public void singleTargetAbilityUsed(ActionEvent e , Ability a){

		int x = GridPane.getRowIndex(((Button)e.getSource())) ;
		int y = GridPane.getColumnIndex(((Button)e.getSource())) ;

		try {
			game.castAbility(a, Math.abs(x-4) , y);
		} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
				| CloneNotSupportedException e1) {
			error.setContentText(e1.getMessage());
			//error.initOwner(frame); 
			error.show();
		}

		coverplace();
		updateCurr();
		updateChampLabels();
		updateOrderLabel();
		endGame() ;
		
		taketurn.P0.setOnAction(null);
		taketurn.P1.setOnAction(null);
		taketurn.P2.setOnAction(null);
		taketurn.P3.setOnAction(null);
		taketurn.P4.setOnAction(null);
		taketurn.P5.setOnAction(null);
		taketurn.P6.setOnAction(null);
		taketurn.P7.setOnAction(null);
		taketurn.P8.setOnAction(null);
		taketurn.P9.setOnAction(null);
		taketurn.P10.setOnAction(null);
		taketurn.P11.setOnAction(null);
		taketurn.P12.setOnAction(null);
		taketurn.P13.setOnAction(null);
		taketurn.P14.setOnAction(null);
		taketurn.P15.setOnAction(null);
		taketurn.P16.setOnAction(null);
		taketurn.P17.setOnAction(null);
		taketurn.P18.setOnAction(null);
		taketurn.P19.setOnAction(null);
		taketurn.P20.setOnAction(null);
		taketurn.P21.setOnAction(null);
		taketurn.P21.setOnAction(null);
		taketurn.P22.setOnAction(null);
		taketurn.P23.setOnAction(null);
		taketurn.P24.setOnAction(null);
		
		taketurn.bottom.getChildren().removeAll(taketurn.singeltargetUse);

		

		taketurn.bottom.getChildren().addAll(taketurn.move , taketurn.attack , taketurn.ability1 , taketurn.ability2,
				taketurn.ability3 );
		
		if(game.hasEffect(game.getCurrentChampion(), "Disarm"))
			taketurn.bottom.getChildren().add(taketurn.punch);
		
		taketurn.endTurn.setDisable(false);
	}
	

	
	public void leaderAbilityUse(ActionEvent e) {
		
		try {
			game.useLeaderAbility();
			
		} catch (LeaderNotCurrentException | LeaderAbilityAlreadyUsedException e1) {
			error.setContentText(e1.getMessage());
			//error.initOwner(frame); 
			error.show();
		}
		
		coverplace();
		updateCurr();
		updateChampLabels();
		updateUseLeaderAbility();
		updateOrderLabel();
		endGame() ;
		
	}
	
	public void endGame() {
		if(game.checkGameOver() != null) {
			endscreen.winner.setText("WINNER  "+ game.checkGameOver().getName()) ;
			if(game.checkGameOver()== game.getFirstPlayer())
				endscreen.loser.setText("LOSER  "+ game.getSecondPlayer().getName()) ;
			else
				endscreen.loser.setText("LOSER  "+ game.getFirstPlayer().getName()+"\n") ;
			
			frame.setScene(endscreen.scene);
			frame.setFullScreen(true);
		}
			
	}
	
	public void abilityHover(MouseEvent e) {
		Button b = (Button)e.getSource() ;
		Tooltip t= new Tooltip();
		for(Ability a : Game.getAvailableAbilities()) {
			if (a.getName().equals(b.getText())) {
				t.setText(a.toString());
			}
		}
		if(b.getText().equals("punch")) {
			
			t.setText("Name: Punch\n"
					+ "Cooldown :" + game.getCurrentChampion().getAbilities().get(3).getCurrentCooldown()+ "/1\n"
					+"ActionPoints :1\n"
					+"SingleTarget\n"
					+"AbilityRange: 1\n"
					+"DamagingAbility\nDMG 50");
			
		}
		
		b.setTooltip(t);
		b.setOnMouseExited(e1 -> t.setText(null));
	}
	

	public static void main(String[] args)  {
		launch(args);
	}





}