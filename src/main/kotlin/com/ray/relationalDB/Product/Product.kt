package com.ray.relationalDB.Product

import com.ray.relationalDB.ProductCategory.ProductCategory
import com.ray.relationalDB.Seller.Seller
import jakarta.persistence.*

@Entity
@Table(name = "products")
class Product (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(name = "product_name")
    var name: String,

    @Column(name = "product_price")
    var price: Int?,

    @Column(name = "product_quantity")
    var quantity: Int,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    val seller: Seller? = null

) {
    @OneToMany(mappedBy = "product")
    var products: Set<ProductCategory> = emptySet()

}