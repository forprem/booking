package com.bus.brs.ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import com.bus.brs.controller.MasterController;
import com.bus.brs.utility.BorderLayoutPositionFactory;
import com.bus.brs.utility.constants.Labels;
import com.bus.brs.utility.constants.Messages;

/**
 * @author <a href="http://PremP.com" target="_blank">Prem P</a>
 */
public class MasterView {

	private JFrame frame;
	private MasterController controller = new MasterController(this);

	public MasterView() {
		frame = new JFrame(Labels.TITLE);

		/*
		 * Setting look and feel
		 */
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			Alert.errorMessage(Messages.ERROR_LOOK_AND_FIELD);
		}

		/*
		 * Window settings
		 */
		frame.setBackground(Color.white);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.setBounds(0, 0, 1024, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		/*
		 * Give control to master controller
		 */
		controller.control(null);
	}

	public boolean insertPanel(View panel, String align) {
		if (align != null) {
			frame.add(BorderLayoutPositionFactory.create(align), (JPanel) panel);
		}
		frame.revalidate();
		frame.repaint();
		return true;
	}

	public void clear() {
		frame.getContentPane().removeAll();
		frame.revalidate();
		frame.repaint();
	}

}
