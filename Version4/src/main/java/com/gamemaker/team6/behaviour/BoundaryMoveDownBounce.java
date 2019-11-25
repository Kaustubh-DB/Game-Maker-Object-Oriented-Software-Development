package com.gamemaker.team6.behaviour;

import com.gamemaker.team6.Game;
import com.gamemaker.team6.model.Component;

public class BoundaryMoveDownBounce implements BoundaryBehavior {

	private static final long serialVersionUID = 1L;

	@Override
	public void reactWithBoundary(Component component, Game game) {
		int xMin = component.getPosX();
		int yMin = component.getPosY();
		int xMax = component.getPosX() + component.getWidth();
		int yMax = component.getPosY() + component.getHeight();
		if (xMin < 0 || xMax > game.getWidth()) {
			component.setDx(-component.getDx());
			component.setPosY(component.getPosY() + 30);

		}
		if (yMin < 0 || yMax > game.getHeight()) {
			component.setDy(-component.getDy());
		}

	}

}
