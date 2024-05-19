package com.example.airport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.airport.model.Person;
import com.example.airport.model.Register;
import com.example.airport.model.airlines;
import com.example.airport.model.confirmed;
import com.example.airport.model.waiting;
import com.example.airport.repository.*;

import java.io.IOException;
import java.util.*;
@RestController
public class airlinecontroller {
	@Autowired
	Registerrepo rr;
	
	@Autowired
	airrepository ar;
	
	@Autowired
	Confirmrepo cr;
	
	
	@Autowired
	waitingrepo wr;
	
	@RequestMapping("add")
	public ModelAndView start() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("addflight.html");
		return mav;
	}
	
	@RequestMapping("mae")
	public String mae() {
		return "vanakam da mapla";
	}
	
	
	@RequestMapping("reservation")
		public ModelAndView rese(String mail) {
			ModelAndView mav=new ModelAndView();
			mav.setViewName("reserve.html");
			mav.addObject("mail", mail);
			return mav;
		}
	
	@RequestMapping("remover")
	public ModelAndView re() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("remove.html");
		//mav.addObject("mail", mail);
		return mav;
	}
	
	@RequestMapping("put")
	public ModelAndView put(MultipartFile image,int flight_no,String from,String to,String depart,String arrival,String Date,String avai_econnomyseats,String avai_businessseats) throws IOException {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("addflight.html");
		if (image==null) {
        	mav.addObject("message", " image is null");
			//System.out.print("image is null");
        	return mav;
        }
		airlines abc=new airlines();
		abc.setArrival(arrival);
		abc.setAvai_businessseats(avai_businessseats);
		abc.setAvai_econnomyseats(avai_econnomyseats);
		abc.setDate(Date);
		abc.setDepart(depart);
		abc.setFlight_no(flight_no);
		abc.setFrom(from);
		
		byte[]base=image.getBytes();
		abc.setImage(java.util.Base64.getEncoder().encodeToString(base));
		abc.setTo(to);
		ar.save(abc);
		
		return mav;
	}
	
	@RequestMapping("register")
	public ModelAndView reg() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("register.html");
		return mav;
	}
	
	@RequestMapping("reg")
	public ModelAndView abcd(Register regis) {
		rr.save(regis);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("login.html");
		return mav;
	}
	
	@RequestMapping("log")
	public ModelAndView login(Register regis) {
		String email=regis.getEmail();
		String pass=regis.getPassword();
		List<Register> list=rr.findByNameandPass(email, pass);
		ModelAndView mav=new ModelAndView();
		if(list.size()==0) {
			
			mav.setViewName("register.html");
			mav.addObject("message", "you have not registered,please register here");
			//return mav;
		}
		else if(email.equals("aravind@gmail.com") && pass.equals("adminforthis")) {
			mav.setViewName("addflight.html");
		}
		else {
			mav.setViewName("inter.html");
			//mav.setViewName("reserve.html");
			mav.addObject("mail",email);
		}
		return mav;
	
}
	
	 @RequestMapping("login")
	 public ModelAndView login() {
		 ModelAndView mav=new ModelAndView();
		 mav.setViewName("login.html");
		 return mav;
	 }
	 
	 @RequestMapping("show")
	 public ModelAndView login(airlines air,String email) {
		 String from=air.getFrom();
		 String to=air.getTo();
		 String date=air.getDate();
		 List<airlines>airlist=ar.GetDetails(from, to, date);
		 ModelAndView mav=new ModelAndView();
		 mav.addObject("list",airlist);
		 mav.addObject("mail",email);
		 mav.setViewName("reserve.html");
		 return mav;
	 }
	 @RequestMapping("reserve")
	 public ModelAndView re(airlines air,String mail) {
		 String from=air.getFrom();
		 String to=air.getTo();
		 String date=air.getDate();
		 String depart=air.getDepart();
		 String arrive=air.getArrival();
		 List<airlines>airlist=ar.GetDetailsForSingle(from, to, date,depart,arrive);
		 ModelAndView mav=new ModelAndView();
		 mav.addObject("list",airlist);
		 mav.setViewName("seat.html");
		 mav.addObject("mail",mail);
		 return mav;
	 }
	 public static int confirm_no=1;
	 public static int order=1;
	 @RequestMapping("book")
	 public ModelAndView bo(String name,String seat,String mail,airlines air) {
		 airlines arl=ar.findByNo(air.getFlight_no());
		 int eco=Integer.parseInt(arl.getAvai_econnomyseats());
		 int busi=Integer.parseInt(arl.getAvai_businessseats());
		 ModelAndView mav=new ModelAndView();
		 
		 confirmed con=new confirmed();
		 if(seat.equals("Economy") && eco>0) {
			 mav.addObject("message", "economy book");
			 mav.addObject("num", confirm_no);
			 mav.addObject("name", name);
			//mav.addObject("message","First class seats are booked for this person "+name+" With Confirmation number of "+confirm_no);;
			arl.setAvai_econnomyseats(String.valueOf(eco-1));		
			 ar.save(arl);
			 con.setConfirma_no(confirm_no);
			 con.setEmail(mail);
			 con.setFlightno(arl.getFlight_no());
			 con.setUsername(name);
			 con.setSeat(seat);
			 cr.save(con);
			 confirm_no++;	

			}
		 else if(seat.equals("Business") && busi>0) {
			 mav.addObject("message", "business book");
			 mav.addObject("num", confirm_no);
			 mav.addObject("name", name);
			//mav.addObject("message","Business class seats are booked for this person "+name+" With Confirmation number of "+confirm_no);
			arl.setAvai_businessseats(String.valueOf(busi-1));
			 ar.save(arl);
			 con.setConfirma_no(confirm_no);
			 con.setEmail(mail);
			 con.setFlightno(arl.getFlight_no());
			 con.setUsername(name);
			 con.setSeat(seat);
			 cr.save(con);
			 confirm_no++;
		 }
		 
		 
		 else {
			 mav.addObject("message","sorry "+seat+" are fully booked. so waiting list");
			 waiting w=new waiting();
			 w.setOrder(confirm_no);
			 
			 w.setFlightno(arl.getFlight_no());
			 w.setEmail(mail);
			 w.setUsername(name);
			 w.setSeat(seat);
			 wr.save(w);
			 confirm_no++;
		 }
		
		 mav.setViewName("seat.html");
		 String from=air.getFrom();
		 String to=air.getTo();
		 String date=air.getDate();
		 String depart=air.getDepart();
		 String arrive=air.getArrival();
		 List<airlines>airlist=ar.GetDetailsForSingle(from, to, date,depart,arrive);
		 mav.addObject("list",airlist);
		 mav.setViewName("seat.html");
		 mav.addObject("mail",mail);
		 return mav;
	 }
	 
	 @RequestMapping("remove")
	 public ModelAndView remove() {
		 ModelAndView mav=new ModelAndView();
		 mav.setViewName("remove.html");
		 return mav;
		
	 }
	 
	 @RequestMapping("removeit")
	 public ModelAndView removeit(int confirm) {
		 confirmed cnf=cr.findByConfirm(confirm);
		 ModelAndView mav=new ModelAndView();
		 if(cnf==null) {
			 mav.addObject("message","Please check the Confirmation number");
			 mav.setViewName("remove.html");
			 
		 }
		 else {
		 int no=cnf.getFlightno();
		 String seat=cnf.getSeat();
		 String name=cnf.getUsername();
		 cr.delete(cnf);
		 List<waiting> waitlist= wr.findByflightnoAndSeat(no, seat);
		 if(waitlist.size()>0) {
		 waiting wait=waitlist.get(0);
		 wr.delete(wait);
		 confirmed c=new confirmed();
		 c.setConfirma_no(confirm_no++);
		 c.setEmail(wait.getEmail());
		 c.setFlightno(wait.getFlightno());
		 c.setSeat(wait.getSeat());
		 c.setUsername(wait.getUsername());
		 cr.save(c);
		 }
		 mav.addObject("message",name+" Removed Successfully");
		 mav.setViewName("remove.html");
		 }
		return mav;
	 }
	 
	 @RequestMapping("logout")
	 public ModelAndView logou() {
		 ModelAndView mav=new ModelAndView();
		 mav.setViewName("login.html");
		 return mav;
		 
	 }
}
	 
	 

