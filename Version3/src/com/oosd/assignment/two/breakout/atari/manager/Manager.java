package com.oosd.assignment.two.breakout.atari.manager;

import com.oosd.assignment.two.breakout.atari.behaviour.Movement;
import com.oosd.assignment.two.breakout.atari.behaviour.Reaction;
import com.oosd.assignment.two.breakout.atari.commands.Command;
import com.oosd.assignment.two.breakout.atari.model.Component;

public interface Manager {
	public void register(Component component,Reaction reaction,  Movement movement);//

	public void unregister();

	public void notifyComponents(Command command);
}
