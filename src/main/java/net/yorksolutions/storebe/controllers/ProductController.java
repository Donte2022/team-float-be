package net.yorksolutions.storebe.controllers;

import net.yorksolutions.storebe.dto.NewProductRequestDTO;
import net.yorksolutions.storebe.entities.Product;
import net.yorksolutions.storebe.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Iterable<Product> getProductList() {
        return this.productService.getProductList();
    }

    @PostMapping
    public Product addProduct(@RequestBody NewProductRequestDTO newProduct) {
      return this.productService.addProduct(newProduct);
    }

    @DeleteMapping
    public void deleteProduct(@RequestParam Long id) {
         this.productService.deleteProduct(id);
    }

    @PutMapping
    public void updateProduct(@RequestBody Product updatedProduct) {
        this.productService.updateProduct(updatedProduct);
    }
}
