package com.gamemaker.team6.behaviour;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.gamemaker.team6.model.Component;

public class GhostReaction extends Reaction {
	private static final long serialVersionUID = 1L;
	Random random = new Random();
	@Override
	public boolean react(Component primary, List<Component> components)
			throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		int randomInt = 0;
		for (int i = 0; i < components.size(); i++) {
			Component secondary = components.get(i);
			if (secondary == primary)
				continue;
			if (doesReact(primary, secondary)) {
				int secondaryYCenter = secondary.getPosY() + secondary.getHeight() / 2;
				if (primary.getPosY() <= secondaryYCenter
						&& secondaryYCenter <= (primary.getPosY() + primary.getHeight())) {
					if (primary.getPosX() < secondary.getPosX()) {
						secondary.setPosX(primary.getPosX() + primary.getWidth() + 5);
					} else {
						secondary.setPosX(primary.getPosX() - secondary.getWidth() - 5);
					}
					int randomInteger = random.nextInt(3);
					randomInt = randomInteger;
					if (randomInt == 0) {

						secondary.setDy((Math.abs(secondary.getDx())));
						 
						secondary.setDx(0);
					}
					if (randomInt == 1) {

						secondary.setDy(-(Math.abs(secondary.getDx())));
						secondary.setDx(0);
					}
					if (randomInt == 2) {

						secondary.setDx(-(Math.abs(secondary.getDx())));
						secondary.setDy(0);
					}

				} else {
					secondary.setDx(4);
					if (primary.getPosY() < secondary.getPosX()) {
						secondary.setPosY(primary.getPosY() + primary.getHeight() + 5);
					} else {
						secondary.setPosY(primary.getPosY() - secondary.getHeight() - 5);
					}
					int randomInteger = random.nextInt(3);
					randomInt = randomInteger;
					if (randomInt == 0) {

						secondary.setDx(-(Math.abs(secondary.getDy())));
						secondary.setDy(0);
					}
					if (randomInt == 1) {

						secondary.setDx(Math.abs(secondary.getDy()));
						secondary.setDy(0);
					}
					if (randomInt == 2) {

						secondary.setDy(-(secondary.getDy()));
						secondary.setDx(0);
					}
				}
			}
		}
		return false;
	}
}
