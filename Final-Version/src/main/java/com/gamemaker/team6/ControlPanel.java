package com.gamemaker.team6;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;


public class ControlPanel extends JPanel implements KeyListener,ActionListener {

	private final static Logger logger = Logger.getLogger(ControlPanel.class);
	private static final long serialVersionUID = 8192288675113760646L;
	private JButton startStop;
	private Game game;
	private JLabel clockLabel;
	private int currTime;

	public ControlPanel(Game game) {
		this.setLayout(null);
		this.setBounds(500,600,600,50);
		startStop = new JButton("Start/ Stop");
		startStop.setEnabled(true);
		startStop.setFocusable(false);
		startStop.setBounds(0, 0, 100, 25);
		
		this.clockLabel = new JLabel("0:0", SwingConstants.CENTER);
		this.clockLabel.setFont(new Font("Monaco", Font.BOLD, 20));
		this.clockLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		clockLabel.setBounds(150, 0, 80, 25);
		this.game = game;
		startStop.addActionListener(this);
		this.add(startStop);
		this.add(clockLabel);
	}
	
	public int getCurrTime() {
		return currTime;
	}

	public void setCurrTime(int currTime) {
		this.currTime = currTime;
		int sec = currTime % 60;
		int min = currTime / 60;
		this.clockLabel.setText(((Integer)min).toString() + ":" + ((Integer)sec).toString());
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
		logger.warn("KeyTyped function is not used and is intentionally left blank");

	}

	@Override
	public void keyPressed(KeyEvent e) {
		logger.warn("KeyTyped Pressed is not used and is intentionally left blank");

	}

	@Override
	public void keyReleased(KeyEvent e) {
		logger.warn("KeyReleased function is not used and is intentionally left blank");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startStop) {
	    	   try {
	    		   		if(game.getStart())
	    		   		{
	    		   			game.setStart(false);
	    		   		}
	    		   		else
	    		   		{
	    		   			game.setStart(true);
	    		   		}
					
	    	   }catch(Exception ex) {
	    		   logger.error("Error in starting the game" + ex.getMessage());    	
	    	   }
	    	   
	       }
	}
}
