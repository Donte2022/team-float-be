package net.yorksolutions.storebe.services;

import net.yorksolutions.storebe.dto.NewProductRequestDTO;
import net.yorksolutions.storebe.entities.Product;
import net.yorksolutions.storebe.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> getProductList() {
        return this.productRepository.findAll();
    }

    public void addProduct(NewProductRequestDTO newProduct) {

        Product product = new Product(newProduct);

        this.productRepository.save(product);
    }

    public void deleteProduct(Long id) {

        this.productRepository.deleteById(id);
    }

    public void updateProduct(Product updatedProduct) {
      Optional<Product> productOpt =  this.productRepository.findById(updatedProduct.getId());
      if (productOpt.isEmpty()) {
          throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
      Product product = productOpt.get();
      product.setAll(updatedProduct);
      this.productRepository.save(product);


    }
}
