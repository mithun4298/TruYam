package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
