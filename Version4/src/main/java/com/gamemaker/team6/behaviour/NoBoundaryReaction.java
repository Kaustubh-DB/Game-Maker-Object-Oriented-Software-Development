package com.gamemaker.team6.behaviour;

import com.gamemaker.team6.Game;
import com.gamemaker.team6.model.Component;

public class NoBoundaryReaction implements BoundaryBehavior {
	
	private static final long serialVersionUID = -5720263427862911380L;

	@Override
	public void reactWithBoundary(Component component, Game game) {
		int xMin = component.getPosX();
		int yMin = component.getPosY();
		int xMax = component.getPosX() + component.getWidth();
		int yMax = component.getPosY() + component.getHeight();
		if (xMin < 0 || xMax > game.getWidth()) {
			component.setActive(false);
		}
		if (yMin < 0 || yMax > game.getHeight()) {
			component.setActive(false);
		}
	}

}
