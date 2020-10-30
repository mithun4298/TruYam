package com.truyum.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.truyum.client.AuthClient;
import com.truyum.model.AuthResponse;
import com.truyum.model.MenuItem;
import com.truyum.service.MenuItemService;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestController {
	@Mock
	MenuItemService service;
	@InjectMocks
	MenuController ctrl;
	@Mock
	MenuItem menu;
	@Mock
	AuthResponse authResponse;
	@Mock
	AuthClient auth;

	int id =10;
	
	@Test
	 public void getByIdNegative() {
		String token = "Authorization" ;
		
	 
	 Mockito.when(auth.verifyToken(token)).thenReturn(authResponse);
	 Mockito.when(authResponse.isValid()).thenReturn(true);
	 Mockito.when(service.getItemByID(id)).thenReturn(null);
	 	assertEquals(ctrl.getById(id,token).getStatusCode(),HttpStatus.NOT_FOUND);
		
	}
	
	
	@Test
	 public void getByIdAuthPositive() {
		String token = "Authorization" ;
		
	 
	 Mockito.when(auth.verifyToken(token)).thenReturn(authResponse);
	 Mockito.when(authResponse.isValid()).thenReturn(false);
	 
	 	assertEquals(ctrl.getById(id,token).getStatusCode(),HttpStatus.FORBIDDEN);
		
	}	
	@Test
	 public void getByIdPositive() {
		String token = "Authorization" ;
		
	 
	 Mockito.when(auth.verifyToken(token)).thenReturn(authResponse);
	 Mockito.when(authResponse.isValid()).thenReturn(true);
	 Mockito.when(service.getItemByID(id)).thenReturn(menu);
	 	assertEquals(ctrl.getById(id,token).getStatusCode(),HttpStatus.OK);
		
	}

	@Test
	 public void getAllPositive() {
		String token = "Authorization" ;
		
	 Mockito.when(auth.verifyToken(token)).thenReturn(authResponse);
	 Mockito.when(authResponse.isValid()).thenReturn(true);
	 Mockito.when(service.getMenu()).thenReturn(new ArrayList<MenuItem>());
	 	assertEquals(ctrl.getall(token).getStatusCode(),HttpStatus.OK);
		
	}
	@Test
	 public void getAllNegative() {
		String token = "Authorization" ;
		
	 Mockito.when(auth.verifyToken(token)).thenReturn(authResponse);
	 Mockito.when(authResponse.isValid()).thenReturn(false);
		 	assertEquals(ctrl.getall(token).getStatusCode(),HttpStatus.FORBIDDEN);
		
	}
	
	@Test
	 public void gwtbyNamePsiitive() {
			String token = "Authorization" ;
			String name = "siddiq";
		 Mockito.when(auth.verifyToken(token)).thenReturn(authResponse);
		 Mockito.when(authResponse.isValid()).thenReturn(true);
		 Mockito.when(service.getItemByName(name)).thenReturn(new ArrayList<MenuItem>());		 
		 	assertEquals(ctrl.getById(name, token).getStatusCode(),HttpStatus.NOT_FOUND);
			
		}
	@Test
	 public void gwtbyNameNegative() {
			String token = "Authorization" ;
			String name = "siddiq";
		 Mockito.when(auth.verifyToken(token)).thenReturn(authResponse);
		 Mockito.when(authResponse.isValid()).thenReturn(false);		 
		 	assertEquals(ctrl.getById(name, token).getStatusCode(),HttpStatus.FORBIDDEN);
				
		}
	
	@Test
	 public void gwtbyNamePsiitiveScond() {
			String token = "Authorization" ;
			String name = "siddiq";
		 Mockito.when(auth.verifyToken(token)).thenReturn(authResponse);
		 Mockito.when(authResponse.isValid()).thenReturn(true);
		 Mockito.when(service.getItemByName(name)).thenReturn(null);		 
		 	assertEquals(ctrl.getById(name, token).getStatusCode(),HttpStatus.NOT_FOUND);
			
		}




	
	
	
	
	
	
	


}
