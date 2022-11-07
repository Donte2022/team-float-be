package net.yorksolutions.storebe.services;
import net.yorksolutions.storebe.dto.NewCartRequestDTO;
import net.yorksolutions.storebe.entities.Cart;
import net.yorksolutions.storebe.repositories.CartRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CartService {

    CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart create(NewCartRequestDTO requestDTO) {


        try {
            return this.cartRepository.save(
                    new Cart(requestDTO.productName, requestDTO.price, requestDTO.quantity));
        }
        catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }
}
