package com.pizzaquickserve.service;

import com.pizzaquickserve.model.Pizza;
import com.pizzaquickserve.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public Pizza addPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    public Optional<Pizza> getPizzaById(Long id) {
        return pizzaRepository.findById(id);
    }

    public Pizza updatePizza(Long id, Pizza pizzaDetails) {
        return pizzaRepository.findById(id)
                .map(pizza -> {
                    pizza.setName(pizzaDetails.getName());
                    pizza.setDescription(pizzaDetails.getDescription());
                    pizza.setPrice(pizzaDetails.getPrice());
                    return pizzaRepository.save(pizza);
                }).orElseThrow(() -> new RuntimeException("Pizza not found with id " + id));
    }

    public void deletePizza(Long id) {
        pizzaRepository.deleteById(id);
    }
}
