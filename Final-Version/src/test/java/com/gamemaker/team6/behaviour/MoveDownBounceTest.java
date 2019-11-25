package com.gamemaker.team6.behaviour;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.gamemaker.team6.model.Component;

public class MoveDownBounceTest {
	private Component primary;
	private Component secondary;
	private List<Component> components = new ArrayList<Component>();
	
	@BeforeEach
	void setUp() throws Exception {
		primary = Mockito.mock(Component.class);
	    secondary = Mockito.mock(Component.class);
 
		when(primary.getPosX()).thenReturn(0);
		when(primary.getPosY()).thenReturn(0);
		when(primary.getHeight()).thenReturn(50);
		when(primary.getWidth()).thenReturn(50);
		when(primary.isToxic()).thenReturn(false);

		when(secondary.getDx()).thenReturn(5);
		when(secondary.getDy()).thenReturn(6);
		when(secondary.isToxic()).thenReturn(false);
	
		components.add(primary);
		components.add(secondary);
	}

	@Test
	void testMoveDownBounceHorizontal() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		when(secondary.getPosX()).thenReturn(25);
		when(secondary.getPosY()).thenReturn(25);
		when(secondary.getHeight()).thenReturn(30);
		when(secondary.getWidth()).thenReturn(30);
		Reaction moveDownBounce = new MoveDownBounce();
		Boolean boo = moveDownBounce.react(primary, components);
		verify(secondary).setDx(-5);
		verify(secondary).setPosY(55);
		Assert.assertEquals(true, boo);
	}
	
	@Test
	void testMoveDownBounceVertical() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		when(secondary.getPosX()).thenReturn(25);
		when(secondary.getPosY()).thenReturn(25);
		when(secondary.getHeight()).thenReturn(60);
		when(secondary.getWidth()).thenReturn(60);
		Reaction moveDownBounce = new MoveDownBounce();
		Boolean boo = moveDownBounce.react(primary, components);
		verify(secondary).setDy(-6);
		Assert.assertEquals(true, boo);
	}
}
