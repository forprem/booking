package com.bus.brs.model.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.bus.brs.model.bean.ReservationBean;

//CRUD operations
public interface ReservationDAO {
   
	public List<ReservationBean> findByPid(int pid) throws EmptyResultDataAccessException;
  
}