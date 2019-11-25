package com.gamemaker.team6.behaviour;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.gamemaker.team6.manager.Manager;
import com.gamemaker.team6.model.Component;
import com.gamemaker.team6.model.ImageComponent;
import org.apache.log4j.Logger;

public class TransformReaction extends Reaction {

	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(TransformReaction.class);

	private Manager gameManager;
	
	public TransformReaction(Manager gm) {
		this.gameManager = gm;
	}

	@Override
	public boolean react(Component primary, List<Component> components)
			throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		
		for (int i = 0; i < components.size(); i++) {
			Component secondary = components.get(i);
			if(primary == secondary)
				continue;
			int primaryMinX = primary.getPosX();
			int primaryMinY = primary.getPosY();
			int primaryWidth = primary.getWidth();
			int primaryHeight = primary.getHeight();
			
			Shape primaryShape = new java.awt.Rectangle(primaryMinX, primaryMinY, primaryWidth, primaryHeight);
			int secondaryMinX = secondary.getPosX();
			int secondaryMinY = secondary.getPosY();
			int secondaryWidth = secondary.getWidth();
			int secondarHeight = secondary.getHeight();
			Shape secondaryShape = new java.awt.Rectangle(secondaryMinX, secondaryMinY, secondaryWidth, secondarHeight);

			if (primaryShape.intersects((Rectangle2D) secondaryShape)) {
				if (secondary.isToxic()) {
					/* Turn the primary component into a static mushroom that has MoveDownBounce reaction */
					primary.explode();
					secondary.explode();
					//components.remove(primary);
					Component mushroom = new ImageComponent("mushroom.png", primaryMinX, primaryMinY, primaryWidth, primaryHeight);
					gameManager.register(mushroom, new MoveDownBounce(), new NoMovement(), new NoBoundaryReaction(), new NoAction());
				} else {
					//primary.setReaction(new NoReaction());
				}
			}
		}
		return false;
	}

}
