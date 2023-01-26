package com.pharmacy.pharmacy.service.impl;

import com.pharmacy.pharmacy.constants.OrderConstants;
import com.pharmacy.pharmacy.model.supply.Order;
import com.pharmacy.pharmacy.model.supply.OrderStatus;
import com.pharmacy.pharmacy.repository.supply.OrderRepository;
import com.pharmacy.pharmacy.repository.supply.OrderStatusRepository;
import com.pharmacy.pharmacy.service.supply.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderStatusRepository statusRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderStatusRepository statusRepository) {
        this.orderRepository = orderRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public Order placeOrder(Order order) {
        Order obj = new Order();
        obj.setId(order.getId());
        obj.setItemCode(order.getItemCode());
        obj.setDescription(order.getDescription());
        obj.setQuantity(order.getQuantity());
        obj.setPatient(order.getPatient());
        obj.setBht(order.getBht());
        obj.setUrgentLevel(order.getUrgentLevel());
        obj.setOrderTime(new Date());
        obj.setStatus(OrderConstants.ORDER_PENDING);
        obj.setUrgentRep(order.getUrgentRep());
        obj.setReadStatus(false);
        return orderRepository.save(obj);
    }


    @Override
    public List<OrderStatus> getAllStatus() {
        return statusRepository.findAll();
    }

    @Override
    public void updateOrder(Integer status, String id) {
        orderRepository.updateStatus(status, id);
    }

    @Override
    public void updateRead() {
        orderRepository.updateRead();
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public Order getOrderById(String id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public int getNewOrderCount() {
        return orderRepository.getNewOrderCount();
    }


}
