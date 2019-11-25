package com.gamemaker.team6.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 * 
 * DigitalClock is a component and has methods that allow it to execute commands
 * such as replay, start, pause and undo
 *
 */

public class DigitalClock extends Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int currMinutes, currSeconds, positionX, positionY, countMinutes = 0, countSeconds = 0, fontSize, totalCount = 0;

	public DigitalClock(int positionX, int positionY, String message, int fontSize) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.fontSize = fontSize;
		this.position(0, 0);
	}

	@Override
	public void position(int minutes, int seconds) {
		if (!isGamePaused()) {
			setCurrSeconds(seconds);
			setCurrMinutes(minutes);
		}
	}

	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		Font f = new Font("Dialog", Font.PLAIN, 20);
		g2d.setFont(f);
		g2d.drawString(currMinutes + ":" + currSeconds, positionX, positionY);

	}



	public int getCurrMinutes() {
		return currMinutes;
	}

	public void setCurrMinutes(int currMinutes) {
		this.currMinutes = currMinutes;
	}

	public int getCurrSeconds() {
		return currSeconds;
	}

	public void setCurrSeconds(int currSeconds) {
		this.currSeconds = currSeconds;
	}

}
