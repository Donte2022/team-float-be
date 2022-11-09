package net.yorksolutions.storebe.services;
import net.yorksolutions.storebe.dto.NewCartRequestDTO;
import net.yorksolutions.storebe.dto.UpdateCartRequestDTO;
import net.yorksolutions.storebe.entities.Cart;
import net.yorksolutions.storebe.entities.Orders;
import net.yorksolutions.storebe.repositories.CartRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CartService {

    CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart create (NewCartRequestDTO requestDTO) {


        try {
             return this.cartRepository.save(
                    new Cart(requestDTO.orderId, requestDTO.productId, requestDTO.productName, requestDTO.price, requestDTO.quantity, requestDTO.account));
        }
        catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);

        }

    }


    public boolean deleteItem(Long id) {

        try {

            //look for id if not present throw an error
            var cartItem = cartRepository.findById(id).orElseThrow();

            //delete the account in the repo
            cartRepository.deleteById(id);

            //delete was successful = true
            return true;

        } catch (Exception e) {

            //delete fail or error = false
            return false;
        }
    }


    public boolean updateCart(UpdateCartRequestDTO requestDTO, Long id) {


        try {

            Optional<Cart> updateUserCart = this.cartRepository.findById(id);

            Cart cart = updateUserCart.get();

            cart.setQuantity(requestDTO.quantity);

            cartRepository.save(cart);

            //update was successful = true
            return true;

        } catch (Exception e) {

            //update fail or error = false
            return false;

        }
    }

}

