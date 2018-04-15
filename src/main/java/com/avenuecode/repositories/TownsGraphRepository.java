package com.avenuecode.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.avenuecode.models.TownsGraph;

public interface TownsGraphRepository extends MongoRepository<TownsGraph, String>, TownsGraphRepositoryCustom{
	
	

}
