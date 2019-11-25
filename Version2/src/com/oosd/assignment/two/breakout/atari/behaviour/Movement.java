package com.oosd.assignment.two.breakout.atari.behaviour;

import java.awt.event.KeyEvent;

import com.oosd.assignment.two.Breakout;
import com.oosd.assignment.two.breakout.atari.model.Component;

public interface Movement {

	void move(Component component, Breakout breakout);

}
