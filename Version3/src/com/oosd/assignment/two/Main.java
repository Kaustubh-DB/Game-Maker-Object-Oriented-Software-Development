package com.oosd.assignment.two;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.oosd.assignment.two.breakout.atari.manager.GameManager;
import com.oosd.assignment.two.breakout.atari.model.Circle;

public class Main extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Circle ball;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	public static void main(String[] args) throws InterruptedException {
		final int frameWidth = 1260;
		final int frameHeight = 700;
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		GameManager gameManager = new GameManager();
		
		frame.setSize(frameWidth, frameHeight);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout gridlayout=new GridLayout(1,3);
		frame.setLayout(gridlayout);
		GamePlay gamePlay = new GamePlay(gameManager);
		GameMaker gamemaker = new GameMaker(gameManager, gamePlay);
		frame.setTitle("Breakout");
		frame.add(gamemaker);
		frame.add(gamePlay );
		gamemaker.chooseComponents();
	
		frame.setVisible(true);
		panel.setVisible(true);
		
		gamePlay.startGame();
	
	}

}