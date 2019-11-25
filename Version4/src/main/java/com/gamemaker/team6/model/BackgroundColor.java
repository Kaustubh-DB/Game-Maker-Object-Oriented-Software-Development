package com.gamemaker.team6.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.Serializable;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.apache.log4j.Logger;

import com.gamemaker.team6.Game;

public class BackgroundColor extends Component implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private final static Logger logger = Logger.getLogger(BackgroundColor.class);
	
	private Color bgColor;
	
	public BackgroundColor(Color c) {
		this.bgColor = c;
	}

	@Override
	public void draw(Graphics2D g2d) {
		logger.warn("This draw method is intentionally left blank");

	}

	@Override
	public void update(Game game) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		logger.warn("This update method is not used and is intentionally left blank");
	}

	public Color getBgColor() {
		return bgColor;
	}

	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}
}
