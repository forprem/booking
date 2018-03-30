package com.bus.brs.controller;

import java.awt.event.ActionEvent;

import com.bus.brs.model.entity.Passenger;
import com.bus.brs.model.service.PassengerService;
import com.bus.brs.ui.Alert;
import com.bus.brs.ui.RegistrationPanelView;
import com.bus.brs.ui.View;
import com.bus.brs.utility.constants.Messages;

/**
 * @author <a href="http://PremP.com" target="_blank">Prem P</a>
 */
public class RegistrationController implements Controller{
	
	private RegistrationController _this;
	
	private RegistrationPanelView registrationView;
	private Passenger passenger = new Passenger();
	private PassengerService passengerService;
	
	
    public RegistrationController(View registrationView) {
    	_this = this;
    	this.registrationView = (RegistrationPanelView) registrationView;
    }
    
    public void control(Controller parentController){
    	MasterController masterController = (MasterController) parentController;
    	
    	registrationView.getCancelButton().addActionListener(new ActionAdapter() {
			public void actionPerformed(ActionEvent ae) {
				registrationView.refresh();
			}
		});
    	
    	registrationView.getSubmitButton().addActionListener(new ActionAdapter() {
			public void actionPerformed(ActionEvent ae) {
				if(registrationView.validateFields()){
					passenger.setUsername(registrationView.getUsername());
					if(_this.isUsernameAvailable()){
						_this.register();
						Alert.successMessage(Messages.SUCCESS_REGISTRATION);
						masterController.loginControl();
					}else{
						Alert.errorMessage(Messages.ERROR_USERNAME_NOT_AVAILABLE);
					}
				}
			}
		});
    	
    }
    
    private boolean isUsernameAvailable(){
    	if(passengerService == null){
    		passengerService = new PassengerService();
    	}
    	passengerService.setModel(passenger);
    	return passengerService.isUsernameAvailable();
    }
    
    private void register(){
    	passenger.setName(registrationView.getFullname());
    	passenger.setPassword(registrationView.getPassword());
    	passenger.setMobile(registrationView.getMobile());
    	passenger.setEmail(registrationView.getEmail());
    	passengerService.setModel(passenger);
    	passengerService.register();
    }
    
}