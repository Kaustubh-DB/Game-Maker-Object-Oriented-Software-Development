package com.gamemaker.team6.behaviour;

import static org.mockito.Mockito.when;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.gamemaker.team6.model.Component;


class ClimbReactionTest {
	private Component primary;
	private Component secondary;
	private Component tertiary;
	KeyEvent isUp,isDown ;
	private List<Component> components = new ArrayList<Component>();
	
	@BeforeEach
	void setUp() throws Exception {
		primary = Mockito.mock(Component.class);
		when(primary.getPosX()).thenReturn(50);
		when(primary.getPosY()).thenReturn(50);
		when(primary.getHeight()).thenReturn(100);
		when(primary.getWidth()).thenReturn(50);

	    secondary = Mockito.mock(Component.class);
		when(secondary.getPosX()).thenReturn(50);
		when(secondary.getPosY()).thenReturn(70);
		when(secondary.getHeight()).thenReturn(30);
		when(secondary.getWidth()).thenReturn(30);
		
		tertiary = Mockito.mock(Component.class);
		
		when(tertiary.getPosX()).thenReturn(300);
		when(tertiary.getPosY()).thenReturn(300);
		when(tertiary.getHeight()).thenReturn(30);
		when(tertiary.getWidth()).thenReturn(30);

		components.add(secondary);
		components.add(tertiary);
		components.add(primary);
		isUp = Mockito.mock(KeyEvent.class);
		isDown = Mockito.mock(KeyEvent.class);
		when(isUp.getKeyCode()).thenReturn(KeyEvent.VK_UP);
		when(isDown.getKeyCode()).thenReturn(KeyEvent.VK_DOWN);
	}

	@Test
	void test() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Reaction climbReaction = new ClimbReaction();
		//climbReaction.react(primary, components);
		
		Assert.assertEquals(false, climbReaction.react(primary, components));
		((KeyListener)climbReaction).keyPressed(isDown);
		((KeyListener)climbReaction).keyReleased(isDown);
		Assert.assertEquals(false, climbReaction.react(primary, components));
		((KeyListener)climbReaction).keyPressed(isUp);
		Assert.assertEquals(true, climbReaction.react(primary, components));
		((KeyListener)climbReaction).keyReleased(isUp);
		
		
		
		//Assert.assertEquals(false, climbReaction.react(secondary, components));
		//Assert.assertEquals(true, climbReaction.react(tertiary, components));
	}

}
