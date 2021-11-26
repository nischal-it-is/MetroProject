package com.vishnu.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vishnu.beans.Card;
import com.vishnu.model.exceptions.CardNotFoudException;
import com.vishnu.model.sevice.*;

@Controller
public class MetroController {
	
	@Autowired
	CardService cardService;
	@Autowired
	StationService stationService;
	@Autowired
	TravelInfoService travelInfoService;
	
	@RequestMapping("/")
	public ModelAndView showLoginPage() {
		return new ModelAndView("Index","command",new Card());
	}
	
	@RequestMapping("/loginCheck")
	public ModelAndView loginCheck(@ModelAttribute("command") Card card,HttpSession session)
	{
		try {
			card=cardService.getCardDetails(card.getCard_id());
			ModelAndView mv=new ModelAndView();
			session.setAttribute("UserCard", card);
			session.setAttribute("IsCheckedIn", travelInfoService.isCheckedInService(card.getCard_id()));
			mv.addObject("card", card);
			mv.setViewName("homepage");
			
			
			return  mv;
		} 
		catch (Exception e) {
		}
		return new ModelAndView("Index","msg","Please enter a valid card Number if You are a new user click on new user");
		
	}
	
	//Card Services
	
	@RequestMapping("/addBalance")
	public ModelAndView addBalance(@RequestParam("xyz") int amount,HttpSession session)
	{
		Card c=(Card) session.getAttribute("UserCard");
		boolean b=cardService.addBalance(c.getCard_id(), amount);
		if(!b)
			return new ModelAndView("AddingBalance","msg","Sorry couldNot Uppdate balance");
		c.setBalance(c.getBalance()+amount);
		session.setAttribute("UserCard", c);
		return new ModelAndView("AddingBalance","msg","Balance updated to"+ c.getBalance());
			
	}
	@RequestMapping("/addBalancePage")
	public ModelAndView addBalanceForm()
	{
		return new ModelAndView("AddingBalance");
		
	}
			

}
