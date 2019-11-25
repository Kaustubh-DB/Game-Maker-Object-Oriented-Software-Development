package com.gamemaker.team6.manager;

import com.gamemaker.team6.behaviour.Action;
import com.gamemaker.team6.behaviour.BoundaryBehavior;
import com.gamemaker.team6.behaviour.Movement;
import com.gamemaker.team6.behaviour.Reaction;
import com.gamemaker.team6.model.Component;

public interface Manager {
	public void register(Component component, Reaction reaction, Movement movement, BoundaryBehavior boundaryBehavior, Action action);

	public void unregister();

}
