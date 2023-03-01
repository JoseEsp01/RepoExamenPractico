package com.ista.springboot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.springboot.web.entity.Depto;
import com.ista.springboot.web.repository.IDeptoRepository;

@Service
public class DeptoServiceImpl extends GenericServiceImpl<Depto, Long> implements IDeptoService{

	@Autowired
	IDeptoRepository deptoRepository;

	@Override
	public CrudRepository<Depto, Long> getDao() {

		return deptoRepository;
	}
}
