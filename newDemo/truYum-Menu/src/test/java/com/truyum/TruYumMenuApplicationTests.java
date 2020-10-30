package com.truyum;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import org.junit.Test;
import com.google.common.base.Verify;
import com.sun.glass.ui.MenuItem;
import com.truyum.dao.MenuItemDao;
import com.truyum.service.MenuItemService;

@RunWith(SpringJUnit4ClassRunner.class)
public class TruYumMenuApplicationTests {
	
	@Mock
	MenuItemDao repo;
	@InjectMocks
	MenuItemService service;
		
	private int id = 10;
	private String name = "hii";

	@Test
	 public void getMenuall() {
	 service.getMenu();
	 Mockito.verify(repo).findAll();
		
		
	}
	
	@Test
	 public void getById() {
	 service.getItemByID(id);
	 Mockito.verify(repo).findById(id);
		
		
	}
	
	
//	@Test
//	 public void getByName() {
//		
//		Mockito.when(repo.findAll()).thenReturn(new ArrayList<MenuItem>());
//		Mockito.when(menu.get)
//		
//	}
//

	
	
	
	
	
	
	
	

}
