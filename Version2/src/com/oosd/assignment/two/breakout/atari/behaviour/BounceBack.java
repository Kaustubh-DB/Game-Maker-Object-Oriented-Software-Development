package com.oosd.assignment.two.breakout.atari.behaviour;

import com.oosd.assignment.two.breakout.atari.behaviour.Reaction;
import com.oosd.assignment.two.breakout.atari.model.Ball;
import com.oosd.assignment.two.breakout.atari.model.Component;
import com.oosd.assignment.two.breakout.atari.model.Paddle;

public class BounceBack implements Reaction {
//Interaction between the ball and paddle
	@Override
	public boolean react(Component paddle, Component ball) {
		int xPaddleMin = ((Paddle) paddle).getPaddleX();
		int yPaddleMin = ((Paddle) paddle).getPaddleY();
		int xPaddleMax = xPaddleMin + ((Paddle) paddle).getPaddleWidth();
		int yPaddleMax = yPaddleMin + ((Paddle) paddle).getPaddleHeight();
		int xBallMin = ((Ball) ball).getBallX();
		int yBallMin = ((Ball) ball).getBallY();
		int xBallMax = xBallMin + ((Ball) ball).getBallWidth();
		int yBallMax = yBallMin + ((Ball) ball).getBallWidth();

		if (xBallMax >= xPaddleMin && xBallMin <= xPaddleMax && yBallMax >= yPaddleMin && yBallMin <= yPaddleMax) {

			((Ball) ball).setDy(-((Ball) ball).getDy());

			return true;

		}

		if (xBallMin - ((Ball) ball).getBallWidth() == xPaddleMax
				&& yBallMin - ((Ball) ball).getBallWidth() >= yPaddleMin && yBallMax <= yPaddleMax) {

			((Ball) ball).setDx(-((Ball) ball).getDx());

			return true;

		}

		if (xBallMax == xPaddleMin && yBallMin - ((Ball) ball).getBallWidth() >= yPaddleMin && yBallMax <= yPaddleMax) {

			((Ball) ball).setDx(-((Ball) ball).getDx());

			return true;

		}
		return false;
	}
}
