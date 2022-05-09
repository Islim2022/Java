package com.HaneiIslim.Counter.Controller;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Counter {
	@RequestMapping("/")
	public String index(HttpSession session) {        
		session.setAttribute("count", 0);
		return "Index.jsp";
	}
	@RequestMapping("/your_server")
	public String showCount(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		if (session.getAttribute("count") == null) {
			currentCount = 0;
			session.setAttribute("count", currentCount);
		} else {
			session.setAttribute("count", currentCount + 1);
		}
		model.addAttribute("countToShow", currentCount);
		return "Index.jsp";
	}
	@RequestMapping("/your_server/count")
	public String count(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("countToShow", currentCount);
		return "Counter.jsp";
	}

}
