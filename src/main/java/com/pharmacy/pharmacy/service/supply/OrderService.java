package com.pharmacy.pharmacy.service.supply;

import com.pharmacy.pharmacy.model.supply.Order;
import com.pharmacy.pharmacy.model.supply.OrderStatus;

import java.util.List;

public interface OrderService {
    Order placeOrder(Order order);

    List<OrderStatus> getAllStatus();

    void updateOrder(Integer status, String id);

    void updateRead();

    List<Order> getAllOrders();

    Order getOrderById(String id);

    int getNewOrderCount();
}
