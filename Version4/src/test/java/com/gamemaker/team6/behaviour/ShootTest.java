package com.gamemaker.team6.behaviour;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.awt.event.KeyEvent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.gamemaker.team6.manager.GameManager;
import com.gamemaker.team6.model.Component;

class ShootTest {
	Shoot shoot;
	GameManager gameManager;
	Component component;
	KeyEvent isSpace;
	@BeforeEach
	void setUp() throws Exception {
		gameManager = Mockito.mock(GameManager.class);
		component = Mockito.mock(Component.class);
		when(component.getPosX()).thenReturn(50);
		when(component.getPosY()).thenReturn(50);
		when(component.getHeight()).thenReturn(100);
		when(component.getWidth()).thenReturn(10);
		
		isSpace = Mockito.mock(KeyEvent.class);
		when(isSpace.getKeyCode()).thenReturn(KeyEvent.VK_SPACE);
	}

	@Test
	void testAct() {
		shoot = new Shoot(component, gameManager);
		shoot.setShootDirection("Up");
		shoot.setShootOption("Manual Shooting");
		shoot.act();
		shoot.setShootDirection("Down");
		shoot.act();
		shoot.setShootDirection("Left");
		shoot.act();
		shoot.setShootDirection("Right");
		shoot.act();
		shoot.setShootDirection("");
		shoot.act();
		shoot.setShootDirection("Right");
		shoot.keyPressed(isSpace);
		
		//verify(gameManager).register(bullet, new NoReaction(), new AutomaticMovement(), new NoBoundaryReaction(), new NoAction());
	}

	

	@Test
	void testSetShootDirection() {
		shoot = new Shoot(component, gameManager);
		shoot.setShootDirection("Up");
		assertEquals("Up", shoot.getShootDirection());
		shoot.setShootDirection("Down");
		assertEquals("Down", shoot.getShootDirection());
		shoot.setShootDirection("Left");
		assertEquals("Left", shoot.getShootDirection());
		shoot.setShootDirection("Right");
		assertEquals("Right", shoot.getShootDirection());
		shoot.setShootDirection("");
		assertEquals("", shoot.getShootDirection());
	}
	@Test
	void testGetShootOption() {
		shoot = new Shoot(component, gameManager);
		shoot.setShootOption("Manual Shooting");
		assertEquals("Manual Shooting", shoot.getShootOption());
	}

}
