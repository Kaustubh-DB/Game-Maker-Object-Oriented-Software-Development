package com.gamemaker.team6.behaviour;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.gamemaker.team6.model.Component;

public abstract class Reaction implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3878706747131540940L;
	private String sound;
	
	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public abstract boolean react(Component primary, List<Component> allComponents) throws UnsupportedAudioFileException, IOException, LineUnavailableException;

	public boolean doesReact(Component primary, Component secondary) {
		int primaryXmin = primary.getPosX();
		int primaryYmin = primary.getPosY();
		int secondaryXmin = secondary.getPosX();
		int secondaryYmin = secondary.getPosY();
		int primaryYmax = primaryYmin + primary.getHeight();
		int primaryXmax = primaryXmin + primary.getWidth();
		
		boolean doesReact = ((primaryYmin - secondary.getHeight())<= secondaryYmin 
				&& secondaryYmin <= primaryYmax 
				&& secondaryXmin >= (primaryXmin - secondary.getWidth())
				&& secondaryXmin <= primaryXmax);
		if(doesReact) {
			if(sound!= null) {
				Thread soundThread = new SoundThread(sound);
				soundThread.start();
				//soundThread.run();
			}
		}
		return doesReact;
	}
}
