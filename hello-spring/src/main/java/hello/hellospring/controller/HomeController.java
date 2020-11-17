package hello.hellospring.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
	
	@GetMapping("/")
	//기본 / 없으면 
	public String home(){
		System.out.println("커밋");
		return "home";
	}
}
