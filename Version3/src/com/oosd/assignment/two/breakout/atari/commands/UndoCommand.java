package com.oosd.assignment.two.breakout.atari.commands;

import java.util.List;

import com.oosd.assignment.two.breakout.atari.model.Component;

public class UndoCommand implements Command {

	List<Component> components;

	public UndoCommand(List<Component> components) {
		super();
		this.components = components;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		for (Component component : components) {
			component.undo();
		}
	}
}
