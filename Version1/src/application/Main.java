
package application;


import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.text.SimpleDateFormat;
import java.io.File;
import java.net.URL;

import javafx.animation.Animation; import
javafx.animation.KeyFrame; import javafx.animation.Timeline;
import javafx.animation.Animation.Status;
import
javafx.application.Application; import javafx.event.ActionEvent; import
javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage; import
javafx.util.Duration;
import observable.ClockObservable;
import observable.ClockObservableImpl;
import observable.ClockObserver;
import observable.NormalClockObserver;
import observable.StopWatchClockObserver;
import observable.TimerClockObserver;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import
javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class Main extends Application {

	//GameComponents gameComponents;
	Undo undo;
	Replay replay;
	public static boolean ballUp= true;
	static boolean ballLeft=false;
	int l=0;
	private static  ClockObservable clockObservableImpl = new ClockObservableImpl();
	private static  ClockObserver normalClockObserver = new NormalClockObserver();
	private static  ClockObserver stopWatchClockObserver = new StopWatchClockObserver();
	private static ClockObserver timerClockObserver = new TimerClockObserver();
	
	Ball ballElement = new Ball(10,Color.BLACK);
	Bat bat = new Bat(180,20,Color.BLUE);
	Brick brick = new Brick(50, 10, Color.DARKRED);	
	Stage stage = null; 
	Scene scene;
	Timeline tl;
	ElementManager manager;
	Bounce bounce;
	Explode explode;
	Pane pane;
	MediaView mediaView;
	static int count = 0;
	Text clockText3;
	// public UserAction action = UserAction.NONE;

	@Override public void start(Stage primaryStage) 
	{ 

		stage = primaryStage;
		Text clockText1 = stopWatchClockObserver.getTxtTime();
		SimpleDateFormat startTime = new SimpleDateFormat("hh:mm:ss");
		Text clockText2 = normalClockObserver.getTxtTime();
		clockText3 = timerClockObserver.getTxtTime();
		VBox leftPanel  = createPanel(); 
		leftPanel.getChildren().add(clockText3);


		pane = new Pane(); 
		pane.setPrefSize(800, 600); 
		
		BorderPane.setAlignment(clockText1,Pos.TOP_CENTER); // setting the center position for clock 
		BorderPane.setAlignment(leftPanel,Pos.CENTER_LEFT); //
		//BorderPane.setAlignment(rightPanel,Pos.CENTER_RIGHT);
		BorderPane.setAlignment(clockText2,Pos.BOTTOM_CENTER);	


		BorderPane borderPane = new BorderPane(pane, clockText1	, null , null, leftPanel); 

		
		scene = new Scene(borderPane);

		manager = new ElementManager();
		bounce = new Bounce();
		explode = new Explode();



		manager.addElements(ballElement,pane,new BallMovement());
		manager.addElements(bat, pane, new BatMovement()); 
		bat.move(scene);
		manager.addElements(brick, pane,null);
		//gameComponents=new GameComponents(ballElement,bat,brick,pane);


		stage.setScene(scene); 
		stage.show(); 

		


	}	
	private void initiateTimeline()
	{
		try
		{
			tl = new Timeline(); 
			tl.setCycleCount(Animation.INDEFINITE);
			KeyFrame moveBall = new KeyFrame(Duration.seconds(0.015), new
					EventHandler<ActionEvent>() {

				@Override public void handle(ActionEvent event) { // TODO Auto-generated
					
					manager.storeCoordinates(ballElement,bat,brick,ballUp,ballLeft);//for replay
					manager.storeStack(ballElement, bat, brick, ballUp, ballLeft);//for undo
					if(count == 1)
			 		{
			 			System.out.println("time increment shoud get called.");
			 			clockObservableImpl.notifyObservers();	
			 			count = 0;
			 		}
			 		count++;

					
					ballElement.move(scene); 
					bounce.response(bat,scene,ballElement);
					if(explode.response(brick,scene, ballElement)) {
						tl.stop();
						pane.getChildren().clear();
						//manager.removeElements();
						 String path = "C://Users//kaust//Downloads/game_over3.mp4";  
				          
					        //Instantiating Media class  
					        Media media = new Media(new File(path).toURI().toString());  
					          
					        //Instantiating MediaPlayer class   
					        MediaPlayer mediaPlayer = new MediaPlayer(media);  
					          
					        //Instantiating MediaView class   
					         mediaView = new MediaView(mediaPlayer);  
					          
					        //by setting this property to true, the Video will be played   
					        mediaPlayer.setAutoPlay(true);  
					          
					        //setting group and scene   
				        pane.getChildren().add(mediaView); 
					}

				} }); tl.getKeyFrames().add(moveBall);
				tl.play();

			
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
}
private VBox createPanel()
{
	VBox leftPanel = new VBox(); 
	leftPanel.setPadding(new Insets(25, 25, 25, 25));
	leftPanel.setSpacing(20);
	leftPanel.autosize();
	leftPanel.setStyle("-fx-border-color:black;");

	//Creating the buttons for the left panel.
	Button pauseButton = new Button("Pause");
	pauseButton.autosize();
	Button undoButton = new Button("Undo");
	undoButton.autosize();
	Button startButton = new Button("Start");
	startButton.autosize();
	Button restartButton = new Button("restart");
	restartButton.autosize();
	Button replayButton = new Button("replay");
	replayButton.autosize();


	leftPanel.getChildren().add(pauseButton);
	leftPanel.getChildren().add(undoButton); 
	leftPanel.getChildren().add(startButton); 
	leftPanel.getChildren().add(restartButton);
	leftPanel.getChildren().add(replayButton);

	startButton.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			initiateTimeline();
		}

	});
	
	
	replayButton.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			
			replay=new Replay(manager);
			CommandInvoker commandInvoker=new CommandInvoker(replay,undo);
			System.out.println("Hi! i am in replay!");
			replay.execute(tl);
			
			//replay.startCommand(manager,tl);
			//tl.stop();
        	//root.getChildren().remove(ballElement.shape);
        	//root.getChildren().remove(bat.shape);
        	//root.getChildren().add(brick.shape);
        	//root.getChildren().add(ballElement.shape);
        	//root.getChildren().add(bat.shape);
        	//ballElement.shape.relocate(400,300);
        	//bat.shape.relocate(400, 350);
        	//brick.shape.relocate(500, 500);
        	//replay.createVideoTimeline(gameComponents);
        	//MainReplayLogic mainObject=new MainReplayLogic();
        	//mainObject.createVideoTimeline(element);
			manager.root.getChildren().remove(mediaView);

		}

	});
	
	
	
	restartButton.setOnAction(new EventHandler<ActionEvent>() {
		
		

		@Override
		public void handle(ActionEvent event) {
			try 
			{
				//timerClockObserver.setMin(0);
				//timerClockObserver.setSec(0);
				clockText3.setText("00:00");
				//stop();
				//tl.stop();
				Main newGame= 	new Main();
				stage.close();
				Stage newStage = new Stage();
				newGame.start(newStage);
				for(l=0;l<manager.coordinateArray.length;l++)
				{manager.coordinateArray[l].xOfBall=0;
				manager.coordinateArray[l].yOfBall=0;
				manager.coordinateArray[l].xOfBat=0;
				manager.coordinateArray[l].yOfBat=0;
				manager.coordinateArray[l].xOfBrick=0;
				manager.coordinateArray[l].yOfBrick=0;}
				//initiateTimeline();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	});

	pauseButton.setOnAction(new EventHandler<ActionEvent>() 
	{

		@Override
		public void handle(ActionEvent event)
		{
			if(tl.getStatus() == Status.PAUSED)
			{
				tl.play();
				pauseButton.setText("Pause");
				System.out.println("Game Resumed");
			}
			else
			{
				tl.pause();
				pauseButton.setText("Resume");
				System.out.println("status = " + tl.getStatus());

			}
			System.out.println("status = " + tl.getStatus());

		}

	});

	undoButton.setOnAction(new EventHandler<ActionEvent>() 
	{

		@Override
		public void handle(ActionEvent event) 
		{
			 undo = new Undo(manager);
			CommandInvoker commandInvoker=new CommandInvoker(replay,undo);
			undo.execute(tl);
			System.out.println("undo functionality ");
			manager.root.getChildren().remove(mediaView);
			//batcommandInvoker.undo();
			//ballcommandInvoker.undo();
			//clockcommandInvoker.undo();
			//brickcommandInvoker.undo();
		}
	});
	return leftPanel;
}

@Override
public void stop() throws Exception {
	// we need to stop our working thread after closing a window 
	// or our program will not exit
	super.stop();
	//enough = true;
}

public static void main(String[] args) 
{
	clockObservableImpl.register(normalClockObserver);
	clockObservableImpl.register(stopWatchClockObserver);
	clockObservableImpl.register(timerClockObserver);
	launch(args);
} 
}
