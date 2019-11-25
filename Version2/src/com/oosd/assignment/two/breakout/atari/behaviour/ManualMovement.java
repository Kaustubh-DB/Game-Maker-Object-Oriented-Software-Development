package com.oosd.assignment.two.breakout.atari.behaviour;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.oosd.assignment.two.Breakout;
import com.oosd.assignment.two.breakout.atari.model.Ball;
import com.oosd.assignment.two.breakout.atari.model.Component;
import com.oosd.assignment.two.breakout.atari.model.Paddle;

public class ManualMovement implements Movement, KeyListener {
	int dx;
	int positionX;
	int positionY;
	boolean isLeft;
	boolean isRight;

	//Movement of the paddle
	@Override
	public void move(Component component, Breakout breakout) {

		if (component.isReplay()) {
			int posX = ((Paddle) component).getHistoryX();
			int posY = ((Paddle) component).getPaddleY();
			((Paddle) component).position(posX, posY);

			if (((Paddle) component).getCountPos() >= ((Paddle) component).getTotalCount()) {
				((Paddle) component).endReplay();
			}
		} else {
			positionY = ((Paddle) component).getPaddleY();
			positionX = ((Paddle) component).getPaddleX();
			int maxX = breakout.getFrame_width();
			dx = component.getDx();
			if (isLeft && positionX > 0) {
				positionX -= dx;
			}
			if (isRight && (positionX + ((Paddle) component).getPaddleWidth()) < maxX) {
				positionX += dx;
			}
			((Paddle) component).position(positionX, positionY);
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

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			this.isLeft = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			this.isRight = false;

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
