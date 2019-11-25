package com.gamemaker.team6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.image.BufferedImage;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.gamemaker.team6.manager.GameManager;
import com.gamemaker.team6.model.Component;


public class GameTest {
	private Game game;
	@Mock
	private GameManager gameManager;
	@Mock 
	private Component c1;
	@Mock 
	private Component c2;
	@Mock
	private Component t1;
	private List<Component> allComponents;
	private List<Component> toxicComponents;
	
	@BeforeEach
	public void setup() {
		gameManager = Mockito.mock(GameManager.class);
		game = new Game(gameManager);
		game.setStart(true);
	}

	@Test
	public void testSetGetImage() {
		BufferedImage mockBufferedImage = Mockito.mock(BufferedImage.class);
		game.setImage(mockBufferedImage);
		assertTrue(game.getImage() == mockBufferedImage);
	}
	
	@Test
	public void testFrameWidthHeight() {
		assertEquals(game.getFrame_width(), 600);
		assertEquals(game.getFrame_height(), 600);
	}
	
	@Test
	public void testSetGetStart() {
		game.setStart(false);
		assertTrue(!game.getStart());
	}
}
