package com.oosd.assignment.two;

import java.awt.Color;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import com.oosd.assignment.two.breakout.atari.behaviour.AutomaticMovement;
import com.oosd.assignment.two.breakout.atari.behaviour.BounceBack;
import com.oosd.assignment.two.breakout.atari.behaviour.Explode;
import com.oosd.assignment.two.breakout.atari.behaviour.ManualMovement;
import com.oosd.assignment.two.breakout.atari.behaviour.Movement;
import com.oosd.assignment.two.breakout.atari.behaviour.StaticMovement;
import com.oosd.assignment.two.breakout.atari.commands.LoadCommand;
import com.oosd.assignment.two.breakout.atari.commands.PauseCommand;
import com.oosd.assignment.two.breakout.atari.commands.ReplayCommand;
import com.oosd.assignment.two.breakout.atari.commands.SaveCommand;
import com.oosd.assignment.two.breakout.atari.commands.UndoCommand;
import com.oosd.assignment.two.breakout.atari.layouts.ButtonContainer;
import com.oosd.assignment.two.breakout.atari.layouts.ControllerLayout;
import com.oosd.assignment.two.breakout.atari.layouts.FlowLayoutClass;
import com.oosd.assignment.two.breakout.atari.manager.GameManager;
import com.oosd.assignment.two.breakout.atari.model.Circle;
import com.oosd.assignment.two.breakout.atari.model.Square;
import com.sun.prism.Graphics;
import com.oosd.assignment.two.breakout.atari.model.Component;
import com.oosd.assignment.two.breakout.atari.model.Rectangle;


public class GameMaker extends JPanel implements ActionListener, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
	JPanel buttonsPanel = new JPanel();
	GamePlay gamePlay;
	Component c;
	String[] components = new String[]{ "Circle", "Square", "Rectangle"};
	private final List<String> componentsList = new ArrayList<String>();
	
	int circleWidth = 0;
	int	circleHeight = 0;
	int	rectangleHeight =0; 
	int	rectangleWidth = 0; 
	int	squareWidth=0;
	int squareHeight=0;
	int x,y;
	int no_squares = 1;
	int no_circles = 1;
	int no_rectangles = 1;
	
	
	Color circleColor;
	Color rectangleColor; 
	Color squareColor;
	String[] color = {"Red", "Blue", "Green"};
	
	String[] size = { "Small", "Medium", "Large"};
	
	String[] movements = {"Automatic","Keyboard","Static"};
	
	String[] themecolor = {"Light", "White", "Dark"};
	
	String[] audiofile = {"Grenade", "Punch", "Bomb"};
	
	String[] imgfile = {"Scenery", "City Lights", "Purple"};
	String[] reaction = {"Bounce Back","Explode"};
	
	List<String> addedComponents = new ArrayList<String>();
	String str = "";
	
	JComboBox componentCombo1;
	JComboBox colorCombo1;
	JComboBox sizeCombo1;
	JComboBox chooseMovements1;
	JComboBox collisionOf;
	JComboBox collisionWith;
	JComboBox audios;
	JComboBox theme;
	JComboBox background;
	JComboBox reactions;
	
	
	JButton addcomponent;
	JButton playButton;
	JButton newButton;
	JButton saveButton;
	JButton loadButton;
	
	
		
	AutomaticMovement circleautomaticMovement;
	AutomaticMovement rectangleautomaticMovement;
	ManualMovement rectanglemanualMovement;
	ManualMovement squaremanualMovement;
	ManualMovement circlemanualMovement;
	Movement circlemovement;
	Movement rectanglemovement;
	Movement squaremovement;
	StaticMovement circlestaticmovement;
	StaticMovement squarestaticMovement;
	StaticMovement rectanglestaticMovement; 
	

	GameManager gameManager;
	

	JLabel object = new JLabel();
	JLabel colour = new JLabel();
	JLabel sizes = new JLabel();
	JLabel movement = new JLabel();
	JLabel collision1 = new JLabel();
	JLabel collision2 = new JLabel();
	JLabel sound = new JLabel();
	JLabel themechoose = new JLabel();
	JLabel bgimage = new JLabel();
	
	
	JPopupMenu popup = new JPopupMenu();
	JMenuItem vertical = new JMenuItem("Vertical");
	JMenuItem horizontal = new JMenuItem("Horizontal");
	
	
	
	
	String circle;
	String rectangle;
	String square;
	String circleSize;
	String rectangleSize;
	String squareSize;
	String circlemove;
	String rectanglemove;
	String squaremove;
	String rectanglealign;
	String automatic = "Automatic";
	String keyboard = "Keyboard";
	String staticMove = "Static";
	String selectedcollisionOf;
    String selectedCollisionWith;
	
	Component circleComp;
	Component rectangleComp;
	Component squareComp;

	
	ButtonContainer buttonContainer;
	
	public GameMaker(GameManager gameManager, GamePlay gamePlay) {
		this.gameManager= gameManager;
		this.gamePlay = gamePlay;
		Collections.addAll(componentsList,components);
		
		buttonContainer = new ButtonContainer(buttonsPanel, gameManager, new FlowLayoutClass(buttonsPanel));
		buttonsPanel.removeAll();
		buttonsPanel.setSize(600, 100);
 		FlowLayoutClass flow = new FlowLayoutClass(buttonContainer);
		controllerSetup(buttonContainer, flow);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
        String selectedcomponent = (String)componentCombo1.getSelectedItem();
        String selectedaudio = (String)audios.getSelectedItem();
        String selectedtheme = (String)theme.getSelectedItem();
        String selectedbg = (String)theme.getSelectedItem();
        String circleColour;
        String rectangleColour;
        String squareColour;
        String collisionOfobj = new String();
        String collisionWithobj = new String();
        String selectedReaction;
      
        String command = e.getActionCommand();
        String red = "Red";
        String blue = "Blue";
        String green = "Green";
        String small ="Small";
        String medium = "Medium";
        String large = "Large";
        String vertical = "Vertical";
        String horizontal = "Horizontal";
        String audio1= "Grenade";
    	String audio2= "Punch";
    	String audio3= "Bomb";
    	String theme1= "Light";
    	String theme2= "White";
    	String theme3= "Dark";
    	String img1= "Scenery";
    	String img2= "City Lights";
    	String img3= "Purple";
        
        
                
        if (e.getSource() == audios) {
    		if(selectedaudio.equals("Grenade")) {
    			String audiofile = "Grenade-SoundBible.com-1777900486.wav";
    			//String a1 = (String) audios.getSelectedItem();
//    			if(a1.equals(audio1)) {
//    					
//    				    String gongFile = "Grenade-SoundBible.com-1777900486.wav";
//    				   try {
//    					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(gongFile).getAbsoluteFile());
//    					Clip clip = AudioSystem.getClip();
//    					clip.open(audioInputStream);
//    					clip.start();
//    				} catch (UnsupportedAudioFileException e1) {
//    					
//    					System.out.println(e1.getMessage());
//    				} catch (IOException e1) {
//    					
//    					System.out.println(e1.getMessage());
//    				} catch (LineUnavailableException e1) {
//    					
//    					System.out.println(e1.getMessage());
//    				}
//
//    				}	
    			 }
    				
    	else if(selectedaudio.equals("Punch")) {
    			String a2 = (String) audios.getSelectedItem();
    			if(a2.equals(audio2)) {
    						
    						
    					    String gongFile = "Punch_HD-Mark_DiAngelo-1718986183.wav";
    					   try {
    						AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(gongFile).getAbsoluteFile());
    						Clip clip = AudioSystem.getClip();
    						clip.open(audioInputStream);
    						clip.start();
    					} catch (UnsupportedAudioFileException e1) {
    						
    						System.out.println(e1.getMessage());
    					} catch (IOException e1) {
    						
    						System.out.println(e1.getMessage());
    					} catch (LineUnavailableException e1) {
    						
    						System.out.println(e1.getMessage());
    					}

    					}
    				}
    		
    	else if(selectedaudio.equals("Bomb")) {
    			String a3 = (String) audios.getSelectedItem();
    			if(a3.equals(audio3)) {
    							
    							
    							String gongFile = "Bomb-SoundBible.com-891110113.wav";
    						   try {
    							AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(gongFile).getAbsoluteFile());
    							Clip clip = AudioSystem.getClip();
    							clip.open(audioInputStream);
    							clip.start();
    						} catch (UnsupportedAudioFileException e1) {
    							
    							System.out.println(e1.getMessage());
    						} catch (IOException e1) {
    							
    							System.out.println(e1.getMessage());
    						} catch (LineUnavailableException e1) {
    							
    							System.out.println(e1.getMessage());
    						}

    						}	
    				 }
    			 }
    				
    	if (e.getSource() == theme) {
    		 if(selectedtheme.equals("Light")) {
    			String t1 = (String) theme.getSelectedItem();
    						if(t1.equals(theme1)) {
    						
    						 this.setBackground(Color.LIGHT_GRAY);
    						 gamePlay.setBackground(Color.YELLOW);
    						}	
    				 }
    			 
    			 
    		 else if(selectedtheme.equals("White")) {
    				 String t1 = (String) theme.getSelectedItem();
    						if(t1.equals(theme2)) {
    						 
    						 this.setBackground(Color.LIGHT_GRAY);
    						 gamePlay.setBackground(Color.WHITE);
    						}	
    				 }
    			 
    			 
    		else if(selectedtheme.equals("Dark")) {
    				 String t1 = (String) theme.getSelectedItem();
    						if(t1.equals(theme3)) {
    						 
    						 this.setBackground(Color.LIGHT_GRAY);
    						 gamePlay.setBackground(Color.BLACK);
    						}	
    				 }
    			 }
    		        
      if (e.getSource() == background) {
    	  if(selectedbg.equals("Scenery")) {
    		  String b1= (String) background.getSelectedItem();
    		  if(b1.equals(img1)) {
    			  java.awt.Image img;
    			  img = Toolkit.getDefaultToolkit().getImage("a.jpg");
    			  Graphics g=null;
    			 
    			 
    			  
    		  }
    	  }
    	  
      }
       
        
      if(selectedcomponent.equals("Circle")) {
        	
        	
        	colorCombo1.setVisible(true);
        	colorCombo1.setEnabled(true);
        	
    		if (e.getSource() == colorCombo1) {
    			circleColour = (String) colorCombo1.getSelectedItem();
    			if(circleColour.equals(red)) {
    				
    				this.circleColor =Color.red;
    			}
    			
    			else if(circleColour.equals(blue)) {
    				this.circleColor =Color.blue;
    				
    			}
    			else if(circleColour.equals(green)) {
    				this.circleColor =Color.green;
    				
    			}
    			System.out.println(this.circleColor);
    			sizeCombo1.setEnabled(true);
        		sizeCombo1.setVisible(true);
    			
    		}
    		
    		if (e.getSource() == sizeCombo1 ) {
    			circleSize = (String) sizeCombo1.getSelectedItem();
    			if(circleSize.equals(small)){
    				circleWidth = 20;
    				circleHeight = 20;
    			}
    			if(circleSize.equals(medium)){
    				circleWidth = 40;
    				circleHeight = 40;
    			}
    			if(circleSize.equals(large)){
    				circleWidth = 60;
    				circleHeight = 60;
    			}
    			
        		chooseMovements1.setEnabled(true);
        		chooseMovements1.setVisible(true);
    			
    			
    		}
    		
    		if(e.getSource() == chooseMovements1) {
    			circlemove = (String) chooseMovements1.getSelectedItem();
    			
    			if(circlemove.equals(automatic))
    			{
    				circlemovement = new AutomaticMovement();
    			}
    			
    			else if(circlemove.equals(keyboard))
    			{
    				circlemovement = new ManualMovement();
    				
    			}
    			else if(circlemove.equals(staticMove))
    			{
    				circlemovement = new StaticMovement();
    			}
    			addcomponent.setEnabled(true);
    			
    			
    		}
    		
    		    		
    		if(command.equals("Add"))
    		{

    			circleComp = new Circle(this.circleColor, 30, 10, circleWidth, circleHeight);
    			
    			
    			
    			gameManager.register(circleComp, null, circlemovement);
    			circleComp.pause();
    			addedComponents.add("Circle"+no_circles);
    			no_circles+=1;
    			
    			
    			if (addedComponents.size() > 1) {
    				collisionOf.setModel(new DefaultComboBoxModel(addedComponents.toArray()));
    				collisionWith.setModel(new DefaultComboBoxModel(addedComponents.toArray()));
    				collisionOf.setEnabled(true);
    				
    			}
    			
    			if(circlemovement instanceof ManualMovement)
    			{
    		    gamePlay.addKeyListener((KeyListener)circlemovement);
    			}
    			
    		  	playButton.setEnabled(true);		
    			//gamePlay.repaint();
    			newButton.setEnabled(true);
    			
    			//playButton.setEnabled(true);
//    			componentCombo1.setSelectedIndex(-1);
//    	    	colorCombo1.setSelectedIndex(-1);
//    	    	sizeCombo1.setSelectedIndex(-1);
//    	    	chooseMovements1.setSelectedIndex(-1);
//    	    	
//    	    	componentCombo1.setEnabled(true);
//    	    	colorCombo1.setEnabled(false);
//    	    	sizeCombo1.setEnabled(false);
//    	    	chooseMovements1.setEnabled(false);
    	    	
    	    	
    			
    		}
    		if(command.equals("New"))
    		{
    			componentCombo1.setEnabled(true);
    			colorCombo1.setEnabled(false);
    			sizeCombo1.setEnabled(false);
    			chooseMovements1.setEnabled(false);
    			addcomponent.setEnabled(false);
    			
    		}
    		
    		
	
    		
        }
        else if (selectedcomponent.equals("Rectangle"))
        {
        	
        	
        	if(!popup.isVisible() && e.getSource().equals(componentCombo1))
        	{
        		popup.setVisible(true);
        		
        	}
        	
        	if(e.getActionCommand().contentEquals(vertical))
        	{
        		
        		rectanglealign = vertical;
        		
        		if(popup.isVisible())
        		{
        			popup.setVisible(false);
        		}
        		colorCombo1.setEnabled(true);
        	}
        	if(e.getActionCommand().contentEquals(horizontal))
        	{
        		rectanglealign = horizontal;
        		if(popup.isVisible())
        		{
        			popup.setVisible(false);
        		}
        		colorCombo1.setEnabled(true);
        		
        	}
        	//System.out.println("In Vertical Rectangle Align "+ rectanglealign);
        	//sizeCombo1.setVisible(true);
        	
        	
            //colorCombo1.setEnabled(true);
    		
    		if (e.getSource() == colorCombo1 ) {
    			rectangleColour = (String) colorCombo1.getSelectedItem();
    			if(rectangleColour.equals(red)) {
    				this.rectangleColor =Color.red;
    				
    			}
    			else if(rectangleColour.equals(blue)) {
    				this.rectangleColor =Color.blue;
    				
    			}
    			else if(rectangleColour.equals(green)) {
    				this.rectangleColor =Color.green;
    				
    			}
    			//System.out.println("Rect color: "+this.rectangleColor);
    			sizeCombo1.setEnabled(true);
        		sizeCombo1.setVisible(true);
    			
    		}
    		if (e.getSource() == sizeCombo1 ) {
    			rectangleSize = (String) sizeCombo1.getSelectedItem();
    			if(rectangleSize.equals(small)){
    				if(rectanglealign.equals(horizontal)) {
    				rectangleWidth = 100;
    				rectangleHeight = 10;
    				}
    				if(rectanglealign.equals(vertical)) {
        				rectangleWidth = 10;
        				rectangleHeight = 100;
        				}
    			}
    			if(rectangleSize.equals(medium)){
    				if(rectanglealign.equals(horizontal)) {
        				rectangleWidth = 180;
        				rectangleHeight = 10;
        				}
    				if(rectanglealign.equals(vertical)) {
        				rectangleWidth = 10;
        				rectangleHeight = 180;
        				}
    			}
    			if(rectangleSize.equals(large)){
    				if(rectanglealign.equals(horizontal)) {
        				rectangleWidth = 250;
        				rectangleHeight = 10;
        				}
    				if(rectanglealign.equals(vertical)) {
        				rectangleWidth = 10;
        				rectangleHeight = 250;
        				}
    			}
    			chooseMovements1.setEnabled(true);
        		chooseMovements1.setVisible(true);
    		
    		}
    		if(e.getSource() == chooseMovements1) {
    			rectanglemove = (String) chooseMovements1.getSelectedItem();
    			
    			if(rectanglemove.equals(automatic))
    			{
    				rectanglemovement = new AutomaticMovement();
    			}
    			if(rectanglemove.equals(keyboard))
    			{
    				rectanglemovement = new ManualMovement();
    				
    			}
    			if(rectanglemove.equals(staticMove))
    			{
    				rectanglemovement = new StaticMovement();
    			}
    			addcomponent.setEnabled(true);
    			addcomponent.setEnabled(true);
    		}
       		
    		if(command.equals("Add"))
    		{
    			rectangleComp = new Rectangle(this.rectangleColor, 180, 280, rectangleWidth, rectangleHeight); 
    			gameManager.register(rectangleComp,null, rectanglemovement);
    			rectangleComp.pause();
    			addedComponents.add("Rectangle "+no_rectangles);
    			no_rectangles+=1;
    			//if (gameManager.getComponentsList().size() > 1) 
    			if (addedComponents.size() > 1) {
    				collisionOf.setModel(new DefaultComboBoxModel(addedComponents.toArray()));
    				collisionWith.setModel(new DefaultComboBoxModel(addedComponents.toArray()));
    				collisionOf.setEnabled(true);
    				
    			}
    			
    			//gameManager.register(rectangleComp, new BounceBack(), rectanglemovement);
    			//rectangleComp.pause();
    			//collisionOf.addItem("Rectangle");
    			//collisionWith.setEnabled(false);
    			if(rectanglemovement instanceof ManualMovement)
    			{
    		    gamePlay.addKeyListener((KeyListener)rectanglemovement);
    			}
    		    //gamePlay.setFocusable(true);
    		    //gamePlay.addKeyListener((KeyListener)rectanglemanualMovement);
    		    newButton.setEnabled(true);
    		    playButton.setEnabled(true);
	
    			gamePlay.repaint();
    			
    			
    		}
    		if(command.equals("New"))
    		{
    			componentCombo1.setEnabled(true);
    			colorCombo1.setEnabled(false);
    			sizeCombo1.setEnabled(false);
    			chooseMovements1.setEnabled(false);
    			addcomponent.setEnabled(false);
    			
    		}
    		
        }
        else if (selectedcomponent.equals("Square"))
        {
        	
        	colorCombo1.setVisible(true);
        	sizeCombo1.setVisible(true);
        	
        	
            colorCombo1.setEnabled(true);
    		
    		if (e.getSource() == colorCombo1 ) {
    			squareColour = (String) colorCombo1.getSelectedItem();
    			if(squareColour.equals(red)) {
    				this.squareColor =Color.red;
    				
    			}
    			else if(squareColour.equals(blue)) {
    				this.squareColor =Color.blue;
    				
    			}
    			else if(squareColour.equals(green)) {
    				this.squareColor =Color.green;
    				
    			}
    			System.out.println("Square color: "+this.squareColor);
    			sizeCombo1.setEnabled(true);
        		sizeCombo1.setVisible(true);
    			
    		}
    		if (e.getSource() == sizeCombo1 ) {
    			squareSize = (String) sizeCombo1.getSelectedItem();
    			if(squareSize.equals(small)){
    				squareWidth = 20;
    				squareHeight = 20;
    			}
    			if(squareSize.equals(medium)){
    				squareWidth = 40;
    				squareHeight = 40;
    			}
    			if(squareSize.equals(large)){
    				squareWidth = 60;
    				squareHeight = 60;
    			}
    			chooseMovements1.setEnabled(true);
        		chooseMovements1.setVisible(true);
    			System.out.println("Square size: "+squareWidth+squareHeight);
    		}
    		if(e.getSource() == chooseMovements1) {
    			squaremove = (String) chooseMovements1.getSelectedItem();
    			
    			if(squaremove.equals(automatic))
    			{
    				squaremovement = new AutomaticMovement();
    			}
    			if(squaremove.equals(keyboard))
    			{
    				squaremovement = new ManualMovement();
    				
    			}
    			if(squaremove.equals(staticMove))
    			{
    				squaremovement = new StaticMovement();
    			}
    			addcomponent.setEnabled(true);
    		}
    		
    		if(command.equals("Add"))
    		{
    			
    			
    			squareComp = new Square(180, 280, this.squareColor, squareWidth, squareHeight);
    			gameManager.register(squareComp,null, squaremovement);
    			squareComp.pause();
    			addedComponents.add("Square"+no_squares);
    			no_squares+=1;

    			
    			//if (gameManager.getComponentsList().size() > 1)
    			if (addedComponents.size() > 1) {
    				collisionOf.setModel(new DefaultComboBoxModel(addedComponents.toArray()));
    				collisionWith.setModel(new DefaultComboBoxModel(addedComponents.toArray()));
    				collisionOf.setEnabled(true);
    				
    			}
    			
    			
    			//gameManager.register(squareComp, new Explode(), squaremovement);
    			//squareComp.pause();
    			//collisionOf.addItem("Square");
    			//collisionWith.setEnabled(false);
    			System.out.println("Square comp:"+gameManager.getComponentsList().toString());
    			if(squaremovement instanceof ManualMovement)
    			{
    		    gamePlay.addKeyListener((KeyListener)squaremovement);
    			}
    			newButton.setEnabled(true);
    			playButton.setEnabled(true);
    			gamePlay.repaint();
    			
    		}
    		
    		if(command.equals("New"))
    		{
    			componentCombo1.setEnabled(true);
    			colorCombo1.setEnabled(false);
    			sizeCombo1.setEnabled(false);
    			chooseMovements1.setEnabled(false);
    			addcomponent.setEnabled(false);
    			
    		}
    		
    
        }
        
        
       if(command.equals("Play")) {
        	
        	this.setFocusable(false);
    		for(int i=0; i< (gameManager.getComponentsList().size()); i++) {
  
    			if(gameManager.getComponentsList().get(i) instanceof Circle) {
    				circleComp.pause();
    				}
    			else if(gameManager.getComponentsList().get(i) instanceof Rectangle) {
    				//rectangleComp.pause();
    				}
    			else if(gameManager.getComponentsList().get(i) instanceof Square) {
    				squareComp.pause();
    				}
    			}
    	
    	gamePlay.setFocusable(true);
    	gamePlay.repaint();
    	
        	
        }
        if (e.getSource().equals(collisionOf)) {
        	selectedcollisionOf= (String)collisionOf.getSelectedItem();
        	collisionWith.removeItem(selectedcollisionOf);
        	for (int i=0;i<addedComponents.size();i++) {
        		if (!addedComponents.get(i).equals(selectedcollisionOf) && ((DefaultComboBoxModel)collisionWith.getModel()).getIndexOf(addedComponents.get(i))==-1) {
        			collisionWith.addItem(addedComponents.get(i));
        		}
        	}
        
        	
        	collisionWith.setEnabled(true);
        }
        if (e.getSource()==collisionWith) {
        	selectedCollisionWith= (String)collisionWith.getSelectedItem();
        	reactions.setEnabled(true);
        	
        }
        if (e.getSource().equals(reactions))
        { 
        	selectedReaction= (String)reactions.getSelectedItem();
        	
        	if (selectedReaction.equals("Bounce Back")) {
        	if(selectedCollisionWith.contains("Circle")&& selectedcollisionOf.contains("Rectangle")) {
        		//System.out.println(rectangleComp);
        		System.out.println("In First");
        		circleComp.setReaction(new BounceBack());
        	}
        	else if (selectedCollisionWith.equals("Square")&& selectedcollisionOf.equals("Circle")) {
        		squareComp.setReaction(new BounceBack()) ;
        	}
        	else if (selectedCollisionWith.equals("Rectangle")&& selectedcollisionOf.equals("Square") ) {
        		rectangleComp.setReaction(new BounceBack()) ;
        	}
        	else if(selectedCollisionWith.contains("Rectangle") && selectedcollisionOf.contains("Circle")) {
        	
        		System.out.println("In Condition *****"+rectangleComp);
        		rectangleComp.setReaction(new BounceBack());
        	}
        	else if(selectedCollisionWith.equals("Circle")&& selectedcollisionOf.equals("Square")) {
        		//System.out.println(rectangleComp);
        		circleComp.setReaction(new BounceBack());
        	}
        	else if (selectedCollisionWith.equals("Square")&& selectedcollisionOf.equals("Rectangle")) {
        		squareComp.setReaction(new BounceBack()) ;
        	}
        	
        
        }
        if(selectedReaction.equals("Explode")) {
        		if(selectedCollisionWith.equals("Circle")&& selectedcollisionOf.equals("Rectangle")) {
            		//System.out.println(rectangleComp);
            		rectangleComp.setReaction(new BounceBack());
            	}
            	else if (selectedCollisionWith.equals("Square")&& selectedcollisionOf.equals("Circle")) {
            		circleComp.setReaction(new Explode()) ;
            	}
            	else if (selectedCollisionWith.equals("Rectangle")&& selectedcollisionOf.equals("Square") ) {
            		squareComp.setReaction(new Explode()) ;
            	}
            	else if(selectedCollisionWith.contains("Circle")&& selectedcollisionOf.contains("Rectangle")) {
            		//System.out.println(rectangleComp);
            		int i =0;
            		List<Component> componentsList = gameManager.getComponentsList();
            		
    				while (i < componentsList.size() && componentsList.get(i).getReaction() == null) {
    					
    					if(componentsList.get(i) instanceof Rectangle)
    					{
            		componentsList.get(i).setReaction(new Explode());
    					}
    					i++;
    				}
            	}
            	else if(selectedCollisionWith.contains("Circle")&& selectedcollisionOf.contains("Square")) {
            		
            		//System.out.println(rectangleComp);
            		int i =0;
            		List<Component> componentsList = gameManager.getComponentsList();
            		
    				while (i < componentsList.size() && componentsList.get(i).getReaction() == null) {
    					
    					System.out.println("In WHile");
    					if(componentsList.get(i) instanceof Square)
    					{
            		componentsList.get(i).setReaction(new Explode());
    					}
    					i++;
    				}
            	}
            	else if(selectedCollisionWith.contains("Circle")&& selectedcollisionOf.contains("Circle")) {
            		
            		//System.out.println(rectangleComp);
            		int i =0;
            		List<Component> componentsList = gameManager.getComponentsList();
            		
    				while (i < componentsList.size() && componentsList.get(i).getReaction() == null) {
    					
    					System.out.println("In WHile");
    					if(componentsList.get(i) instanceof Circle)
    					{
            		componentsList.get(i).setReaction(new Explode());
    					}
    					i++;
    				}
            	}
            	else if (selectedCollisionWith.equals("Square")&& selectedcollisionOf.equals("Rectangle")) {
            		rectangleComp.setReaction(new Explode()) ;
            	}
        	}
        	
        }
//        if (e.getSource().equals(reactions))
//        {
//        if (explode.isSelected()) {
//        	if(selectedCollisionWith.equals("Circle")&& selectedcollisionOf.equals("Rectangle")) {
//        		//System.out.println(rectangleComp);
//        		rectangleComp.setReaction(new BounceBack());
//        	}
//        	else if (selectedCollisionWith.equals("Square")&& selectedcollisionOf.equals("Circle")) {
//        		circleComp.setReaction(new Explode()) ;
//        	}
//        	else if (selectedCollisionWith.equals("Rectangle")&& selectedcollisionOf.equals("Square") ) {
//        		squareComp.setReaction(new Explode()) ;
//        	}
//        	else if(selectedCollisionWith.equals("Rectangle")&& selectedcollisionOf.equals("Circle")) {
//        		//System.out.println(rectangleComp);
//        		rectangleComp.setReaction(new Explode());
//        	}
//        	else if(selectedCollisionWith.contains("Circle")&& selectedcollisionOf.contains("Square")) {
//        		//System.out.println(rectangleComp);
//        		squareComp.setReaction(new Explode());
//        	}
//        	else if (selectedCollisionWith.equals("Square")&& selectedcollisionOf.equals("Rectangle")) {
//        		rectangleComp.setReaction(new Explode()) ;
//        	}
//        	else if (selectedCollisionWith.equals("Rectangle")&& selectedcollisionOf.equals("Circle")) {
//        		circleComp.setReaction(new Explode()) ;
//        	}
//       	
//        }
       }
        
        
        
	
	public JComboBox getAudios() {
		return audios;
	}


	public void setAudios(JComboBox audios) {
		this.audios = audios;
	}


	public List<String> getAddedComponents() {
		return addedComponents;
	}


	public void setAddedComponents(List<String> addedComponents) {
		this.addedComponents = addedComponents;
	}


	public void controllerSetup(ButtonContainer buttonContainer, ControllerLayout layout) {
		System.out.println(layout);
		buttonContainer.addButton("Pause/ Resume", new PauseCommand(gameManager),layout);
		buttonContainer.addButton("Replay", new ReplayCommand(((GameManager) gameManager).getComponentsList()), layout);
		buttonContainer.addButton("Save", new SaveCommand(gameManager, this), layout);
		buttonContainer.addButton("Load", new LoadCommand(gameManager,gamePlay, this), layout);
		buttonContainer.addButton("Undo", new UndoCommand(((GameManager) gameManager).getComponentsList()), layout);
		
	}
	
	public String[] getAudiofile() {
		return audiofile;
	}


	public void setAudiofile(String[] audiofile) {
		this.audiofile = audiofile;
	}


	public JComboBox getCollisionOf() {
		return collisionOf;
	}
	
	
	public void setCollisionOf(List<String> addedComp) {
		collisionOf.setModel(new DefaultComboBoxModel(addedComponents.toArray()));
	}


	public JComboBox getCollisionWith() {
		return collisionWith;
	}


	public void setCollisionWith(List<String> addedComp) {
		collisionWith.setModel(new DefaultComboBoxModel(addedComponents.toArray()));

	}


	public JButton getAddcomponent() {
		return addcomponent;
	}


	public void setAddcomponent(JButton addcomponent) {
		this.addcomponent = addcomponent;
	}


	public void chooseComponents() {
				
		this.setLayout(null);
		componentCombo1 = new JComboBox(componentsList.toArray());		
        colorCombo1 = new JComboBox(color);		
    	sizeCombo1 = new JComboBox(size);
    	reactions = new JComboBox(reaction);
    	//collisionOf = new JComboBox();
    	//collisionWith = new JComboBox(componentsList.toArray());
    	audios = new JComboBox(audiofile);
    	theme = new JComboBox(themecolor);
    	sound = new JLabel("Choose sounds:");
    	themechoose = new JLabel("Choose theme:");
    	bgimage = new JLabel("Choose background");
    	collisionOf = new JComboBox();
    	collisionWith = new JComboBox();
    	object = new JLabel("Choose Object");
    	colour = new JLabel("Choose Color");
    	sizes = new JLabel("Choose Size");
    	movement = new JLabel("Choose Movement");
    	collision1 = new JLabel("Collision Of:");
    	collision2 = new JLabel("Collision With:");
    	saveButton = new JButton("Save");
    	loadButton = new JButton("Load");
    	playButton = new JButton("Play");
    	newButton = new JButton("New");
    	
    	colorCombo1.setEnabled(false);
    	sizeCombo1.setEnabled(false);
    	newButton.setEnabled(false);
    	collisionOf.setEnabled(false);
    	collisionWith.setEnabled(false);
    	audios.setEnabled(true);
    	theme.setEnabled(true);
    	reactions.setEnabled(false);
    	
    
		
    	
    	chooseMovements1 = new JComboBox(movements);
		
    	chooseMovements1.setEnabled(false);
    	
    	addcomponent = new JButton("Add");
    	addcomponent.setVisible(true);
    	reactions.setVisible(true);
    	
    	
    	
    	//bounceBack.setActionCommand("Bounce Back");
    	//explode.setActionCommand("Explode");
    	
//    	ButtonGroup bg = new ButtonGroup();
//    	bg.add(bounceBack);
//    	bg.add(explode);
    	
    	
		componentCombo1.setSelectedIndex(-1);
    	colorCombo1.setSelectedIndex(-1);
    	sizeCombo1.setSelectedIndex(-1);
    	chooseMovements1.setSelectedIndex(-1);
    	collisionOf.setSelectedIndex(-1);
    	reactions.setSelectedIndex(-1);
    	
    	
    	
    	this.add(componentCombo1);
    	this.add(colorCombo1);
    	this.add(sizeCombo1);
    	this.add(collisionOf);
    	this.add(collisionWith);
    	this.add(audios);
    	this.add(theme);
    	this.add(sound);
    	this.add(themechoose);
//    	this.add(bounceBack);
//    	this.add(explode);
    	this.add(object);
    	this.add(colour);
    	this.add(sizes);
    	this.add(movement);
    	this.add(collision1);
    	this.add(collision2);
    	this.add(newButton);
    	this.add(saveButton);
    	this.add(loadButton);
    	this.add(playButton);
    	this.add(popup);
    	this.add(chooseMovements1);
    	this.add(addcomponent);
    	this.add(buttonContainer);
    	this.add(reactions);
    	
    	popup.add(vertical);
    	popup.add(horizontal);
    	
	
    	
    	componentCombo1.setBounds(10, 40, 120, 50);    	
    	colorCombo1.setBounds(130, 40, 100, 50);
    	sizeCombo1.setBounds(230, 40, 100, 50);
    	chooseMovements1.setBounds(330,40,130,50);
    	collisionOf.setBounds(10,150,100,50);
    	collisionWith.setBounds(150,150,100,50);
    	audios.setBounds(10, 300, 100, 50);
    	theme.setBounds(150, 300, 100, 50);
    	reactions.setBounds(300,150,120,50);
//    	bounceBack.setBounds(300, 150, 120, 50);
//    	explode.setBounds(430, 150, 90, 50);
    	
    	object.setBounds(10, 0, 100, 50);
    	colour.setBounds(130, 0, 100, 50);
    	sizes.setBounds(230, 0, 100, 50);
    	movement.setBounds(330, 0, 130, 50);
    	collision1.setBounds(10,110,100,50);
    	collision2.setBounds(150,110,100,50);
    	sound.setBounds(10, 260, 100, 50);
    	themechoose.setBounds(150, 260, 100, 50);
    	addcomponent.setBounds(460, 40, 70, 50);
    	newButton.setBounds(530,40,80,50);
    	
    	buttonContainer.setBounds(0, 560, 500, 100);
    	
    	popup.setLocation(15,120);
    	
    	
    	
    	
    	
    	newButton.setEnabled(false);
    	playButton.setEnabled(false);
    	popup.setVisible(false);
    	
		
    	
    	
    	addcomponent.setEnabled(false);
    	
    	newButton.setEnabled(false);
    	playButton.setEnabled(false);
    	
    	
   


		
        
    	componentCombo1.addActionListener(this);
    	colorCombo1.addActionListener(this);
    	sizeCombo1.addActionListener(this);
    	chooseMovements1.addActionListener(this);
    	addcomponent.addActionListener(this);
    	playButton.addActionListener(this);
    	 collisionOf.addActionListener(this);
    	 collisionWith.addActionListener(this);
//    	 bounceBack.addActionListener(this);
//    	 explode.addActionListener(this);
    	newButton.addActionListener(this);
    	 saveButton.addActionListener(this);
    	 loadButton.addActionListener(this);
    	 vertical.addActionListener(this);
    	 horizontal.addActionListener(this);
    	 audios.addActionListener(this);
      	theme.addActionListener(this);
//      	bounceBack.addActionListener(this);
//      	explode.addActionListener(this);
      	reactions.addActionListener(this);
    	 
    	
    	
    	componentCombo1.setFocusable(false);
    	colorCombo1.setFocusable(false);
    	sizeCombo1.setFocusable(false);
    	chooseMovements1.setFocusable(false);
    	addcomponent.setFocusable(false);
    	playButton.setFocusable(false);
    	collisionOf.setFocusable(false);
    	collisionWith.setFocusable(false);
//    	bounceBack.setFocusable(false);
//    	explode.setFocusable(false);
    	saveButton.setFocusable(false);
    	loadButton.setFocusable(false);
    	newButton.setFocusable(false);
    	audios.setFocusable(false);
    	theme.setFocusable(false);
    	reactions.setFocusable(false);
    	
    	collisionWith.setEnabled(false);
		
    	
	}


	
	
	


}
