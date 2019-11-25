package com.oosd.assignment.two.breakout.atari.behaviour;

import com.oosd.assignment.two.breakout.atari.model.Component;

public interface Reaction {

	boolean react(Component component, Component ball);

}
