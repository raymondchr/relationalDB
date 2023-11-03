package com.ray.relationalDB.ProductCategory

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProductCategoryService(private val productCategoryRepository: ProductCategoryRepository) {

    fun getAll(pageable: Pageable): Page<ProductCategoryResponse>{
        return productCategoryRepository.findAllProduct(pageable).map { it.toResponse() }
    }

    fun getProductCategory(id: Int): List<String>{
        return productCategoryRepository.findCategoryByProductId(id)
    }
}