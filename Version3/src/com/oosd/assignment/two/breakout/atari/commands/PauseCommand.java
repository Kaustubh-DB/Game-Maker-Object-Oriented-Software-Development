package com.oosd.assignment.two.breakout.atari.commands;

import com.oosd.assignment.two.breakout.atari.manager.GameManager;
import com.oosd.assignment.two.breakout.atari.model.Component;

public class PauseCommand implements Command {
	
	GameManager gameManager;

	public PauseCommand(GameManager gameManager) {
		super();
		this.gameManager = gameManager;
	}

	@Override
	public void execute() {
		for (Component component : gameManager.getComponentsList()) {
			component.pause();
		}
	}
}
