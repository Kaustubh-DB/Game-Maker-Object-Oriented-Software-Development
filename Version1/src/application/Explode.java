package application;

import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class Explode implements Interaction {

	@Override
	public boolean response(Element brick, Scene scene, Element ballElement) {
		// TODO Auto-generated method stub
		//Ball ballElement = new Ball(10,Color.BLACK);
		//Brick brick = new Brick(50,10,Color.DARKRED);
		

		
		if (ballElement.shape.getTranslateY() + ballElement.radius == 600 - 100
				&& ballElement.shape.getTranslateX() + ballElement.radius <= brick.shape.getTranslateX() + brick.BRICK_W
				&& ballElement.shape.getTranslateX() - ballElement.radius >= brick.shape.getTranslateX()) { 
			return true;
		}

		if (ballElement.shape.getTranslateY() - ballElement.radius == 600 - 90
				&& ballElement.shape.getTranslateX() + ballElement.radius <= brick.shape.getTranslateX() + brick.BRICK_W
				&& ballElement.shape.getTranslateX() - ballElement.radius >= brick.shape.getTranslateX()) {
			return true;
		}

		return false;
	}

}
