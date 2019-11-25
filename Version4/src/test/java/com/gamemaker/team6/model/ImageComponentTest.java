package com.gamemaker.team6.model;

import java.io.IOException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ImageComponentTest {
	@Test
	public void test() throws IOException {
		ImageComponent b = new ImageComponent("monkey.png", 0, 0, 0, 0);
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
		
		String temp = "random string";
		b.setImageName(temp);
		Assert.assertEquals(temp, b.getImageName());
	}
}
