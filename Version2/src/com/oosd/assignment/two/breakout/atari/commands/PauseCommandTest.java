package com.oosd.assignment.two.breakout.atari.commands;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.oosd.assignment.two.breakout.atari.model.Ball;
import com.oosd.assignment.two.breakout.atari.model.Component;
import com.oosd.assignment.two.breakout.atari.model.Paddle;

class PauseCommandTest {

	private List<Component> components;
	private Ball ball;
	private Paddle paddle;
	
	@Test
	void test() {
		ball = new Ball(Color.black, 0, 1, 1, 4);
		paddle = new Paddle(Color.CYAN, 1, 2, 10, 5);
		
		components = new ArrayList<>();
		components.add(ball);
		components.add(paddle);
		
		Command command = new PauseCommand(components);
		command.execute();
	}

}
