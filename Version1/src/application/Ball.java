package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Element {
	
 double radius=10.0;
	Color color;
	 
	public Ball() {
		
	}
	
	public Ball(double radius, Color color) {
		this.color = color;
		this.radius = radius;
		shape = new Circle(radius, color);
		shape.setTranslateX(400);
		shape.setTranslateY(300);
		
	}
	
	@Override
	public void display(Pane pane) {
		// TODO Auto-generated method stub
		shape.setTranslateX(400);
		shape.setTranslateY(300);
		pane.getChildren().add(shape);
	}
	
	public void position(double x, double y) {
		shape.relocate(x, y);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public double getTranslateX() {
		// TODO Auto-generated method stub
		return (int) shape.getTranslateX();
	}

	public double getTranslateY() {
		// TODO Auto-generated method stub
		return  (int)shape.getTranslateY();
	}

	public void setTranslateX(int x) {
		// TODO Auto-generated method stub
		shape.setTranslateX(x);
	}

	public void setTranslateY(int y) {
		// TODO Auto-generated method stub
		shape.setTranslateY(y);
	}
	
	

}
