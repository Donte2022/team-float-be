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

import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

@Service
public class CategoryService {

    CategoryRepository repository;
    ProductRepository prorepo;


    public CategoryService(CategoryRepository repository, ProductRepository prorepo) {
        this.repository = repository;
        this.prorepo = prorepo;
    }

    public Iterable<Category> getallcat () {
        return this.repository.findAll();
    }

    public Category postcat (CategoryPostDTO dto) {
            Category cat = new Category(dto.name);
            for (Long pro : dto.proidList)
            {
                System.out.println(pro);
                Optional<Product> obs2 = prorepo.findById(pro);
                if (obs2.isEmpty()){
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
                else {

                    obs2.get().Categories.add(cat);
                }
            }
        repository.save(cat);
            return cat;
    }


//    public void putcat (CategoryDTO dto) {
//        Optional<Category> obs = repository.findById(dto.id);
//        prorepo.deleteAllByCategoriesContains(dto.id);
//        if (obs.isEmpty()){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//        else {
//            for (Long pro : dto.proidList){
//                Optional<Product> obs2 = prorepo.findById(pro);
//                if (obs2.isEmpty()){
//                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//                }
//                else {
//                    obs2.get().Categories.add(obs.get());
//                }
//            }
//        }
//    }
}
