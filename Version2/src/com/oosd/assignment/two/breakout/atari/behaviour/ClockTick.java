package com.oosd.assignment.two.breakout.atari.behaviour;

import com.oosd.assignment.two.Breakout;
import com.oosd.assignment.two.breakout.atari.model.Component;
import com.oosd.assignment.two.breakout.atari.model.DigitalClock;

public class ClockTick implements Movement {

	private double milliSeconds;
	private int seconds;
	private int minutes;

	@Override
	public void move(Component component, Breakout breakout) {
		if (component.isReplay()) {
			int minutes = ((DigitalClock) component).getHistoryMinutes();
			int seconds = ((DigitalClock) component).getHistorySeconds();
			((DigitalClock) component).position(minutes, seconds);
			if (((DigitalClock) component).getCountPos() >= ((DigitalClock) component).getTotalCount()) {
				((DigitalClock) component).endReplay();
			}
		} else {
			milliSeconds += 0.01;
			seconds = ((DigitalClock) component).getCurrSeconds();
			minutes = ((DigitalClock) component).getCurrMinutes();
			if (milliSeconds >= 1) {
				seconds++;
				milliSeconds = 0;
			}
			if (seconds == 60) {
				minutes++;
				seconds = 0;
			}
			((DigitalClock) component).position(minutes, seconds);
		}

	}

}
