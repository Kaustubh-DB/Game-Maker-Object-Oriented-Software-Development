package com.gamemaker.team6;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import com.gamemaker.team6.behaviour.Action;
import com.gamemaker.team6.behaviour.AutomaticMovement;
import com.gamemaker.team6.behaviour.BounceBack;
import com.gamemaker.team6.behaviour.BoundaryBehavior;
import com.gamemaker.team6.behaviour.BoundaryBounce;
import com.gamemaker.team6.behaviour.BoundaryBounceDrop;
import com.gamemaker.team6.behaviour.BoundaryMoveDownBounce;
import com.gamemaker.team6.behaviour.BoundaryRotate;
import com.gamemaker.team6.behaviour.ClimbReaction;
import com.gamemaker.team6.behaviour.Explode;
import com.gamemaker.team6.behaviour.GhostReaction;
import com.gamemaker.team6.behaviour.ManualMovement;
import com.gamemaker.team6.behaviour.MoveDownBounce;
import com.gamemaker.team6.behaviour.Movement;
import com.gamemaker.team6.behaviour.NoAction;
import com.gamemaker.team6.behaviour.NoBoundaryReaction;
import com.gamemaker.team6.behaviour.NoMovement;
import com.gamemaker.team6.behaviour.NoReaction;
import com.gamemaker.team6.behaviour.Reaction;
import com.gamemaker.team6.behaviour.Shoot;
import com.gamemaker.team6.behaviour.StayReaction;
import com.gamemaker.team6.behaviour.ThrowBarrel;
import com.gamemaker.team6.behaviour.TransformReaction;
import com.gamemaker.team6.manager.Manager;
import com.gamemaker.team6.model.Circle;
import com.gamemaker.team6.model.Component;
import com.gamemaker.team6.model.ImageComponent;
import com.gamemaker.team6.model.Rectangle;

public class ComponentProperties extends JPanel {
	private static final long serialVersionUID = 177928544196565319L;

	private JTextField widthText;
	private JTextField heightText;
	private Component component;
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
    private String sound;
    private String path = "./icons/";
	private JComboBox<String> colorCombobox;
	private JComboBox<String> soundComboBox;
	private JComboBox<String> movementCombobox;
	private JComboBox<String> directionCombobox;
	private JSpinner speedSpinner;
	private JComboBox<String> reactionCombobox;
    private JComboBox<String> shootOptionComboBox;
    private JComboBox<String> shootDirectionComboBox;
    private JComboBox<String> boundaryReactionComboBox;
	private JButton addButton;
    private Game game;
    private Manager gameManager;
    private String componentString;
	private JFrame frame;

	public ComponentProperties(Game game, Manager gameManager, String componentString,JFrame frame) {
		this.game = game;
		this.gameManager = gameManager;
		this.componentString = componentString;
		this.setLayout(null);
		this.frame = frame;
        JLabel widthLabel = new JLabel(WIDTH);
        widthLabel.setBounds(0, 0, 40, 25);
		widthText = new JTextField("0");
        widthText.setBounds(40, 0, 40, 25);

        JLabel heightLabel = new JLabel(HEIGHT);
		heightLabel.setBounds(90, 0, 40, 25);
        heightText = new JTextField("0");
        heightText.setBounds(130, 0, 40, 25);


        JLabel speedLabel = new JLabel(SPEED);
        speedLabel.setBounds(180, 0, 40, 25);
        speedSpinner = new JSpinner();
        speedSpinner.setBounds(220, 0, 40, 25);


        JLabel colorLabel = new JLabel(COLOR);
        String[] circleColor = {
                RED,
                BLACK,
                GRAY
            };
        colorCombobox = new JComboBox <String>(circleColor);
        colorCombobox.setEditable(true);
        colorLabel.setBounds(0, 40, 40, 25);
        colorCombobox.setBounds(40, 40, 60, 25);

        JLabel soundLabel = new JLabel(SOUND);
        String soundArray[] = {
        		"no sound",
        		"Ball_Bounce.wav",
                "metal_gear.wav",
                "cartoon.wav",
                "boom.wav"
            };
         soundComboBox = new JComboBox <String> (soundArray);
         soundComboBox.setEditable(true);
         soundLabel.setBounds(110, 40, 40, 25);
         soundComboBox.setBounds(150, 40, 140, 25);

        JLabel movementLabel = new JLabel("Movement");
        String[] movement = {
                "Arrow",
                "WASD",
                "Automatic",
                "No Movement"
            };
        movementCombobox = new JComboBox <String>(movement);
        movementCombobox.setEditable(true);
        movementLabel.setBounds(0, 80, 70, 25);
        movementCombobox.setBounds(70, 80, 110, 25);

        JLabel directionLabel = new JLabel("Direction");
        String[] direction = {
                "One direction-X",
                "One direction-Y",
                "Multi direction"
            };
        directionCombobox = new JComboBox <String>(direction);
        directionCombobox.setEditable(true);
        directionLabel.setBounds(190, 80, 65, 25);
        directionCombobox.setBounds(255, 80, 110, 25);

        JLabel reactionLabel = new JLabel(REACTION);
        String[] circleReaction= {
        		"BounceBack",
        		"Move Down Bounce",
        		"Explode",
        		"Explode on Weapon",
				"Consumable",
        		"Climb",
        		"Stay",
        		"Transform",
        		"Ghost Reaction",
        		"No Reaction"
        };

        reactionCombobox = new JComboBox <>(circleReaction);
        reactionCombobox.setEditable(true);
        reactionLabel.setBounds(0, 120, 60, 25);
        reactionCombobox.setBounds(60, 120, 110, 25);

        JLabel shootOptionLabel = new JLabel("Actions");
        shootOptionLabel.setBounds(0,150,110,30);
        String[] shootingOptions= {
        		"No Action",
        		"Automatic Shooting",
        		"Manual Shooting",
        		"Throw Barrel"
        };
        shootOptionComboBox = new JComboBox<String>(shootingOptions);
        shootOptionComboBox.setBounds(150,150,110,30);

        JLabel shootDirectionLabel = new JLabel("Shoot Direction");
        shootDirectionLabel.setBounds(0,180,110,30);
        String[] shootingDirections= {
        		"Left",
        		"Right",
        		"Up",
        		"Down"
        };
        shootDirectionComboBox = new JComboBox<String>(shootingDirections);
        shootDirectionComboBox.setBounds(150,180,110,30);

        JLabel boundaryReactionLabel = new JLabel("Boundary Behavior");
        boundaryReactionLabel.setBounds(180,120,110,30);
        String[] boundaryBehaviors= {
        		"Bounce",
        		"Rotate",
        		"Bounce Drop",
        		"Bounce and Move Down",
        		"No Reaction",
        };
        boundaryReactionComboBox = new JComboBox<String>(boundaryBehaviors);
        boundaryReactionComboBox.setBounds(300,120,110,30);

        addButton = new JButton("Add Component");
        addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setProperties();

			}
		});
        addButton.setBounds(120, 220, 150, 25);

        this.add(heightLabel);
        this.add(heightText);
        this.add(widthLabel);
        this.add(widthText);
        this.add(soundLabel);
        this.add(soundComboBox);
        this.add(speedLabel);
        this.add(speedSpinner);
        this.add(colorLabel);
        this.add(colorCombobox);
		this.add(movementLabel);
		this.add(movementCombobox);
		this.add(directionLabel);
		this.add(directionCombobox);
        this.add(reactionLabel);
        this.add(reactionCombobox);
        this.add(shootOptionLabel);
        this.add(shootOptionComboBox);
        this.add(shootDirectionLabel);
        this.add(shootDirectionComboBox);
        this.add(boundaryReactionLabel);
        this.add(boundaryReactionComboBox);
        this.add(addButton);
	}
	public void setProperties() {

    	Color color = null;
    	Movement componentMovement = null;
		if(colorCombobox.getSelectedItem().toString().equals(RED))
        {
                     color = Color.RED;
        }
        else if(colorCombobox.getSelectedItem().toString().equals(BLACK))
        {
                     color = Color.BLACK;
        }
        else if(colorCombobox.getSelectedItem().toString().equals(GRAY))
        {
                     color = Color.GRAY;
        }
    	sound = soundComboBox.getSelectedItem().toString();


		switch (componentString) {
			case "circle":
				component = new Circle(color, 100, 100, Integer.parseInt(widthText.getText()), Integer.parseInt(heightText.getText()));
				break;
			case "rectangle":
				component = new Rectangle(color, 100, 100, Integer.parseInt(widthText.getText()), Integer.parseInt(heightText.getText()));
				break;
			case "ship":
				component = new ImageComponent("spaceship.png", 100, 100, Integer.parseInt(widthText.getText()), Integer.parseInt(heightText.getText()));
				break;
			case "invader":
				component = new ImageComponent("invader.png", 100, 100, Integer.parseInt(widthText.getText()), Integer.parseInt(heightText.getText()));
				component.setIsToxic(true);
				break;
			case "invader2":
				component = new ImageComponent("invader2.png", 100, 100, Integer.parseInt(widthText.getText()), Integer.parseInt(heightText.getText()));
				component.setIsToxic(true);
				break;
			case "mushroom":
				component = new ImageComponent("mushroom.png", 100, 100, Integer.parseInt(widthText.getText()), Integer.parseInt(heightText.getText()));
				break;
			case "monkey":
				component = new ImageComponent("monkey.png", 100, 100, Integer.parseInt(widthText.getText()), Integer.parseInt(heightText.getText()));
				break;
			case "pacman":
				component = new ImageComponent("pacman.png", 100, 100, Integer.parseInt(widthText.getText()), Integer.parseInt(heightText.getText()));
				break;
			case "food":
				component = new ImageComponent("food.png", 100, 100, Integer.parseInt(widthText.getText()), Integer.parseInt(heightText.getText()));
				break;
			case "ladder":
				component = new ImageComponent("ladder.png", 100, 100, Integer.parseInt(widthText.getText()), Integer.parseInt(heightText.getText()));
				break;
			case "mario":
				component = new ImageComponent("mario.png", 100, 100, Integer.parseInt(widthText.getText()), Integer.parseInt(heightText.getText()));
				break;
			case "ghostred":
				component = new ImageComponent("ghost.png", 100, 100, Integer.parseInt(widthText.getText()), Integer.parseInt(heightText.getText()));
				component.setIsToxic(true);
				break;
			case "ghostblue":
				component = new ImageComponent("ghost2.png", 100, 100, Integer.parseInt(widthText.getText()), Integer.parseInt(heightText.getText()));
				component.setIsToxic(true);
				break;
				
			default:
				
				component = null;
		}


		if(movementCombobox.getSelectedItem().toString().equals("Automatic"))
    	{
    		if(directionCombobox.getSelectedItem().toString().equals("One direction-X"))
    		{
    			component.setDy(0);
    			component.setDx((int)speedSpinner.getValue());

    			 componentMovement = new AutomaticMovement();
    		}
    		else if(directionCombobox.getSelectedItem().toString().equals("One direction-Y"))
    		{
    			component.setDy((int)speedSpinner.getValue());
    			component.setDx(0);

    			 componentMovement = new AutomaticMovement();
    		}
    		else if(directionCombobox.getSelectedItem().toString().equals("Multi direction"))
    		{
    			componentMovement = new AutomaticMovement();
    			component.setDx((int)speedSpinner.getValue());
    			component.setDy((int)speedSpinner.getValue());
    		}

    	}
    	if(movementCombobox.getSelectedItem().toString().equals("Arrow"))
    	{
    		if(directionCombobox.getSelectedItem().toString().equals("One direction-X"))
    		{
    			componentMovement = new ManualMovement("arrow",gameManager);
        		game.addKeyListener((KeyListener) componentMovement);
        		component.setDx((int)speedSpinner.getValue());
        		component.setDy(0);
    		}
    		else if(directionCombobox.getSelectedItem().toString().equals("One direction-Y"))
    		{
    			componentMovement = new ManualMovement("arrow",gameManager);
        		game.addKeyListener((KeyListener) componentMovement);
        		component.setDx(0);
        		component.setDy((int)speedSpinner.getValue());
    		}
    		else if(directionCombobox.getSelectedItem().toString().equals("Multi direction"))
    		{
    			 componentMovement = new ManualMovement("arrow",gameManager);
        		game.addKeyListener((KeyListener) componentMovement);
        		component.setDx((int)speedSpinner.getValue());
        		component.setDy((int)speedSpinner.getValue());
    		}

    	}
    	if(movementCombobox.getSelectedItem().toString().equals("WASD"))
    	{
    		if(directionCombobox.getSelectedItem().toString().equals("One direction-X"))
    		{
    			 componentMovement = new ManualMovement("wasd",gameManager);
        		game.addKeyListener((KeyListener) componentMovement);
        		component.setDx((int)speedSpinner.getValue());
        		component.setDy(0);
    		}
    		if(directionCombobox.getSelectedItem().toString().equals("One direction-Y"))
    		{
    			 componentMovement = new ManualMovement("wasd",gameManager);
        		game.addKeyListener((KeyListener) componentMovement);
        		component.setDx(0);
        		component.setDy((int)speedSpinner.getValue());
    		}
    		else if(directionCombobox.getSelectedItem().toString().equals("Multi direction"))
    		{
    			 componentMovement = new ManualMovement("wasd",gameManager);
        		game.addKeyListener((KeyListener) componentMovement);

        		component.setDx((int)speedSpinner.getValue());
        		component.setDy((int)speedSpinner.getValue());
    		}
    	}

    	else if(movementCombobox.getSelectedItem().toString().equals("No Movement"))
    	{
    		component.setDx(0);
    		component.setDy(0);
    		componentMovement = new NoMovement();
    	}

    	Reaction reaction = null;
		if (reactionCombobox.getSelectedItem().toString().equals("BounceBack")) {
			// circleReaction = new BounceBack(path + sound);
			reaction = new BounceBack();

		} else if (reactionCombobox.getSelectedItem().toString().equals("Explode")) {
			reaction = new Explode("");

		} else if (reactionCombobox.getSelectedItem().toString().equals("Explode on Weapon")) {
			reaction = new Explode("Weapon");

		} else if (reactionCombobox.getSelectedItem().toString().equals("Consumable")) {
			reaction = new Explode("Consumable");
			
		} else if (reactionCombobox.getSelectedItem().toString().equals("Move Down Bounce")) {
			reaction = new MoveDownBounce();
		} else if (reactionCombobox.getSelectedItem().toString().equals("Climb")) {
			reaction = new ClimbReaction();
			game.addKeyListener((KeyListener) reaction);
		} else if (reactionCombobox.getSelectedItem().toString().equals("Stay"))
			reaction = new StayReaction();
		else if (reactionCombobox.getSelectedItem().toString().equals("Transform")) {
			reaction = new TransformReaction(gameManager);
		} else if (reactionCombobox.getSelectedItem().toString().equals("Ghost Reaction")) {
			reaction = new GhostReaction();
		} else if (reactionCombobox.getSelectedItem().toString().equals("No Reaction")) {
			reaction = new NoReaction();

		}
		if(!sound.equals("no sound") && !sound.equals(""))  {
			reaction.setSound(path+sound);
		}
		
		BoundaryBehavior boundaryBehavior = new NoBoundaryReaction();
		if(boundaryReactionComboBox.getSelectedItem().toString().equals("Bounce")){
			boundaryBehavior = new BoundaryBounce();
		}
		else if(boundaryReactionComboBox.getSelectedItem().toString().equals("Rotate")){
			boundaryBehavior = new BoundaryRotate();
		}
		else if(boundaryReactionComboBox.getSelectedItem().toString().equals("Bounce Drop")) {
			boundaryBehavior = new BoundaryBounceDrop();
		}
		else if (boundaryReactionComboBox.getSelectedItem().toString().equals("Bounce and Move Down")) {
			boundaryBehavior = new BoundaryMoveDownBounce();
		}
		
		Action action = new NoAction();
		if (shootOptionComboBox.getSelectedItem().toString().equals("Automatic Shooting") || shootOptionComboBox.getSelectedItem().toString().equals("Manual Shooting") ) {
			action = new Shoot(component, gameManager);
			((Shoot)action).setShootOption(shootOptionComboBox.getSelectedItem().toString());
			((Shoot)action).setShootDirection(shootDirectionComboBox.getSelectedItem().toString());
			game.addKeyListener((KeyListener) action);
		} else if (shootOptionComboBox.getSelectedItem().toString().equals("Throw Barrel")) {
			action = new ThrowBarrel(component, gameManager);
		}
		gameManager.register(component, reaction, componentMovement,boundaryBehavior, action);
    	this.frame.dispose();
	}
}
