package com.gamemaker.team6;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import javax.swing.JFrame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.gamemaker.team6.manager.GameManager;
import com.gamemaker.team6.manager.Manager;

class ComponentPropertiesTest {
	@Mock
	private Game game;
	@Mock
	private Manager gameManager;
	@Mock
	private JFrame jFrame;
	private ComponentProperties cp;
	
	@BeforeEach
	void setUp() throws Exception {
		game = Mockito.mock(Game.class);
		gameManager = Mockito.mock(GameManager.class);
		jFrame = Mockito.mock(JFrame.class);
		
	}

	@Test
	void testCircle() {
		cp = new ComponentProperties(game, gameManager, "circle", jFrame);
		cp.setProperties();
		verify(gameManager).register(any(), any(), any(), any(), any());
		verify(jFrame).dispose();
	}
	
	@Test
	void testRectangle() {
		cp = new ComponentProperties(game, gameManager, "rectangle", jFrame);
		cp.setProperties();
		verify(gameManager).register(any(), any(), any(), any(), any());
		verify(jFrame).dispose();
	}
	
	@Test
	void testShip() {
		cp = new ComponentProperties(game, gameManager, "ship", jFrame);
		cp.setProperties();
		verify(gameManager).register(any(), any(), any(), any(), any());
		verify(jFrame).dispose();
	}
	
	@Test
	void testInvader() {
		cp = new ComponentProperties(game, gameManager, "invader", jFrame);
		cp.setProperties();
		verify(gameManager).register(any(), any(), any(), any(), any());
		verify(jFrame).dispose();
	}
	
	@Test
	void testMushroom() {
		cp = new ComponentProperties(game, gameManager, "mushroom", jFrame);
		cp.setProperties();
		verify(gameManager).register(any(), any(), any(), any(), any());
		verify(jFrame).dispose();
	}
	
	@Test
	void testGhost() {
		cp = new ComponentProperties(game, gameManager, "ghostred", jFrame);
		cp.setProperties();
		verify(gameManager).register(any(), any(), any(), any(), any());
		verify(jFrame).dispose();
	}
	
	@Test
	void testMonkey() {
		cp = new ComponentProperties(game, gameManager, "monkey", jFrame);
		cp.setProperties();
		verify(gameManager).register(any(), any(), any(), any(), any());
		verify(jFrame).dispose();
	}
	
	@Test
	void testPacman() {
		cp = new ComponentProperties(game, gameManager, "pacman", jFrame);
		cp.setProperties();
		verify(gameManager).register(any(), any(), any(), any(), any());
		verify(jFrame).dispose();
	}
	
	@Test
	void testFood() {
		cp = new ComponentProperties(game, gameManager, "food", jFrame);
		cp.setProperties();
		verify(gameManager).register(any(), any(), any(), any(), any());
		verify(jFrame).dispose();
	}
	
	@Test
	void testLadder() {
		cp = new ComponentProperties(game, gameManager, "ladder", jFrame);
		cp.setProperties();
		verify(gameManager).register(any(), any(), any(), any(), any());
		verify(jFrame).dispose();
	}
}
