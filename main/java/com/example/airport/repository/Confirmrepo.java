package com.example.airport.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.airport.model.confirmed;

@Repository
public interface Confirmrepo extends MongoRepository<confirmed,Integer> {

	@Query("{'confirma_no' : ?0}")
	confirmed findByConfirm(int no);
}
