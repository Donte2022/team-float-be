package net.yorksolutions.storebe.repositories;

import net.yorksolutions.storebe.entities.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository <Orders, Long>{


}
