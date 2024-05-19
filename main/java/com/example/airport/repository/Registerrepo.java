package com.example.airport.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.airport.model.Register;
import java.util.*;

@Repository

public interface Registerrepo extends MongoRepository<Register,String> {

	@Query("{'$and': [{'email': ?0}, {'password': ?1}]}")
 List<Register> findByNameandPass(String email,String pass);
}
