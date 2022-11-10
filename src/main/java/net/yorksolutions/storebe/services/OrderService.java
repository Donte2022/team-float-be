package net.yorksolutions.storebe.services;

import net.yorksolutions.storebe.dto.CartOrderRequestDTO;
import net.yorksolutions.storebe.entities.Orders;
import net.yorksolutions.storebe.repositories.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class OrderService {

    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Orders create(CartOrderRequestDTO requestDTO) {


        try {
            return this.orderRepository.save(
                    new Orders (requestDTO.accountId,requestDTO.dateOrdered, requestDTO.productId, requestDTO.productName, requestDTO.quantity, requestDTO.price));
        }
        catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }


    public Orders findOrders (Integer id) {
    Optional<Orders> accountOrders = this.orderRepository.findOrdersByAccountId(id);

        if (accountOrders.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND
            );
        }
        return accountOrders.get();
    }

}

