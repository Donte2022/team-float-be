package net.yorksolutions.storebe.repositories;

import net.yorksolutions.storebe.entities.PriceChange;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceChangeRepository extends CrudRepository<PriceChange,Long> {
}
