package com.gamemaker.team6.behaviour;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.gamemaker.team6.model.Component;
import org.apache.log4j.Logger;

public class ClimbReaction extends Reaction implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6559189932236499676L;
	private boolean isUp = false;
	private boolean isDown =  false;
	private final static Logger logger = Logger.getLogger(ClimbReaction.class);
	@Override
	public boolean react(Component primary, List<Component> components)
			throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		for (int i = 0; i < components.size(); i++) {
			Component secondary = components.get(i);
			if (secondary == primary)
				continue;
			if(doesReact(primary, secondary))
			{
				if(isUp) {
					secondary.setPosY(secondary.getPosY()- 2);
					return true;
				}
				if(isDown) {
					secondary.setPosY(secondary.getPosY() + 2);
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_UP) {
			isUp = true;
		}
		if(arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			isDown = true;
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_UP) {
			isUp = false;
		}
		if(arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			isDown = false;
		}
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// Do nothing
		logger.warn("KeyTyped function is not used and intentionally left blank");
	}

}
