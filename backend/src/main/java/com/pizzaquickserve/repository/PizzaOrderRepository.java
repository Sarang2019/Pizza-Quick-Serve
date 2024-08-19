package com.pizzaquickserve.repository;

import com.pizzaquickserve.dto.PizzaOrderDTO;
import com.pizzaquickserve.model.PizzaOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PizzaOrderRepository extends CrudRepository<PizzaOrder, Long> {

    @Query("SELECT new com.pizzaquickserve.dto.PizzaOrderDTO(po.id, c.name, po.pizza.id, po.orderDateTime, po.deliveryDateTime, po.quantity) " +
            "FROM PizzaOrder po JOIN po.customer c")
    List<PizzaOrderDTO> findAllOrdersWithCustomerName();
}
