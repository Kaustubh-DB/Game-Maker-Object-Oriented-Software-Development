package com.oosd.assignment.two.breakout.atari.commands;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.oosd.assignment.two.breakout.atari.model.Circle;
import com.oosd.assignment.two.breakout.atari.model.Component;
import com.oosd.assignment.two.breakout.atari.model.Rectangle;

class UndoCommandTest {

		private List<Component> components;
		private Circle ball;
		private Rectangle paddle;
		
		@Test
		void test() {
			ball = new Circle(Color.black, 0, 1, 1, 4);
			paddle = new Rectangle(Color.CYAN, 1, 2, 10, 5);
			
			List<Integer> histXList = new ArrayList<Integer>();
			
			histXList.add(1);
			histXList.add(2);
			paddle.setHistX(histXList);
			
			components = new ArrayList<>();
			components.add(ball);
			components.add(paddle);
			
			Command command = new UndoCommand(components);
			command.execute();
		}
}