package com.ray.relationalDB.Shop

import com.ray.relationalDB.error.NotFoundException
import com.ray.relationalDB.Shop.model.CreateShopRequest
import com.ray.relationalDB.Product.ProductRepository
import com.ray.relationalDB.Seller.SellerRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ShopService (
    private val shopRepository: ShopRepository,
    private val sellerRepository: SellerRepository,
    private val productRepository: ProductRepository
    ){

    fun getShopResponse(pageable: Pageable): Page<ShopResponse>{
        return shopRepository.findAllShopSeller(pageable).map { it.toResponse() }
    }

    fun getShopById(id:Int): ShopResponse {
        val shop = findOneOrThrowNotFound(id)

        return shop.toResponse()
    }

    fun delete(id: Int){
        val shop = findOneOrThrowNotFound(id)

        shopRepository.delete(shop)
    }

    fun create(createShopRequest: CreateShopRequest): ShopResponse {
        val seller = sellerRepository.findByIdOrNull(createShopRequest.sellerId) ?: throw NotFoundException()

            val newShop = Shop(
                name = createShopRequest.name,
                seller = seller
            )

            shopRepository.save(newShop)
            return newShop.toResponse()
    }

    fun update(id: Int, createShopRequest: CreateShopRequest): ShopResponse {
        val shop = findOneOrThrowNotFound(id)

        shop.apply {
            name = createShopRequest.name
        }

        shopRepository.save(shop)

        return shop.toResponse()
    }

    private fun findOneOrThrowNotFound(id: Int): Shop {
        return shopRepository.findByIdOrNull(id) ?: throw NotFoundException()
    }

}