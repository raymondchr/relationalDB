package com.ray.relationalDB.Product

import com.ray.relationalDB.Product.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface ProductRepository: JpaRepository<Product, Int> {
    @Query("""
        SELECT p
        FROM Product p
    """)
    fun findAllProduct(pageable: Pageable): Page<Product>

    @Query("""
        SELECT p
        FROM Product p
        WHERE p.name = :name
    """)
    fun findByName(@Param("name") name: String): Product
}