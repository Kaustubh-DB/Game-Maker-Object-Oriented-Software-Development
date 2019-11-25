package com.oosd.assignment.two.breakout.atari.commands;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.oosd.assignment.two.breakout.atari.model.Ball;
import com.oosd.assignment.two.breakout.atari.model.Component;
import com.oosd.assignment.two.breakout.atari.model.Paddle;

class ReplayCommandTest {

	private List<Component> components;
	private Ball ball;
	private Paddle paddle;
	
	@Test
	void test() {
		ball = new Ball(Color.black, 0, 1, 1, 4);
		paddle = new Paddle(Color.CYAN, 1, 2, 10, 5);
		
		List<Integer> histXList = new ArrayList<Integer>();
		
		histXList.add(1);
		histXList.add(2);
		paddle.setHistX(histXList);
		
		components = new ArrayList<>();
		components.add(ball);
		components.add(paddle);
		
		Command command = new ReplayCommand(components);
		command.execute();
	}

}
