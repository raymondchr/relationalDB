package com.ray.relationalDB.Product

import com.ray.relationalDB.Product.dto.ProductWithCategory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/products")
class ProductController(private val productService: ProductService) {

    @GetMapping
    fun getProducts(pageable: Pageable): Page<ProductResponse>{
        return productService.getAll(pageable)
    }

    @GetMapping("/search")
    fun getProductByName(@RequestParam name: String):ProductWithCategory{
        return productService.getProductByName(name)
    }


}