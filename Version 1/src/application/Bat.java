package application;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bat extends Element {

	int BAT_W;
	int BAT_H;
	Color color;


public Bat() {
		
	}
	
	
	public Bat(int x, int y,Color color) {
		this.BAT_W=x;
		this.BAT_H=y;
		this.color=color;
		shape=new Rectangle(BAT_W,BAT_H,color);
		shape.setTranslateX(400);
		shape.setTranslateY(350);
	}
	
	@Override
	public void display(Pane pane) {
		// TODO Auto-generated method stub
		shape.setTranslateX(400);
		shape.setTranslateY(350);
		shape.setFill(color);
		pane.getChildren().add(shape);
	}

	public void setTranslateX(int BAT_W) {
		// TODO Auto-generated method stub
		shape.setTranslateX(BAT_W);
	}

	public void setTranslateY(int BAT_H) {
		// TODO Auto-generated method stub
		shape.setTranslateY(BAT_H);
	}

	public double getTranslateX() {
		// TODO Auto-generated method stub
		return shape.getTranslateX();
	}
	
	
	public double getTranslateY() {
		// TODO Auto-generated method stub
		return shape.getTranslateY();
	}
	
	public double getBAT_W() {
		return BAT_W;
	}


	public void setBAT_W(double bAT_W) {
		BAT_W = (int) bAT_W;
	}

	@Override
	public void position(double x, double y) {
		// TODO Auto-generated method stub

	}

}
