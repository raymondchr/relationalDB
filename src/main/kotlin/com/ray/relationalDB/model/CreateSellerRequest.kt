package com.ray.relationalDB.model

data class CreateSellerRequest(
    val name: String,
    val email:String,
    val password:String
)
