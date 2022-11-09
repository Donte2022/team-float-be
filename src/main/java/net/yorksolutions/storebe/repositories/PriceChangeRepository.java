package net.yorksolutions.storebe.repositories;

import net.yorksolutions.storebe.entities.priceChange;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceChangeRepository extends CrudRepository<priceChange,Long> {
}
