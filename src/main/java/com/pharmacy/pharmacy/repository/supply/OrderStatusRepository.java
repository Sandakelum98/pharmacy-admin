package com.pharmacy.pharmacy.repository.supply;

import com.pharmacy.pharmacy.model.supply.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {
}
