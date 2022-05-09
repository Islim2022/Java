package com.HaneiIslim.FruityLoops.Controller;

import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.HaneiIslim.FruityLoops.models.Item;

@Controller
public class FruityLoopsController {
	@RequestMapping("/")
	public String Index(Model model) {
		ArrayList<Item> Fruits = new ArrayList<Item>();
		Fruits.add(new Item("Kiwi", 1.5));
        Fruits.add(new Item("Mango", 2.0));
        Fruits.add(new Item("Goji Berries", 4.0));
        Fruits.add(new Item("Guava", .75));
        model.addAttribute("fruits", Fruits);
        
        return "Index.jsp";
		
}
}
