package com.gamemaker.team6.behaviour;

import java.io.IOException;
import java.io.Serializable;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.gamemaker.team6.Game;
import com.gamemaker.team6.model.Component;

public interface Movement extends Serializable {

	void move(Component component, Game game) throws LineUnavailableException, IOException, UnsupportedAudioFileException;

}
