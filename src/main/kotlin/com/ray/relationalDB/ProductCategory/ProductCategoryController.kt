package com.ray.relationalDB.ProductCategory

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/products/category")
class ProductCategoryController(private val productCategoryService: ProductCategoryService) {

    @GetMapping
    fun getAll(pageable: Pageable): Page<ProductCategoryResponse> {
        return productCategoryService.getAll(pageable)
    }
}