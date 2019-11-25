package com.gamemaker.team6;

import java.awt.Color;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.gamemaker.team6.manager.GameManager;

public class Main extends JPanel {

	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		
		final int frameWidth = 1100;
		final int frameHeight = 700;
		JFrame frame = new JFrame();
		GameManager atariManager = new GameManager();
		Game game = new Game(atariManager);
		BuildGame buildGame = new BuildGame(atariManager,game);
		buildGame.setBackground(Color.white);
		frame.setSize(frameWidth, frameHeight);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setTitle("GameMaker");
		frame.add(buildGame);
		JPanel controls = new ControlPanel(game);
		game.setControlPanel(controls);
		frame.add(controls);
		frame.add(game);
		buildGame.setVisible(true);
		frame.setVisible(true);
		buildGame.makeGame();
		game.startGame();
	}
}
