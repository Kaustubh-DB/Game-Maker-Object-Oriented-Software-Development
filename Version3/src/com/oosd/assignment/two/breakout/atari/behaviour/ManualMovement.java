package com.oosd.assignment.two.breakout.atari.behaviour;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;

import com.oosd.assignment.two.GamePlay;
import com.oosd.assignment.two.breakout.atari.model.Circle;
import com.oosd.assignment.two.breakout.atari.model.Component;
import com.oosd.assignment.two.breakout.atari.model.Rectangle;
import com.oosd.assignment.two.breakout.atari.model.Square;

public class ManualMovement implements Movement, KeyListener, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int dx;
	int dy;
	int positionX;
	int positionY;
	boolean isLeft;
	boolean isRight;
	boolean isUp;
	boolean isDown;

	//Movement of the paddle
	@Override
	public void move(Component component, GamePlay breakout) {
		
		
		
		if (component instanceof Rectangle) {
			if (component.isReplay()) {
				int posX = ((Rectangle) component).getHistoryX();
				int posY = ((Rectangle) component).getPaddleY();
				((Rectangle) component).position(posX, posY);

				if (((Rectangle) component).getCountPos() >= ((Rectangle) component).getTotalCount()) {
					((Rectangle) component).endReplay();
				}
			} else {
				
				positionY = ((Rectangle) component).getPaddleY();
				positionX = ((Rectangle) component).getPaddleX();
				int maxX = breakout.getFrame_width();
				int maxY = breakout.getFrame_height();
				dx = component.getDx();
				dy = component.getDy();
				if (isLeft && positionX > 0) {
					positionX -= dx;
				}
				if (isRight && (positionX + ((Rectangle) component).getPaddleWidth()) < maxX) {
					positionX += dx;
				}
				if (isUp && positionY > 0) {
					positionY -= dy;
				}
				if (isDown && (positionY + ((Rectangle) component).getPaddleHeight()) < maxY) {
					positionY += dy;
				}
				((Rectangle) component).position(positionX, positionY);
			}
		}
	
	
	if (component instanceof Square) {
		//System.out.println("In Square");
			/*
			 * if (component.isReplay()) { int posX = ((Square) component).getHistoryX();
			 * System.out.println(posX); int posY = ((Square) component).getHistoryY();
			 * ((Square) component).position(posX, posY);
			 * 
			 * if (((Square) component).getCountPos() >= ((Square)
			 * component).getTotalCount()) { ((Square) component).endReplay(); } } else {
			 */
			positionY = ((Square) component).getBrickY();
		//	System.out.println(positionY);
			positionX = ((Square) component).getBrickX();
		//	System.out.println(positionX);
			int maxX = breakout.getFrame_width();
			int maxY = breakout.getFrame_height();
			dx = component.getDx();
			dy = component.getDy();
			if (isLeft && positionX > 0) {
				positionX -= dx;
			}
			if (isRight && (positionX + ((Square) component).getWidth()) < maxX) {
				positionX += dx;
			}
			if (isUp && positionY > 0) {
				positionY -= dy;
			}
			if (isDown && (positionY + ((Square) component).getLength()) < maxY) {
				positionY += dy;
			}
			((Square) component).position(positionX, positionY);
		//}
	}
	
	if (component instanceof Circle) {
			positionY = ((Circle) component).getBallY();
		
			positionX = ((Circle) component).getBallX();
	
			int maxX = breakout.getFrame_width();
			//System.out.println(maxX);
			int maxY = breakout.getFrame_height();
			dx = component.getDx();
			dy = component.getDy();
			if (isLeft && positionX > 0) {
				positionX -= dx;
			}
			if (isRight && (positionX + ((Circle) component).getBallX() + (((Circle) component).getBallWidth() / 2)) < maxX) {
				positionX += dx;
			}
			if (isUp && positionY > 0) {
				positionY -= dy;
			}
			if (isDown && (positionY + ((Circle) component).getBallY() + (((Circle) component).getBallWidth() / 2)) < maxY) {
				positionY += dy;
			}
			((Circle) component).position(positionX, positionY);
		
	}
}

	
	@Override
	public void keyPressed(KeyEvent e) {
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

	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Key move");
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

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
