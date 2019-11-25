package com.gamemaker.team6.behaviour;

import java.awt.Color;
import java.util.Random;

import com.gamemaker.team6.manager.Manager;
import com.gamemaker.team6.model.Circle;
import com.gamemaker.team6.model.Component;

public class ThrowBarrel implements Action {

	private static final long serialVersionUID = -6485735481355277923L;
	private Component component;
	private Manager gameManager;
	public ThrowBarrel(Component c, Manager gameManager) {
		this.component = c;
		this.gameManager = gameManager;
	}
	@Override
	public void act() {		
		if(new Random().nextInt(300) >= 299) {
			Component barrel = new Circle(Color.DARK_GRAY, component.getPosX()+component.getWidth(), component.getPosY()-5, 30, 30);
			barrel.setDx(3);
			barrel.setDy(3);
			barrel.setIsToxic(true);
			gameManager.register(barrel, new NoReaction(), new AutomaticMovement(), new BoundaryBounceDrop(), new NoAction());
		}
	}

}
