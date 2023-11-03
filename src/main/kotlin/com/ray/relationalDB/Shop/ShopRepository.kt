package com.ray.relationalDB.Shop

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ShopRepository: JpaRepository<Shop, Int> {
    @Query(
        """
            SELECT s
            FROM Shop s
        """
    )
    fun findAllShopSeller(pageable: Pageable): Page<Shop>
//
//    fun getShopSeller(pageable: Pageable): Page<Shop>
}