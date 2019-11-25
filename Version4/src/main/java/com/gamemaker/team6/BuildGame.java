package com.gamemaker.team6;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import com.gamemaker.team6.behaviour.ClimbReaction;
import com.gamemaker.team6.behaviour.ManualMovement;
import com.gamemaker.team6.manager.GameManager;
import com.gamemaker.team6.model.BackgroundColor;
import com.gamemaker.team6.model.Component;


public class BuildGame extends JPanel implements ActionListener {

    
	private static final long serialVersionUID = 1L;
	private final static Logger logger = Logger.getLogger(BuildGame.class);
  
    private GameManager gameManager;
    private JLabel circleLabel;
    private JLabel rectangleLabel;
    private JLabel shipLabel;
    private JLabel invaderLabel;
    private JLabel invader2Label;
    private JLabel mushroomLabel;
    private JLabel ghostRedLabel;
    private JLabel ghostBlueLabel;
    private JLabel monkeyLabel;
    private JLabel pacmanLabel;
    private JLabel foodLabel;
    private JLabel ladderLabel;
    private JLabel marioLabel;

    public static final String HEIGHT = "Height";
    public static final String REACTION = "Reaction";
    public static final String WIDTH = "Width";
    public static final String SOUND = "Sound";
    public static final String SPEED = "Speed";
    public static final String INITIALX = "Initial X";
    public static final String INITIALY = "Initial Y";
    public static final String COLOR = "Color";
    public static final String RED = "Red";
    public static final String BLACK = "Black";
    public static final String GRAY = "Grey";
    
    private Game game;
	private JButton save;
	private JButton load;
	private JButton startGame;
	private JButton stop;
	private JButton bgColorButton;
	private Color bgColor = Color.WHITE;
	private BackgroundColor bgColorComponent = new BackgroundColor(Color.WHITE);
	
    public BuildGame(GameManager gameManagerMain, Game gamePanel) {
    	this.setLayout(null);
    	this.setBounds(0, 0, 500, 700);
    	save= new JButton("Save");
    	save.setBounds(10, 410, 77, 25);
    	load = new JButton("Load");
    	load.setBounds(90, 410, 77, 25);
		startGame=new JButton("Start/Stop Game");
		stop= new JButton("Stop");
		save.setFocusable(false);
		save.addActionListener(this);
		load.setFocusable(false);
		stop.setFocusable(false);
		stop.addActionListener(this);
		this.add(save);
		load.addActionListener(this);
		this.add(load);
		startGame.setFocusable(false);
		startGame.addActionListener(this);
		this.add(startGame);

        this.gameManager = gameManagerMain;
        Icon circleIcon = new ImageIcon(new ImageIcon("icons/circle.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        this.circleLabel = new JLabel(circleIcon);
        circleLabel.setBounds(20, 30, 40, 40);
        circleLabel.setToolTipText("Add a Circle");
        
        Icon rectangleIcon = new ImageIcon(new ImageIcon("icons/rectangle.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        this.rectangleLabel = new JLabel(rectangleIcon);
        rectangleLabel.setBounds(80, 20, 60, 60);
        rectangleLabel.setToolTipText("Add a Rectangle");
        
        Icon mushroomIcon = new ImageIcon(new ImageIcon("icons/mushroom.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        this.mushroomLabel = new JLabel(mushroomIcon);
        mushroomLabel.setBounds(160, 20, 60, 60);
        mushroomLabel.setToolTipText("Add Mushroom");
        
        Icon shipIcon = new ImageIcon(new ImageIcon("icons/spaceship.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        this.shipLabel = new JLabel(shipIcon);
        shipLabel.setBounds(240, 20, 60, 60);
        shipLabel.setToolTipText("Add a Spaceship");
        
        Icon invaderIcon = new ImageIcon(new ImageIcon("icons/invader.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        this.invaderLabel = new JLabel(invaderIcon);
        invaderLabel.setBounds(320, 20, 60, 60);
        invaderLabel.setToolTipText("Add Invader");
        
        Icon invader2Icon = new ImageIcon(new ImageIcon("icons/invader2.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        this.invader2Label = new JLabel(invader2Icon);
        invader2Label.setBounds(400, 20, 60, 60);
        invader2Label.setToolTipText("Add Invader 2");
        
        Icon ghostRedIcon = new ImageIcon(new ImageIcon("icons/ghost.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        this.ghostRedLabel = new JLabel(ghostRedIcon);
        ghostRedLabel.setBounds(20, 80, 60, 60);
        ghostRedLabel.setToolTipText("Add Red Ghost");
        
        Icon monkeyIcon = new ImageIcon(new ImageIcon("icons/monkey.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        this.monkeyLabel = new JLabel(monkeyIcon);
        monkeyLabel.setBounds(140, 80, 60, 60);
        monkeyLabel.setToolTipText("Add Monkey");
        
        Icon pacmanIcon = new ImageIcon(new ImageIcon("icons/pacman.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        this.pacmanLabel = new JLabel(pacmanIcon);
        pacmanLabel.setBounds(80, 80, 60, 60);
        pacmanLabel.setToolTipText("Add Pacman");
        
        Icon foodIcon = new ImageIcon(new ImageIcon("icons/food.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        this.foodLabel = new JLabel(foodIcon);
        foodLabel.setBounds(200, 80, 60, 60);
        foodLabel.setToolTipText("Add Food");
        
        Icon ladderIcon = new ImageIcon(new ImageIcon("icons/ladder.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        this.ladderLabel = new JLabel(ladderIcon);
        ladderLabel.setBounds(260, 80, 60, 60);
        ladderLabel.setToolTipText("Add Ladder");
        
        Icon marioIcon = new ImageIcon(new ImageIcon("icons/mario.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        this.marioLabel = new JLabel(marioIcon);
        marioLabel.setBounds(340, 80, 60, 60);
        marioLabel.setToolTipText("Add Mario");
        
        Icon ghostBlueIcon = new ImageIcon(new ImageIcon("icons/ghost2.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        this.ghostBlueLabel = new JLabel(ghostBlueIcon);
        ghostBlueLabel.setBounds(20, 150, 60, 60);
        ghostBlueLabel.setToolTipText("Add Ghost");
        
        this.bgColorButton = new JButton("Background color");
		bgColorButton.setBounds(20, 240, 150, 25);
		bgColorButton.setFocusable(false);

        this.add(circleLabel);
        this.add(rectangleLabel);
        this.add(shipLabel);
        this.add(invaderLabel);
        this.add(invader2Label);
        this.add(mushroomLabel);
        this.add(ghostRedLabel);
        this.add(ghostBlueLabel);
        this.add(monkeyLabel);
        this.add(pacmanLabel);
        this.add(foodLabel);
        this.add(ladderLabel);
        this.add(marioLabel);
		this.add(bgColorButton);
        this.game=gamePanel;
    }
    
    
    public void makeGame() {
    	 
    	 this.shipLabel.addMouseListener(new MouseAdapter() {
    		 @Override
    		 public void mouseClicked(MouseEvent e) {    			 
					JFrame frame = new JFrame();
					frame.setBounds(100,100,400,400);
					JPanel componentProperties = new ComponentProperties(game, gameManager, "ship",frame);
					frame.add(componentProperties);
					frame.setVisible(true);
    		 }
    	 });
    	 
    	 this.invaderLabel.addMouseListener(new MouseAdapter() {
    		 @Override
    		 public void mouseClicked(MouseEvent e) {	 
					JFrame frame = new JFrame();
					frame.setBounds(100,100,400,400);
					JPanel componentProperties = new ComponentProperties(game, gameManager, "invader",frame);
					frame.add(componentProperties);
					frame.setVisible(true);
    		 }
		});
    	 
    	 this.mushroomLabel.addMouseListener(new MouseAdapter() {
    		 @Override
    		 public void mouseClicked(MouseEvent e) {
					JFrame frame = new JFrame();
					frame.setBounds(100,100,400,400);
					JPanel componentProperties = new ComponentProperties(game, gameManager, "mushroom",frame);
					frame.add(componentProperties);
					frame.setVisible(true);
    		 }
    	 });
    	 
    	 this.ghostRedLabel.addMouseListener(new MouseAdapter() {
    		 @Override
    		 public void mouseClicked(MouseEvent e) {
					JFrame frame = new JFrame();
					frame.setBounds(100,100,400,400);
					JPanel componentProperties = new ComponentProperties(game, gameManager, "ghostred",frame);
					frame.add(componentProperties);
					frame.setVisible(true);
    		 }
    	 });
    	 
    	 this.ghostBlueLabel.addMouseListener(new MouseAdapter() {
    		 @Override
    		 public void mouseClicked(MouseEvent e) {
					JFrame frame = new JFrame();
					frame.setBounds(100,100,400,400);
					JPanel componentProperties = new ComponentProperties(game, gameManager, "ghostblue",frame);
					frame.add(componentProperties);
					frame.setVisible(true);
    		 }
    	 });
    	 
    	 this.invader2Label.addMouseListener(new MouseAdapter() {
    		 @Override
    		 public void mouseClicked(MouseEvent e) {
					JFrame frame = new JFrame();
					frame.setBounds(100,100,400,400);
					JPanel componentProperties = new ComponentProperties(game, gameManager, "invader2",frame);
					frame.add(componentProperties);
					frame.setVisible(true);
    		 }
    	 });
    	 
    	 this.monkeyLabel.addMouseListener(new MouseAdapter() {
    		 @Override
    		 public void mouseClicked(MouseEvent e) {
					JFrame frame = new JFrame();
					frame.setBounds(100,100,400,400);
					JPanel componentProperties = new ComponentProperties(game, gameManager, "monkey",frame);
					frame.add(componentProperties);
					frame.setVisible(true);
    		 }
    	 });
    	 
    	 this.pacmanLabel.addMouseListener(new MouseAdapter() {
    		 @Override
    		 public void mouseClicked(MouseEvent e) {
					JFrame frame = new JFrame();
					frame.setBounds(100,100,400,400);
					JPanel componentProperties = new ComponentProperties(game, gameManager, "pacman",frame);
					frame.add(componentProperties);
					frame.setVisible(true);
    		 }
    	 });
    	 
    	 this.foodLabel.addMouseListener(new MouseAdapter() {
    		 @Override
    		 public void mouseClicked(MouseEvent e) {
					JFrame frame = new JFrame();
					frame.setBounds(100,100,400,400);
					JPanel componentProperties = new ComponentProperties(game, gameManager, "food",frame);
					frame.add(componentProperties);
					frame.setVisible(true);
    		 }
    	 });
    	
    	 this.ladderLabel.addMouseListener(new MouseAdapter() {
    		 @Override
    		 public void mouseClicked(MouseEvent e) {
					JFrame frame = new JFrame();
					frame.setBounds(100,100,400,400);
					JPanel componentProperties = new ComponentProperties(game, gameManager, "ladder",frame);
					frame.add(componentProperties);
					frame.setVisible(true);
    		 }
    	 });
    	 this.ladderLabel.addMouseListener(new MouseAdapter() {
    		 @Override
    		 public void mouseClicked(MouseEvent e) {
					JFrame frame = new JFrame();
					frame.setBounds(100,100,400,400);
					JPanel componentProperties = new ComponentProperties(game, gameManager, "ladder",frame);
					frame.add(componentProperties);
					frame.setVisible(true);
    		 }
    	 });
    	 
    	 this.marioLabel.addMouseListener(new MouseAdapter() {
    		 @Override
    		 public void mouseClicked(MouseEvent e) {
					JFrame frame = new JFrame();
					frame.setBounds(100,100,400,400);
					JPanel componentProperties = new ComponentProperties(game, gameManager, "mario",frame);
					frame.add(componentProperties);
					frame.setVisible(true);
    		 }
    	 });
    	    	 
    	 this.bgColorButton.addActionListener( new ActionListener() {

 			@Override
 			public void actionPerformed(ActionEvent arg0) {
 				Color prevColor = bgColor;
 				bgColor = JColorChooser.showDialog(null, "Choose a Color", bgColor);
 				if( bgColor == null) {
 					bgColor = prevColor;
 				}
 				bgColorComponent.setBgColor(bgColor);
 				game.setBackground(bgColor);
 			}
 		});
 
        this.circleLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            	JFrame frame = new JFrame();
            	frame.setBounds(100,100,400,400);
                JPanel componentProperties = new ComponentProperties(game, gameManager, "circle",frame);
                frame.add(componentProperties);
                frame.setVisible(true);
            }
        });

        rectangleLabel.addMouseListener(new MouseAdapter() {
        	
        	public void mouseClicked(MouseEvent e) {

            	JFrame frame = new JFrame();
            	frame.setBounds(100,100,400,400);
                JPanel componentProperties = new ComponentProperties(game, gameManager, "rectangle",frame);
                frame.add(componentProperties);
                frame.setVisible(true);
        	}
        });
    }

        
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	String filePath = System.getProperty("user.dir") + File.separator + "game.sav";
    	File f = new File(filePath);
    	
    	if(e.getSource() == save) {
    		logger.info("Game has been saved");
			FileOutputStream fout = null;
			ObjectOutputStream oos = null;
			List<Object> woi = new ArrayList<>();

			try {
				logger.info("Saving the states of components of game-maker");
				fout = new FileOutputStream(f);
				oos = new ObjectOutputStream(fout);
				woi.add(gameManager.getAllComponents());
				woi.add(bgColorComponent);
				oos.writeObject(woi);
			} catch (Exception ex) {
				logger.error("Error while saving the states of game maker components" + ex.getMessage());
			} finally {
				if (fout != null) {
					try {
						fout.close();
					} catch (IOException ex) {
						logger.error("Error in closing fileOutputStream for save game" + ex.getMessage());
					}
				}
				if (oos != null) {
					try {
						oos.close();
					} catch (IOException ex) {
						logger.error("Error in closing ObjectOutputstream for save game" + ex.getMessage());
					}
				}
			}
       }   
       
       
       if(e.getSource() == load) {
    	   
    	   try(FileInputStream fin = new FileInputStream(f.getPath()); ObjectInputStream ois =  new ObjectInputStream(fin)) {
    		   logger.info("Loading the states of components of game-maker");
			    @SuppressWarnings("unchecked")
			    List<Object> woi = new ArrayList<>();
		        woi = (ArrayList<Object>)ois.readObject();
				List<Component> allComponents = (List<Component>)woi.get(0);
				BackgroundColor bgc = (BackgroundColor)woi.get(1);
			    gameManager.setAllComponents(allComponents);
			    bgColor = bgc.getBgColor();
			    game.setBackground(bgColor);
			    
			    for(Component component : allComponents)
			    {
			    	if(component.getMovement() instanceof ManualMovement)
			    	{
			    		game.addKeyListener((KeyListener) component.getMovement());
			    	}
			    	if(component.getReaction() instanceof ClimbReaction) {
			    		game.addKeyListener((KeyListener)component.getReaction());
			    	}
			    }
			    this.game.repaint();
			    
    	   }catch(Exception ex) {
    		   logger.error("Error while loading the states of game maker components" + ex.getMessage());
    	   }
       }
    }

}

