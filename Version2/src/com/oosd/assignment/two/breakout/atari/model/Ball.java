package com.oosd.assignment.two.breakout.atari.model;

import java.util.ArrayList;
import java.util.List;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 
 * Ball is a component and has methods that allow it to execute commands such as
 * replay, start, pause and undo
 *
 */
public class Ball extends Component {
	private int initialPositionX, initialPositionY, ballX, ballY;
	private Color color;
	private int countPosX = 0;
	private int countPosY = 0;
	private int lastDx;
	private int lastDy;
	private int totalCount = 0;
	private int ballWidth = 0;
	private int ballHeight = 0;

	private List<Integer> historyX = new ArrayList<Integer>();
	private List<Integer> historyY = new ArrayList<Integer>();

	public Ball(Color color, int initialPositionX, int initialPositionY, int ballWidth, int ballHeight) {
		this.color = color;
		this.initialPositionX = initialPositionX;
		this.initialPositionY = initialPositionY;
		this.position(initialPositionX, initialPositionY);
		this.ballHeight = ballHeight;
		this.ballWidth = ballWidth;
		this.countPosX = 0;
		this.countPosY = 0;
		this.totalCount = 0;
	}

	public int getBallX() {
		return ballX;
	}

	public int getBallY() {
		return ballY;
	}

	public void setBallX(int x) {
		ballX = x;
	}

	public void setBallY(int y) {
		ballY = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void undo() {
		ballX = historyX.get(historyX.size() - 1);
		ballY = historyY.get(historyY.size() - 1);
		historyX.remove(historyX.size() - 1);
		historyY.remove(historyY.size() - 1);
		if (!isGamePaused())
			pause();
	}

	@Override
	public void storeHistory() {
		historyX.add(ballX);
		historyY.add(ballY);
		lastDx = getDx();
		lastDy = getDy();
	}

	public int getHistoryX() {
		return historyX.get(countPosX++);
	}

	public int getHistoryY() {
		return historyY.get(countPosY++);
	}

	@Override
	public void replay() {
		totalCount = historyX.size();
		setGamePaused(false);
		setReplay(true);
	}

	public void endReplay() {
		countPosX = 0;
		countPosY = 0;
		setReplay(false);
		if (!isGamePaused())
			pause();
	}

	@Override
	public void position(int x, int y) {
		// TODO Auto-generated method stub
		if (!isGamePaused()) {
			if (!isReplay()) {
				storeHistory();
			}
			ballX = x;
			ballY = y;
		}
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(this.color);
		g2d.fillOval(ballX, ballY, getBallWidth(), ballHeight);

	}

	public int getBallWidth() {
		return ballWidth;
	}

	public int getBallHeight() {
		return ballHeight;
	}

	public int getpaddleYloc() {
		return initialPositionY;
	}

	public int getCountPos() {
		return countPosX;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getLastDx() {
		return lastDx;
	}

	public int getLastDy() {
		return lastDy;
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

}
