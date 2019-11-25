package com.oosd.assignment.two.breakout.atari.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Brick is a component and has methods that allow it to execute commands such
 * as replay, start, pause and undo
 *
 */
public class Square extends Component implements Serializable {
	private int length, width, brickX, brickY, initialX, initialY;
	private Color color;
	private int countPosX = 0;
	private int countPosY = 0;
	private int totalCount = 0;
	private int lastDx;
	private int lastDy;
	private List<Integer> historyX = new ArrayList<Integer>();
	private List<Integer> historyY = new ArrayList<Integer>();

	public Square( int initialPositionX, int initialPositionY,Color color,int length, int width) {
		super();
		this.length = length;
		this.width = width;
		this.color = color;
		this.initialX = initialPositionX;
		this.initialY = initialPositionY;
		this.countPosX = 0;
		this.countPosY = 0;
		this.totalCount = 0;
		this.position(initialPositionX, initialPositionY);
	}

	public int getBrickX() {
		return brickX;
	}

	public void setBrickX(int bx) {
		this.brickX = bx;
	}

	public int getBrickY() {
		return brickY;
	}

	public void setBrickY(int by) {
		this.brickY = by;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(this.color);
		g.fillRect(brickX, brickY, width, length);
	}
	
	public int getLastDx() {
		return lastDx;
	}
	
	public int getLastDy() {
		return lastDy;
	}

	@Override
	public void position(int x, int y) {
		if (!isGamePaused()) {
			if (!isReplay()) {
				storeHistory();
			}
			brickX = x;
			brickY = y;
		}
		// this.update();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		brickX = historyX.get(historyX.size() - 1);
		brickY = historyY.get(historyY.size() - 1);
		historyX.remove(historyX.size() - 1);
		historyY.remove(historyY.size() - 1);
		if (!isGamePaused())
			pause();

	}

	@Override
	public void replay() {
		// TODO Auto-generated method stub
		totalCount = historyX.size();
		countPosX = 0;
		countPosY = 0;
		setGamePaused(false);
		setReplay(true);

	}

	@Override
	public void storeHistory() {
		// TODO Auto-generated method stub
		historyX.add(brickX);
		historyY.add(brickY);

	}

	@Override
	public void endReplay() {
		// TODO Auto-generated method stub
		countPosX = 0;
		countPosY = 0;
		setReplay(false);
		if (!isGamePaused())
			pause();

	}

	public int getCountPos() {
		return countPosX;
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

	public int getHistoryX() {
		return historyX.get(countPosX++);
	}

	public int getHistoryY() {
		return historyY.get(countPosY++);
	}

	public int getTotalCount() {
		return totalCount;
	}

	public List<Integer> getHistX() {
		return historyX;
	}

	public List<Integer> getHistY() {
		return historyY;
	}

	public void clearHistX() {
		historyX.clear();
	}

	public void clearHistY() {
		historyY.clear();
	}

	public void setHistX(List<Integer> list) {
		historyX = list;
	}

	public void setHistY(List<Integer> list) {
		historyY = list;

	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		
		return brickX;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return brickY;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		brickX = x;
		
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		brickY = y;
		
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return length;
	}

	@Override
	public void setHeight(int y) {
		// TODO Auto-generated method stub
		length =y;
		
	}
}
