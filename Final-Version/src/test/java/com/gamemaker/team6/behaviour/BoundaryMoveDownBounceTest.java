package com.gamemaker.team6.behaviour;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.gamemaker.team6.Game;
import com.gamemaker.team6.model.Component;

public class BoundaryMoveDownBounceTest {

	private BoundaryBehavior boundaryMoveDownBounce;
	private Component component;
	private JPanel game;

	@BeforeEach
	public void setup() {
		boundaryMoveDownBounce = new BoundaryMoveDownBounce();
		component = Mockito.mock(Component.class);
		game = Mockito.mock(Game.class);
		when(game.getWidth()).thenReturn(24);
		when(game.getHeight()).thenReturn(27);
		when(component.getPosX()).thenReturn(0);
		when(component.getPosY()).thenReturn(0);
		when(component.getDx()).thenReturn(5);
		when(component.getDy()).thenReturn(8);
		when(component.getWidth()).thenReturn(25);
		when(component.getHeight()).thenReturn(28);
		boundaryMoveDownBounce.reactWithBoundary(component, (Game)game);
	}

	@Test
	public void testHorizontalBounce() {
		verify(component).setDx(-5);
		verify(component).setPosY(30);
	}
	
	@Test
	public void testVerticalBounce() {
		verify(component).setDy(-8);
	}
}
