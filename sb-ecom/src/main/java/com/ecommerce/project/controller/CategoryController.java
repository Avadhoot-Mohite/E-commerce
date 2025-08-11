package com.ecommerce.project.controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping("/api")//This defines the repeating end point used in the class
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    // @RequestMapping(value = "/public/categories", method = RequestMethod.GET)
    @GetMapping("/public/categories")
    public ResponseEntity<List<Category>> getAllCategories(){
            List<Category> categories = categoryService.getAllCategories();
            return new ResponseEntity<>(categories , HttpStatus.OK);
        }


    // @RequestMapping(value = "/public/categories", method = RequestMethod.POST)
    @PostMapping("/public/categories")
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category){
            categoryService.createCategories(category);
            return new ResponseEntity<>("Category added successfully" , HttpStatus.OK);
        }

    @DeleteMapping("/admin/category/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
        try {
            String status = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(status , HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason() , e.getStatusCode());
        }
    }

    @PutMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category , @PathVariable Long categoryId){
        try {
            Category updatedCategory = categoryService.updateCategory(category , categoryId);
            return new ResponseEntity<>("Category with Category Id "+categoryId+" is Updated",HttpStatus.OK);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }
}

