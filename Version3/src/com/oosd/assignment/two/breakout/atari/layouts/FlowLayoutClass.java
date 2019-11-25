package com.oosd.assignment.two.breakout.atari.layouts;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class FlowLayoutClass extends JPanel implements ControllerLayout {
	JPanel buttonsPanel;

	public FlowLayoutClass(JPanel buttonsPanel) {
		
		this.setLayout(null);
		this.buttonsPanel = buttonsPanel;
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		buttonsPanel.setLayout(new FlowLayout());
	}

	@Override
	public void addComponentToLayout(JComponent component) {
		buttonsPanel.add(component);

	}

}