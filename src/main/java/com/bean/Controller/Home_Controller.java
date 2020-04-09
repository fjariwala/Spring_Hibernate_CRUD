package com.bean.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home_Controller {

	@GetMapping("/")
	public String home() {

		System.out.println("Its here");
		return "index";
	}

}
