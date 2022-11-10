package net.yorksolutions.storebe.controllers;


import net.yorksolutions.storebe.dto.NewCartRequestDTO;
import net.yorksolutions.storebe.dto.UpdateCartRequestDTO;
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
         static class Message {
             public String message;

             Message(String message) {

                 this.message = message;
             }
         }
    @DeleteMapping("/{id}")
     public Message deleteItem(@PathVariable Long id) {
        return new Message( cartService.deleteItem(id) ? "Item successfully deleted" : "Fail to delete item");

    }


    @PutMapping("/{id}")
     Message updateCart(@PathVariable Long id, @RequestBody UpdateCartRequestDTO requestDTO) {
        return new Message( cartService.updateCart(requestDTO, id) ? "cart successfully updated" : "Fail to update cart");
    }

    @GetMapping("/{accountId}/{orderId}")
    public Iterable<Cart> getCartsByOrderId(@PathVariable Integer accountId, @PathVariable Integer orderId) {
      return this.cartService.getCartsByOrderId(accountId, orderId);

    }


}
