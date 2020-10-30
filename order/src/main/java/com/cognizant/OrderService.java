package com.cognizant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.client.MenuClient;
import com.cognizant.model.MenuItem;
import com.cognizant.model.Order;
import com.cognizant.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository ord;
	@Autowired
	MenuClient menu;

	public  Order getOrder(int menuid, int quantity, String token) {
				ResponseEntity<MenuItem> response = menu.getAll(menuid, token);
		
		Object menuItem = response.getBody();
		Order ordin = ord.save(new Order(100,menuid,quantity,response.getBody().getItemprice()*quantity));
		return new ResponseEntity<Order>(ordin,HttpStatus.OK).getBody();
		
	}

}
