package com.ray.relationalDB.Category

import com.ray.relationalDB.Product.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository: JpaRepository<Category,Int> {
    @Query("""
        SELECT c
        FROM Category c
    """)
    fun findAllCategory(pageable: Pageable): Page<Category>

    @Query("""
        SELECT c
        FROM Category c
        WHERE c.description = :name
    """)
    fun findCategoryByName(name: String): Category


}