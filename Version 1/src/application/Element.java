package application;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public abstract class Element {
	Movement movement;
	//Response response;
	Shape shape;
	double x;
	double radius=10.0;
	double BAT_W=180,BRICK_W=50;

	double y;
	
	public boolean ballUp=true, ballLeft=false;
	
	public void Elements() {
		
	}
	
	public abstract void display(Pane pane);
	
	public abstract void position(double x, double y);
	
	public void move(Scene scene) {
		this.movement.move(this, shape, scene,ballUp,ballLeft);
	}
	
	
	/*
	 * public boolean response(Scene scene, Element ball){ return
	 * this.response.resp(this, scene, ball);
	 * 
	 * }
	 */
	 

	  
	  public  abstract double getTranslateX() ;

	  public  abstract double getTranslateY() ;
		public abstract void setTranslateX(int x);

		public abstract void setTranslateY(int y);
	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}

	
	/*
	 * public Response getResponse() { return response; }
	 * 
	 * 
	 * public void setResponse(Response response) { this.response = response; }
	 */
	 
	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

}
