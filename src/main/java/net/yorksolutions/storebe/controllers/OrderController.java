package net.yorksolutions.storebe.controllers;

import net.yorksolutions.storebe.dto.CartOrderRequestDTO;
import net.yorksolutions.storebe.entities.Orders;
import net.yorksolutions.storebe.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/orders")
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

        @PostMapping
    public Orders create(@RequestBody CartOrderRequestDTO requestDTO) {

        return this.orderService.create(requestDTO);
    }


    @GetMapping("/{id}")
    public Orders getOrders(@PathVariable Integer id) {
        return this.orderService.findOrders(id);
    }
}
