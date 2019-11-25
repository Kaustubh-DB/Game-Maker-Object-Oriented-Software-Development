package com.gamemaker.team6.behaviour;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.gamemaker.team6.model.Component;

public class MoveDownBounce extends Reaction {

	private static final long serialVersionUID = 1L;
	
	@Override
	public boolean react(Component primary, List<Component> components) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		for (int i = 0; i < components.size(); i++) {
			Component secondary = components.get(i);
			if (secondary == primary || secondary.isToxic())
				continue;
			if(doesReact(primary, secondary))
			{
				int secondaryYCenter = secondary.getPosY() + secondary.getHeight()/2;
				if(primary.getPosY() <= secondaryYCenter && secondaryYCenter <= (primary.getPosY()+primary.getHeight()) ) {
					secondary.setDx(-secondary.getDx());
					secondary.setPosY(secondary.getPosY() + 30);
				}
				else {
					secondary.setDy(-(secondary.getDy()));
				}
				return true;
			}
		}
		return false;
	}

}
