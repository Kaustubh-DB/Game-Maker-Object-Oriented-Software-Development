package com.oosd.assignment.two;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.oosd.assignment.two.breakout.atari.manager.AtariManager;
import com.oosd.assignment.two.breakout.atari.model.Ball;

public class Main extends JPanel {

	Ball ball;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	public static void main(String[] args) {
		final int frameWidth = 820;
		final int frameHeight = 650;
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		AtariManager atariManager = new AtariManager();
		frame.setSize(frameWidth, frameHeight);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Breakout breakout = new Breakout(atariManager);
		frame.setTitle("Breakout");
		breakout.setSize(820, 660);
		breakout.setBackground(Color.white);
		frame.add(breakout);
		panel.setVisible(true);
		breakout.setLocation(140, 40);
		frame.setVisible(true);
		breakout.startGame();
	}

}