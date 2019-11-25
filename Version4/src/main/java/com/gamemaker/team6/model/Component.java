package com.gamemaker.team6.model;

import java.awt.Graphics2D;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.gamemaker.team6.Game;
import com.gamemaker.team6.behaviour.Action;
import com.gamemaker.team6.behaviour.BoundaryBehavior;
import com.gamemaker.team6.behaviour.Movement;
import com.gamemaker.team6.behaviour.Reaction;

public abstract class Component implements Serializable {
	private boolean isActive = true;
	

	private static final long serialVersionUID = 1L;
	private Movement movement;
	private Reaction reaction;
	private BoundaryBehavior boundaryBehavior;
	private Action action;
	private boolean isReplay = false;
	private boolean isGamePaused = false;
	private int dx = 3, posX, posY, height, width;
	private int dy = 3;
	private boolean isToxic = false;

	public BoundaryBehavior getBoundaryBehavior() {
		return boundaryBehavior;
	}

	public void setBoundaryBehavior(BoundaryBehavior boundaryBehavior) {
		this.boundaryBehavior = boundaryBehavior;
	}

	public void position(int x, int y) {
		this.posX = x;
		this.posY = y;
	}

	public void pause() {
		this.isGamePaused = !isGamePaused;
	}



	public void update(Game game) throws LineUnavailableException, IOException, UnsupportedAudioFileException {

		this.movement.move(this, game);
		this.boundaryBehavior.reactWithBoundary(this, game);
		this.action.act();
	}

	public boolean react(List<Component> allComponents) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		return this.reaction.react(this, allComponents);
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

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}


	public void explode() {
		setHeight(0);
		setWidth(0);
		setActive(false);
	}

	public boolean isToxic() {
		return isToxic;
	}

	public void setIsToxic(boolean isToxic) {
		this.isToxic = isToxic;
	}
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
