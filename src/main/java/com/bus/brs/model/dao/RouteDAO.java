package com.bus.brs.model.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.bus.brs.model.entity.Route;

//CRUD operations
public interface RouteDAO {

	// Read
	public List<String> findAllOrigins() throws EmptyResultDataAccessException;
	public List<Route> findByOrigin(String origin) throws EmptyResultDataAccessException;

}