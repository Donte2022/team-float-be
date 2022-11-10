package net.yorksolutions.storebe.services;

import net.yorksolutions.storebe.dto.CategoryDTO;
import net.yorksolutions.storebe.dto.CategoryPostDTO;
import net.yorksolutions.storebe.entities.Category;
import net.yorksolutions.storebe.entities.Product;
import net.yorksolutions.storebe.repositories.CategoryRepository;
import net.yorksolutions.storebe.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;
    ProductRepository productRepository;


    public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public Iterable<Category> getallcat () {
        return this.categoryRepository.findAll();
    }

    public Category postCategory(CategoryPostDTO dto) {
            Category cat = new Category(dto.name);
            for (Long pro : dto.proidList)
            {
                System.out.println(pro);
                Optional<Product> obs2 = productRepository.findById(pro);
                if (obs2.isEmpty()){
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
                else {

                    obs2.get().categories.add(cat);
                }
            }
        categoryRepository.save(cat);
            return cat;
    }


    public void putCategory(CategoryDTO dto) {
        Optional<Category> op = categoryRepository.findById(dto.id);
        if (op.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else {
            op.get().setName(dto.name);
            for (Product pro : productRepository.findAll()){
               pro.categories.remove(op.get());
               productRepository.save(pro);
            }
            for (Long pro : dto.proidList){
                Optional<Product> obs2 = productRepository.findById(pro);
                if (obs2.isEmpty()){
                    throw new ResponseStatusException(HttpStatus.CONFLICT);
                }
                else {
                    obs2.get().categories.add(op.get());
                    productRepository.save(obs2.get());
                }
            }
        }
    }


    public void deleteCategory(Long id) {
        Optional<Category> op = categoryRepository.findById(id);
        if (op.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else {
            for (Product pro : productRepository.findAll()){
                pro.categories.remove(op.get());
                productRepository.save(pro);
            }
            categoryRepository.delete(op.get());
        }
    }
}
