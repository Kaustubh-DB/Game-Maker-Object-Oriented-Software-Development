package com.gamemaker.team6.behaviour;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.gamemaker.team6.Game;
import com.gamemaker.team6.manager.Manager;
import com.gamemaker.team6.model.Component;

public class ManualMovement implements Movement, KeyListener {

	private static final long serialVersionUID = 1L;
	int dx, dy; //Change in x and y positions of the component
	int jumpStrength, jumpCounter = 0; //parameters for jumping, jumpStrength for assigning strength of a jump, jumpCounter for counting the frames while jumping 
	int positionX;
	int positionY;
	boolean isLeft; 
	boolean isRight;
	boolean jumpCall; //
	String keyset;
	boolean isUp, isDown;
	Component component;
	Manager gameManager;
	public ManualMovement(String keyset, Manager gameManager) {
		this.keyset = keyset;
		this.gameManager = gameManager;
	}


	@Override
	public void move(Component component, Game game) {
		positionY = component.getPosY();
		positionX = component.getPosX();
		int maxX = game.getFrame_width();
		int maxY = game.getFrame_height();
		dx = component.getDx();
		dy = component.getDy();
		if (isLeft && positionX > 0) {
			positionX -= dx;
		}
		if (isRight && (positionX + component.getWidth()) < maxX) {
			positionX += dx;
		}
		if (isUp && positionY > 0) {
			positionY -= dy;
		}
		if (isDown && (positionY +  component.getHeight()) < maxY) {
			positionY += dy;
		}
		if(jumpCall && positionY > 0 && (positionY +  component.getHeight()) < maxY) {
			if(jumpCounter < 5) {
				positionY -= jumpStrength ;
			}
			if(jumpCounter >= 5 && jumpCounter <= 10) {
				positionY += jumpStrength ;
			}
			jumpCounter++;
			if(jumpCounter == 10) {
				jumpCounter = 0;
				jumpCall = false;
			}
		}
		component.position(positionX, positionY);
		this.component = component;


	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(keyset.equals("arrow")) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {

				this.isLeft = true;
			}

			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

				this.isRight = true;

			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {

				this.isUp = true;
			}

			if (e.getKeyCode() == KeyEvent.VK_DOWN) {

				this.isDown = true;

			}
			
			if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
				this.jumpCall = true;
				jumpStrength = 4;
			}

		}
		else if(keyset.equals("wasd")) {
			if (e.getKeyCode() == KeyEvent.VK_A) {

				this.isLeft = true;
			}

			if (e.getKeyCode() == KeyEvent.VK_D) {

				this.isRight = true;

			}
			if (e.getKeyCode() == KeyEvent.VK_W) {

				this.isUp = true;
			}

			if (e.getKeyCode() == KeyEvent.VK_S) {

				this.isDown = true;

				}
			}
		}

	



	

	@Override
	public void keyReleased(KeyEvent e) {
		if(keyset.equals("arrow")) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {

				this.isLeft = false;
			}

			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

				this.isRight = false;

			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {

				this.isUp = false;
			}

			if (e.getKeyCode() == KeyEvent.VK_DOWN) {

				this.isDown = false;

			}
		}
		else if(keyset.equals("wasd")) {
			if (e.getKeyCode() == KeyEvent.VK_A) {

				this.isLeft = false;
			}

			if (e.getKeyCode() == KeyEvent.VK_D) {

				this.isRight = false;

			}
			if (e.getKeyCode() == KeyEvent.VK_W) {

				this.isUp = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_S) {

				this.isDown = false;

			}
		}
		
//		if((e.getKeyCode() == KeyEvent.VK_SPACE) && (component.getWillShoot() == 2)) {
//			Bullets bullets = new Bullets(Color.BLACK,(component.getPosX()+(component.getWidth()/2)),(component.getPosY()-component.getHeight()/2),5,5);
//			BulletsMovement m=new BulletsMovement((GameManager)gameManager,false);
//			gameManager.register(bullets,new NoReaction(), m);
//		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
