package com.example.recette.controller;

import com.example.recette.entity.Category;
import com.example.recette.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Integer id) {
        return categoryService.findById(id);
    }

    @PostMapping("/")
    public Category save(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Integer id, @RequestBody Category category) {
        if (category.getId().equals(id)){
            return categoryService.update(category);
        } else {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Path id : "+id+" and category id : "+category+ " not valid");
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        categoryService.deleteById(id);
    }
}
