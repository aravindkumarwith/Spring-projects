package com.example.demo.model;

import org.springframework.stereotype.Component;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="questions")
public class Question {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int quesId;
    private int ans;
    private String chose;
    public void setChose(String chose) {
		this.chose = chose;
	}



	public String title;
    private String optionA;
    private String optionB;
    private String optionC;
    public int getQuesId() {
        return quesId;
    }



    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }



    public String getTitle() {
        return title;
    }



    public void setTitle(String title) {
        this.title = title;
    }



    public String getOptionA() {
        return optionA;
    }



    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }



    public String getOptionB() {
        return optionB;
    }



    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }



    public String getOptionC() {
        return optionC;
    }



    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }



    public int getAns() {
        return ans;
    }



    public void setAns(int ans) {
        this.ans = ans;
    }



    public String getChose() {
        return chose;
    }


    public Question(int quesId, String title, String optionA, String optionB, String optionC, int ans, String chose) {
        super();
        this.quesId = quesId;
        this.title = title;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.ans = ans;
        this.chose = chose;
    }



    public Question() {
        super();
    }


}