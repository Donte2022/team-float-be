package net.yorksolutions.storebe.controllers;


import net.yorksolutions.storebe.dto.NewCartRequestDTO;
import net.yorksolutions.storebe.entities.Cart;
import net.yorksolutions.storebe.services.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/cart")
public class CartController {

    CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public Cart createCart(@RequestBody NewCartRequestDTO requestDTO) {

        return this.cartService.create(requestDTO);

    }

}
