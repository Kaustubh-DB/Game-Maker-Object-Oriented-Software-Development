package com.oosd.assignment.two.breakout.atari.commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import com.oosd.assignment.two.breakout.atari.model.Ball;
import com.oosd.assignment.two.breakout.atari.model.Brick;
import com.oosd.assignment.two.breakout.atari.model.Component;
import com.oosd.assignment.two.breakout.atari.model.DigitalClock;
import com.oosd.assignment.two.breakout.atari.model.Paddle;

public class LoadCommand implements Command {

	List<Component> components;

	public LoadCommand(List<Component> components) {
		super();
		this.components = components;
	}

	@Override
	public void execute() {
		Ball ball = (Ball) components.get(0);
		Paddle paddle = (Paddle) components.get(1);
		DigitalClock clock = (DigitalClock) components.get(3);
		Brick brick = (Brick) components.get(2);
		JFileChooser fs = new JFileChooser(new File("//home//bivas//"));
		fs.setDialogTitle("OPEN");
		int result = fs.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {

			File fi = fs.getSelectedFile();
			List<Integer> historyX = new ArrayList<Integer>();
			List<Integer> historyY = new ArrayList<Integer>();
			List<Integer> brickHistoryX = new ArrayList<Integer>();
			List<Integer> brickHistoryY = new ArrayList<Integer>();
			List<Integer> paddleHist = new ArrayList<Integer>();
			List<Integer> clockMins = new ArrayList<Integer>();
			List<Integer> clockSec = new ArrayList<Integer>();
			int dx = 0;
			int dy = 0;
			try {
				String line = "";
				BufferedReader b = new BufferedReader(new FileReader(fi.getPath()));
				while ((line = b.readLine()) != null) {
					String[] arr = line.split(",");
					historyX.add(Integer.parseInt(arr[0]));
					historyY.add(Integer.parseInt(arr[1]));
					paddleHist.add(Integer.parseInt(arr[4]));
					dx = (Integer.parseInt(arr[2]));
					dy = (Integer.parseInt(arr[3]));
					clockMins.add(Integer.parseInt(arr[5]));
					clockSec.add(Integer.parseInt(arr[6]));
					brickHistoryX.add(Integer.parseInt(arr[7]));
					brickHistoryY.add(Integer.parseInt(arr[8]));
				}
				ball.setHistX(historyX);
				ball.setHistY(historyY);
				paddle.setHistX(paddleHist);
				clock.setAllMins(clockMins);
				clock.setAllSec(clockSec);
				brick.setHistX(brickHistoryX);
				brick.setHistY(brickHistoryY);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			ball.setBallX(historyX.get(historyX.size() - 1));
			ball.setBallY(historyY.get(historyY.size() - 1));
			paddle.setPaddleX(paddleHist.get(paddleHist.size() - 1));
			ball.setDx(dx);
			ball.setDy(dy);
			clock.setCurrMinutes(clockMins.get(clockMins.size() - 1));
			clock.setCurrSeconds(clockSec.get(clockSec.size() - 1));
			brick.setBrickX(brickHistoryX.get(brickHistoryX.size() - 1));
			brick.setBrickY(brickHistoryY.get(brickHistoryY.size() - 1));
		}

	}
}
