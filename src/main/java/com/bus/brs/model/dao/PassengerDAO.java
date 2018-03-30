package com.bus.brs.model.dao;

import org.springframework.dao.EmptyResultDataAccessException;

import com.bus.brs.model.entity.Passenger;

/**
 * CRUD operations for passenger table.
 * @author <a href="http://PremP.com" target="_blank">Prem P</a>
 */
public interface PassengerDAO {
   
  //Create
  public void save(Passenger employee);
  
  //Read
  public Passenger findById(int id) throws EmptyResultDataAccessException;
  public Passenger findByUsername(String username) throws EmptyResultDataAccessException;

}