package com.bus.brs.ui;

import javax.swing.JOptionPane;

/**
 * @author <a href="http://PremP.com" target="_blank">Prem P</a>
 */
public class Alert {
	public static final void errorMessage(String mesg){
		JOptionPane.showMessageDialog(null, mesg, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static final void successMessage(String mesg){
		JOptionPane.showMessageDialog(null, mesg, "Success", JOptionPane.PLAIN_MESSAGE);
	}
}