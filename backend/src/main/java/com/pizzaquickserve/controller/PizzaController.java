package com.pizzaquickserve.controller;

import com.pizzaquickserve.model.Pizza;
import com.pizzaquickserve.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping("/add")
    public Pizza addPizza(@RequestBody Pizza pizza) {
        return pizzaService.addPizza(pizza);
    }

    @GetMapping
    public List<Pizza> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }

    @GetMapping("/{id}")
    public Pizza getPizzaById(@PathVariable Long id) {
        return pizzaService.getPizzaById(id)
                .orElseThrow(() -> new RuntimeException("Pizza not found with id " + id));
    }

    @PutMapping("/update/{id}")
    public Pizza updatePizza(@PathVariable Long id, @RequestBody Pizza pizzaDetails) {
        return pizzaService.updatePizza(id, pizzaDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePizza(@PathVariable Long id) {
        pizzaService.deletePizza(id);
    }
}
