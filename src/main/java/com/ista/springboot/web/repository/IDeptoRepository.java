package com.ista.springboot.web.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ista.springboot.web.entity.Depto;

public interface IDeptoRepository extends MongoRepository<Depto, Long>{

}
