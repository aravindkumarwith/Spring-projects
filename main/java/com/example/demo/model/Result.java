package com.example.demo.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="results")
public class Result {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String username;
    private int totalcorrect=0;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public  void setUsername(String username) {
        this.username = username;
    }
    public int getTotalcorrect() {
        return totalcorrect;
    }
    public void setTotalcorrect(int totalcorrect) {
        this.totalcorrect = totalcorrect;
    }

    public Result() {
        super();

    }
    public Result(int id, String username, int totalcorrect) {
        super();
        this.id = id;
        this.username = username;
        this.totalcorrect = totalcorrect;
    }
}




