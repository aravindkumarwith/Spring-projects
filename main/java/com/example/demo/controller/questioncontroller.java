package com.example.demo.controller;

//import com.example.airport.model.Register;
import com.example.demo.model.Question;
import com.example.demo.model.Questionform;
import com.example.demo.model.Register;
import com.example.demo.model.Result;
import com.example.demo.repository.quesrepository;
import com.example.demo.repository.regrespo;
import com.example.demo.service.QuizService;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class questioncontroller {
    @Autowired
    Result result;
    Boolean submit=false;

    @Autowired
    QuizService qservice;
    
    @Autowired
    quesrepository repo;
    
    @Autowired
    regrespo rr;

    @ModelAttribute("result")
    public Result getResult() {
        return result;
    }
    
    @RequestMapping("quizi")
    public ModelAndView qui(String name) {
    	ModelAndView mav=new ModelAndView();
    	Questionform qform = qservice.getQuestion(name);
        mav.addObject("qform", qform);
        mav.setViewName("quiz.html");
        return mav;
        
    }
    @RequestMapping("login")
    public ModelAndView log() {
    	ModelAndView mav=new ModelAndView();
    	mav.setViewName("login.html"); 
    	return mav;
    }
    @RequestMapping("put")
    public ModelAndView pu(Question que) {
    	repo.save(que);
    	ModelAndView mav=new ModelAndView();
    	mav.addObject("message", "Question added successfully");
    	mav.setViewName("addquestion.html");
    	return mav;
    	
    	}
  
    @RequestMapping("submit")
    public ModelAndView sub(@ModelAttribute Questionform qform) {
    	int correct=0;
    	if(!submit) {
    		 correct=qservice.getResult(qform);
    		result.setTotalcorrect(correct);
    		qservice.savescore(result);
    		submit=true;
    		}
    	ModelAndView mav=new ModelAndView();
    	mav.addObject("res", correct);
    	Register r=rr.findByemail(result.getUsername());
    	mav.addObject("name", r.getUsername());
    	mav.setViewName("score.html");
    	return mav;
    }
    
    @RequestMapping("logout")
    public ModelAndView logou(HttpServletRequest request, RedirectAttributes ra) {
        // Invalidate session
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return new ModelAndView("login.html");
    }
  
    @RequestMapping("register")
	public ModelAndView login(String username,String email ) {
		Register list=rr.findByemail(email);
		ModelAndView mav=new ModelAndView();
		if(list==null) {
			
			mav.setViewName("register.html");
			mav.addObject("message", "you have not registered,please register here");
			//return mav;
		}
		else if(email.equals("admin@gmail.com") && username.equals("adminforthis@123")) {
			mav.setViewName("addquestion.html");
		}
		else {
			submit = false;
	        result.setUsername(email);
	        
	        //Questionform qform = qservice.getQuestion();
	        //mav.addObject("qform", qform);
	        mav.setViewName("inter.html");
	
			//mav.setViewName("reserve.html");
			mav.addObject("mail",email);
		}
		return mav;
	
}
    
    @RequestMapping("reg")
    public ModelAndView insert(Register re) {
    	rr.save(re);
    	ModelAndView mav=new ModelAndView();
    	mav.setViewName("login.html");
    	return mav;
    }
}


