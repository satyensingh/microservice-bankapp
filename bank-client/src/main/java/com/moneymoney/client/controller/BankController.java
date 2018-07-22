package com.moneymoney.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
}
