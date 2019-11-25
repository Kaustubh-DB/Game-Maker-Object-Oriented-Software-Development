package com.gamemaker.team6.behaviour;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.awt.Color;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.gamemaker.team6.manager.Manager;
import com.gamemaker.team6.model.Circle;
import com.gamemaker.team6.model.Component;

class ThrowBarrelTest {

	Circle barrel;
	Component component;
	Manager gamemanager;
	Random randomno;
	
	@BeforeEach
	void setUp() throws Exception {
		barrel = Mockito.mock(Circle.class);
		when(barrel.getColor()).thenReturn(Color.DARK_GRAY);
		when(barrel.getHeight()).thenReturn(30);
		when(barrel.getWidth()).thenReturn(30);
		
		randomno = Mockito.mock(Random.class);
		//when(randomno.nextInt()).thenReturn(300);
		when(randomno.nextInt())
		.thenReturn(300)
	   .thenReturn(400);
		
		component = Mockito.mock(Component.class);
		when(component.getPosX()).thenReturn(50);
		when(component.getPosY()).thenReturn(50);

		
		
	}
	@Test
	void test() {
		ThrowBarrel throwBarrel = new ThrowBarrel(component, gamemanager);
		throwBarrel.act();
		
	}

}
