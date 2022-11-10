package net.yorksolutions.storebe.repositories;

import net.yorksolutions.storebe.entities.Account;
import net.yorksolutions.storebe.entities.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository <Orders, Long>{

    Optional<Orders> findOrdersByAccountId(Integer id);
    Optional<Orders> findByAccountId(Integer id);


}
