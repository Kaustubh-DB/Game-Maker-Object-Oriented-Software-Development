package com.gamemaker.team6.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

/**
 * 
 * Ball is a component and has methods that allow it to execute commands such as
 * replay, start, pause and undo
 *
 */
public class Circle extends Component implements Serializable {
	private static final long serialVersionUID = 1L;
	private Color color;

	public Circle(Color color, int initialPositionX, int initialPositionY, int ballWidth, int ballHeight) {
		this.color = color;
		setPosX(initialPositionX);
		setPosY(initialPositionY);
		position(initialPositionX, initialPositionY);
		setHeight(ballHeight);
		setWidth(ballWidth);	
	}


	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}



	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(this.color);
		g2d.fillOval(getPosX(), getPosY(), getWidth(), getHeight());

	}


	

}
