package com.ray.relationalDB.Category

import com.ray.relationalDB.Category.model.CategoryResponse
import com.ray.relationalDB.ProductCategory.ProductCategory
import jakarta.persistence.*

@Entity
@Table(name = "categories")
class Category (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name="category_description")
    var description: String?
) {
    @OneToMany(mappedBy = "category")
    var categories: Set<ProductCategory> = emptySet()

    fun toResponse(): CategoryResponse{
        return CategoryResponse(
            id = this.id,
            description = this.description
        )
    }
}