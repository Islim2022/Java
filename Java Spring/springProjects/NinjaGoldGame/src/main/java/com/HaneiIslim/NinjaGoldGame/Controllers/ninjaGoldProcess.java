package com.HaneiIslim.NinjaGoldGame.Controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ninjaGoldProcess {
	@RequestMapping("/")
	public String gold(HttpSession session) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		return "Index.jsp";
	}
	
	Random random=new Random();
	ArrayList<String> activities = new ArrayList<String>();
	String timeDatePattern = "MMMM dd yyyy HH:mm aa";
	SimpleDateFormat DateFormat = new SimpleDateFormat(timeDatePattern);
	String dateTime = DateFormat.format(new Date());
	
	@RequestMapping(value= "/process_gold", method=RequestMethod.POST)
	public String processGold(
			@RequestParam(value="form") String form, HttpSession session) {
		if(form.equals("farm")) {
			int gold = random.nextInt(21 - 10) + 10;
			int currentGold = (int) session.getAttribute("gold");
			session.setAttribute("gold", currentGold + gold);
		
			String activity = "You entered a farm and earned " + gold + " gold. " + "(" + dateTime + ")";
			activities.add(activity);
		
		} else if(form.equals("cave")) {
			int gold = random.nextInt(11 - 5) + 5;
			int currentGold = (int) session.getAttribute("gold");
			session.setAttribute("gold", currentGold + gold);
			
			String activity = "You entered a cave and earned " + gold + " gold. " + "(" + dateTime + ")";
			activities.add(activity);
					
		} else if(form.equals("house")) {
			int gold = random.nextInt(6 - 2) + 2;
			int currentGold = (int) session.getAttribute("gold");
			session.setAttribute("gold", currentGold + gold);
			
			String activity = "You entered a house and earned " + gold + " gold. " + "(" + dateTime + ")";
			activities.add(activity);
		
		} else {
			
			int gold = random.nextInt(101)-50;
			
			if(gold > 0) {
				int currentGold = (int) session.getAttribute("gold");
				session.setAttribute("gold", currentGold + gold);
				
				String activity = "You completed a quest and earned " + gold + " gold. " + "(" + dateTime + ")";
				activities.add(activity);
				
			} else {
				int currentGold = (int) session.getAttribute("gold");
				session.setAttribute("gold", currentGold + gold);
				
				String activity = "You failed a quest and lost " + -gold + " gold. " +"(" + dateTime + ")";
				activities.add(activity);
				
			}
			
		}
		session.setAttribute("activities", activities);
		System.out.print(activities);
	return "redirect:/";
	}
}


