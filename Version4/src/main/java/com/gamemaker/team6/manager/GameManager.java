package com.gamemaker.team6.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gamemaker.team6.behaviour.Action;
import com.gamemaker.team6.behaviour.BoundaryBehavior;
import com.gamemaker.team6.behaviour.Movement;
import com.gamemaker.team6.behaviour.Reaction;
import com.gamemaker.team6.model.Component;

public class GameManager implements Serializable, Manager {
	private static final long serialVersionUID = 1L;
	private List<Component> allComponents;

	public GameManager() {
		allComponents = new ArrayList<Component>();
	}

	public void register(Component component, 
						Reaction reaction, 
						Movement movement, 
						BoundaryBehavior boundaryBehavior, 
						Action action) {
		component.setMovement(movement);
		component.setReaction(reaction);
		component.setBoundaryBehavior(boundaryBehavior);
		component.setAction(action);
			allComponents.add(component);
	}

	public void unregister() {
		allComponents.clear();
	}


	public List<Component> getAllComponents() {
		return allComponents;
	}

	public void setAllComponents(List<Component> set) {
		this.allComponents = set;
	}
}
