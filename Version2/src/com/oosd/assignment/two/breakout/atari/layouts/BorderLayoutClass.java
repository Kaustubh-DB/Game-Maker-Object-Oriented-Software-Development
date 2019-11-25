package com.oosd.assignment.two.breakout.atari.layouts;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class BorderLayoutClass extends JPanel implements ControllerLayout {
	int count;
	JPanel buttonsPanel;

	public BorderLayoutClass(JPanel buttonsPanel) {
		this.setLayout(null);
		this.buttonsPanel = buttonsPanel;
		BorderLayout border = new BorderLayout();
		this.count = 0;
		buttonsPanel.setLayout(border);

	}

	public void addComponentToLayout(JComponent component) {
		if (count >= 5) {
			return;
		}

		if (count == 0) {
			buttonsPanel.add(component, BorderLayout.PAGE_START);
		} else if (count == 1) {
			buttonsPanel.add(component, BorderLayout.LINE_END);
		} else if (count == 2) {
			buttonsPanel.add(component, BorderLayout.PAGE_END);
		} else if (count == 3) {
			buttonsPanel.add(component, BorderLayout.LINE_START);
		} else if (count == 4) {
			buttonsPanel.add(component, BorderLayout.CENTER);
		}
		count++;
	}

}