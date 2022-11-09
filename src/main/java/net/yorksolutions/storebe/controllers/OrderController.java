package net.yorksolutions.storebe.controllers;

import net.yorksolutions.storebe.dto.CartOrderRequestDTO;
import net.yorksolutions.storebe.dto.NewAccountRequestDTO;
import net.yorksolutions.storebe.entities.Account;
import net.yorksolutions.storebe.entities.Orders;
import net.yorksolutions.storebe.services.OrderService;
import org.hibernate.criterion.Order;
import org.springframework.web.bind.annotation.*;

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


    //allow the FE to have access to the accounts to allow the user past orders
//    @GetMapping("/{id}")
//    public Orders getOrders(@PathVariable Long id) {
//        return this.orderService.getOrders(id);
//    }

//    @GetMapping("/{id}")
//    public Account login(@RequestParam String username, @RequestParam String password) {
//        return this.accountService.login(username, password);
//    }
}
