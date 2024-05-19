package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Question;
import com.example.demo.model.Questionform;
import com.example.demo.model.Register;
import com.example.demo.model.Result;
import com.example.demo.repository.quesrepository;
import com.example.demo.repository.regrespo;
import com.example.demo.repository.resultrepo;

@Service
public class QuizService {

    @Autowired
    quesrepository repo;

   @Autowired
    Question ques;

    @Autowired
    Questionform qform;

    @Autowired
    Result result;
//
    @Autowired
    resultrepo rRepo;
    
    @Autowired
    regrespo rr;

    public Questionform getQuestion(String name) {
        List<Question>allques=repo.findBychose(name);
        List<Question>qlist=new ArrayList<Question>();
        Questionform qform = new Questionform();
//        Random random=new Random();
//        for(int i=0;i<5;i++) {
//            int rand=random.nextInt(allques.size());
//            qlist.add(allques.get(rand));
//            allques.remove(rand);
//
//        }
//        
        qform.setQuestions(allques);
        return qform;
    }
    
    public int getResult(Questionform qform) {
    	int correct=0;
    	for(Question que:qform.getQuestions()) {
    		if(que.getChose()!=null) {
    			
    		
    		if(que.getAns()==Integer.parseInt(que.getChose())) {
    			correct++;
    			
    		}
    		}
    	}
    	return correct;
    }
   
    public void savescore(Result result) {
    	Result res=new Result();
    	Register r=rr.findByemail(result.getUsername());
    	res.setUsername( r.getUsername());
    	res.setTotalcorrect(result.getTotalcorrect());
    	rRepo.save(res);
    }
    
    



}