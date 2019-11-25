package com.gamemaker.team6.behaviour;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.gamemaker.team6.Game;
import com.gamemaker.team6.model.Component;

public class BoundaryRotateTest {
	private BoundaryBehavior boundaryRotate;
	private Component component;
	private JPanel game;

	@BeforeEach
	public void setup() {
		boundaryRotate = new BoundaryRotate();
		component = Mockito.mock(Component.class);
		game = Mockito.mock(Game.class);
		when(game.getWidth()).thenReturn(24);
		when(game.getHeight()).thenReturn(27);
		when(component.getHeight()).thenReturn(29);
	}

	@Test
	public void testRightOut() {
		when(component.getPosX()).thenReturn(25);
		when(component.getPosY()).thenReturn(0);
		boundaryRotate.reactWithBoundary(component, (Game)game);
		verify(component).position(1, 0);
	}
	
	@Test
	public void testLeftOut() {
		when(component.getPosX()).thenReturn(-1);
		when(component.getPosY()).thenReturn(0);
		boundaryRotate.reactWithBoundary(component, (Game)game);
		verify(component).position(24, 0);
	}
	
	@Test
	public void testUpOut() {
		when(component.getPosX()).thenReturn(5);
		when(component.getPosY()).thenReturn(-1);
		boundaryRotate.reactWithBoundary(component, (Game)game);
		verify(component).position(5, 27);
	}
	
	@Test
	public void testBottomOut() {
		when(component.getPosX()).thenReturn(5);
		when(component.getPosY()).thenReturn(0);
		boundaryRotate.reactWithBoundary(component, (Game)game);
		verify(component).position(5, 29);
	}
}
