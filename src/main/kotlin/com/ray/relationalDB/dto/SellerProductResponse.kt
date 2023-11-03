package com.ray.relationalDB.dto

import com.ray.relationalDB.Product.ProductResponse
import org.springframework.data.domain.Page

data class SellerProductResponse(
    val shopName: String?,
    val products: Page<ProductResponse>
)
