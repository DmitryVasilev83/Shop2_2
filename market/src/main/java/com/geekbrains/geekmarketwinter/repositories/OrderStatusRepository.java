package com.geekbrains.geekmarketwinter.repositories;

import com.geekbrains.geekmarketwinter.entities.OrderStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends CrudRepository<OrderStatus, Long> {

}
