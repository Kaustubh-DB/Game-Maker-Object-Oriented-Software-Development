package com.oosd.assignment.two.breakout.atari.commands;

import java.util.List;

import com.oosd.assignment.two.breakout.atari.model.Component;

public class ReplayCommand implements Command {

	List<Component> components;

	public ReplayCommand(List<Component> components) {
		super();
		this.components = components;
	}

	@Override
	public void execute() {
		for (Component component : components) {
			component.replay();
		}
	}
}
