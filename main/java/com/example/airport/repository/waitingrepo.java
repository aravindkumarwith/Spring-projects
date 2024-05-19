package com.example.airport.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;
import com.example.airport.model.waiting;

@Repository
public interface waitingrepo extends MongoRepository<waiting,Integer> {

	@Query("{'flightno':?0, 'Seat':?1}")
	List<waiting> findByflightnoAndSeat(int no,String seat);
	
	
}
