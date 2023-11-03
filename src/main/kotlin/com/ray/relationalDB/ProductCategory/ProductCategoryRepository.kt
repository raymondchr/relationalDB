package com.ray.relationalDB.ProductCategory

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ProductCategoryRepository: JpaRepository<ProductCategory,Int> {
    @Query("""
        SELECT p
        FROM ProductCategory p
    """)
    fun findAllProduct(pageable: Pageable): Page<ProductCategory>
    @Query("""
        SELECT p.category.description
        FROM ProductCategory p
        WHERE p.product.id = :id
    """)
    fun findCategoryByProductId(id: Int): List<String>
}