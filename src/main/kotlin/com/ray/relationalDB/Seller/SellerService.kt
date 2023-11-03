package com.ray.relationalDB.Seller

import com.ray.relationalDB.Seller.model.CreateSellerRequest
import com.ray.relationalDB.error.NotFoundException
import com.ray.relationalDB.Seller.model.UpdateSellerRequest
import com.ray.relationalDB.Product.ProductRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class SellerService(
    private val sellerRepository: SellerRepository,
    private val productRepository: ProductRepository
    ) {

    fun getAllSeller(pageable: Pageable): Page<SellerResponse> {
        return sellerRepository.findAllSeller(pageable).map { it.toResponse() }
    }

    fun getSellerById(id: Int): SellerResponse {
        return findOneOrThrowNotFound(id).toResponse()
    }

    fun createNewSeller(createSellerRequest: CreateSellerRequest): SellerResponse {


        val seller = Seller(
            name = createSellerRequest.name,
            email = createSellerRequest.email,
            password = createSellerRequest.password
        )

        sellerRepository.save(seller)

        return seller.toResponse()
    }

    fun deleteSeller(id: Int){
        val seller = findOneOrThrowNotFound(id)

        sellerRepository.delete(seller)
    }

    fun update(id: Int, updateSellerRequest: UpdateSellerRequest): SellerResponse {
        val seller = findOneOrThrowNotFound(id)

        seller.apply {
            email = updateSellerRequest.email
            password = updateSellerRequest.password
        }

        sellerRepository.save(seller)

        return seller.toResponse()
    }


    private fun findOneOrThrowNotFound(id: Int): Seller {
        return sellerRepository.findByIdOrNull(id) ?: throw NotFoundException()
    }
}