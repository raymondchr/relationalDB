package com.ray.relationalDB.model

data class CreateShopRequest(
    val name: String,
    val sellerId: Int
) {
}