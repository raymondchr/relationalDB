package com.ray.relationalDB.ProductCategory

import com.ray.relationalDB.Category.Category
import com.ray.relationalDB.Product.Product
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name="product_category")
class ProductCategory(
    @Id
    val id: Int?,

    @ManyToOne
    @JoinColumn(name = "product_id")
    val product: Product,

    @ManyToOne
    @JoinColumn(name="category_id")
    var category: Category
) {
    fun toResponse():ProductCategoryResponse{
        return ProductCategoryResponse(
            name = this.product.name,
            categories = this.category.description
        )
    }
}