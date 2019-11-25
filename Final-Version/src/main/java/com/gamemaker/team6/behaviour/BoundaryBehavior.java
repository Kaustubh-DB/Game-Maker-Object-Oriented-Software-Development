package com.gamemaker.team6.behaviour;

import java.io.Serializable;

import com.gamemaker.team6.Game;
import com.gamemaker.team6.model.Component;


public interface BoundaryBehavior extends Serializable {
	public void reactWithBoundary(Component component, Game game);
}
