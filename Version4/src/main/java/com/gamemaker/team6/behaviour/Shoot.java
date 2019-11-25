package com.gamemaker.team6.behaviour;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import com.gamemaker.team6.manager.Manager;
import com.gamemaker.team6.model.Circle;
import com.gamemaker.team6.model.Component;
import org.apache.log4j.Logger;

public class Shoot implements Action, KeyListener {
	
	private static final long serialVersionUID = 1L;
	private final static Logger logger = Logger.getLogger(Shoot.class);

	private Component component;
	private int dx;
	private int dy;
	private int bulletX;
	private int bulletY;
	private Manager gameManager;
	private String shootOption;
	private String shootDirection;
	
	public Shoot(Component c, Manager gameManager) {
		this.component = c;
		this.gameManager = gameManager;
	}

	@Override
	public void act() {
		if (component != null) {
			int minX = component.getPosX();
			int minY = component.getPosY();
			int maxX = minX + component.getWidth();
			int maxY = minY + component.getHeight();
			switch(shootDirection) {
				case "Up":
					this.dy = -8;
					bulletX = (maxX + minX) /2 - 5;
					bulletY = minY - 10;
					break;
				case "Down":
					this.dy = 8;
					bulletX = (maxX + minX) /2 - 5;
					bulletY = maxY + 10;
					break;
				case "Left":
					this.dx = -8;
					bulletX = minX - 10;
					bulletY = (maxY + minY) /2 - 5;
					break;
				case "Right":
					this.dx = 8;
					bulletX = maxX + 10;
					bulletY = (maxY + minY) /2 - 5;
					break;
				default:
					logger.debug("Deafult case is triggered with option: "+shootDirection);
					break;
			}
		}

		if(shootOption.equals("Automatic Shooting") && new Random().nextInt(400) >= 399) {
			// The new Random().nextInt(100) >= 98 defines the possibility of shooting bullets
			Component bullet = new Circle(Color.PINK, bulletX, bulletY, 8, 8);
			bullet.setDx(dx);
			bullet.setDy(dy);
			bullet.setIsToxic(true);
			gameManager.register(bullet, new NoReaction(), new AutomaticMovement(), new NoBoundaryReaction(), new NoAction());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		logger.warn("Keytyped is not used and intentionally left empty");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if((e.getKeyCode() == KeyEvent.VK_SPACE) && shootOption.equals("Manual Shooting")) {
			Component bullet = new Circle(Color.PINK, bulletX, bulletY, 8, 8);
			bullet.setDx(dx);
			bullet.setDy(dy);
			bullet.setIsToxic(true);
			gameManager.register(bullet, new NoReaction(), new AutomaticMovement(), new NoBoundaryReaction(), new NoAction());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		logger.warn("KeyReleased is not used and intentionally left empty");
	}
	
	public String getShootDirection() {
		return shootDirection;
	}

	public void setShootDirection(String shootDirection) {
		this.shootDirection = shootDirection;
	}

	public String getShootOption() {
		return shootOption;
	}

	public void setShootOption(String shootOption) {
		this.shootOption = shootOption;
	}
}
