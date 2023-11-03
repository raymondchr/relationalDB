package com.ray.relationalDB.Shop

import com.ray.relationalDB.Seller.Seller
import jakarta.persistence.*

@Entity
@Table(name = "shops")
class Shop(
    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name = "shop_name")
    var name: String?,

    @OneToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    var seller: Seller?,
) {
    fun toResponse(): ShopResponse {
        return ShopResponse(
            shopId = this.id,
            shopName = this.name,
            sellerId = this.seller?.id
        )
    }
}