package com.ray.relationalDB.Shop

import com.ray.relationalDB.model.CreateShopRequest
import com.ray.relationalDB.Shop.ShopResponse
import com.ray.relationalDB.Shop.ShopService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/shops")
class ShopController(
    private val shopService: ShopService
) {

    @GetMapping
    fun getAllShopSeller(pageable: Pageable): Page<ShopResponse> {
        //return shopService.getShopSellerData(pageable)
        return shopService.getShopResponse(pageable)
    }

    @GetMapping("/{id}")
    fun getShopById(@PathVariable("id") id: Int): ShopResponse {
        return shopService.getShopById(id)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int){
        return shopService.delete(id)
    }

    @PostMapping
    fun createNewShop(@RequestBody body: CreateShopRequest): ShopResponse {
        return shopService.create(body)
    }

    @PutMapping("/{id}")
    fun updateShopName(@PathVariable("id") id: Int,@RequestBody body: CreateShopRequest): ShopResponse {
        return shopService.update(id, body)
    }
}