package com.gamemaker.team6.behaviour;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.gamemaker.team6.Game;
import com.gamemaker.team6.manager.GameManager;
import com.gamemaker.team6.manager.Manager;
import com.gamemaker.team6.model.Component;
import com.gamemaker.team6.model.Rectangle;

public class ManualMovementTest {
	private ManualMovement manualMovement;
	
	@Mock
	private Manager gameManager;
	@Mock
	private Game game;
	@Mock
	private Component component= Mockito.mock(Rectangle.class);

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setup() {
		gameManager = Mockito.mock(GameManager.class);
		game = Mockito.mock(Game.class);
		component= Mockito.mock(Rectangle.class);
		
		when(component.getPosX()).thenReturn(10);
		when(component.getPosY()).thenReturn(10);
		when(component.getWidth()).thenReturn(8);
		when(component.getHeight()).thenReturn(8);
		when(component.getDx()).thenReturn(4);
		when(component.getDy()).thenReturn(4);
		when(game.getFrame_width()).thenReturn(50);
		when(game.getFrame_height()).thenReturn(50);
	}
	
	@Test
	public void testPressLeft() {
		KeyEvent leftKey = new KeyEvent(new JPanel(), 0, 0, 0, KeyEvent.VK_LEFT);
		manualMovement = new ManualMovement("arrow", gameManager);
		manualMovement.keyPressed(leftKey);
		manualMovement.move(component, game);
		verify(component).position(6, 10);
	}
	
	@Test
	public void testPressRight() {
		KeyEvent rightKey = new KeyEvent(new JPanel(), 0, 0, 0, KeyEvent.VK_RIGHT);
		manualMovement = new ManualMovement("arrow", gameManager);
		manualMovement.keyPressed(rightKey);
		manualMovement.move(component, game);
		verify(component).position(14, 10);
	}
	
	@Test
	public void testPressUp() {
		KeyEvent upKey = new KeyEvent(new JPanel(), 0, 0, 0, KeyEvent.VK_UP);
		manualMovement = new ManualMovement("arrow", gameManager);
		manualMovement.keyPressed(upKey);
		manualMovement.move(component, game);
		verify(component).position(10, 6);
	}
	
	@Test
	public void testPressDown() {
		KeyEvent downKey = new KeyEvent(new JPanel(), 0, 0, 0, KeyEvent.VK_DOWN);
		manualMovement = new ManualMovement("arrow", gameManager);
		manualMovement.keyPressed(downKey);
		manualMovement.move(component, game);
		verify(component).position(10, 14);
	}
	
	@Test
	public void testPressA() {
		KeyEvent AKey = new KeyEvent(new JPanel(), 0, 0, 0, KeyEvent.VK_A);
		manualMovement = new ManualMovement("wasd", gameManager);
		manualMovement.keyPressed(AKey);
		manualMovement.move(component, game);
		verify(component).position(6, 10);
	}
	
	@Test
	public void testPressD() {
		KeyEvent DKey = new KeyEvent(new JPanel(), 0, 0, 0, KeyEvent.VK_D);
		manualMovement = new ManualMovement("wasd", gameManager);
		manualMovement.keyPressed(DKey);
		manualMovement.move(component, game);
		verify(component).position(14, 10);
	}
	
	@Test
	public void testPressW() {
		KeyEvent WKey = new KeyEvent(new JPanel(), 0, 0, 0, KeyEvent.VK_W);
		manualMovement = new ManualMovement("wasd", gameManager);
		manualMovement.keyPressed(WKey);
		manualMovement.move(component, game);
		verify(component).position(10, 6);
	}
	
	@Test
	public void testPressS() {
		KeyEvent SKey = new KeyEvent(new JPanel(), 0, 0, 0, KeyEvent.VK_S);
		manualMovement = new ManualMovement("wasd", gameManager);
		manualMovement.keyPressed(SKey);
		manualMovement.move(component, game);
		verify(component).position(10, 14);
	}
}
