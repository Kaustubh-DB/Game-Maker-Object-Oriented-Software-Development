package com.oosd.assignment.two.breakout.atari.behaviour;

import java.io.Serializable;

import com.oosd.assignment.two.GamePlay;
import com.oosd.assignment.two.breakout.atari.model.Circle;
import com.oosd.assignment.two.breakout.atari.model.Square;
import com.oosd.assignment.two.breakout.atari.model.Component;
import com.oosd.assignment.two.breakout.atari.model.Rectangle;

public class AutomaticMovement implements Movement, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Movement of the ball
	@Override
	public void move(Component component, GamePlay breakout) {
		if (component instanceof Circle) {
			if (component.isReplay()) {

				int posX = ((Circle) component).getHistoryX();
				int posY = ((Circle) component).getHistoryY();
				((Circle) component).position(posX, posY);
				if (((Circle) component).getCountPos() >= ((Circle) component).getTotalCount()) {
					component.setDx(((Circle) component).getLastDx());
					component.setDy(((Circle) component).getLastDy());
					((Circle) component).endReplay();
				}
			} else {

				int xMin = ((Circle) component).getBallX() - (((Circle) component).getBallWidth() / 2);
				int yMin = ((Circle) component).getBallY() - (((Circle) component).getBallWidth() / 2);
				int xMax = ((Circle) component).getBallX() + (((Circle) component).getBallWidth() / 2);
				int yMax = ((Circle) component).getBallY() + (((Circle) component).getBallWidth() / 2);

				if (xMin < 0 || xMax > breakout.getFrame_width()) {
					component.setDx(-component.getDx());
				}
				if (yMin < 0 || yMax > breakout.getFrame_height()) {
					component.setDy(-component.getDy());
				}
				int positionX = ((Circle) component).getBallX() + component.getDx();
				int positionY = ((Circle) component).getBallY() + component.getDy();
				((Circle) component).position(positionX, positionY);
			}
		}
		
		if (component instanceof Square) {
			if (component.isReplay()) {
				System.out.println("In Square Component");
				int posX = ((Square) component).getHistoryX();
				int posY = ((Square) component).getHistoryY();
				((Square) component).position(posX, posY);
				if (((Square) component).getCountPos() >= ((Square) component).getTotalCount()) {
					component.setDx(((Square) component).getLastDx());
					component.setDy(((Square) component).getLastDy());
					((Square) component).endReplay();
				}
			} else {

				int xBrickMin = ((Square) component).getBrickX();
				int yBrickMin = ((Square) component).getBrickY();
				int xBrickMax = ((Square) component).getBrickX() + ((Square) component).getWidth();
				int yBrickMax = ((Square) component).getBrickY() + ((Square) component).getLength();


				if (xBrickMin < 0 || xBrickMax > breakout.getFrame_width()) {
					component.setDx(-component.getDx());
				}
				if (yBrickMin < 0 || yBrickMax > breakout.getFrame_height()) {
					component.setDy(-component.getDy());
				}
				int positionX = ((Square) component).getBrickX() + component.getDx();
				int positionY = ((Square) component).getBrickY() + component.getDy();
				((Square) component).position(positionX, positionY);
			}
		}
		
		
		if (component instanceof Rectangle) {
			/*
			 * if (component.isReplay()) { System.out.println("In Rectangle Component"); int
			 * posX = ((Rectangle) component).getHistoryX(); int posY = ((Rectangle)
			 * component).getHistoryY(); ((Square) component).position(posX, posY); if
			 * (((Square) component).getCountPos() >= ((Square) component).getTotalCount())
			 * { component.setDx(((Square) component).getLastDx());
			 * component.setDy(((Square) component).getLastDy()); ((Square)
			 * component).endReplay(); } } else
			 */
			//{

				int xRectMin = ((Rectangle) component).getPaddleX();
				int yRectMin = ((Rectangle) component).getPaddleY();
				int xRectMax = ((Rectangle) component).getPaddleX() + ((Rectangle) component).getPaddleWidth();
				int yRectMax = ((Rectangle) component).getPaddleY() + ((Rectangle) component).getPaddleHeight();


				if (xRectMin < 0 || xRectMax > breakout.getFrame_width()) {
					component.setDx(-component.getDx());
				}
				if (yRectMin < 0 || yRectMax > breakout.getFrame_height()) {
					component.setDy(-component.getDy());
				}
				int positionX = ((Rectangle) component).getPaddleX() + component.getDx();
				int positionY = ((Rectangle) component).getPaddleY() + component.getDy();
				((Rectangle) component).position(positionX, positionY);
			//}
		}
		
		
		
		/*
		 * else if (component instanceof Square) { if (component.isReplay()) { int posX
		 * = ((Square) component).getHistoryX(); int posY = ((Square)
		 * component).getHistoryY(); ((Square) component).position(posX, posY); if
		 * (((Square) component).getCountPos() >= ((Square) component).getTotalCount())
		 * { ((Square) component).endReplay(); } } }
		 */
	}

}
