package com.cognizant.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
public class Modeltesting {
	@Mock
	MenuItem menu;
	@Mock 
	AuthResponse auther;
	
	
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
	public void orderTest() {
		Order ord= new Order();
		ord.setId(5);
		ord.setMenuid(200);
		ord.setQuantity(2);
		ord.setTotalprice(200);
		
		
		assertEquals(5,ord.getId());
		assertEquals(200,ord.getMenuid());
		assertEquals(2,ord.getQuantity());
		assertEquals(200,ord.getTotalprice());

		
	}

	

}
