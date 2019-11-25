package com.gamemaker.team6.behaviour;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.gamemaker.team6.Game;
import com.gamemaker.team6.model.Component;

public class BoundaryBounceDropTest {
	private BoundaryBehavior boundaryBounceDrop;
	private Component component;
	private JPanel game;

	@BeforeEach
	public void setup() {
		boundaryBounceDrop = new BoundaryBounceDrop();
		component = Mockito.mock(Component.class);
		game = Mockito.mock(Game.class);
		when(game.getWidth()).thenReturn(24);
		when(game.getHeight()).thenReturn(27);
		when(component.getPosX()).thenReturn(0);
		when(component.getPosY()).thenReturn(-1);
		when(component.getDx()).thenReturn(5);
		when(component.getDy()).thenReturn(8);
		when(component.getWidth()).thenReturn(25);
		when(component.getHeight()).thenReturn(29);
		boundaryBounceDrop.reactWithBoundary(component, (Game)game);
	}

	@Test
	public void testHorizontalBounce() {
		verify(component).setDx(-5);
	}
	
	@Test
	public void testUpBounce() {
		verify(component).setDy(-8);
	}
	
	@Test
	public void testBottomBounce() {
		verify(component).explode();
	}
}
