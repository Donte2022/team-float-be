package net.yorksolutions.storebe.repositories;

import net.yorksolutions.storebe.entities.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends CrudRepository <Cart, Long>{

    Iterable<Cart> findAllByAccount_IdAndOrderId(Integer accountId, Integer orderId);

    Optional<Cart> findByProductId(Integer productId);


    Optional<Cart> deleteByProductId(Integer productId);
}
