package com.gamemaker.team6.model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import org.apache.log4j.Logger;

import com.gamemaker.team6.Game;
public class ImageComponent extends Component {
	
	private static final long serialVersionUID = 1L;
	private String imageName;
	private final static Logger logger = Logger.getLogger(ImageComponent.class);

	public ImageComponent(String imageName, int initialPositionX, int initialPositionY, int imageWidth, int imageHeight) {
		position(initialPositionX, initialPositionY);
		setHeight(imageHeight);
		setWidth(imageWidth);
		this.imageName = imageName;
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		BufferedImage img = null;
		String filePath = System.getProperty("user.dir") + File.separator + "icons" + File.separator + imageName;
		try {
			img = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			logger.debug("Catch the exception if image is not found"+e.getMessage());
		}
		g2d.drawImage(img, this.getPosX(), this.getPosY(),  this.getWidth(), this.getHeight(), null);
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
}
