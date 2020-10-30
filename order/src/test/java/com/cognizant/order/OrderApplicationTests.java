package com.cognizant.order;

import static org.junit.Assert.assertEquals;

//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import com.cognizant.OrderService;
import com.cognizant.client.MenuClient;
import com.cognizant.model.MenuItem;
import com.cognizant.model.Order;
import com.cognizant.repository.OrderRepository;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderApplicationTests {
	@Mock
	OrderRepository repo;
	@InjectMocks
	OrderService service;
	@Mock
	MenuClient menu;
	@Mock
	ResponseEntity<MenuItem> response;
	int menuid=10;
	String token = "siddiq";
	int quantity=2;
	

	@Test
	public void gettAll() {
		Mockito.when(menu.getAll(menuid, token)).thenReturn(response);
		Mockito.when(response.getBody()).thenReturn(new MenuItem());
		Mockito.when(repo.save(new Order())).thenReturn(null);
		assertEquals(service.getOrder(menuid, quantity, token),null);
	}
	
	
	

}
