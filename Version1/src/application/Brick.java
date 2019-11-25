package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Brick extends Element {
	
	int BRICK_W;
	int BRICK_H;
	Color color;
	
	public Brick(int i, int j, Color color) {
		// TODO Auto-generated constructor stub
		this.BRICK_W=50;
		this.BRICK_H=10;
		this.color=color;
		shape = new Rectangle(BRICK_W, BRICK_H, color);
		shape.setTranslateX(500);
		shape.setTranslateY(500);
	}

	public int getBAT_W() {
		return BRICK_W;
	}

	public void setBAT_W(int bAT_W) {
		BRICK_W = bAT_W;
	}

	public int getBAT_H() {
		return BRICK_H;
	}

	public void setBAT_H(int bAT_H) {
		BRICK_H = bAT_H;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void display(Pane pane) {
		// TODO Auto-generated method stub
		pane.getChildren().add(shape);
	}

	@Override
	public void position(double x, double y) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getTranslateX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTranslateY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTranslateX(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTranslateY(int y) {
		// TODO Auto-generated method stub
		
	}

}
