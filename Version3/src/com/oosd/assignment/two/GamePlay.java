package com.oosd.assignment.two;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.oosd.assignment.two.breakout.atari.behaviour.ManualMovement;
import com.oosd.assignment.two.breakout.atari.manager.GameManager;
import com.oosd.assignment.two.breakout.atari.model.Circle;
import com.oosd.assignment.two.breakout.atari.model.Component;
import com.oosd.assignment.two.breakout.atari.model.Rectangle;
import com.oosd.assignment.two.breakout.atari.model.Square;

public class GamePlay extends JPanel implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame bframe = new JFrame();
	JPanel panel = new JPanel();
	JPanel buttonsPanel = new JPanel();
	String frameType = "border";
	int x, y;
	String str = "";
	DragPlaceObjects mousemotion;

	public GamePlay(GameManager gameManager) {

		this.gameManager = gameManager;
		JButton toggle = new JButton("Change Layout");
		toggle.setFocusable(false);
		// this.add(toggle);
		toggle.addActionListener(this);
		bframe.setSize(400, 400);
		// bframe.setLocation(815, 250);

		this.setBackground(Color.WHITE);
//		ButtonContainer buttonContainer = new ButtonContainer(panel, gameManager, new BorderLayoutClass(buttonsPanel));
//		BorderLayoutClass border = new BorderLayoutClass(buttonsPanel);
//		controllerSetup(buttonContainer, border);
//		bframe.add(buttonsPanel);
		// bframe.setVisible(true);
		this.setFocusable(true);
		this.addKeyListener((KeyListener) new ManualMovement());
		mousemotion = new DragPlaceObjects(gameManager);
		this.addMouseListener(mousemotion);
		this.addMouseMotionListener(mousemotion);
	}

//	public void controllerSetup(ButtonContainer buttonContainer, ControllerLayout layout) {
//		buttonContainer.addButton("Pause/ Resume", new PauseCommand(((GameManager) gameManager).getComponentsList()),
//				layout);
//		buttonContainer.addButton("Replay", new ReplayCommand(((GameManager) gameManager).getComponentsList()),
//				layout);
//		buttonContainer.addButton("Save", new SaveCommand(((GameManager) gameManager).getComponentsList()), layout);
//		buttonContainer.addButton("Load", new LoadCommand(gameManager), layout);
//		buttonContainer.addButton("Undo", new UndoCommand(((GameManager) gameManager).getComponentsList()), layout);
//	}

	Graphics2D graphobj = null;

	GameManager gameManager = new GameManager();
	Component circleReact;
	Component rectangleReact;
	Component squareReact;

	// private int frame_width = 800;

	// private int frame_height = 600;

	public int getFrame_width() {
		return getWidth();
	}

	/*
	 * public void setFrame_width(int frame_width) { this.frame_width = frame_width;
	 * }
	 */
	public int getFrame_height() {
		return getHeight();
	}

	/*
	 * public void setFrame_height(int frame_height) { this.frame_height =
	 * frame_height; }
	 */

	public void startGame() throws InterruptedException {
		do {

			if (!gameManager.getComponentsList().isEmpty()) {
				// System.out.println(gameManager.getComponentsList().get(0).getMovement());
				int i = 0;
				while (i < gameManager.getComponentsList().size() && gameManager.getComponentsList().get(i) != null) {
					gameManager.getComponentsList().get(i).move(this);
					if (gameManager.getComponentsList().get(i) instanceof Circle) {
						circleReact = gameManager.getComponentsList().get(i);
					} else if (gameManager.getComponentsList().get(i) instanceof Rectangle) {

						rectangleReact = gameManager.getComponentsList().get(i);

					}
					//
					// System.out.println(gameManager.getComponentsList().get(i));
					else if (gameManager.getComponentsList().get(i) instanceof Square) {

						squareReact = gameManager.getComponentsList().get(i);
					}
					i++;

				}
				if (circleReact != null && circleReact != null && circleReact.getReaction() != null) {
					// System.out.println("circle play "+circleReact.getX());
					/*
					 * System.out.println("HERE"); rectangleReact.react(circleReact);
					 */
					int j = 0;
					List<Component> componentsList = gameManager.getComponentsList();
					while (j < componentsList.size()) {

						System.out.println("In Circle Circle");
						if (componentsList.get(j) instanceof Circle) {
							if (componentsList.get(j).react(circleReact)) {
								System.out.println("In Pacman Circle If");
								
								/*
								 * if (!circleReact.isGamePaused()) { circleReact.pause(); }
								 * if(!componentsList.get(j).isGamePaused()) { componentsList.get(j).pause(); }
								 */
								 
							}
						}
						j++;

					}

				}

				if (circleReact != null && squareReact != null && squareReact.getReaction() != null) {
					int j = 0;
					List<Component> componentsList = gameManager.getComponentsList();
					while (j < componentsList.size()) {

						System.out.println("In Circle Square, SquareReact");
						if (componentsList.get(j) instanceof Square) {
							if (componentsList.get(j).react(circleReact)) {
								
								/*
								 * if (!circleReact.isGamePaused()) circleReact.pause(); if
								 * (!componentsList.get(j).isGamePaused()) { componentsList.get(j).pause(); }
								 */
							}
						}
						j++;

					}
				}
				
				
				if (circleReact != null && rectangleReact != null && rectangleReact.getReaction() != null) {
					int j = 0;
					List<Component> componentsList = gameManager.getComponentsList();
					while (j < componentsList.size()) {

						System.out.println("In circle Rectangle, RectangleReact ");
						if (componentsList.get(j) instanceof Rectangle) {
							if (componentsList.get(j).react(circleReact)) {
							//	System.out.println("In Loop");
								
								  if (!circleReact.isGamePaused()) circleReact.pause(); if
								  (!componentsList.get(j).isGamePaused()) { componentsList.get(j).pause(); }
								 
							}
						}
						j++;

					}
				}

				if (circleReact != null && rectangleReact != null && squareReact != null && squareReact.getReaction() != null) {
					if (squareReact.react(circleReact)) {
						System.out.println("Circle rect square, squareReact.getReaction");
						System.out.println("SquareReact with circle");
						if (!circleReact.isGamePaused())
							circleReact.pause();
						if (!rectangleReact.isGamePaused())
							rectangleReact.pause();
						if (!squareReact.isGamePaused()) {
							squareReact.pause();
						}
					}
				}

				if (circleReact!= null && rectangleReact != null && squareReact != null && squareReact.getReaction() != null) {
					if (rectangleReact.react(squareReact)) {
						System.out.println("Circle Rectangle Square, SquareReact.getReaction");
						System.out.println("Rectangle React with Circle");
						if (!rectangleReact.isGamePaused())
							rectangleReact.pause();
						if (!squareReact.isGamePaused()) {
							squareReact.pause();
						}
					}
				}
				Thread.sleep(10);

			}

			repaint();

		} while (true);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (!gameManager.getComponentsList().isEmpty()) {

			graphobj = (Graphics2D) g;

			int i = 0;
			while (i < gameManager.getComponentsList().size() && gameManager.getComponentsList().get(i) != null) {
				gameManager.getComponentsList().get(i).draw(graphobj);
				i++;
			}
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
//		if (this.frameType.equals("border")) {
//			ButtonContainer buttonContainer = new ButtonContainer(panel, gameManager,
//					new FlowLayoutClass(buttonsPanel));
//			FlowLayoutClass flow = new FlowLayoutClass(buttonsPanel);
//			buttonsPanel.removeAll();
//			controllerSetup(buttonContainer, flow);
//			bframe.setSize(600, 100);
//
//			this.bframe.setVisible(false);
//			this.bframe.setVisible(true);
//			this.frameType = "flow";
//
//		} else if (this.frameType.equals("flow")) {

//			ButtonContainer buttonContainer = new ButtonContainer(panel, gameManager,
//					new BorderLayoutClass(buttonsPanel));
//			BorderLayoutClass border = new BorderLayoutClass(buttonsPanel);
//			buttonsPanel.removeAll();
//			controllerSetup(buttonContainer, border);
//			bframe.setSize(400, 400);
//			this.bframe.add(buttonsPanel);
//			this.bframe.setVisible(false);
//			this.bframe.setVisible(true);
//			this.frameType = "border";
//		}

	}

	public void shiftFocus() {
		this.setFocusable(true);

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	public DragPlaceObjects getMouseMotionListener() {
		return mousemotion;
	}

}