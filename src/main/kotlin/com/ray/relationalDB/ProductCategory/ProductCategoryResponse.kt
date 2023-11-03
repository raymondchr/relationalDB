package com.ray.relationalDB.ProductCategory

import org.springframework.data.domain.Page

data class ProductCategoryResponse(
    val name: String,
    val categories: String?
)