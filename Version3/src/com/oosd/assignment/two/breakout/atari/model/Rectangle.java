package com.oosd.assignment.two.breakout.atari.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Paddle is a component and has methods that allow it to execute commands such
 * as replay, start, pause and undo
 *
 */

public class Rectangle extends Component implements Serializable {
	int initialPositionX, initialPositionY, paddleX, paddleY,initialX,initialY;
	int paddleWidth, paddleHeight;
	List<Integer> historyX = new ArrayList<Integer>();
	int countX = 0, totalCount = 0;
	Boolean flag = false;
	Color color;

	public Rectangle(Color color, int initialPositionX, int initialPositionY, int paddleWidth, int paddleHeight) {
		this.color = color;
		this.initialX = initialPositionX;
		this.initialY = initialPositionY;
		this.paddleWidth = paddleWidth;
		this.paddleHeight = paddleHeight;
		this.position(initialPositionX, initialPositionY);
	}

	public int getHistoryX() {
		return historyX.get(countX++);
	}

	@Override
	public void position(int x, int y) {
		if (!isGamePaused()) {
			if (!isReplay()) {
				storeHistory();
			}
			paddleX = x;
			paddleY = y;
		}

	}

	public int getPaddleX() {
		return paddleX;
	}

	public Color getColor() {
		return color;
	}
	
	public void setPaddleX(int paddleX) {
		this.paddleX = paddleX;
	}

	public int getPaddleY() {
		return paddleY;
	}

	public void setPaddleY(int paddleY) {
		this.paddleY = paddleY;
	}

	@Override
	public void undo() {
		paddleX = historyX.get(historyX.size() - 1);
		historyX.remove(historyX.size() - 1);
		if (!isGamePaused())
			pause();
	}

	@Override
	public void replay() {
		totalCount = historyX.size();
		setGamePaused(false);
		setReplay(true);

	}

	@Override
	public void storeHistory() {
		historyX.add(paddleX);

	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(this.color);
		g2d.fillRect(paddleX, paddleY, paddleWidth, paddleHeight);

	}

	private int getpaddleWidth() {
		return getPaddleWidth();
	}

	private int getpaddleHeight() {
		return paddleHeight;
	}

	public int getPaddleWidth() {
		return paddleWidth;
	}

	public int getPaddleHeight() {
		return paddleHeight;
	}

	@Override
	public void endReplay() {
		countX = 0;
		setReplay(false);
		if (!isGamePaused())
			pause();

	}

	public int getCountPos() {
		return countX;
	}

	/*
	 * public void explode() {
	 * 
	 * if (!isGamePaused()) { position(-100, -100); if (!isReplay()) {
	 * storeHistory(); } }
	 * 
	 * }
	 */
	public int getInitialX() {
		return initialX;
	}

	public int getInitialY() {
		return initialY;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public List<Integer> getHistX() {
		return historyX;
	}

	public void setHistX(List<Integer> list) {
		historyX = list;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return paddleX;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return paddleY ;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		paddleX = x;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		paddleY = y;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return paddleHeight;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return paddleWidth;
	}

	@Override
	public void setWidth(int x) {
		// TODO Auto-generated method stub
		paddleWidth=x;
	}

	@Override
	public void setHeight(int y) {
		// TODO Auto-generated method stub
		paddleHeight=y;
	}

}
