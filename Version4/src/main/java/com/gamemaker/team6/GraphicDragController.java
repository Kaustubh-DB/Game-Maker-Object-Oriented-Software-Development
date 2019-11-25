package com.gamemaker.team6;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.gamemaker.team6.model.Component;
import org.apache.log4j.Logger;

public class GraphicDragController implements MouseListener, MouseMotionListener {
	Game game;
	private Component selectedComponent;
	private final static Logger logger = Logger.getLogger(Game.class);

	public GraphicDragController(Game game)
	{
		this.game = game;
		game.addMouseListener(this);
		game.addMouseMotionListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int startX = e.getX();
		int startY = e.getY();
		for(Component c : game.getGameManager().getAllComponents()) {			
			if((startX >= c.getPosX()-c.getWidth())&&(startX <= c.getPosX()+c.getWidth())&&
					(startY <= c.getPosY()+c.getHeight())&&(startY >= c.getPosY()-c.getHeight())) {
				selectedComponent = c;
				break;
			}
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		int startX = e.getX();
		int startY = e.getY();
		for(Component c : game.getGameManager().getAllComponents()) {			
			if((startX >= c.getPosX()-c.getWidth())&&(startX <= c.getPosX()+c.getWidth())&&(startY <= c.getPosY()+c.getHeight())&&(startY >= c.getPosY()-c.getHeight())) {
				selectedComponent = c;
				break;
			}
		}
		try {
			selectedComponent.setPosX(e.getX());
			selectedComponent.setPosY(e.getY());
		} catch (NullPointerException excpt) {
			logger.warn("Null Pointer Exception"+ excpt.getMessage());
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		try {
			selectedComponent.setPosX(e.getX());
			selectedComponent.setPosY(e.getY());
		} catch (NullPointerException excpt) {
			logger.warn("Null Pointer Exception"+ excpt.getMessage());
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		logger.warn("MouseMoved function is not used and intentionally left blank");
		

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		logger.warn("MouseExited function is not used and intentionally left blank");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		logger.warn("MousePressed function is not used and intentionally left blank");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int startX = e.getX();
		int startY = e.getY();
		logger.warn("MouseReleased function is not used and intentionally left blank");
		for(Component c : game.getGameManager().getAllComponents()) {			
			if((startX >= c.getPosX()-c.getWidth())&&(startX <= c.getPosX()+c.getWidth())&&(startY <= c.getPosY()+c.getHeight())&&(startY >= c.getPosY()-c.getHeight())) {
				selectedComponent = c;
				break;
			}
		}
		try {
			selectedComponent.setPosX(e.getX());
			selectedComponent.setPosY(e.getY());
		} catch (NullPointerException excpt) {
			logger.warn("Null Pointer Exception"+ excpt.getMessage());
		}
	}

	
}
