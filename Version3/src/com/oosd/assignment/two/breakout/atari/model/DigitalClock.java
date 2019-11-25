package com.oosd.assignment.two.breakout.atari.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * DigitalClock is a component and has methods that allow it to execute commands
 * such as replay, start, pause and undo
 *
 */

public class DigitalClock extends Component {

	int currMinutes, currSeconds, positionX, positionY, countMinutes = 0, countSeconds = 0, fontSize, totalCount = 0;
	List<Integer> historyMinutes = new ArrayList<Integer>();
	List<Integer> historySeconds = new ArrayList<Integer>();

	public DigitalClock() {
	}

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
			if (!isReplay()) {
				storeHistory();
			}
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

	@Override
	public void undo() {
		currMinutes = historyMinutes.get(historyMinutes.size() - 1);
		currSeconds = historySeconds.get(historySeconds.size() - 1);
		historyMinutes.remove(historyMinutes.size() - 1);
		historySeconds.remove(historySeconds.size() - 1);
		if (!isGamePaused())
			pause();
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

	@Override
	public void storeHistory() {
		historyMinutes.add(currMinutes);
		historySeconds.add(currSeconds);

	}

	public int getHistoryMinutes() {
		return historyMinutes.get(countMinutes++);
	}

	public int getHistorySeconds() {
		return historySeconds.get(countSeconds++);
	}

	@Override
	public void replay() {
		totalCount = historyMinutes.size();
		setGamePaused(false);
		setReplay(true);
	}

	@Override
	public void endReplay() {
		countMinutes = 0;
		countSeconds = 0;
		setReplay(false);
		if (!isGamePaused())
			pause();

	}

	public int getCountPos() {
		return countMinutes;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public List<Integer> getAllMins() {
		return historyMinutes;
	}

	public void setAllMins(List<Integer> list) {
		historyMinutes = list;
	}

	public List<Integer> getAllSec() {
		return historySeconds;
	}

	public void setAllSec(List<Integer> list) {
		historySeconds = list;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setWidth(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHeight(int y) {
		// TODO Auto-generated method stub
		
	}
}
