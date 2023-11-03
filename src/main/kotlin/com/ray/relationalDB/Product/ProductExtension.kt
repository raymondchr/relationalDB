package com.ray.relationalDB.Product

import com.ray.relationalDB.Product.Product
import com.ray.relationalDB.Product.ProductResponse
import com.ray.relationalDB.Product.dto.ProductWithCategory

fun Product.toResponse(): ProductResponse {
    return ProductResponse(
        name = this.name,
        price = this.price,
        quantity= this.quantity,
        sellerId = this.seller?.id
    )
}
