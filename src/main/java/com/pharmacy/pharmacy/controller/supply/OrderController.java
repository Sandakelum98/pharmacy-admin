package com.pharmacy.pharmacy.controller.supply;

import com.pharmacy.pharmacy.model.supply.Order;
import com.pharmacy.pharmacy.model.supply.OrderStatus;
import com.pharmacy.pharmacy.model.user.User;
import com.pharmacy.pharmacy.service.supply.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/save")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        return new ResponseEntity<Order>(orderService.placeOrder(order), HttpStatus.CREATED);
    }

    @GetMapping("/get-list/status")
    public List<OrderStatus> getAllStatus() {
        return orderService.getAllStatus();
    }

    @PutMapping("/update/id/{id}/status/{status}")
    public void updateStatus(@PathVariable String id, @PathVariable Integer status) {
        orderService.updateOrder(status, id);
    }

    @PutMapping("/update-read")
    public void updateRead() {
        orderService.updateRead();
    }

    @GetMapping("/get-list/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/get-Order/id/{id}")
    public Order getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/new-count")
    public int getNewOrderCount() {
        return orderService.getNewOrderCount();
    }
}
