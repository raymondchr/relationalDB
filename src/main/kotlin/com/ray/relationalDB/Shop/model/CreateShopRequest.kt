package com.ray.relationalDB.Shop.model

data class CreateShopRequest(
    val name: String,
    val sellerId: Int
) {
}