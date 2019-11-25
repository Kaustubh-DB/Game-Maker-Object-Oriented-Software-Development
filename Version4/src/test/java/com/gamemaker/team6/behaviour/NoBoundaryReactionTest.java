package com.gamemaker.team6.behaviour;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.gamemaker.team6.Game;
import com.gamemaker.team6.model.Component;

public class NoBoundaryReactionTest {
	private BoundaryBehavior noBoundaryReaction;
	private Component component;
	private JPanel game;

	@BeforeEach
	public void setup() {
		noBoundaryReaction = new NoBoundaryReaction();
		component = Mockito.mock(Component.class);
		game = Mockito.mock(Game.class);
		when(game.getWidth()).thenReturn(24);
		when(game.getHeight()).thenReturn(27);
	}

	@Test
	public void testLeft() {
		when(component.getPosX()).thenReturn(-1);
		noBoundaryReaction.reactWithBoundary(component, (Game)game);
		verify(component).setActive(false);
	}
	
	@Test
	public void testRight() {
		when(component.getPosX()).thenReturn(-1);
		when(component.getWidth()).thenReturn(26);
		noBoundaryReaction.reactWithBoundary(component, (Game)game);
		verify(component).setActive(false);
	}
	
	@Test
	public void testTop() {
		when(component.getPosY()).thenReturn(-1);
		noBoundaryReaction.reactWithBoundary(component, (Game)game);
		verify(component).setActive(false);
	}
	
	@Test
	public void testBottom() {
		when(component.getPosY()).thenReturn(-1);
		when(component.getHeight()).thenReturn(29);
		noBoundaryReaction.reactWithBoundary(component, (Game)game);
		verify(component).setActive(false);
	}
}
