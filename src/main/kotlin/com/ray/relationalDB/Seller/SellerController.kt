package com.ray.relationalDB.Seller

import com.ray.relationalDB.model.CreateSellerRequest
import com.ray.relationalDB.model.UpdateSellerRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/sellers")
class SellerController(private val sellerService: SellerService) {

    @GetMapping
    fun getAll(pageable: Pageable): Page<SellerResponse> {
        return sellerService.getAllSeller(pageable)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Int): SellerResponse {
        return sellerService.getSellerById(id)
    }

    @PostMapping
    fun createNewSeller(@RequestBody body: CreateSellerRequest): SellerResponse {
        return sellerService.createNewSeller(body)
    }

    @DeleteMapping("/{id}")
    fun deleteSeller(@PathVariable("id") id: Int){
        sellerService.deleteSeller(id)
    }

    @PutMapping("/{id}")
    fun updateSeller(@PathVariable("id") id: Int,@RequestBody body: UpdateSellerRequest): SellerResponse {
        return sellerService.update(id, body)
    }

}