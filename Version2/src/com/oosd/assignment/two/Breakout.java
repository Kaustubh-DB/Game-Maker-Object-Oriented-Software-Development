package com.oosd.assignment.two;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.oosd.assignment.two.breakout.atari.behaviour.AutomaticMovement;
import com.oosd.assignment.two.breakout.atari.behaviour.BounceBack;
import com.oosd.assignment.two.breakout.atari.behaviour.ClockTick;
import com.oosd.assignment.two.breakout.atari.behaviour.Explode;
import com.oosd.assignment.two.breakout.atari.behaviour.ManualMovement;
import com.oosd.assignment.two.breakout.atari.behaviour.Movement;
import com.oosd.assignment.two.breakout.atari.commands.LoadCommand;
import com.oosd.assignment.two.breakout.atari.commands.PauseCommand;
import com.oosd.assignment.two.breakout.atari.commands.ReplayCommand;
import com.oosd.assignment.two.breakout.atari.commands.SaveCommand;
import com.oosd.assignment.two.breakout.atari.commands.UndoCommand;
import com.oosd.assignment.two.breakout.atari.layouts.BorderLayoutClass;
import com.oosd.assignment.two.breakout.atari.layouts.ButtonContainer;
import com.oosd.assignment.two.breakout.atari.layouts.ControllerLayout;
import com.oosd.assignment.two.breakout.atari.layouts.FlowLayoutClass;
import com.oosd.assignment.two.breakout.atari.manager.AtariManager;
import com.oosd.assignment.two.breakout.atari.model.Ball;
import com.oosd.assignment.two.breakout.atari.model.Brick;
import com.oosd.assignment.two.breakout.atari.model.Component;
import com.oosd.assignment.two.breakout.atari.model.DigitalClock;
import com.oosd.assignment.two.breakout.atari.model.Paddle;

public class Breakout extends JPanel implements ActionListener {

	private JFrame bframe = new JFrame();
	JPanel panel = new JPanel();
	JPanel buttonsPanel = new JPanel();
	String frameType = "border";

	public Breakout(AtariManager atariManager) {
		ballComponent = new Ball(Color.BLACK, 400, 300, 20, 20);
		paddleComponent = new Paddle(Color.BLUE, 400, 350, 180, 20);
		brickComponent = new Brick(30, 80, Color.RED, 500, 500);
		clockComponent = new DigitalClock(20, 20, "0 : 0", 10);
		this.atariManager = atariManager;
		JButton toggle = new JButton("Change Layout");
		toggle.setFocusable(false);
		this.add(toggle);
		toggle.addActionListener(this);
		bframe.setSize(400, 400);
		bframe.setLocation(250, 900);

		ButtonContainer buttonContainer = new ButtonContainer(panel, atariManager, new BorderLayoutClass(buttonsPanel));
		BorderLayoutClass border = new BorderLayoutClass(buttonsPanel);
		controllerSetup(buttonContainer, border);
		bframe.add(buttonsPanel);
		bframe.setVisible(true);
	}

	public void controllerSetup(ButtonContainer buttonContainer, ControllerLayout layout) {
		buttonContainer.addButton("Pause/ Resume", new PauseCommand(((AtariManager) atariManager).getComponentsList()),
				layout);
		buttonContainer.addButton("Replay", new ReplayCommand(((AtariManager) atariManager).getComponentsList()),
				layout);
		buttonContainer.addButton("Save", new SaveCommand(((AtariManager) atariManager).getComponentsList()), layout);
		buttonContainer.addButton("Load", new LoadCommand(((AtariManager) atariManager).getComponentsList()), layout);
		buttonContainer.addButton("Undo", new UndoCommand(((AtariManager) atariManager).getComponentsList()), layout);
	}

	public static Graphics2D graphobj = null;

	AtariManager atariManager = new AtariManager();

	Component ballComponent;
	Component paddleComponent;
	Component brickComponent;
	Component clockComponent;

	private int frame_width = 800;

	private int frame_height = 600;

	public int getFrame_width() {
		return frame_width;
	}

	public void setFrame_width(int frame_width) {
		this.frame_width = frame_width;
	}

	public int getFrame_height() {
		return frame_height;
	}

	public void setFrame_height(int frame_height) {
		this.frame_height = frame_height;
	}

	public void startGame() {
		Movement paddleMovement = new ManualMovement();
		atariManager.register(ballComponent, null, new AutomaticMovement());
		atariManager.register(paddleComponent, new BounceBack(), paddleMovement);
		atariManager.register(brickComponent, new Explode(), new AutomaticMovement());
		atariManager.register(clockComponent, null, new ClockTick());
		this.setFocusable(true);
		this.addKeyListener((KeyListener) paddleMovement);
		while (true) {
			ballComponent.move(this);
			clockComponent.move(this);
			brickComponent.move(this);
			paddleComponent.react(ballComponent);
			if (brickComponent.react(ballComponent)) {
				if (!ballComponent.isGamePaused())
					ballComponent.pause();
				if (!paddleComponent.isGamePaused())
					paddleComponent.pause();
				if (!clockComponent.isGamePaused())
					clockComponent.pause();
				if (!brickComponent.isGamePaused()) {
					brickComponent.pause();
				}
			}
			paddleComponent.move(this);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			repaint();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		graphobj = (Graphics2D) g;
		ballComponent.draw(graphobj);
		paddleComponent.draw(graphobj);
		brickComponent.draw(graphobj);
		clockComponent.draw(graphobj);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (this.frameType == "border") {
			ButtonContainer buttonContainer = new ButtonContainer(panel, atariManager,
					new FlowLayoutClass(buttonsPanel));
			FlowLayoutClass flow = new FlowLayoutClass(buttonsPanel);
			buttonsPanel.removeAll();
			controllerSetup(buttonContainer, flow);
			bframe.setSize(600, 100);

			this.bframe.setVisible(false);
			this.bframe.setVisible(true);
			this.frameType = "flow";

		} else if (this.frameType == "flow") {

			ButtonContainer buttonContainer = new ButtonContainer(panel, atariManager,
					new BorderLayoutClass(buttonsPanel));
			BorderLayoutClass border = new BorderLayoutClass(buttonsPanel);
			buttonsPanel.removeAll();
			controllerSetup(buttonContainer, border);
			bframe.setSize(400, 400);
			this.bframe.add(buttonsPanel);
			this.bframe.setVisible(false);
			this.bframe.setVisible(true);
			this.frameType = "border";
		}

	}

}