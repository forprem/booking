package com.bus.brs;

import java.awt.EventQueue;

import com.bus.brs.ui.MasterView;

/**
 * The main launcher for java bus reservation system application. Creates the
 * {@code MasterView} object.
 * 
 * @author <a href="http://PremP.com" target="_blank">Prem P</a>
 * @version 2.0
 * @see MasterView
 */
public class AppLauncher {

	/**
	 * @param args
	 *            Currently no arguments required to be passed to this program.
	 */
	public static void main(String[] args) {

		// Use the event dispatch thread for Swing components
		EventQueue.invokeLater(new Runnable() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see java.lang.Runnable#run()
			 */
			@Override
			public void run() {
				new MasterView();
			}
		});
	}

}
