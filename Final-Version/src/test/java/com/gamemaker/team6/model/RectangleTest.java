package com.gamemaker.team6.model;

import static org.mockito.Mockito.verify;

import java.awt.Color;
import java.awt.Graphics2D;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RectangleTest {
	@Test
	public void test() {
		Component b = new Rectangle(Color.BLUE, 0, 0, 0, 0);
		b.setPosX(2);
		Assert.assertEquals(2, b.getPosX());
			
		b.setPosY(3);
		Assert.assertEquals(3, b.getPosY());

		b.setDx(3);
		Assert.assertEquals(3,b.getDx());
		
		b.setDy(4);
		Assert.assertEquals(4,b.getDy());
		
		b.setHeight(200);
		Assert.assertEquals(200,b.getHeight());
		
		b.setWidth(300);
		Assert.assertEquals(300,b.getWidth());
		
		Graphics2D g2d = Mockito.mock(Graphics2D.class);
		b.draw(g2d);
		verify(g2d).setColor(Color.BLUE);
		verify(g2d).fillRect(2, 3, 300, 200);	
	}
}
