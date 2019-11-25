package com.gamemaker.team6.behaviour;
import com.gamemaker.team6.Game;
import com.gamemaker.team6.manager.Manager;
import com.gamemaker.team6.model.Component;
public class AutomaticMovement implements Movement {

	private static final long serialVersionUID = 189331475972854629L;
	String filename;
	Manager gameManager;
	
	public AutomaticMovement() {
	}
	@Override
	public void move(Component component, Game game){
		int positionX = component.getPosX() + component.getDx();
		int positionY = component.getPosY() + component.getDy();
		component.position(positionX, positionY);
	}

}
