package com.cognizant.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.OrderService;
import com.cognizant.client.AuthRepo;
import com.cognizant.model.AuthResponse;
import com.cognizant.model.Order;

@RunWith(SpringJUnit4ClassRunner.class)
public class ControllerTest {
	@Mock
	OrderService service;
	@InjectMocks
	OrderController ctrl;
	@Mock
	Order ord;
	@Mock
	AuthResponse authResponse;
	@Mock
	AuthRepo auth;
	int id = 101;
	int quantity =2;
	String token ="siddiq";
	
	@Test
	public void testControllerPositive() {
		Mockito.when(auth.verifyToken(token)).thenReturn(authResponse);
		 Mockito.when(authResponse.isValid()).thenReturn(true);
		 Mockito.when(service.getOrder(id, quantity, token)).thenReturn(ord);
		 	assertEquals(ctrl.getall(token, id, quantity).getStatusCode(),HttpStatus.OK);
			
		
		
		
	}
	@Test
	public void testControllerNegative() {
		Mockito.when(auth.verifyToken(token)).thenReturn(authResponse);
		 Mockito.when(authResponse.isValid()).thenReturn(false);
		 
		 	assertEquals(ctrl.getall(token, id, quantity).getStatusCode(),HttpStatus.FORBIDDEN);
			
		
		
		
	}


	
	
}
