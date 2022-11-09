package net.yorksolutions.storebe.controllers;

import net.yorksolutions.storebe.dto.CategoryDTO;
import net.yorksolutions.storebe.dto.CategoryPostDTO;
import net.yorksolutions.storebe.entities.Category;
import net.yorksolutions.storebe.services.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoryController {

    CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Category> getallcat () {
        return this.service.getallcat();
    }

    @PostMapping
    public Category postcat (@RequestBody CategoryPostDTO dto) {
      return this.service.postCategory(dto);
    }

    @PutMapping
    public void putcat (@RequestBody CategoryDTO dto) {
        this.service.putCategory(dto);
    }

    @DeleteMapping("/{id}")
    public void deletecat (@PathVariable Long id) {
        this.service.deleteCategory(id);
    }

}
