package com.oosd.assignment.two.breakout.atari.layouts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.oosd.assignment.two.breakout.atari.commands.Command;
import com.oosd.assignment.two.breakout.atari.manager.AtariManager;
import com.oosd.assignment.two.breakout.atari.manager.Manager;

public class ButtonContainer extends JPanel implements ActionListener {
	Manager atariManager = new AtariManager();
	JPanel buttonsPanel;
	ControllerLayout layout;
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	ArrayList<Command> commands = new ArrayList<Command>();

	public ButtonContainer(JPanel buttonsPanel, AtariManager atariManager, ControllerLayout layout) {
		this.atariManager = atariManager;
		this.layout = layout;
		this.buttonsPanel = buttonsPanel;
	}

	public void addButton(String name, Command command, ControllerLayout layout) {
		JButton jbutton = new JButton(name);
		jbutton.setFocusable(false);
		jbutton.addActionListener(this);
		buttons.add(jbutton);
		commands.add(command);
		layout.addComponentToLayout(jbutton);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (int i = 0; i < buttons.size(); i++) {

			if (arg0.getSource() == buttons.get(i)) {
				((AtariManager) atariManager).notifyComponents(commands.get(i));
			}
		}

	}

}