package com.gamemaker.team6.behaviour;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.gamemaker.team6.Game;
import com.gamemaker.team6.model.Component;

public class NoMovement implements Movement{

	
	private static final long serialVersionUID = 1L;

	@Override
	public void move(Component component, Game game)
			throws LineUnavailableException, IOException, UnsupportedAudioFileException {
	component.setDx(0);
	component.setDy(0);
	}
	
}
