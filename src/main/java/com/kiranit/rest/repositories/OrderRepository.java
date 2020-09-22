package com.kiranit.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiranit.rest.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long>
{

}
