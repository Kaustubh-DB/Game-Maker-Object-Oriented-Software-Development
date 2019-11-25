package com.gamemaker.team6.behaviour;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.gamemaker.team6.model.Component;

public class StayReaction extends Reaction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 915416139154409940L;

	@Override
	public boolean react(Component primary, List<Component> allComponents)
			throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// TODO Auto-generated method stub
		for (int i = 0; i < allComponents.size(); i++) {
			Component secondary = allComponents.get(i);
			if (secondary == primary)
				continue;
			if(doesReact(primary, secondary))
			{
				secondary.setPosY(primary.getPosY() - secondary.getHeight());
				return true;
			}
		}
		return false;
	}

}
