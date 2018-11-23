package fr.cesi.ril17.spring.tp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("msg","Hello");
		return "views/index";
	}

}
