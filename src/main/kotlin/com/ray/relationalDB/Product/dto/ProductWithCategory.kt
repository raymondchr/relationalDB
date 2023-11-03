package com.ray.relationalDB.Product.dto

import com.ray.relationalDB.Category.Category
import com.ray.relationalDB.ProductCategory.ProductCategory
import org.springframework.data.domain.Page

data class ProductWithCategory (
    val name: String,
    val category: List<String>
){
}