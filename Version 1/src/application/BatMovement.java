package application;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class BatMovement implements Movement {
		
	Bat batElement = new Bat(180,20,Color.BLUE);

	@Override
	public void move(Element element, Shape shape, Scene scene, Boolean ballUp, Boolean ballLeft) {
		// TODO Auto-generated method stub

		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
	          @Override
	          public void handle(KeyEvent event){
	            if (event.getCode() == KeyCode.LEFT) 
	            {
	            	if (shape.getTranslateX() - 10 >= 0) {
	    				shape.setTranslateX(shape.getTranslateX() - 10);	    				
	    			}
	            } 
	            else if (event.getCode() == KeyCode.RIGHT) 
	            {
	            	if (shape.getTranslateX() + batElement.BAT_W + 10 <= 800) {
	    				shape.setTranslateX(shape.getTranslateX() + 10);
	    			}
	            }
	          }
	        });
	}

	
	
}
