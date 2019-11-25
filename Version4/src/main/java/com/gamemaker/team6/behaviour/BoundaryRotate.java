package com.gamemaker.team6.behaviour;

import com.gamemaker.team6.Game;
import com.gamemaker.team6.model.Component;

public class BoundaryRotate implements BoundaryBehavior{

	private static final long serialVersionUID = 128908821291724008L;

	@Override
	public void reactWithBoundary(Component component, Game game) {
		int xMin = component.getPosX() ;
		int yMin = component.getPosY() ;
		int yMax = component.getPosY() + component.getHeight();
		if ( xMin > game.getWidth())
		{
			component.position(1,component.getPosY());
		}
		if(xMin<0)
			component.position(game.getWidth(),component.getPosY());
		if (yMin < 0 )
		{
			component.position(component.getPosX(),game.getHeight());
		}
		if(yMax>game.getHeight())
			component.position(component.getPosX(),component.getHeight());
	}
	
}
