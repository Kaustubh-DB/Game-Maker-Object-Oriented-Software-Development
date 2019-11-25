package com.gamemaker.team6;

import static org.mockito.Mockito.when;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.gamemaker.team6.manager.GameManager;

class BuildGameTest {
	
	@Mock
	private Game game;
	@Mock
	private GameManager gameManager;
	private BuildGame buildGame;

	@BeforeEach
	void setUp() throws Exception {
		game = Mockito.mock(Game.class);
		gameManager = Mockito.mock(GameManager.class);
		buildGame = new BuildGame(gameManager, game);
		buildGame.makeGame();
	}

	@Test
	void testSave() {
		ActionEvent e = Mockito.mock(ActionEvent.class);
		when(e.getSource()).thenReturn(new JButton("Save"));
		buildGame.actionPerformed(e);
	}
	
	@Test
	void testLoad() {
		ActionEvent e = Mockito.mock(ActionEvent.class);
		when(e.getSource()).thenReturn(new JButton("Load"));
		buildGame.actionPerformed(e);
	}
}
