package com.truyum.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truyum.dao.MenuItemDao;
import com.truyum.model.MenuItem;


@Service
public class MenuItemService {
	
	
	@Autowired
	MenuItemDao menuitemdao;
	
	private List<MenuItem>itemlist ;

	public List<MenuItem> getMenu()
	{
		return   menuitemdao.findAll(); 
		
	}
	public MenuItem getItemByID(int id)
	{
		
		return menuitemdao.findById(id).orElse(null);
	}
	public List<MenuItem> getItemByName(String itemname)
	{
		
		List<MenuItem> items=menuitemdao.findAll(); 
		for(MenuItem item : itemlist)
		{
			if(item.getItemname().contains(itemname))
			{
				items.add(item);
			}
		}
		return items;
	}
	

	
	
	
	

}
