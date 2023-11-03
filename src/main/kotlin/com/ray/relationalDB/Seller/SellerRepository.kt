package com.ray.relationalDB.Seller

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface SellerRepository: JpaRepository<Seller, Int> {
    @Query("""
       SELECT se
       FROM Seller se
    """)
    fun findAllSeller(pageable: Pageable): Page<Seller>
}