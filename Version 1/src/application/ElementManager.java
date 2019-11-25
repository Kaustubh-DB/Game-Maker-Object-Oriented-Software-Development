package application;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import application.Main;

public class ElementManager {
	int j = 0;
	List<Element> elementsList;
	static Coordinates[] coordinateArray =new Coordinates[10000];
	static List arrayList = new ArrayList();
	static Stack ballx = new Stack();
	static Stack bally = new Stack();
	static Stack batx = new Stack();
	static StackBool bup = new StackBool();
	static StackBool bleft = new StackBool();
	Main main = new Main();
	int i = 0;
	Pane root;

	// static count = 0;
	public ElementManager() {
		elementsList = new ArrayList<Element>();
	}

	public void addElements(Element element, Pane pane, Movement movement) {
		element.display(pane);
		root = pane;
		element.setMovement(movement);
		// element.setResponse(response);
		elementsList.add(element);
	}

	void storeCoordinates(Element ballElement,Element bat, Element brick, boolean ballUp, boolean ballLeft)
	{	
		
		
		  coordinateArray[i]=new Coordinates();
		  coordinateArray[i].xOfBall=ballElement.shape.getTranslateX();
		  coordinateArray[i].yOfBall=ballElement.shape.getTranslateY();
		  coordinateArray[i].xOfBat=bat.shape.getTranslateX();
		  coordinateArray[i].yOfBat=bat.shape.getTranslateY();
		  coordinateArray[i].xOfBrick=brick.shape.getTranslateX();
		  coordinateArray[i].yOfBrick=brick.shape.getTranslateY();
		  coordinateArray[i].bup=ballUp; coordinateArray[i].bleft=ballLeft;
		  //System.out.println(coordinateArray[i].xOfBall); System.out.println(i);
		  //System.out.println(coordinateArray[i].yOfBall); 
		  i=i+1;
		 	
		
	
	}
	
	void storeStack(Element ballElement, Element bat, Element brick, boolean ballUp, boolean ballLeft ) {
		ballx.push(ballElement.shape.getTranslateX());
		bally.push(ballElement.shape.getTranslateY());
		batx.push(bat.shape.getTranslateX());
		System.out.println(batx.push(bat.shape.getTranslateX())+"*************************************");
		System.out.println("BatX posiiton: "+bat.shape.getTranslateX());
		bup.push(ballUp);
		bleft.push(ballLeft);
	}

	public void undo(ElementManager m) {
		ballx.pop();
		bally.pop();
		batx.pop();
		bup.pop();
		bleft.pop();
		m.elementsList.get(0).shape.setTranslateX(ballx.pop());
		m.elementsList.get(0).shape.setTranslateY(bally.pop());
		System.out.println("bat x coordinate" + batx.pop());
		System.out.println(m.elementsList.get(1)+"***************************************");
		m.elementsList.get(1).shape.setTranslateX(batx.pop());
		System.out.println(batx.pop()+"*************************Popped value of bat************************");
		m.elementsList.get(2).shape.setTranslateX(500);
		m.elementsList.get(2).shape.setTranslateY(500);
		main.ballUp = bup.pop();
		main.ballLeft = bleft.pop();	
	}

	public void replay(ElementManager m, Timeline tl) {
		int k;
		tl.stop();

		System.out.println("Hi i am in start command!");
		for (k = 0; k < m.elementsList.size(); k++) {
			// System.out.println(iterator.next().shape);
			m.root.getChildren().remove(m.elementsList.get(k).shape);
		}
		for (k = 0; k < m.elementsList.size(); k++) {
			// System.out.println(iterator.next().shape);
			m.root.getChildren().add(m.elementsList.get(k).shape);
			if (k == 0) {
				m.elementsList.get(k).shape.setTranslateX(400);
				m.elementsList.get(k).shape.setTranslateY(300);
			}

			if (k == 1) {
				m.elementsList.get(k).shape.setTranslateX(400);
				m.elementsList.get(k).shape.setTranslateY(350);
			}

			if (k == 2) {
				m.elementsList.get(k).shape.setTranslateX(500);
				m.elementsList.get(k).shape.setTranslateY(500);
			}

			createVideoTimeline(m);
		}
	}

	// root.getChildren().remove(shape);
	// root.getChildren().remove(bat2);
	// root.getChildren().add(shape);
	// root.getChildren().add(bat2);
	// shape.relocate(10, 10);
	// bat2.relocate(100, 200);
	// MainReplayLogic mainObject=new MainReplayLogic();
	// mainObject.createVideoTimeline(element);

	public void endCommand() {
	}

	void replayLogic(ElementManager m, Timeline tl) {
		if (j == m.i) {
			tl.stop();
			return;
		}

		System.out.println("Entered the loop!");
		System.out.println(j);
		System.out.println(m.i);
		System.out.println("replay y coordinate" + m.coordinateArray[j].yOfBall);
		// g.gameComponentsArray.get(1).shape.setTranslateX(g.coordinateArray[j].xOfBat);
		m.elementsList.get(1).shape.setTranslateX(m.coordinateArray[j].xOfBat);
		m.elementsList.get(1).shape.setTranslateY(m.coordinateArray[j].yOfBat);
		m.elementsList.get(0).shape.setTranslateX(m.coordinateArray[j].xOfBall);
		m.elementsList.get(0).shape.setTranslateY(m.coordinateArray[j].yOfBall);
		m.elementsList.get(2).shape.setTranslateX(m.coordinateArray[j].xOfBrick);
		m.elementsList.get(2).shape.setTranslateY(m.coordinateArray[j].yOfBrick);
		System.out.println(j);
		j = j + 1;
	}

	void createVideoTimeline(ElementManager m) {

		Timeline tl = new Timeline();

		tl.setCycleCount(Animation.INDEFINITE);
		System.out.println("Created a new Timeline!");
		KeyFrame moveBall = new KeyFrame(Duration.seconds(0.076), new EventHandler<ActionEvent>() {

			@Override

			public void handle(ActionEvent event) {

				replayLogic(m, tl);

				// TODO Auto-generated method stub

			}

		});
		tl.getKeyFrames().add(moveBall);

		tl.play();

	}

	public void removeElements() {
		elementsList.clear();
	}

}
