package com.oosd.assignment.two;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.util.List;

import com.oosd.assignment.two.breakout.atari.manager.GameManager;
import com.oosd.assignment.two.breakout.atari.model.Component;

public class DragPlaceObjects implements MouseListener,MouseMotionListener {
	GameManager gameManager;
	List<Component> componentList ;
	Component component ; 
	public DragPlaceObjects(GameManager gameManager) {
		this.gameManager =  gameManager;
		componentList = gameManager.getComponentsList();
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		int startX = e.getX();
		int startY = e.getY();
		for(int i=0; i<componentList.size(); i++) {			
			if((startX >= componentList.get(i).getX()-componentList.get(i).getWidth())&&(startX <= componentList.get(i).getX()+componentList.get(i).getWidth())&&(startY <= componentList.get(i).getY()+componentList.get(i).getHeight())&&(startY >= componentList.get(i).getY()-componentList.get(i).getHeight())) {
				component = componentList.get(i);
				break;
			}
		}
			
		component.setX(e.getX());
		component.setY(e.getY());
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int startX = e.getX();
		int startY = e.getY();
		for(int i=0; i<componentList.size(); i++) {			
			if((startX >= componentList.get(i).getX()-componentList.get(i).getWidth())&&(startX <= componentList.get(i).getX()+componentList.get(i).getWidth())&&
					(startY <= componentList.get(i).getY()+componentList.get(i).getHeight())&&(startY >= componentList.get(i).getY()-componentList.get(i).getHeight()) 
					
					) {
				component = componentList.get(i);
				break;
			}
		}
			
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}
	

}
