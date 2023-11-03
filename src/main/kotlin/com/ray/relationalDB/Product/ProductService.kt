package com.ray.relationalDB.Product

import com.ray.relationalDB.Category.Category
import com.ray.relationalDB.Category.CategoryRepository
import com.ray.relationalDB.Product.dto.ProductWithCategory
import com.ray.relationalDB.ProductCategory.ProductCategoryRepository
import com.ray.relationalDB.error.NotFoundException
import com.ray.relationalDB.model.CreateProductRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository,
    private val productCategoryRepository: ProductCategoryRepository
) {

    fun getAll(pageable: Pageable): Page<ProductResponse> {
        return productRepository.findAllProduct(pageable).map { it.toResponse() }
    }

    fun getProductByName(name: String): ProductWithCategory {
        val product = productRepository.findByName(name)
        val category = productCategoryRepository.findCategoryByProductId(product.id!!)

        return ProductWithCategory(
            name = product.name,
            category = category
        )

    }
}