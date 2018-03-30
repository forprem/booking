package com.bus.brs.ui;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author <a href="http://PremP.com" target="_blank">Prem P</a>
 */
@SuppressWarnings("serial")
public abstract class BaseView extends JPanel{
	
	ArrayList<JTextField> inputFields;
	
	public BaseView() {
		this.setLayout(null);
		this.inputFields = new ArrayList<JTextField>();
	}
	
	/**
	 * Clears all input and repaints the panel.
	 */
	public void refresh(){
		inputFields.forEach(field -> field.setText(null));
		this.revalidate();
	}
}