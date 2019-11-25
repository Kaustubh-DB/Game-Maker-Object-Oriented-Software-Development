package application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class BallMovement implements Movement {

	@Override
	public void move(Element element, Shape shape, Scene scene, Boolean ballUp,Boolean ballLeft) {
		// TODO Auto-generated method stub
				
		Ball ballElement = new Ball(10,Color.BLACK);
	
		if (shape.getTranslateY() - ballElement.radius == 0)
		{
			element.ballUp = false;		
		}
		
		if (shape.getTranslateX() - ballElement.radius == 0)
		{
			element.ballLeft = false;
		}
		else if (shape.getTranslateX() + ballElement.radius == 800)
		{
			
			element.ballLeft = true;
		}
			

		if (shape.getTranslateY() + ballElement.radius == 600)
			element.ballUp = true;

		
		shape.setTranslateX(shape.getTranslateX() + (element.ballLeft ? -5 : 5));
		shape.setTranslateY(shape.getTranslateY() + (element.ballUp ? -5 : 5));

		/*
		 * System.out.println(ballElement.radius);
		 * System.out.println(shape.getTranslateX());
		 * System.out.println(shape.getTranslateY());
		 */
		
	}
	
}

