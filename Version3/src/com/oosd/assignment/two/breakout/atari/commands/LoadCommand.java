package com.oosd.assignment.two.breakout.atari.commands;


import java.awt.event.KeyListener;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;

import javax.swing.JOptionPane;

import com.oosd.assignment.two.GameMaker;
import com.oosd.assignment.two.GamePlay;
import com.oosd.assignment.two.breakout.atari.behaviour.ManualMovement;
import com.oosd.assignment.two.breakout.atari.manager.GameManager;

import com.oosd.assignment.two.breakout.atari.model.Component;


public class LoadCommand implements Command,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Component> components;
	GameManager gameManager;
	GamePlay gamePlay;
	GameMaker gameMaker;
	List<String> addedcomponents;

	public LoadCommand(GameManager gameManager, GamePlay gamePlay, GameMaker gameMaker) {
		super();
		//this.components = components;
		this.gameManager = gameManager;
		this.gamePlay = gamePlay;
		this.gameMaker = gameMaker;
		
	}

	@Override
	public void execute() {
		
//		FileInputStream fis = null;
//		FileInputStream fis2 = null;
//		ObjectInputStream ois = null;
//		ObjectInputStream ois2 = null;
//		
//		try {
//			  fis = new FileInputStream("SavedGame");
//			  fis2 = new FileInputStream("SavedGameComp");
//			 ois = new ObjectInputStream(fis);
//			 ois2 = new ObjectInputStream(fis2);
//			List<Component> readObject = (List<Component>) ois.readObject();
//			gameManager.setComponentsList(readObject);
//			gameMaker.setAddedComponents((List<String>) ois2.readObject());
//			components = gameManager.getComponentsList();
//			addedcomponents = gameMaker.getAddedComponents();
//			for (Component component: components) {
//				if(component.getMovement() instanceof ManualMovement) {
//					gamePlay.addKeyListener((KeyListener)component.getMovement());
//				}
//			}
//			 if(addedcomponents.size() > 1) {
//				 gameMaker.setEnabled(true);
//				 gameMaker.getCollisionOf().setEnabled(true);
//				 gameMaker.getCollisionWith().setEnabled(true);
//				 gameMaker.setCollisionOf(addedcomponents);
//				 gameMaker.setCollisionWith(addedcomponents);
//			 }
//			
//			gamePlay.addMouseListener(gamePlay.getMouseMotionListener());
//			gamePlay.addMouseMotionListener(gamePlay.getMouseMotionListener());
//			
//			
//			
//		} catch (Exception e2) {
//			JOptionPane.showMessageDialog(null, e2.getMessage());
//		}
//		finally {
//			if (fis != null && fis2 != null && ois!=null && ois2!=null) {
//					try {
//						fis.close();
//						fis2.close();
//						ois.close();
//						ois2.close();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						System.out.println(e.getMessage());
//					}
//					
//				} 
//			}
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		ObjectInputStream ois2 = null;
		try {
			 fis = new FileInputStream("SavedGame");
			  ois = new ObjectInputStream(fis);
			  ois2 = new ObjectInputStream(fis);
			 
			List<Component> readObject = (List<Component>) ois.readObject();
			gameManager.setComponentsList(readObject);
			gameMaker.setAddedComponents((List<String>) ois2.readObject());
			components = gameManager.getComponentsList();
			addedcomponents = gameMaker.getAddedComponents();
			for (Component component: components) {
				if(component.getMovement() instanceof ManualMovement) {
					gamePlay.addKeyListener((KeyListener)component.getMovement());
				}
			}
			 if(addedcomponents.size() > 1) {
				 gameMaker.setEnabled(true);
				 gameMaker.getCollisionOf().setEnabled(true);
				 gameMaker.getCollisionWith().setEnabled(true);
				 gameMaker.setCollisionOf(addedcomponents);
				 gameMaker.setCollisionWith(addedcomponents);
			 }
			
			gamePlay.addMouseListener(gamePlay.getMouseMotionListener());
			gamePlay.addMouseMotionListener(gamePlay.getMouseMotionListener());
		}
		catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
		finally {
			if (fis != null && ois!=null && ois2!=null) {
					try {
						fis.close();
						//fis2.close();
						ois.close();
						ois2.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					
				} 
		}
	}
}
