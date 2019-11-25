package com.oosd.assignment.two.breakout.atari.commands;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import com.oosd.assignment.two.GameMaker;
import com.oosd.assignment.two.breakout.atari.manager.GameManager;
import com.oosd.assignment.two.breakout.atari.model.Circle;
import com.oosd.assignment.two.breakout.atari.model.Square;
import com.oosd.assignment.two.breakout.atari.model.Component;
import com.oosd.assignment.two.breakout.atari.model.DigitalClock;
import com.oosd.assignment.two.breakout.atari.model.Rectangle;

public class SaveCommand implements Command, Serializable {

	GameManager gameManager;
	GameMaker gameMaker;

	public SaveCommand(GameManager gameManager, GameMaker gameMaker) {
		super();
		this.gameManager = gameManager;
		this.gameMaker = gameMaker;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
//		FileOutputStream fos = null;
//		FileOutputStream fos2 = null;
//		ObjectOutputStream oos = null;
//		ObjectOutputStream oos2 = null;
//		try {
//			fos = new FileOutputStream("SavedGame");
//			fos2 = new FileOutputStream("SavedGameComp");
//			oos = new ObjectOutputStream(fos);
//			oos2 = new ObjectOutputStream(fos2);
//			oos.writeObject(gameManager.getComponentsList()); // write MenuArray to ObjectOutputStream
//			oos2.writeObject(gameMaker.getAddedComponents());
//
//		} catch (Exception e2) {
//			JOptionPane.showMessageDialog(null, e2.getMessage());
//		} finally {
//			if (fos != null && fos2 != null && oos2!= null && oos!=null) {
//				
//					try {
//						fos.close();
//						fos2.close();
//						oos2.close();
//						oos.close();
//						
//						
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						System.out.println(e.getMessage());
//					}
//					
//
//			}
//		}
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		ObjectOutputStream oos2 = null;
		try {
			fos= new FileOutputStream("SavedGame");
			 oos = new ObjectOutputStream(fos);
			oos2 = new ObjectOutputStream(fos);
			oos.writeObject(gameManager.getComponentsList());
			oos2.writeObject(gameMaker.getAddedComponents());
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if (fos != null && oos2!= null && oos!=null) {
				
					try {
						fos.close();
						//fos2.close();
						oos2.close();
						oos.close();
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					

			}
		}
	}
}
