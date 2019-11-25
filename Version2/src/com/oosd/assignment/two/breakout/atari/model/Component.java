package com.oosd.assignment.two.breakout.atari.model;

import java.awt.Graphics2D;

import com.oosd.assignment.two.Breakout;
import com.oosd.assignment.two.breakout.atari.behaviour.Movement;
import com.oosd.assignment.two.breakout.atari.behaviour.Reaction;

public abstract class Component {
	private Movement movement;
	private Reaction reaction;
	private boolean isReplay = false;
	private boolean isGamePaused = false;
	private int dx = 1;
	private int dy = 1;

	public void Components() {

	}

	public abstract void position(int x, int y);

	public void pause() {
		this.isGamePaused = !isGamePaused;
	}

	public abstract void undo();

	public abstract void replay();

	public abstract void endReplay();

	public abstract void storeHistory();

	public void move(Breakout breakout) {

		this.movement.move(this, breakout);
	}

	public boolean react(Component ball) {
		return this.reaction.react(this, ball);
	}

	public Movement getMovement() {
		return movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}

	public Reaction getReaction() {
		return reaction;
	}

	public void setReaction(Reaction reaction) {
		this.reaction = reaction;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public abstract void draw(Graphics2D g2d);

	public boolean isGamePaused() {
		return isGamePaused;
	}

	public void setGamePaused(boolean isGamePaused) {
		this.isGamePaused = isGamePaused;
	}

	public boolean isReplay() {
		return isReplay;
	}

	public void setReplay(boolean saveComponent) {
		this.isReplay = saveComponent;
	}
}
