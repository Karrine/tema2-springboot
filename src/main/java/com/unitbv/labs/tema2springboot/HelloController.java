package com.unitbv.labs.tema2springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String index(@RequestParam("name") String name) {
		 
		return "Hello, " + name +"!";
	}
}