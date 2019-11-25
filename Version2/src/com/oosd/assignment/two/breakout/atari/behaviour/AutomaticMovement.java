package com.oosd.assignment.two.breakout.atari.behaviour;

import java.awt.event.KeyEvent;

import com.oosd.assignment.two.Breakout;
import com.oosd.assignment.two.breakout.atari.model.Ball;
import com.oosd.assignment.two.breakout.atari.model.Brick;
import com.oosd.assignment.two.breakout.atari.model.Component;

public class AutomaticMovement implements Movement {

	//Movement of the ball
	@Override
	public void move(Component component, Breakout breakout) {
		// TODO Auto-generated method stub
		if (component instanceof Ball) {
			if (component.isReplay()) {

				int posX = ((Ball) component).getHistoryX();
				int posY = ((Ball) component).getHistoryY();
				((Ball) component).position(posX, posY);
				if (((Ball) component).getCountPos() >= ((Ball) component).getTotalCount()) {
					component.setDx(((Ball) component).getLastDx());
					component.setDy(((Ball) component).getLastDy());
					((Ball) component).endReplay();
				}
			} else {

				int xMin = ((Ball) component).getBallX() - (((Ball) component).getBallWidth() / 2);
				int yMin = ((Ball) component).getBallY() - (((Ball) component).getBallWidth() / 2);
				int xMax = ((Ball) component).getBallX() + (((Ball) component).getBallWidth() / 2);
				int yMax = ((Ball) component).getBallY() + (((Ball) component).getBallWidth() / 2);

				if (xMin < 0 || xMax > breakout.getFrame_width()) {
					component.setDx(-component.getDx());
				}
				if (yMin < 0 || yMax > breakout.getFrame_height()) {
					component.setDy(-component.getDy());
				}
				int positionX = ((Ball) component).getBallX() + component.getDx();
				int positionY = ((Ball) component).getBallY() + component.getDy();
				((Ball) component).position(positionX, positionY);
			}
		} else if (component instanceof Brick) {
			if (component.isReplay()) {
				int posX = ((Brick) component).getHistoryX();
				int posY = ((Brick) component).getHistoryY();
				((Brick) component).position(posX, posY);
				if (((Brick) component).getCountPos() >= ((Brick) component).getTotalCount()) {
					((Brick) component).endReplay();
				}
			}
		}
	}

}
