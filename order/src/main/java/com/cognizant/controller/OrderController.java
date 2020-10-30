package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.OrderService;
import com.cognizant.client.AuthRepo;
import com.cognizant.model.AuthResponse;




@RestController
public class OrderController {
	
	@Autowired
	AuthRepo authclient;
	
	@Autowired
	OrderService service;
	
	
	
	
	@PostMapping(path="/makeorder/{menuitem}/{quantity}")
	public ResponseEntity<?> getall(@RequestHeader(name="Authorization")String token,@PathVariable("menuitem") int menuitem, @PathVariable("quantity") int quantity)
	{
		AuthResponse authResponse= authclient.verifyToken(token);
		if(authResponse.isValid())
		{
			return new ResponseEntity<>(service.getOrder(menuitem,quantity,token),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("You are not LoggedIn",HttpStatus.FORBIDDEN);
		}
		
	}
	
		

}
