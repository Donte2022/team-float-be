package net.yorksolutions.storebe.repositories;

import net.yorksolutions.storebe.entities.Cart;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository {
    Cart save(Cart cart);
}
