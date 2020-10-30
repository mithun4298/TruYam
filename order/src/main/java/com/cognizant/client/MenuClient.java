package com.cognizant.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.model.MenuItem;
import com.cognizant.model.Order;

@FeignClient(url="localhost:8001/menu",name="menuitem-service")
public interface MenuClient {
	
	
	@GetMapping("{id}")
	public ResponseEntity<MenuItem> getAll(@PathVariable("id") int id,@RequestHeader(name="Authorization",required=true)String token);
	

}
