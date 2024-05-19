package com.example.airport.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.airport.model.airlines;
import java.util.*;
@Repository
public interface airrepository extends MongoRepository<airlines,Integer> {
	
	@Query("{'from':?0 , 'to':?1 ,'Date':?2}")
	List<airlines> GetDetails(String from,String to,String date);
	
	@Query("{'from':?0 , 'to':?1 ,'Date':?2,'depart':?3,'arrival':?4}")
	List<airlines> GetDetailsForSingle(String from,String to,String date,String depart,String arrive);
	
	@Query("{'flight_no' : ?0}")
	airlines findByNo(int no);
}


