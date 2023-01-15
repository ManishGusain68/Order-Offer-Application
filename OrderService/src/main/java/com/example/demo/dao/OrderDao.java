package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.OrderData;

public interface OrderDao extends CrudRepository<OrderData, Integer>{

}
