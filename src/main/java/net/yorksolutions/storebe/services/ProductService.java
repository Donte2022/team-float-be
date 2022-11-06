package net.yorksolutions.storebe.services;

import net.yorksolutions.storebe.dto.NewProductRequestDTO;
import net.yorksolutions.storebe.entities.Product;
import net.yorksolutions.storebe.repositories.ProductRepository;
import org.springframework.stereotype.Service;

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
}
