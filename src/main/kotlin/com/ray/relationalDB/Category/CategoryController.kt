package com.ray.relationalDB.Category

import com.ray.relationalDB.Category.model.CategoryResponse
import com.ray.relationalDB.Category.model.CreateNewCategory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/category")
class CategoryController(private val categoryService: CategoryService) {
    @GetMapping
    fun getAllCategory(pageable: Pageable): Page<CategoryResponse> {
        return categoryService.getAllCategory(pageable)
    }

    @PostMapping
    fun createNewCategory(@RequestBody createNewCategory: CreateNewCategory): CategoryResponse{
        return categoryService.createNewCategory(createNewCategory)
    }
}