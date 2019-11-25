package com.oosd.assignment.two.breakout.atari.commands;

import java.io.File;
import java.io.FileWriter;
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

public class SaveCommand implements Command {

	List<Component> components;

	public SaveCommand(List<Component> components) {
		super();
		this.components = components;
	}

	@Override
	public void execute() {
		Ball ball = (Ball) components.get(0);
		Paddle paddle = (Paddle) components.get(1);
		DigitalClock clock = (DigitalClock) components.get(3);
		Brick brick = (Brick) components.get(2);
		String content = "";
		for (int i = 0; i < ball.getHistX().size() - 1; i++) {
			content += ball.getHistX().get(i) + "," + ball.getHistY().get(i) + "," + ball.getLastDx() + ","
					+ ball.getLastDy() + "," + paddle.getHistX().get(i) + "," + clock.getAllMins().get(i) + ","
					+ clock.getAllSec().get(i) + "," + brick.getHistX().get(i) + "," + brick.getHistY().get(i) + "\n";
		}

		JFileChooser fs = new JFileChooser(new File("//home//bivas//"));
		fs.setDialogTitle("SAVE");
		int result = fs.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File fi = fs.getSelectedFile();
			try {
				FileWriter fw = new FileWriter(fi.getPath());
				fw.write(content);
				fw.flush();
				fw.close();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}
		}

	}
}
