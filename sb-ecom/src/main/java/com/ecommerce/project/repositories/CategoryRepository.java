package com.ecommerce.project.repositories;

import com.ecommerce.project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
// JpaRepository provides u the ready-made curd operations.It is advance version of CurdRepo.


public interface CategoryRepository extends JpaRepository<Category , Long> {
    Category findByCategoryName(String category);
}
