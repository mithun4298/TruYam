package com.truyum.model;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.truyum.TruYumMenuApplication;
import com.truyum.service.SwaggerConfig;

import springfox.documentation.spring.web.plugins.Docket;

@RunWith(SpringJUnit4ClassRunner.class)
public class MenuItemTest {
	@Mock
	MenuItem menu;
	@Mock
	AuthResponse response;
	
	@Mock
	SwaggerConfig swagger;
	
	@Mock
	TruYumMenuApplication turapp;
	
	@Test
	public void getItem() {
		//menu.setItemid(101);
		MenuItem menn = new MenuItem(10,"hgfhd","gfhtrf",201);
		//assertEquals(101,menu.getItemid());
		assertEquals(10,menn.getItemid());
		assertEquals("gfhtrf",menn.getItemname());
		assertEquals("hgfhd",menn.getItemtype());
		assertEquals(201,menn.getItemprice());

		
	}
	
	@Test
	public void setItem() {
		MenuItem men = new MenuItem();
		men.setItemid(100);
		men.setItemname("siddiq");
		men.setItemtype("jhd");
		men.setItemprice(300);
		
		assertEquals(100,men.getItemid());
		assertEquals("siddiq",men.getItemname());
		assertEquals("jhd",men.getItemtype());
		assertEquals(300,men.getItemprice());

		
	}
	
	
	@Test
	public void getAuth() {
	AuthResponse auth = new AuthResponse("siddiq","md",true);
		//assertEquals(101,menu.getItemid());
		assertEquals("siddiq",auth.getUid());
		assertEquals("md",auth.getName());
		assertEquals(true,auth.isValid());

		
	}
	@Test
	public void setAuth() {
	AuthResponse auth = new AuthResponse();
	auth.setName("md");
	auth.setUid("siddiq");
	auth.setValid(true);
		//assertEquals(101,menu.getItemid());
		assertEquals("siddiq",auth.getUid());
		assertEquals("md",auth.getName());
		assertEquals(true,auth.isValid());

		
	}

	@Test
	public void swagger() {
		assertNull(swagger.api());
	}
	
	
	
	
	
}
