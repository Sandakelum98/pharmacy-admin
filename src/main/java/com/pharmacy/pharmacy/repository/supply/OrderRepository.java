package com.pharmacy.pharmacy.repository.supply;

import com.pharmacy.pharmacy.model.supply.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {
    @Modifying
    @Transactional
    @Query("update Order o set o.status=:status where o.id=:id")
    public void updateStatus(@Param("status") Integer status, @Param("id") String id);

    @Query("select o from Order o order by o.urgentRep, o.orderTime desc")
    List<Order> getAllOrders();

    Order getOrderById(String id);

    @Query("select count(o.id) from Order o where o.readStatus=false")
    int getNewOrderCount();

    @Modifying
    @Transactional
    @Query("update Order o set o.readStatus=true where o.readStatus=false")
    public void updateRead();
}
