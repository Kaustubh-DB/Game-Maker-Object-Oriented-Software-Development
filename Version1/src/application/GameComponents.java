
package application;

	import java.util.ArrayList;

	import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

	public class GameComponents {
		static Coordinates[] coordinateArray =new Coordinates[100000];
		static ArrayList<Element> gameComponentsArray=new ArrayList<Element>();
		int i=0;
		Element c;
		Element r1,r2;
		Pane root;
		public GameComponents() {
			// TODO Auto-generated constructor stub
		}

		GameComponents(Element ballElement,Element bat,Element brick,Pane root)
		{
			this.c=ballElement;
			this.r1=bat;
			this.r2=brick;
			this.root=root;
			gameComponentsArray.add(c);//index 0
			gameComponentsArray.add(r1);//index 1
			gameComponentsArray.add(r2);//index 2
		
		}
		
		
		void storeCoordinates(Element ballElement,Element bat, Element brick)
		{	
			
			coordinateArray[i]=new Coordinates();
			coordinateArray[i].xOfBall=ballElement.shape.getTranslateX();
			coordinateArray[i].yOfBall=ballElement.shape.getTranslateY();
			coordinateArray[i].xOfBat=bat.shape.getTranslateX();
			coordinateArray[i].yOfBat=bat.shape.getTranslateY();
			coordinateArray[i].xOfBrick=brick.shape.getTranslateX();
			coordinateArray[i].yOfBrick=brick.shape.getTranslateY();
			System.out.println(coordinateArray[i].xOfBall);
			System.out.println(i);
			System.out.println(coordinateArray[i].yOfBall);
			i=i+1;
			
			
		} 

	}


