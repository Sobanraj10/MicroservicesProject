package com.mobi.order_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobi.order_service.entity.Order;
@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{

}
