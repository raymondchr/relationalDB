package com.ray.relationalDB.Seller.model

data class CreateSellerRequest(
    val name: String,
    val email:String,
    val password:String
)
