package com.gamemaker.team6.behaviour;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.gamemaker.team6.model.Component;

public class NoReaction extends Reaction{

	
	private static final long serialVersionUID = 1L;

	@Override
	public boolean react(Component component, List<Component> balls)
			throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		return false;
	}
	
}
