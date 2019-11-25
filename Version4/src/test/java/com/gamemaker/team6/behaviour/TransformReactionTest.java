package com.gamemaker.team6.behaviour;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.gamemaker.team6.manager.Manager;
import com.gamemaker.team6.model.Component;

class TransformReactionTest {

	private Component primary;
	private Component secondary;
	private Component tertiary;
	private List<Component> components = new ArrayList<Component>();
	private Manager gm;

	@BeforeEach
	public void setup() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		gm = Mockito.mock(Manager.class);
		
		primary = Mockito.mock(Component.class);
		when(primary.getPosX()).thenReturn(50);
		when(primary.getPosY()).thenReturn(50);
		when(primary.getHeight()).thenReturn(100);
		when(primary.getWidth()).thenReturn(10);
		
		
		secondary = Mockito.mock(Component.class);
		when(secondary.getPosX()).thenReturn(40);
		when(secondary.getPosY()).thenReturn(60);
		when(secondary.getHeight()).thenReturn(30);
		when(secondary.getWidth()).thenReturn(30);
		when(secondary.isToxic()).thenReturn(true);
		
		
		tertiary = Mockito.mock(Component.class);
		when(tertiary.getPosX()).thenReturn(300);
		when(tertiary.getPosY()).thenReturn(300);
		when(tertiary.getHeight()).thenReturn(30);
		when(tertiary.getWidth()).thenReturn(30);
		
		components.add(secondary);
		components.add(tertiary);
		components.add(primary);
	}
	

	@SuppressWarnings("deprecation")
	@Test
	void testReact() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		 TransformReaction transformReaction = new TransformReaction(gm);
		Assertions.assertEquals(false, transformReaction.react(primary, components));
		verify(primary).explode();
	}
}
