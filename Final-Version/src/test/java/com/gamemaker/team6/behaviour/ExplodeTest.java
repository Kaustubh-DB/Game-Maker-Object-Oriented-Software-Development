package com.gamemaker.team6.behaviour;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.gamemaker.team6.model.Component;

public class ExplodeTest {

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
		
		when(secondary.getPosX()).thenReturn(25);
		when(secondary.getPosY()).thenReturn(25);
		when(secondary.getHeight()).thenReturn(30);
		when(secondary.getWidth()).thenReturn(30);
		when(secondary.isToxic()).thenReturn(true);
	
		components.add(primary);
		components.add(secondary);
	}

	@Test
	void testExplodeOnWeapon() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Reaction explode = new Explode("Weapon");
		Boolean boo = explode.react(primary, components);
		verify(primary).explode();
		Assert.assertEquals(true, boo);
	}
	
	@Test
	void testExplodeConsumable() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Reaction explode = new Explode("Consumable");
		Boolean boo = explode.react(secondary, components);
		verify(secondary).explode();
		Assert.assertEquals(true, boo);
	}
	
	@Test
	void testExplode() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Reaction explode = new Explode("");
		Boolean boo = explode.react(primary, components);
		verify(primary).explode();
		Assert.assertEquals(true, boo);
	}
	
	@Test
	void testNoExplode() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Reaction explode = new Explode("Consumable");
		Boolean boo = explode.react(primary, components);
		Assert.assertEquals(false, boo);
	}
}
