package com.gamemaker.team6.behaviour;

import com.gamemaker.team6.Game;
import com.gamemaker.team6.model.Component;

public class BoundaryBounce implements BoundaryBehavior {

	private static final long serialVersionUID = 5926701958956742611L;

	@Override
	public void reactWithBoundary(Component component, Game game) {
		if(!(component.getMovement() instanceof ManualMovement)) {
			
		
		int xMin = component.getPosX();
		int yMin = component.getPosY();
		int xMax = component.getPosX() + component.getWidth();
		int yMax = component.getPosY() + component.getHeight();
		if (xMin < 0 || xMax > game.getWidth()) {
			component.setDx(-component.getDx());

		}
		if (yMin < 0 || yMax > game.getHeight()) {
			component.setDy(-component.getDy());
		}
	}
	}
}
