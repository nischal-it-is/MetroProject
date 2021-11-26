package com.nischal.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nischal.beans.Card;
import com.nischal.beans.Station;
import com.nischal.beans.Transaction;
import com.nischal.model.service.CardService;
import com.nischal.model.service.StationService;
import com.nischal.model.service.TransactionService;

@Controller

public class metroController {
	
	@Autowired
	private CardService cardService;
	@Autowired
	private StationService stationService;
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping("/")
	public ModelAndView landingPage()
	{
		return new ModelAndView("landing");
	}
	@RequestMapping("/signUp")
	public ModelAndView signUpController()
	{
		int cid=(int)(Math.random()*200+1);
		Card card=new Card(100,cid);
		try
		{
			boolean flag=cardService.insert(card);
		}
		catch(Exception e)
		{
			return new ModelAndView("failed","message","failed to generate card");
		}
		String message="Signed Up successful,Your card-Id is "+cid+" remaining balance "+100;
		return new ModelAndView("signUp","message",message);
	}
	@RequestMapping("/login")
	public ModelAndView loginController()
	{
		return new ModelAndView("login","command",new Card());
	}
	Card cardinput=null;
	@RequestMapping("/loginCheck")
	public ModelAndView loginCheck(@ModelAttribute("command") Card card,HttpSession session )
	{
		//Card cardinput=null;
		try
		{
			cardinput=cardService.searchById(card.getCardId());
			
		}catch(Exception e) {
			return new ModelAndView("landing");
		}
		//ModelAndView model=new ModelAndView();
		session.setAttribute("Card",cardinput);
		if(cardinput.getBalance()<20)
		{
			return new ModelAndView("insufficientBalance");
		}
		
		return new ModelAndView("menu");
	}
	@RequestMapping("/recharge")
	public ModelAndView rechargeHandler()
	{
		return new ModelAndView("recharge");
	}
	//how to get value from session in controller
	@RequestMapping("/rechargeCard")
	public ModelAndView recharge(@RequestParam("amount") int amount,HttpSession session)
	{
		Card card=(Card)(session.getAttribute("Card"));
		//int id=cardinput.getCardId();
		int id=card.getCardId();
		try {
		boolean flag=cardService.updateBalance(id,amount+card.getBalance());
		}catch(Exception e)
		{
			return new ModelAndView("failed","message","failed to update balance");
		}
		Card card2=null;
	     try
	     {
	    	 card2=cardService.searchById(card.getCardId());
	     }catch(Exception e) {return new ModelAndView("failed","message","failed to insert into transaction table");}
	     
	     session.setAttribute("Card", card2);
		return new ModelAndView("rechargeDone");
		
	}
	@RequestMapping("/menu")
	public ModelAndView menuHandler()
	{
		return new ModelAndView("menu");
	}
	@RequestMapping("/checkBalance")
	public ModelAndView checkBalance(HttpSession session)
	{
		Card card=(Card)(session.getAttribute("Card"));
		//int id=cardinput.getCardId();
		String message="Your Balance is "+card.getBalance();
		return new ModelAndView("showBalance","message",message);
		
	}
	@RequestMapping("/staionSelect")
	public ModelAndView selectStation()
	{
		ArrayList<Station> stations=null;
		try
		{
			stations=stationService.getAllStation();
		}
		catch(Exception e)
		{
			return new ModelAndView("failed","message","No station Present");
		}
		ModelAndView mv=new ModelAndView();
		mv.setViewName("stationList");
		mv.addObject("stationlist",stations);
		mv.addObject("StationObject",new Station());
		return mv;
	}
	@RequestMapping("/checkInDisplay")
	public ModelAndView checkInController(@ModelAttribute("stationObject") Station starting,HttpSession session)
	{
		session.setAttribute("StartingStation",starting);
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
             "yyyy-MM-dd HH:mm:ss");
	     LocalDateTime now = LocalDateTime.now();
	    
	     String checkInTime = now.format(formatter);
	     int checkInhour=now.getHour();
	     session.setAttribute("checkInTime", checkInTime);
	     session.setAttribute("checkInHour", checkInhour);
		return new ModelAndView("checkIn");
	}
	@RequestMapping("/checkOut")
	public ModelAndView selectCheckOutStation()
	{

		ArrayList<Station> stations=null;
		try
		{
			stations=stationService.getAllStation();
		}
		catch(Exception e)
		{
			return new ModelAndView("failed","message","No station Present");
		}
		ModelAndView mv=new ModelAndView();
		mv.setViewName("stationOutList");
		mv.addObject("stationlist",stations);
		mv.addObject("StationObject",new Station());
		return mv;
	}
	@RequestMapping("/checkOutDisplay")
	public ModelAndView checkOutController(@ModelAttribute("stationObject") Station ending,HttpSession session)
	{
		session.setAttribute("EndingStation",ending);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
	             "yyyy-MM-dd HH:mm:ss");
		     LocalDateTime now = LocalDateTime.now();
		    
		     String checkOutTime = now.format(formatter);
		     int checkOuthour=now.getHour();
		     //used to calculate fine only
//		     session.setAttribute("checkOutTime", checkOutTime);
//		     session.setAttribute("checkOutHour", checkOuthour);
		     Station starting=(Station)(session.getAttribute("StartingStation"));
		     int fare=Math.abs((ending.getStationId()-starting.getStationId())*5);
		     Card card=(Card)(session.getAttribute("Card"));
		     try
		     {
		    	 boolean flag=cardService.updateBalance(card.getCardId(),card.getBalance()-fare);
		    	 
		     }
		     catch(Exception e)
		     {
		    	 return new ModelAndView("failed","message","failed to update balance at checkOut");
		     }
		     Card card2=null;
		     try
		     {
		    	 card2=cardService.searchById(card.getCardId());
		     }catch(Exception e) {return new ModelAndView("failed","message","failed to insert into transaction table");}
		     
		     session.setAttribute("Card", card2);
		     int remainingBalance=card.getBalance();
		     System.out.println(remainingBalance);
		     int transactionId=(int)(Math.random()*100000+1);
		     Transaction t=new Transaction(card.getCardId(),transactionId,starting,ending,fare);
		     String checkInTime=(String)(session.getAttribute("checkInTime"));
		     try
		     {
		    	 boolean updateTransaction=transactionService.insert(t,checkInTime);
		     }
		     catch(Exception e)
		     {
		    	 return new ModelAndView("failed","message","failed to insert into transaction table");
		     }
		     String message="Thank you for using metro.Fare is "+fare;
		     return new ModelAndView("SignOut","message",message);
		     
	}
	@RequestMapping("/exit")
	public ModelAndView exitHandler(HttpSession session)
	{
		session.invalidate();
		return new ModelAndView("landing");
		
	}
}
