package com.pizzaquickserve.service;

import com.pizzaquickserve.dto.PizzaOrderDTO;
import com.pizzaquickserve.model.Customer;
import com.pizzaquickserve.model.Pizza;
import com.pizzaquickserve.model.PizzaOrder;
import com.pizzaquickserve.repository.CustomerRepository;
import com.pizzaquickserve.repository.PizzaOrderRepository;
import com.pizzaquickserve.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PizzaOrderService {

    private final PizzaOrderRepository pizzaOrderRepository;
    private final PizzaRepository pizzaRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public PizzaOrderService(PizzaOrderRepository pizzaOrderRepository, PizzaRepository pizzaRepository, CustomerRepository customerRepository) {
        this.pizzaOrderRepository = pizzaOrderRepository;
        this.pizzaRepository = pizzaRepository;
        this.customerRepository = customerRepository;
    }

    public PizzaOrder addPizzaOrder(PizzaOrderDTO pizzaOrderDTO) {
        Pizza pizza = pizzaRepository.findById(pizzaOrderDTO.getPizzaId())
                .orElseThrow(() -> new RuntimeException("Pizza not found"));
        Customer customer = customerRepository.findById(pizzaOrderDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        PizzaOrder pizzaOrder = new PizzaOrder();
        pizzaOrder.setPizza(pizza);
        pizzaOrder.setCustomer(customer);
        pizzaOrder.setQuantity(pizzaOrderDTO.getQuantity());
        pizzaOrder.setOrderDateTime(pizzaOrderDTO.getOrderDateTime());
        pizzaOrder.setDeliveryDateTime(pizzaOrderDTO.getDeliveryDateTime());

        return pizzaOrderRepository.save(pizzaOrder);
    }

    public List<PizzaOrderDTO> getAllOrders() {
        // Convert Iterable<PizzaOrder> to List<PizzaOrderDTO>
        return StreamSupport.stream(pizzaOrderRepository.findAll().spliterator(), false)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private PizzaOrderDTO convertToDTO(PizzaOrder pizzaOrder) {
        PizzaOrderDTO dto = new PizzaOrderDTO();
        dto.setId(pizzaOrder.getId());
        dto.setCustomerName(pizzaOrder.getCustomer().getName());
        dto.setPizzaId(pizzaOrder.getPizza().getId());
        dto.setOrderDateTime(pizzaOrder.getOrderDateTime());
        dto.setDeliveryDateTime(pizzaOrder.getDeliveryDateTime());
        dto.setQuantity(pizzaOrder.getQuantity());
        return dto;
    }

    public void deleteOrder(Long id) {
        pizzaOrderRepository.deleteById(id);
    }
}
