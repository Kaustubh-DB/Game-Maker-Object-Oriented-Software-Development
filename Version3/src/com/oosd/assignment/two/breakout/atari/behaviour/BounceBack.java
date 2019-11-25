package com.oosd.assignment.two.breakout.atari.behaviour;

import java.io.Serializable;

import com.oosd.assignment.two.breakout.atari.behaviour.Reaction;
import com.oosd.assignment.two.breakout.atari.model.Component;

public class BounceBack implements Reaction, Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Interaction between the ball and paddle
//	@Override
//	public boolean react(Component paddle, Component ball) {
//		int xPaddleMin = ((Rectangle) paddle).getPaddleX();
//		int yPaddleMin = ((Rectangle) paddle).getPaddleY();
//		int xPaddleMax = xPaddleMin + ((Rectangle) paddle).getPaddleWidth();
//		int yPaddleMax = yPaddleMin + ((Rectangle) paddle).getPaddleHeight();
//		
//		int xBallMin = ((Circle) ball).getBallX();
//		int yBallMin = ((Circle) ball).getBallY();
//		int xBallMax = xBallMin + ((Circle) ball).getBallWidth();
//		int yBallMax = yBallMin + ((Circle) ball).getBallWidth();
//		System.out.println("In BounceBack");
//
//		if (xBallMax >= xPaddleMin && xBallMin <= xPaddleMax && yBallMax >= yPaddleMin && yBallMin <= yPaddleMax) {
//
//			((Circle) ball).setDy(-((Circle) ball).getDy());
//
//			return true;
//
//		}
//
//		if (xBallMin - ((Circle) ball).getBallWidth() == xPaddleMax
//				&& yBallMin - ((Circle) ball).getBallWidth() >= yPaddleMin && yBallMax <= yPaddleMax) {
//
//			((Circle) ball).setDx(-((Circle) ball).getDx());
//
//			return true;
//
//		}
//
//		if (xBallMax == xPaddleMin && yBallMin - ((Circle) ball).getBallWidth() >= yPaddleMin && yBallMax <= yPaddleMax) {
//
//			((Circle) ball).setDx(-((Circle) ball).getDx());
//
//			return true;
//
//		}
//		return false;
//	}
	@Override
	public boolean react(Component component1, Component component2) {
		System.out.println("int bounce back");
		int xPaddleMin = component1.getX();
		int yPaddleMin = component1.getY();
		int xPaddleMax = xPaddleMin + component1.getWidth();
		int yPaddleMax = yPaddleMin + component1.getHeight();
		
		int xBallMin = component2.getX();
		int yBallMin = component2.getY();
		int xBallMax = xBallMin + component2.getWidth();
		int yBallMax = yBallMin + component2.getWidth();
		System.out.println("In BounceBack");

		if (xBallMax >= xPaddleMin && xBallMin <= xPaddleMax && yBallMax >= yPaddleMin && yBallMin <= yPaddleMax) {
			

			component2.setDy(-component2.getDy());

			return true;

		}

		if (xBallMin - component2.getWidth() == xPaddleMax
				&& yBallMin - component2.getWidth() >= yPaddleMin && yBallMax <= yPaddleMax) {

			component2.setDx(-component2.getDx());

			return true;

		}

		if (xBallMax == xPaddleMin && yBallMin - component2.getWidth() >= yPaddleMin && yBallMax <= yPaddleMax) {

			component2.setDx(-component2.getDx());

			return true;

		}
		return false;
	}
}
