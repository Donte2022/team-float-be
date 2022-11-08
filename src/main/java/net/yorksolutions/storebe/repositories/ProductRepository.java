package net.yorksolutions.storebe.repositories;

import net.yorksolutions.storebe.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Iterable<Product> deleteAllByCategoriesContains(Long id);
}
