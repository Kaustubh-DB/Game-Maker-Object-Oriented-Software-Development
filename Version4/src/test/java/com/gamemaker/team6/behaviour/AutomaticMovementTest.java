package com.gamemaker.team6.behaviour;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.gamemaker.team6.Game;
import com.gamemaker.team6.behaviour.AutomaticMovement;
import com.gamemaker.team6.model.Component;


class AutomaticMovementTest {
	
	private Component component;
	private Game game;
	@BeforeEach
	void setUp() throws Exception {
		component = Mockito.mock(Component.class);
		game = Mockito.mock(Game.class);
		when(component.getPosX()).thenReturn(0);
		when(component.getPosY()).thenReturn(0);
		when(component.getDx()).thenReturn(10);
		when(component.getDy()).thenReturn(12);
		
	}

	@Test
	void testMove() {
		AutomaticMovement autoMove = new AutomaticMovement();
		autoMove.move(component, game);
		verify(component).position(10, 12);
	}

}