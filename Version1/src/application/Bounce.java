package application;

import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class Bounce implements Interaction {

	
	
	public boolean response(Element batElement, Scene scene, Element ballElement) {
		// TODO Auto-generated method stub
		/*
		 * Ball ballElement = new Ball(10,Color.BLACK); Bat batElement = new
		 * Bat(180,20,Color.BLUE);
		 */
		
		
		System.out.println("ball Y" + ballElement.getTranslateY() );
		System.out.println("ball Radius" + ballElement.radius);
		System.out.println("ball X" + ballElement.getTranslateX());
		System.out.println("bat Y" + batElement.shape.getTranslateX());
		System.out.println("Bat Width" + batElement.BAT_W);
		System.out.println("App Height" + 350);
		
		
		
		System.out.println(batElement.BAT_W);
		
		if (ballElement.shape.getTranslateY() + ballElement.radius == 350
				&& ballElement.shape.getTranslateX() + ballElement.radius <= batElement.shape.getTranslateX() + batElement.BAT_W
				&& ballElement.shape.getTranslateX() - ballElement.radius >= batElement.shape.getTranslateX()) {
			
			ballElement.ballUp = true;
			return true;
		}

		if (ballElement.shape.getTranslateY() - ballElement.radius  == 360
				&& ballElement.shape.getTranslateX() + ballElement.radius  <= batElement.shape.getTranslateX() + batElement.BAT_W
				&& ballElement.shape.getTranslateX() - ballElement.radius  >= batElement.shape.getTranslateX())
		{
			ballElement.ballUp = false;
			return true;
		}
		return false;
	}
}
