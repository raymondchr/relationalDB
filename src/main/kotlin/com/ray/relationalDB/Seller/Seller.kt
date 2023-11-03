package com.ray.relationalDB.Seller

import com.ray.relationalDB.Product.Product
import com.ray.relationalDB.Shop.Shop
import jakarta.persistence.*

@Entity
@Table(name = "sellers")
class Seller(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name = "seller_name")
    var name: String? = null,

    @Column(name = "seller_email")
    var email: String? = null,

    @Column(name = "seller_password")
    var password: String? = null,

) {

    @OneToOne(mappedBy = "seller", cascade = [CascadeType.ALL])
    var shop: Shop? = null

    @OneToMany(mappedBy = "seller")
    var products: List<Product> = mutableListOf()

    fun toResponse(): SellerResponse {
        return SellerResponse(
            name = this.name,
            email = this.email,
            shopId = this.shop?.id
        )
    }

}