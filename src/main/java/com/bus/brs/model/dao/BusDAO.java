package com.bus.brs.model.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.bus.brs.model.entity.Bus;
import com.bus.brs.model.entity.Route;

/**
 * CRUD operations for bus table.
 * @author <a href="http://PremP.com" target="_blank">Prem P</a>
 */
public interface BusDAO {
  
  //Read
  public List<Bus> findByRouteAndDate(Route route, String date) throws EmptyResultDataAccessException;

}