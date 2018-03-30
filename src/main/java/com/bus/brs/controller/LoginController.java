package com.bus.brs.controller;

import java.awt.event.ActionEvent;

import org.springframework.dao.EmptyResultDataAccessException;

import com.bus.brs.model.entity.Passenger;
import com.bus.brs.model.service.PassengerService;
import com.bus.brs.ui.Alert;
import com.bus.brs.ui.LoginPanelView;
import com.bus.brs.ui.View;
import com.bus.brs.utility.constants.Messages;

/**
 * @author <a href="http://PremP.com" target="_blank">Prem P</a>
 */
public class LoginController implements Controller{
	
	private LoginController _this;
	private PassengerService passengerService;
	private LoginPanelView loginView;
	private Passenger passenger;
	
    public LoginController(View loginView) {
    	_this = this;
    	this.loginView = (LoginPanelView) loginView;
    	this.passenger = new Passenger();
    }
    
    public void control(Controller parentController){
    	MasterController masterController = (MasterController) parentController;
    	/**
		 *  On click of register button, switch control to RegistrationController
		 */
    	loginView.getLoginButton().addActionListener(new ActionAdapter() {
			public void actionPerformed(ActionEvent ae) {
				if(loginView.validateFields()){
					passenger.setUsername(loginView.getUsername());
					passenger.setPassword(loginView.getPassword());
					try{
						if(_this.login()){
							masterController.setPassengerService(passengerService);
							masterController.applicationControl();
						}else{
							loginView.refresh();
							Alert.errorMessage(Messages.ERROR_WRONG_PASSWORD);
						}
					}catch(EmptyResultDataAccessException e){
						loginView.refresh();
						Alert.errorMessage(Messages.ERROR_NO_USERNAME);
					}
				}
			}
		});
    	
    	loginView.getRegisterButton().addActionListener(new ActionAdapter() {
			public void actionPerformed(ActionEvent ae) {
				masterController.registrationControl();
			}
		});
    	
    }
    
    private boolean login()throws EmptyResultDataAccessException{
    	if(passengerService == null){
    		passengerService = new PassengerService();
    	}
    	passengerService.setModel(passenger);
    	return passengerService.login();
    }    
    
}