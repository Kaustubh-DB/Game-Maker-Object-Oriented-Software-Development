package com.oosd.assignment.two.breakout.atari.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.oosd.assignment.two.breakout.atari.behaviour.Movement;
import com.oosd.assignment.two.breakout.atari.behaviour.Reaction;
import com.oosd.assignment.two.breakout.atari.commands.Command;
import com.oosd.assignment.two.breakout.atari.model.Component;

public class GameManager implements Manager, Serializable {
//	Creating a list of components
	List<Component> componentsList;

	public GameManager() {
		componentsList = new ArrayList<Component>();
	}

	// Registering components(observers) with the manager(Subject) and setting up
	// their behaviors
	public void register(Component component, Reaction reaction,  Movement movement) {//
		component.setMovement(movement);
		component.setReaction(reaction);
		componentsList.add(component);
	}

//	Removing all observers(components)
	public void unregister() {
		componentsList.clear();
	}

//	Called when a command is given
	@Override
	public void notifyComponents(Command command) {
		// TODO Auto-generated method stub
		command.execute();
	}

	public List<Component> getComponentsList() {
		return componentsList;
	}

	public void setComponentsList(List<Component> componentsList) {
		this.componentsList = componentsList;
	}

}
