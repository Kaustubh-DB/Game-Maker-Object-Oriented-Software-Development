package com.oosd.assignment.two.breakout.atari.behaviour;

import com.oosd.assignment.two.breakout.atari.model.Ball;
import com.oosd.assignment.two.breakout.atari.model.Brick;
import com.oosd.assignment.two.breakout.atari.model.Component;

public class Explode implements Reaction {

//	Setting up the behaviour when ball bits the brick
	@Override
	public boolean react(Component brick, Component ball) {
		int xBrickMin = ((Brick) brick).getBrickX();
		int yBrickMin = ((Brick) brick).getBrickY();
		int xBrickMax = ((Brick) brick).getBrickX() + ((Brick) brick).getWidth();
		int yBrickMax = ((Brick) brick).getBrickY() + ((Brick) brick).getLength();

		int xBallMin = ((Ball) ball).getBallX();
		int yBallMin = ((Ball) ball).getBallY();
		int xBallMax = xBallMin + ((Ball) ball).getBallWidth();
		int yBallMax = yBallMin + ((Ball) ball).getBallWidth();

		if ((yBallMax == yBrickMin && xBallMax > xBrickMin && xBallMin < xBrickMax)
				|| (xBallMax == xBrickMin && yBallMax > yBrickMin && yBallMin < yBrickMax)
				|| (yBallMin == yBrickMax && xBallMax > xBrickMin && xBallMin < xBrickMax)
				|| (xBallMin == xBrickMax && yBallMax > yBrickMin && yBallMin < yBrickMax)) {
			((Brick) brick).explode();
			return true;
		}
		((Brick) brick).position(((Brick) brick).getInitialX(), ((Brick) brick).getInitialY());
		return false;
	}
}
