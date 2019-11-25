package com.gamemaker.team6.model;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 
 * Paddle is a component and has methods that allow it to execute commands such
 * as replay, start, pause and undo
 *
 */

public class Rectangle extends Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Color color;

	public Rectangle(Color color, int initialPositionX, int initialPositionY, int paddleWidth, int paddleHeight) {
		
		this.color = color;
		setPosX(initialPositionX);
		setPosY(initialPositionY);
		position(initialPositionX, initialPositionY);
		setHeight(paddleHeight);
		setWidth(paddleWidth);
		position(initialPositionX, initialPositionY);
	}





	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(this.color);
		
		g2d.fillRect(getPosX(), getPosY(), getWidth(), getHeight());

	}


}
