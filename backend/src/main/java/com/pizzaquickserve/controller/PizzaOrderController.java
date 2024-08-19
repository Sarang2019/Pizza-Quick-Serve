package com.pizzaquickserve.controller;

import com.pizzaquickserve.dto.PizzaOrderDTO;
import com.pizzaquickserve.model.PizzaOrder;
import com.pizzaquickserve.service.PizzaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class PizzaOrderController {

    private final PizzaOrderService pizzaOrderService;

    @Autowired
    public PizzaOrderController(PizzaOrderService pizzaOrderService) {
        this.pizzaOrderService = pizzaOrderService;
    }

    // POST request to add a new pizza order
    @PostMapping("/add")
    public ResponseEntity<PizzaOrder> addPizzaOrder(@RequestBody PizzaOrderDTO pizzaOrderDTO) {
        PizzaOrder pizzaOrder = pizzaOrderService.addPizzaOrder(pizzaOrderDTO);
        return ResponseEntity.ok(pizzaOrder);
    }

    // GET request to retrieve all pizza orders
    @GetMapping("/all")
    public ResponseEntity<List<PizzaOrderDTO>> getAllOrders() {
        List<PizzaOrderDTO> orders = pizzaOrderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
}
