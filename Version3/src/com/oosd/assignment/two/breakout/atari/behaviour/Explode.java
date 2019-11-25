package com.oosd.assignment.two.breakout.atari.behaviour;

import java.io.Serializable;

import com.oosd.assignment.two.breakout.atari.model.Component;

public class Explode implements Reaction, Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//	Setting up the behaviour when ball bits the brick
	@Override
	public boolean react(Component component1, Component component2) {
		System.out.println("In Explode");
		int xBrickMin = component1.getX();
		int yBrickMin = component1.getY();
		int xBrickMax = component1.getX() + component1.getWidth();
		int yBrickMax = component1.getY() + component1.getHeight();

		/*
		 * int xBallMin = ((Circle) ball).getBallX(); int yBallMin = ((Circle)
		 * ball).getBallY(); int xBallMax = xBallMin + ((Circle) ball).getBallWidth();
		 * int yBallMax = yBallMin + ((Circle) ball).getBallWidth();
		 */
		int xRectMin = component2.getX();
		int yRectMin = component2.getY();
		int xRectMax = component2.getX() + component2.getWidth();
		int yRectMax = component2.getY() + component2.getHeight();
		System.out.println("*****" + xRectMax);
		/*
		 * if ((yBallMax == yBrickMin && xBallMax > xBrickMin && xBallMin < xBrickMax)
		 * || (xBallMax == xBrickMin && yBallMax > yBrickMin && yBallMin < yBrickMax) ||
		 * (yBallMin == yBrickMax && xBallMax > xBrickMin && xBallMin < xBrickMax) ||
		 * (xBallMin == xBrickMax && yBallMax > yBrickMin && yBallMin < yBrickMax)) {
		 * ((Square) brick).explode(); return true; } ((Square)
		 * brick).position(((Square) brick).getInitialX(), ((Square)
		 * brick).getInitialY());
		 */
		if ((yRectMax == yBrickMin && xRectMax > xBrickMin && xRectMin < xBrickMax)
				|| (xRectMax == xBrickMin && yRectMax > yBrickMin && yRectMin < yBrickMax)
				|| (yRectMin == yBrickMax && xRectMax > xBrickMin && xRectMin < xBrickMax)
				|| (xRectMin == xBrickMax && yRectMax > yBrickMin && yRectMin < yBrickMax)) {
			component2.setWidth(0);
			component2.setHeight(0);
			return true;
		}
	//	component2.position(((Rectangle) brick).getInitialX(), ((Rectangle) brick).getInitialY());

		return false;
	}
}

/*
 * package com.oosd.assignment.two.breakout.atari.behaviour;
 * 
 * import com.oosd.assignment.two.breakout.atari.model.Circle; import
 * com.oosd.assignment.two.breakout.atari.model.Square; import
 * com.oosd.assignment.two.breakout.atari.model.Component; import
 * com.oosd.assignment.two.breakout.atari.model.Rectangle;
 * 
 * public class Explode implements Reaction {
 * 
 * // Setting up the behaviour when ball bits the brick
 * 
 * @Override public boolean react(Component brick, Component ball) {
 * System.out.println("In Explode"); int xBrickMin = ((Square)
 * ball).getBrickX(); int yBrickMin = ((Square) ball).getBrickY(); int xBrickMax
 * = ((Square) ball).getBrickX() + ((Square) ball).getWidth(); int yBrickMax =
 * ((Square) ball).getBrickY() + ((Square) ball).getLength();
 * 
 * 
 * int xBallMin = ((Circle) ball).getBallX(); int yBallMin = ((Circle)
 * ball).getBallY(); int xBallMax = xBallMin + ((Circle) ball).getBallWidth();
 * int yBallMax = yBallMin + ((Circle) ball).getBallWidth();
 * 
 * int xRectMin = ((Rectangle) brick).getPaddleX(); int yRectMin = ((Rectangle)
 * brick).getPaddleY(); int xRectMax = ((Rectangle) brick).getPaddleX() +
 * ((Rectangle) brick).getPaddleWidth(); int yRectMax = ((Rectangle)
 * brick).getPaddleY() + ((Rectangle) brick).getPaddleHeight();
 * System.out.println("*****"+xRectMax);
 * 
 * if ((yBallMax == yBrickMin && xBallMax > xBrickMin && xBallMin < xBrickMax)
 * || (xBallMax == xBrickMin && yBallMax > yBrickMin && yBallMin < yBrickMax) ||
 * (yBallMin == yBrickMax && xBallMax > xBrickMin && xBallMin < xBrickMax) ||
 * (xBallMin == xBrickMax && yBallMax > yBrickMin && yBallMin < yBrickMax)) {
 * ((Square) brick).explode(); return true; } ((Square)
 * brick).position(((Square) brick).getInitialX(), ((Square)
 * brick).getInitialY());
 * 
 * if ((yRectMax == yBrickMin && xRectMax > xBrickMin && xRectMin < xBrickMax)
 * || (xRectMax == xBrickMin && yRectMax > yBrickMin && yRectMin < yBrickMax) ||
 * (yRectMin == yBrickMax && xRectMax > xBrickMin && xRectMin < xBrickMax) ||
 * (xRectMin == xBrickMax && yRectMax > yBrickMin && yRectMin < yBrickMax)) {
 * ((Rectangle) brick).explode(); return true; } ((Rectangle)
 * brick).position(((Rectangle) brick).getInitialX(), ((Rectangle)
 * brick).getInitialY());
 * 
 * return false; } }
 */
