package net.yorksolutions.storebe.services;

import net.yorksolutions.storebe.dto.CartOrderRequestDTO;
import net.yorksolutions.storebe.entities.Cart;
import net.yorksolutions.storebe.entities.Orders;
import net.yorksolutions.storebe.repositories.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OrderService {

    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Orders create(CartOrderRequestDTO requestDTO) {
        //@RequestBody

        try {
            return this.orderRepository.save(
                    new Orders (requestDTO.accountId,requestDTO.dateOrdered, requestDTO.productId, requestDTO.productName, requestDTO.quantity, requestDTO.price));
        }
        catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }


//    public Orders getOrders(Long id) {
//
//
//        //TODO create an Iterable to find the ids
//        try {
//            return Orders this.orderRepository.findAllById(id);
//        }
//        catch (RuntimeException exception) {
//            throw new ResponseStatusException(HttpStatus.CONFLICT);
//        }
//    }
}

