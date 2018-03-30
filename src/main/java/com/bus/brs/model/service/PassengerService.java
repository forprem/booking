package com.bus.brs.model.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import com.bus.brs.model.dao.PassengerDAO;
import com.bus.brs.model.entity.Passenger;

/**
 * @author <a href="http://PremP.com" target="_blank">Prem P</a>
 */
public class PassengerService implements Service{
	
	/**
	 * Session variable which holds account details of the customer until he logout.
	 */
	private Passenger passenger;
	public static ClassPathXmlApplicationContext dbApplicationContext;
	
	public PassengerService(){
		dbApplicationContext = new ClassPathXmlApplicationContext("spring-jdbc.xml");
	}
	
	public void setModel(Passenger passenger){
		this.passenger = passenger;
	}
	
	public Passenger getModel(){
		return passenger;
	}
	
	public boolean isUsernameAvailable(){
		PassengerDAO passengerDAO = dbApplicationContext.getBean("passengerDAO", PassengerDAO.class);
		try{
			passengerDAO.findByUsername(passenger.getUsername());
		}catch(EmptyResultDataAccessException e){
			return true;
		}
		return false;
	}
	
	public void register(){
		PassengerDAO passengerDAO = dbApplicationContext.getBean("passengerDAO", PassengerDAO.class);
		passengerDAO.save(passenger);
	}
	
	public boolean login() throws EmptyResultDataAccessException{
		PassengerDAO passengerDAO = dbApplicationContext.getBean("passengerDAO", PassengerDAO.class);
		
		Passenger dbRecord = passengerDAO.findByUsername(passenger.getUsername());
		if(passenger.getPassword().equals(dbRecord.getPassword())){
			setModel(dbRecord);
			return true;
		}
		return false;
	}
	
	protected void finalize(){
		dbApplicationContext.close();
		dbApplicationContext = null;
	}
}
