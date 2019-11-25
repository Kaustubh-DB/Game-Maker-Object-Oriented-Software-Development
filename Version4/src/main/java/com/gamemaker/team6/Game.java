package com.gamemaker.team6;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ConcurrentModificationException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

import com.gamemaker.team6.manager.GameManager;
import com.gamemaker.team6.model.Component;
import org.apache.log4j.Logger;

public class Game extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final static Logger logger = Logger.getLogger(Game.class);

	private int frame_width = 600;
	private int frame_height = 600;
	private GameManager gameManager;
	private Boolean start = false;
	private Boolean gameOn=true;
	private Graphics2D graphobj = null;
	private BufferedImage image=null;
	private JPanel controlPanel;
	private int showTime;
	
	public Game(GameManager gameManagerMain) {
		this.gameManager = gameManagerMain;
		this.setLayout(null);
		this.setBounds(500, 0, frame_width, frame_height);
		new GraphicDragController(this);
		showTime = 0;
	}

	public GameManager getGameManager() {
		return gameManager;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		graphobj = (Graphics2D) g;
		graphobj.drawImage(image, 0, 0, 820, 650,this);
		
		try {
			for(Component component : gameManager.getAllComponents()) {
				if (component !=null)
				{
					component.draw(graphobj);
				}
			}
		} catch (ConcurrentModificationException e) {
			logger.error("Concurrent Modification Exception" + e.getMessage());
		}
	}

	public int getFrame_width() {
		return frame_width;
	}

	public int getFrame_height() {
		return frame_height;
	}

	public void startGame() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		this.setFocusable(true);	
		this.requestFocus();

		while(gameOn) {
			if(start) {
				for (int i = 0; i < gameManager.getAllComponents().size(); i++) {
					Component component = gameManager.getAllComponents().get(i);
					if(!component.isActive()) {
						gameManager.getAllComponents().remove(i);
						continue;
					}
					component.update(this);
					component.react(gameManager.getAllComponents());
					this.setFocusable(true);	
				}
				
				// Add bullets to the set allComponents, doing it here to avoid concurrent modification
				showTime += 10;
				if (showTime % 1000 == 0) {
					((ControlPanel)controlPanel).setCurrTime(showTime / 1000);
				}

				try {
					logger.info("In try method, to see the animation for sleep");
					Thread.sleep(10);
					
				}
				catch(InterruptedException e1) {
					Thread.currentThread().interrupt();
					logger.error("Error in Starting the game" + e1.getMessage()	);

				}
				repaint();
			}
			repaint();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		logger.warn("ActionPerformed action is not used and is intentionally left exmpty!");
	}

	public Boolean getStart() {
		return start;
	}

	public void setStart(Boolean start) {
		this.start = start;
	}
	
	public void setGameOn(Boolean gameOn) {
		this.gameOn = gameOn;
	}
	
	public void setControlPanel(JPanel controls) {
		this.controlPanel = controls;
	}
}
