package com.bus.brs.ui;

import java.awt.BorderLayout;

import com.bus.brs.utility.ViewComponentFactory;
import com.bus.brs.utility.constants.ResourcePaths;

/**
 * @author <a href="http://PremP.com" target="_blank">Prem P</a>
 */
@SuppressWarnings("serial")
public class BannerViewPanel extends BaseView implements View{
	public BannerViewPanel(){
		this.setLayout(new BorderLayout());
		this.add(ViewComponentFactory.createJLabelImage(ResourcePaths.BANNER));
	}
}
