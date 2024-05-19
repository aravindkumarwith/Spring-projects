package com.example.demo.repository;

import com.example.demo.model.Question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface quesrepository extends JpaRepository<Question,Integer> {


	List<Question> findBychose(String name);
}