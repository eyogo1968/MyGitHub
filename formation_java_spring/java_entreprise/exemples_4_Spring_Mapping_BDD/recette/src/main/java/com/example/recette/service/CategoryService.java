package com.example.recette.service;

import com.example.recette.entity.Category;
import com.example.recette.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Integer id) {
//         Optional<Category> optCategory = this.categoryRepository.findById(id);
//         if (optCategory.isPresent()){
//             return optCategory.get();
//         } else{
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//         }
        return categoryRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Category not found"));
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Category category) {
        if (category.getId() != null) {
            categoryRepository.save(category);
        } else {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "Category not found");
        }
        return category;
    }

    public void deleteById(Integer id) {
        if (!categoryRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Category not found");
        }
        categoryRepository.deleteById(id);
        if (categoryRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "Error suppression");
        }
    }
}
